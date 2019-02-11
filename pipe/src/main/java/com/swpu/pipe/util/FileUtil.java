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
 * �����ļ��Ĺ����࣬�����ļ����޸ġ������Լ�ɾ��
 * @author Allen
 *
 */

import com.swpu.pipe.dto.DataShowDto;
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
			
			/**
			 * ���ַ����ķ�ʽ��ȡ�ļ���Ŀ����Ϊ�˵õ���txt�ļ��µ�ģ�͵�������ݡ�
			 * @param pathName
			 * @return ������ݣ��ı���������ݣ�
			 */
			public static List<String> read(String pathName){	
				List<String> list = new ArrayList<>();
				
		        // ����·�������·�������ԣ�д���ļ�ʱ��ʾ���·��,��ȡ����·����input.txt�ļ�
		        //��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw;
		        //���ر��ļ��ᵼ����Դ��й¶����д�ļ���ͬ��
		        //Java7��try-with-resources�������Źر��ļ����쳣ʱ�Զ��ر��ļ�����ϸ���https://stackoverflow.com/a/12665271
		        try (FileReader reader = new FileReader(pathName);
		             BufferedReader br = new BufferedReader(reader) // ����һ�����������ļ�����ת�ɼ�����ܶ���������
		        ) {
		            String line;
		            //�����Ƽ����Ӽ���д��
		            while ((line = br.readLine()) != null) {
		                // һ�ζ���һ������
		                list.add(line);
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        return list;
			}
			
			/**
			 * �����ݿ��������ַ������� ת���� list �� ����ǰ��ҳ��չʾ��
			 * @param list : һ�����ڷָ����б�
			 * @return
			 */
			public static DataShowDto StringToArray(List<String> list){
				DataShowDto dataShowDto = new DataShowDto();
				// setCrackJs  
				String str0 = list.get(0);	
				String string0 = str0.substring(1,str0.length()-1);
				String[] arr0 = string0.split(","); // ��,�ָ�
				dataShowDto.setCrackJs(Arrays.asList(arr0));
				
				// setCrackMises  
				String str1 = list.get(1);	
				String string1 = str1.substring(1,str1.length()-1);
				String[] arr1 = string1.split(","); // ��,�ָ�
				dataShowDto.setCrackMises(Arrays.asList(arr1));	
				
				// setAxialMises  
				String str2 = list.get(2);	
				String string2 = str2.substring(1,str2.length()-1);
				String[] arr2 = string2.split(","); // ��,�ָ�
				dataShowDto.setAxialMises(Arrays.asList(arr2));	
				
				// setAxialUs  
				String str3 = list.get(3);	
				String string3 = str3.substring(1,str3.length()-1);
				String[] arr3 = string3.split(","); // ��,�ָ�
				dataShowDto.setAxialUs(Arrays.asList(arr3));	
				
				// setAxialPressure
				String str4 = list.get(4);	
				String string4 = str4.substring(1,str4.length()-1);
				String[] arr4 = string4.split(","); // ��,�ָ�
				dataShowDto.setAxialPressure(Arrays.asList(arr4));	
				
				// setAxialShear
				String str5 = list.get(5);	
				String string5 = str5.substring(1,str5.length()-1);
				String[] arr5 = string5.split(","); // ��,�ָ�
				dataShowDto.setAxialShear(Arrays.asList(arr5));					
				
				return dataShowDto;
			}
			/**
			 * �����ļ�����inp����ز��������滻
			 * @param command - dos�µ��������
			 * @param filePath - Դ�ļ�·��
			 * @param newFilePath - ���ļ�·��
			 * @param oldList - Ҫ�滻��
			 * @param newList - �滻��
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
