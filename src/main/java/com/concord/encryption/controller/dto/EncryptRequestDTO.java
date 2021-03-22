package com.concord.encryption.controller.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EncryptRequestDTO {

    @NotNull(message = "Field 'id' is mandatory")
    private Long id;

}
