package com.practicas.linkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Link {
    private Integer linkId;
    private String url;
    private Boolean valid;
    private Integer redirects;
    private String salt;
    private String password;
}
