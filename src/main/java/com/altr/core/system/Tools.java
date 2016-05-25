package com.altr.core.system;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * Created by Алексей on 21.05.2016.
 */
public class Tools {

    public static boolean isEmpty(List input){
        return input == null || input.size() == 0;
    }

    public static String getPass(){
        String password = "admin";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return  passwordEncoder.encode(password);
    }

}
