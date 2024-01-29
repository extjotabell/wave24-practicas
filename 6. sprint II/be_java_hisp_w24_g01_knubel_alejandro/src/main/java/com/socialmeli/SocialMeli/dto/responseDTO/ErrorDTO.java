package com.socialmeli.SocialMeli.dto.responseDTO;

import java.util.List;

public record ErrorDTO(String explanation,
                       List<String> messages) {
}
