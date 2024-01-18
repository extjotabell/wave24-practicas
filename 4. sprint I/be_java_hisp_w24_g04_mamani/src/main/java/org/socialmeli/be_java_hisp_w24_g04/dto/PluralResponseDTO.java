package org.socialmeli.be_java_hisp_w24_g04.dto;

import java.util.List;

public record PluralResponseDTO(Integer statusCode, List<Object> data) {
}
