package com.majeurProjet.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
public class Util {
	//This class is used for generic function, parameters etc...
	
	public static boolean aFieldIsEmpty(String[] params) {
        for (String param : params) {
            if (param.equals("")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSamePasswords(String password, String password2) {
        if (password2.equals(password)) {
            return true;
        }
        return false;
    }
    
    public static void showErrorMessage(HttpServletRequest req ,String message) {
    	//Use to display message to user if need
        req.setAttribute("display", "");
        req.setAttribute("errorMessage", message);
    }

    public static void hideErrorMessage(HttpServletRequest req) {
    	//Use to hide error message to user
        req.setAttribute("display", "none");
        req.setAttribute("errorMessage", "");
    }
    
    public static String encryptPassword(String password) {
    	MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
	    	String encoded = Base64.getEncoder().encodeToString(hash);
	    	return encoded;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	
    }

}
