package com.ssafy.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class UserUtil {
	 public String getSalt() {
	        //1. Random, salt 생성
	        SecureRandom secureRandom = new SecureRandom();
	        byte[] salt = new byte[20];

	        //2. 난수 생성
		 	secureRandom.nextBytes(salt);

	        //3. byte To String (10진수 문자열로 변경)
	        StringBuffer stringBuffer = new StringBuffer();
	        for(byte byteSalt : salt) {
				stringBuffer.append(String.format("%02x", byteSalt));
	        }

	        return stringBuffer.toString();
	    }

	  	// SHA-256 알고리즘 적용
	    public String getEncrypt(String pwd, String salt) {
	        String result = "";
	        try {
	            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

				messageDigest.update((pwd + salt).getBytes());
	            byte[] pwdSalt = messageDigest.digest();

	            StringBuffer stringBuffer = new StringBuffer();
	            for(byte bytePwdSalt : pwdSalt) {
					stringBuffer.append(String.format("%02x", bytePwdSalt));
	            }

	            result = stringBuffer.toString();

	        } catch (NoSuchAlgorithmException error) {
	            throw new RuntimeException(error);
	        }

	        return result;
	    }

}
