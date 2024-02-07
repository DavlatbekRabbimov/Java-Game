package org.example.game;

import lombok.AllArgsConstructor;

import java.security.SecureRandom;

@AllArgsConstructor
public class KeyGenerator {

    private final SecureRandom random;

    public KeyGenerator(){
        this.random = new SecureRandom();
    }
    public byte[] generateKey() {
        byte[] key = new byte[32];
        random.nextBytes(key);
        return key;
    }

    public SecureRandom getRandom(){
        return random;
    }

}
