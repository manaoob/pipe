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
//		Configuration configuration = new Configuration().configure();//底层默认加载配置src目录下的hibernate.cfg.xml配置文件，所以配置文件名称写死
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();//实例化服务登记
//		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);//获取Session工厂
//		return sessionFactory;
//	}
//
//	public static SessionFactory getSessionFactory() {
//		return sessionFactory;
//
//	}
	
	/**
	 * 生成二维码的工具类
	 * @param request
	 * @param response
	 */
	public static void CreateQRCode(HttpServletRequest request, HttpServletResponse response){
        // 创建一个宽100,高50,且不带透明色的image对象 100 50
        BufferedImage bi = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        //RGB色彩
        Color c = new Color(200, 150, 255);
        // 框中的背景色
        g.setColor(c);
        // 颜色填充像素
        g.fillRect(0, 0, 100, 50);

        // 定义验证码字符数组
        char[] ch = "ABCDEFGHIJKLMNPQRSTUVWXYZ0123456798".toCharArray();
        Random r = new Random();
        int len = ch.length;
        int index;
        StringBuffer sb = new StringBuffer();
        // 取出四个数字
        for (int i = 0; i < 4; i++) {
            // 循环四次随机取长度定义为索引
            index = r.nextInt(len);
            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
            Font font = new Font("Times New Roman", Font.ITALIC, 18);
            g.setFont(font);
            g.drawString(ch[index] + "", (i * 18) + 10, 30);
            sb.append(ch[index]);
        }
        //放入Session中
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
	 * 监测abaqus程序是否运行。
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
	
