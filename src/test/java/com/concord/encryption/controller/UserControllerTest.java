package com.concord.encryption.controller;

import com.concord.encryption.controller.dto.DecryptRequestDTO;
import com.concord.encryption.controller.dto.DecryptResponseDTO;
import com.concord.encryption.controller.dto.EncryptRequestDTO;
import com.concord.encryption.controller.dto.EncryptResponseDTO;
import com.concord.encryption.entity.User;
import com.concord.encryption.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserControllerTest {

    UserController userController;

    @BeforeEach
    void setup() {
        UserService userService = Mockito.mock(UserService.class);
        User user = new User();
        user.setId(1L);
        user.setFio("Test Testov");
        when(userService.getUserFioById(1L)).thenReturn(user);
        when(userService.decryptUserFio("68599f2cbb845209aab71b68677d439955d31af0f1e957ce7ad3fc19e319b9fb"))
                .thenReturn("Test Testov");
        when(userService.encryptUserFio("Test Testov"))
                .thenReturn("68599f2cbb845209aab71b68677d439955d31af0f1e957ce7ad3fc19e319b9fb");
        this.userController = new UserController(userService);
    }

    @Test
    void encryptUserFio() {
        EncryptRequestDTO encryptRequestDTO = new EncryptRequestDTO();
        encryptRequestDTO.setId(1L);
        EncryptResponseDTO encryptResponseDTO = new EncryptResponseDTO("68599f2cbb845209aab71b68677d439955d31af0f1e957ce7ad3fc19e319b9fb");
        assertEquals(encryptResponseDTO, userController.encryptUserFio(encryptRequestDTO));
    }

    @Test
    void decryptUserFio() {
        DecryptRequestDTO decryptRequestDTO = new DecryptRequestDTO();
        decryptRequestDTO.setFio_encr("68599f2cbb845209aab71b68677d439955d31af0f1e957ce7ad3fc19e319b9fb");
        DecryptResponseDTO decryptResponseDTO = new DecryptResponseDTO("Test Testov");
        assertEquals(decryptResponseDTO, userController.decryptUserFio(decryptRequestDTO));
    }

}