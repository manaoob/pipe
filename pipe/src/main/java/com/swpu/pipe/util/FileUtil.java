package com.swpu.pipe.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
/**
 * 操作文件的工具类，包括文件的修改、复制以及删除
 * @author Allen
 *
 */
public class FileUtil {

	    /**
		 * 文件内容替换:方法1（可用）
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
				// 避免出现中文乱码
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
	     * 复制单个文件 
	     * @param oldPath String 原文件路径 如：c:/fqf.txt 
	     * @param newPath String 复制后路径 如：f:/fqf.txt 
	     * @return boolean 
	     */ 
	   public static void copyFile(String oldPath, String newPath) { 
	       try { 
	           int bytesum = 0; 
	           int byteread = 0; 
	           File oldfile = new File(oldPath); 
	           if (oldfile.exists()) { //文件存在时 
	               InputStream inStream = new FileInputStream(oldPath); //读入原文件 
	               FileOutputStream fs = new FileOutputStream(newPath); 
	               byte[] buffer = new byte[1444]; 
	               int length; 
	               while ( (byteread = inStream.read(buffer)) != -1) { 
	                   bytesum += byteread; //字节数 文件大小 
	                   //System.out.println(bytesum); 
	                   fs.write(buffer, 0, byteread); 
	               } 
	               inStream.close(); 
	           } 
	       } 
	       catch (Exception e) { 
	           System.out.println("复制单个文件操作出错"); 
	           e.printStackTrace(); 

	       } 

	   } 
	   
		   /**
			 * 删除文件
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
