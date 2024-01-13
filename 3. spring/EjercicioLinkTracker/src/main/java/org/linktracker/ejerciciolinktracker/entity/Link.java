package org.linktracker.ejerciciolinktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
public class Link {
    private Integer linkId;
    private String url;
    private Boolean valid;
    private Integer redirectCount;
    private String password;

    public Link(String url, String password) {
        this.url = url;
        this.redirectCount = 0;
        this.valid = true;
        this.password = password;
    }

    public void incrementRedirectCount() {
        this.redirectCount++;
    }
}
