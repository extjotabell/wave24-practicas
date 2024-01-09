package com.bootcamp.dtoresponseentity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class RiskPersonDTO {
    private final String NAME;
    private final String LAST_NAME;
}
