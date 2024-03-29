package com.redios.redios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static  String getMd5(String text,int length){
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(text.getBytes());
            byte[] b=messageDigest.digest();
            int i=0;
            StringBuilder builder=new StringBuilder("");
            for (int offset=0;offset<b.length;offset++){
                i=b[offset];
                if (i<0){
                    i+=256;
                }
                if(i<16){
                    builder.append(0);
                }
                builder.append(Integer.toHexString(i));
            }
            return  builder.toString().substring(0,length);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }


}
