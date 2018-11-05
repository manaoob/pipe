package com.swpu.pipe.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
/**
 * �����ļ��Ĺ����࣬�����ļ����޸ġ������Լ�ɾ��
 * @author Allen
 *
 */
public class FileUtil {

	    /**
		 * �ļ������滻:����1�����ã�
		 * @param filePath
		 * @param oldstr
		 * @param newStr
		 */
		private static void autoReplace(String filePath, String oldstr, String newStr) {
			File file = new File(filePath);
			Long fileLength = file.length();
			byte[] fileContext = new byte[fileLength.intValue()];
			FileInputStream in = null;
			PrintWriter out = null;
			try {
				in = new FileInputStream(filePath);
				in.read(fileContext);
				// ���������������
				String str = new String(fileContext, "utf-8");
				str = str.replace(oldstr, newStr);
				out = new PrintWriter(filePath);
				out.write(str);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					out.flush();
					out.close();
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 
		}	
		
		  /** 
	     * ���Ƶ����ļ� 
	     * @param oldPath String ԭ�ļ�·�� �磺c:/fqf.txt 
	     * @param newPath String ���ƺ�·�� �磺f:/fqf.txt 
	     * @return boolean 
	     */ 
	   public static void copyFile(String oldPath, String newPath) { 
	       try { 
	           int bytesum = 0; 
	           int byteread = 0; 
	           File oldfile = new File(oldPath); 
	           if (oldfile.exists()) { //�ļ�����ʱ 
	               InputStream inStream = new FileInputStream(oldPath); //����ԭ�ļ� 
	               FileOutputStream fs = new FileOutputStream(newPath); 
	               byte[] buffer = new byte[1444]; 
	               int length; 
	               while ( (byteread = inStream.read(buffer)) != -1) { 
	                   bytesum += byteread; //�ֽ��� �ļ���С 
	                   //System.out.println(bytesum); 
	                   fs.write(buffer, 0, byteread); 
	               } 
	               inStream.close(); 
	           } 
	       } 
	       catch (Exception e) { 
	           System.out.println("���Ƶ����ļ���������"); 
	           e.printStackTrace(); 

	       } 

	   } 
	   
		   /**
			 * ɾ���ļ�
			 * 
			 * @param pathname
			 * @return
			 * @throws IOException
			 */
			public static boolean deleteFile(String pathname){
				File file = new File(pathname);
				if (file.exists()) {
					file.delete();
					return true;
				}
				return false;
			}		
}
