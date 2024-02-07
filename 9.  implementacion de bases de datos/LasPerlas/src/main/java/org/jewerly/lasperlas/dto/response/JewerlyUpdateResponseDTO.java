package org.jewerly.lasperlas.dto.response;

import org.jewerly.lasperlas.dto.JewerlyDTO;
import org.jewerly.lasperlas.dto.MessageDTO;

public record JewerlyUpdateResponseDTO(
        MessageDTO message,
        JewerlyDTO jewerly
) {
}
