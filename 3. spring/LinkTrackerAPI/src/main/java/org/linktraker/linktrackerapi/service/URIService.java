package org.linktraker.linktrackerapi.service;

import org.linktraker.linktrackerapi.dto.CounterDTO;
import org.linktraker.linktrackerapi.dto.CreateUrlDTO;
import org.linktraker.linktrackerapi.dto.RedirectDTO;
import org.linktraker.linktrackerapi.exception.ElementNotFoundException;
import org.linktraker.linktrackerapi.exception.InvalidBodyParamsException;
import org.linktraker.linktrackerapi.exception.InvalidCredentialsException;
import org.linktraker.linktrackerapi.exception.MalformedURLException;
import org.linktraker.linktrackerapi.model.URI;
import org.linktraker.linktrackerapi.repository.IURIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class URIService implements IURIService {
    private final IURIRepository uriRepository;
    private static final String URL_REGEX =
            "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                    "([).!';/?:,][[:blank:]])?$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    private static boolean urlValidator(String url) {
        Matcher matcher = URL_PATTERN.matcher(url);

        return matcher.matches();
    }

    @Autowired
    public URIService(IURIRepository uriRepository) {
        this.uriRepository = uriRepository;
    }

    public Integer saveLinkTracking(CreateUrlDTO url) {
        Integer id = uriRepository.findAll().size()+1;
        String urlStr = url.url().trim();

        if (urlStr.isEmpty()) {
            throw new MalformedURLException("URL cannot be empty.");
        }
        if (!urlValidator(urlStr)) {
            throw new MalformedURLException("Invalid URL.");
        }
//        if (url.password() == null) {
//            throw new InvalidBodyParamsException(
//                    "Invalid password. Please use a correct password within a query param. Ex: http://.../link?" +
//                            "password=..."
//            );
//        }

        uriRepository.save(new URI(id, urlStr, 0, url.password()));

        return id;
    }

    public List<URI> getAll() {
        return uriRepository.findAll();
    }

    @Override
    public URI getLinkTracking(Integer id) {
        var uriFound = uriRepository
                .findById(id)
                .orElse(null);

        if (uriFound == null) {
            throw new ElementNotFoundException(String.format("Element with id %d not found.", id));
        }

        return uriFound;
    }
    @Override
    public String getLinkToRedirect(RedirectDTO dataToRedirect) {
        var entity = this.getLinkTracking(dataToRedirect.id());

        if (dataToRedirect.password().equals(entity.getPassword())) {
            uriRepository
                    .update(
                            new URI(
                                    entity.getId(),
                                    entity.getUri(),
                                    entity.getCounter() + 1,
                                    entity.getPassword()
                            )
                    );

            return entity.getUri();
        } else
            throw new InvalidCredentialsException("Wrong password. Try again with a different password.");
    }

    @Override
    public CounterDTO getRedirectCount(Integer id) {
        var uriFound = uriRepository.findById(id);

        if (uriFound.isEmpty()) {
            throw new ElementNotFoundException(String.format("Element with id %d not found.", id));
        }

        return new CounterDTO(uriFound.get().getUri(), uriFound.get().getCounter());
    }
}
