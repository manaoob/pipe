package com.swpu.pipe.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.support.StaticApplicationContext;


public class PipeUtil {
	
//	private static final SessionFactory sessionFactory = buildSessionFactory();
//	private static SessionFactory buildSessionFactory() {
//		Configuration configuration = new Configuration().configure();//�ײ�Ĭ�ϼ�������srcĿ¼�µ�hibernate.cfg.xml�����ļ������������ļ�����д��
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();//ʵ��������Ǽ�
//		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);//��ȡSession����
//		return sessionFactory;
//	}
//
//	public static SessionFactory getSessionFactory() {
//		return sessionFactory;
//
//	}
	
	/**
	 * ���ɶ�ά��Ĺ�����
	 * @param request
	 * @param response
	 */
	public static void CreateQRCode(HttpServletRequest request, HttpServletResponse response){
        // ����һ����100,��50,�Ҳ���͸��ɫ��image���� 100 50
        BufferedImage bi = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        //RGBɫ��
        Color c = new Color(200, 150, 255);
        // ���еı���ɫ
        g.setColor(c);
        // ��ɫ�������
        g.fillRect(0, 0, 100, 50);

        // ������֤���ַ�����
        char[] ch = "ABCDEFGHIJKLMNPQRSTUVWXYZ0123456798".toCharArray();
        Random r = new Random();
        int len = ch.length;
        int index;
        StringBuffer sb = new StringBuffer();
        // ȡ���ĸ�����
        for (int i = 0; i < 4; i++) {
            // ѭ���Ĵ����ȡ���ȶ���Ϊ����
            index = r.nextInt(len);
            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
            Font font = new Font("Times New Roman", Font.ITALIC, 18);
            g.setFont(font);
            g.drawString(ch[index] + "", (i * 18) + 10, 30);
            sb.append(ch[index]);
        }
        //����Session��
        request.getSession().setAttribute("code", sb.toString());
        try {
            ImageIO.write(bi, "JPG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public static String getSuffix(String currentFilename) {
		return currentFilename.lastIndexOf(".") > 0 ? currentFilename.substring(currentFilename.lastIndexOf(".")) : "";
	}

	public static String getRandomFileName(String currentFilename) {
		return UUID.randomUUID().toString() + getSuffix(currentFilename);
	}
	
	/**
	 * ���abaqus�����Ƿ����С�
	 * @param program
	 * @return
	 */
	public static boolean judgeRuning(String program){
			Runtime runtime = Runtime.getRuntime();
        
        try {
            Process process = runtime.exec("cmd /c Tasklist");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String s;
            while ((s = in.readLine()) != null) {
                s = s.toLowerCase();
                if (s.startsWith(program)) {
                    return true;
                }
               
            }            	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
         return false;
		}
}
	
