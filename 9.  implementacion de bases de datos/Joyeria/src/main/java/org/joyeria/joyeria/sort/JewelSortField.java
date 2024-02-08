package org.joyeria.joyeria.sort;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JewelSortField {
    ID("id"),
    NOMBRE("name"),
    PRECIO("price"),
    PESO("weight"),
    MATERIAL("material");

    private final String databaseFieldName;
}
