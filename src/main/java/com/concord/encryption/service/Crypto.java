package com.concord.encryption.service;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class Crypto {

    final static String password = "Some password";
    final static String salt = KeyGenerators.string().generateKey();


    public static String encryptString(String stringToEncrypt) {
        String cipherText = "";
        for (int i = 0; i < 10; i++) {
            TextEncryptor encryptor = Encryptors.text(password, salt);
            cipherText = encryptor.encrypt(stringToEncrypt);
        }
        return cipherText;
    }

    public static String decryptString(String cipherText) {
        String decryptedText = "";
        for (int i = 0; i < 10; i++){
            TextEncryptor encryptor = Encryptors.text(password, salt);
            decryptedText = encryptor.decrypt(cipherText);
        }
        return decryptedText;
    }
}
