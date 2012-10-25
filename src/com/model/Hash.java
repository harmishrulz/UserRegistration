package com.model;

import java.security.MessageDigest;

public class Hash {

	public static String toMd5(String chain) {
	    MessageDigest md;
	    try {
	        md = MessageDigest.getInstance("MD5");
	        md.update(chain.getBytes("UTF-8"));
	        byte[] mb = md.digest();
	        String out = "";
	        for (int i = 0; i < mb.length; i++) {
	            byte temp = mb[i];
	            String s = Integer.toHexString(new Byte(temp));
	            while (s.length() < 2) {
	                s = "0" + s;
	            }
	            s = s.substring(s.length() - 2);
	            out += s;
	        }
	        return out;

	    } catch (Exception e) {
	        System.out.println("ERROR: " + e.getMessage());
	    }
	    return null;
	}
	
	public static void main(String args[]) {
		
		String s1 = toMd5("hello world!");
		String s2 = toMd5("hello world!");
		System.out.println(s1);
		System.out.println(s2);
	}

	
	
}
