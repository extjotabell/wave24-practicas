package com.Link.link.service;

import com.Link.link.dto.LinkDTO;
import com.Link.link.entity.Link;

public interface ILinkService {
    LinkDTO create(Link link);

    Link redirect(Link linkId);

}
