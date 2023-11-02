package com.ssafy.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class UserUtil {
	 public String getSalt() {
	        //1. Random, salt 생성
	        SecureRandom sr = new SecureRandom();
	        byte[] salt = new byte[20];

	        //2. 난수 생성
	        sr.nextBytes(salt);

	        //3. byte To String (10진수 문자열로 변경)
	        StringBuffer sb = new StringBuffer();
	        for(byte b : salt) {
	            sb.append(String.format("%02x", b));
	        }

	        return sb.toString();
	    }

	  	// SHA-256 알고리즘 적용
	    public String getEncrypt(String pwd, String salt) {
	        String result = "";
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");

	            md.update((pwd + salt).getBytes());
	            byte[] pwdSalt = md.digest();

	            StringBuffer sb = new StringBuffer();
	            for(byte b : pwdSalt) {
	                sb.append(String.format("%02x", b));
	            }

	            result = sb.toString();

	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }

	        return result;
	    }

}
