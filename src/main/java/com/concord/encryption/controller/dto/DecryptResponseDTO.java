package com.concord.encryption.controller.dto;

import lombok.Data;

@Data
public class DecryptResponseDTO {

    private String fio;

    public DecryptResponseDTO(String fio) {
        this.fio = fio;
    }

}
