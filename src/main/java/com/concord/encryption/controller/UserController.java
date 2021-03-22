package com.concord.encryption.controller;

import com.concord.encryption.controller.dto.DecryptRequestDTO;
import com.concord.encryption.controller.dto.DecryptResponseDTO;
import com.concord.encryption.controller.dto.EncryptRequestDTO;
import com.concord.encryption.controller.dto.EncryptResponseDTO;
import com.concord.encryption.entity.User;
import com.concord.encryption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private static final Logger logger = LogManager.getLogger(UserController.class.getName());

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/encrypt")
    public EncryptResponseDTO encryptUserFio(@Valid @RequestBody EncryptRequestDTO encryptRequestDTO) {
        User user = userService.getUserFioById(encryptRequestDTO.getId());
        EncryptResponseDTO encryptResponseDTO = new EncryptResponseDTO(userService.encryptUserFio(user.getFio()));
        logger.info(encryptRequestDTO.toString());
        logger.info(encryptResponseDTO.toString());
        return encryptResponseDTO;
    }

    @PostMapping("/decrypt")
    public DecryptResponseDTO decryptUserFio(@Valid @RequestBody DecryptRequestDTO decryptRequestDTO){
        DecryptResponseDTO decryptResponseDTO = new DecryptResponseDTO(userService.decryptUserFio(decryptRequestDTO.getFio_encr()));
        logger.info(decryptRequestDTO.toString());
        logger.info(decryptResponseDTO.toString());
        return decryptResponseDTO;
    }

}
