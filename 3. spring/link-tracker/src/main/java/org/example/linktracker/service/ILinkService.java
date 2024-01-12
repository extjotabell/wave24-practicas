package org.example.linktracker.service;

import org.example.linktracker.model.Link;

public interface ILinkService {
    Link createLink(String url, String password);
    Link redirectLink(Integer linkId);
    Integer getRedirectCount(Integer linkId);
    void invalidateLink(Integer linkId);

}
