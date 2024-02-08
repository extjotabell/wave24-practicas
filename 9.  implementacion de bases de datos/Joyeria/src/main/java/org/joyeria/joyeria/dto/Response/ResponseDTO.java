package org.joyeria.joyeria.dto.Response;

import org.springframework.http.HttpStatus;

public record ResponseDTO(Short code, String message, Object data) {
    public static ResponseDTO ok(String msg, Object data) {
        var status = HttpStatus.OK;

        return new ResponseDTO((short) status.value(), msg, data);
    }
}
