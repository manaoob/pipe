package com.swpu.pipe.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64; 
/*
 * md5�����㷨�Ĺ�����
 */
public class MD5Util {
	  public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		    //ȷ�����㷽��
		    MessageDigest md5=MessageDigest.getInstance("MD5");
		    Base64 base64en = new Base64();
		    //���ܺ���ַ���
		    @SuppressWarnings("static-access")
			String newstr=base64en.encodeBase64String(md5.digest(str.getBytes("utf-8")));
		    return newstr;
		  }
		   
		  /**�ж��û������Ƿ���ȷ
		   *newpasswd �û����������
		   *oldpasswd ��ȷ����*/
		  public boolean checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		    if(EncoderByMd5(newpasswd).equals(oldpasswd))
		      return true;
		    else
		      return false;
		  }
}
