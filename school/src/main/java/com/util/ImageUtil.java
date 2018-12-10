package com.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageUtil {

    //1、定义变量保存生成后的验证码字符串
    static String code="";


    public static String getCode(){
        return code;
    }

    //2、生成验证码
    public static String createcode(){
        code="";//保证每次点击验证码时，进入该方法都要清空上一次生成的code
        String a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 4; i++) {
            int index = (int)(Math.random()*62);
            char b = a.charAt(index);
            code = code+b;
        }
        return  code;
    }

    //3、生成图片
    public static BufferedImage createimage(){
        BufferedImage bi = new BufferedImage(90,30,BufferedImage.TYPE_INT_RGB);
        //1.得到一个画布
        Graphics g = bi.getGraphics();
        //2.添加背景颜色
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,90,30);//(0,0)开始坐标

        //3。添加干扰线
        for (int i = 0; i < 30; i++) {
            Random r = new Random();
            int red = r.nextInt(256);//随机生成整数(0,255]
            int green = r.nextInt(256);
            int blue = r.nextInt(256);
            Color c = new Color(red,green,blue);
            g.setColor(c);
            int x1 = r.nextInt(101);
            int y1 = r.nextInt(31);
            int x2 = r.nextInt(101);
            int y2 = r.nextInt(31);//干扰线的，开始位置和结束位置
            g.drawOval(x1,y1,x2,y2);
        }

        //4.添加文字
        g.setColor(Color.WHITE);
        g.setFont(new Font("宋体",Font.BOLD,25));
        String str = getCode();

        //5.将文字填充到画板中
        g.drawString(str,10,25);
        //6.关闭画布
        g.dispose();

        return  bi;

    }
}
