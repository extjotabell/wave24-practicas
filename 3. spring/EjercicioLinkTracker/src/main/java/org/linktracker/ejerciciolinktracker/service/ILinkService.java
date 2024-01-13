package org.linktracker.ejerciciolinktracker.service;

import org.linktracker.ejerciciolinktracker.dto.LinkDTO;
import org.linktracker.ejerciciolinktracker.entity.Link;

public interface ILinkService {

    Link createLink(String url, String password);
    Link redirectLink(Integer linkId);
    Integer getRedirectCount(Integer linkId);
    void invalidateLink(Integer linkId);
}
