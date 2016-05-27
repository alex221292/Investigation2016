package com.altr.core.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


public class Tools {
    private static final Logger logger = LoggerFactory.getLogger(Tools.class);

    public static boolean isEmpty(List input){
        return input == null || input.size() == 0;
    }

    public static void getPass(){
        String password = "admin";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        logger.info("PASSWORD IS: " + passwordEncoder.encode(password));
    }

}
