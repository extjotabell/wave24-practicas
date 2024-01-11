package org.linktraker.linktrackerapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class URI {
    private Integer id;
    private String uri;
    private Integer counter;
    private String password;
}
