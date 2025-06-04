package com.nhom2.project_capybra_system.util;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncodeUtil {
    public static String encode (String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static Boolean check (String password, String encodedPassword){
        return BCrypt.checkpw(password, encodedPassword);
    }
}
