package org.carinsurance.carinsurancehql.service.interfaces;

import org.carinsurance.carinsurancehql.dto.SinisterDTO;

import java.util.List;

public interface ISinisterService {
    SinisterDTO createSinister(SinisterDTO sinisterDTO);
    List<SinisterDTO> getListOfSinisters();

}
