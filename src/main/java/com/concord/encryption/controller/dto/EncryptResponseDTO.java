package com.concord.encryption.controller.dto;

import lombok.Data;

@Data
public class EncryptResponseDTO {

    private String fio_encr;

    public EncryptResponseDTO(String fio_encr) {
        this.fio_encr = fio_encr;
    }
}
