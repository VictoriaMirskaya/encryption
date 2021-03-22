package com.concord.encryption.controller.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class DecryptRequestDTO {

    @NotBlank(message = "Field 'fio_encr' is mandatory")
    private String fio_encr;

}
