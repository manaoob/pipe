package com.swpu.pipe.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 操作文件的工具类，包括文件的修改、复制以及删除
 * @author Allen
 *
 */

import com.swpu.pipe.dto.DataShowDto;
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
			
			/**
			 * 以字符流的方式读取文件，目的是为了得到在txt文件下的模型的输出数据。
			 * @param pathName
			 * @return 输出数据（文本里面的数据）
			 */
			public static List<String> read(String pathName){	
				List<String> list = new ArrayList<>();
				
		        // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
		        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
		        //不关闭文件会导致资源的泄露，读写文件都同理
		        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
		        try (FileReader reader = new FileReader(pathName);
		             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
		        ) {
		            String line;
		            //网友推荐更加简洁的写法
		            while ((line = br.readLine()) != null) {
		                // 一次读入一行数据
		                list.add(line);
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        return list;
			}
			
			/**
			 * 将数据库查出来的字符串数据 转化成 list 型 方便前端页面展示。
			 * @param list : 一个用于分隔的列表
			 * @return
			 */
			public static DataShowDto StringToArray(List<String> list){
				DataShowDto dataShowDto = new DataShowDto();
				// setCrackJs  
				String str0 = list.get(0);	
				String string0 = str0.substring(1,str0.length()-1);
				String[] arr0 = string0.split(","); // 用,分割
				dataShowDto.setCrackJs(Arrays.asList(arr0));
				
				// setCrackMises  
				String str1 = list.get(1);	
				String string1 = str1.substring(1,str1.length()-1);
				String[] arr1 = string1.split(","); // 用,分割
				dataShowDto.setCrackMises(Arrays.asList(arr1));	
				
				// setAxialMises  
				String str2 = list.get(2);	
				String string2 = str2.substring(1,str2.length()-1);
				String[] arr2 = string2.split(","); // 用,分割
				dataShowDto.setAxialMises(Arrays.asList(arr2));	
				
				// setAxialUs  
				String str3 = list.get(3);	
				String string3 = str3.substring(1,str3.length()-1);
				String[] arr3 = string3.split(","); // 用,分割
				dataShowDto.setAxialUs(Arrays.asList(arr3));	
				
				// setAxialPressure
				String str4 = list.get(4);	
				String string4 = str4.substring(1,str4.length()-1);
				String[] arr4 = string4.split(","); // 用,分割
				dataShowDto.setAxialPressure(Arrays.asList(arr4));	
				
				// setAxialShear
				String str5 = list.get(5);	
				String string5 = str5.substring(1,str5.length()-1);
				String[] arr5 = string5.split(","); // 用,分割
				dataShowDto.setAxialShear(Arrays.asList(arr5));					
				
				return dataShowDto;
			}
			/**
			 * 操作文件，将inp的相关参数进行替换
			 * @param command - dos下的命令代码
			 * @param filePath - 源文件路径
			 * @param newFilePath - 新文件路径
			 * @param oldList - 要替换掉
			 * @param newList - 替换成
			 * @return
			 */
			public static boolean createScriptFile(String command,String filePath,String newFilePath, List<String> oldList, List<String> newList){
				copyFile(filePath,newFilePath);
				for (int i = 0; i < oldList.size(); i++) {
					autoReplace(newFilePath, oldList.get(i), newList.get(i));
				}	
			     command = "cmd /c start C://Users//Administrator//Desktop//editFile.bat";
			        try {
			            Runtime.getRuntime().exec(command);
			            return true;
			        } catch (IOException e) {
			            e.printStackTrace();
			            return false;
				}				
			}
}
