package org.linktraker.linktrackerapi.service;

import org.linktraker.linktrackerapi.dto.CounterDTO;
import org.linktraker.linktrackerapi.dto.CreateUrlDTO;
import org.linktraker.linktrackerapi.dto.RedirectDTO;
import org.linktraker.linktrackerapi.model.URI;

import java.util.List;

public interface IURIService {
    Integer saveLinkTracking(CreateUrlDTO url);
    List<URI> getAll();
    URI getLinkTracking(Integer id);
    String getLinkToRedirect(RedirectDTO dataToRedirect);
    CounterDTO getRedirectCount(Integer id);
}
