package com.concord.encryption.controller.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class EncryptRequestDTO {

    @NotNull(message = "Field 'id' is mandatory")
    private Long id;

}
