package org.example.linktracker.model;

import lombok.Data;

@Data
public class Link {
    private Integer linkId;
    private String url;
    private Integer redirectCount;
    private Boolean valid;
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
