package com.linkedin_microservices.user_service.utils;

import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

@NoArgsConstructor
public class PasswordUtil {

    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
