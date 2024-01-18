package org.mercadolibre.co.consigna.service;

import org.mercadolibre.co.consigna.dto.LinkDTO;
import org.mercadolibre.co.consigna.entity.Link;

public interface ILinkService {

    LinkDTO create(Link link);

    LinkDTO redirect(Integer linkId);

}
