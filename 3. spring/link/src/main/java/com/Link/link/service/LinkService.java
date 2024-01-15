package com.Link.link.service;

import com.Link.link.dto.LinkDTO;
import com.Link.link.entity.Link;
import com.Link.link.exceptions.InvalidUrlException;
import com.Link.link.repository.ILinkRepository;
import com.Link.link.util.enums.CrudOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class LinkService implements ILinkService{
    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public LinkDTO create(Link link) {

        Pattern pattern = Pattern.compile("^(https?|ftp):/\\/[^\\s/$.?#].[^\\s]*$");
        if(!pattern.matcher(link.getUrl()).matches()){
            throw new InvalidUrlException(CrudOperation.CREATE,"Invalid URL");
        }
        this.linkRepository.save(link);
        LinkDTO linkDTO = new LinkDTO(link.getUrl(),link.getId());
        return linkDTO;
    }

    @Override
    public Link redirect(Link linkId) {
        Link link = this.linkRepository.findById(linkId).get();
        return link;
    }
}
