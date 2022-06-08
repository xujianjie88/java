package com.xjj.java.match;

import java.awt.image.BufferedImage;
import java.util.Stack;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PaintPanel extends Component {  //定义PaintPanel类，实现画板的基本操作

    private static final long serialVersionUID = 1L;
    private BufferedImage bimg;
    private Stack<Integer> data;
    public PaintPanel() {
        bimg = new BufferedImage(400,500,BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g2 = bimg.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 400, 500);
        g2.dispose();
        data = new Stack<Integer>(); //定义data为栈的数据类型
    }
    public void paint(Graphics g) { //初始化画板照片方法
        g.drawImage(bimg, 0, 0, null);
        g.dispose();
    }

    public void add(int num) { //定义火柴添加的方法
        Graphics2D g2 = bimg.createGraphics();
        int loc = data.size();
        int offx = loc % 3 * 80;
        int offy = loc / 3 * 20;
        g2.setColor(Color.YELLOW);
        g2.fillRect(offx+8, offy+8, 65, 8);
        g2.setColor(Color.RED);
        g2.fillArc(offx+68, offy+6, 12,12,0,360);
        g2.setColor(Color.GREEN);
        g2.drawString(String.valueOf(num), offx, offy+g2.getFont().getSize());
        data.push(num); //调用栈的入栈方法
        repaint();
        g2.dispose();
    }
    public int remove() { //定义火柴移动的方法
        Graphics2D g2 = bimg.createGraphics();
        int loc = data.size() - 1;
        int offx = loc % 3 * 80;
        int offy = loc / 3 * 20;
        g2.setColor(Color.WHITE);
        g2.fillRect(offx, offy, 80, 20);
        g2.dispose();
        repaint();
        return data.pop(); //调用栈的出栈方法
    }
    public void reset() { //定义重置画板的方法
        data.clear();
        Graphics2D g2 = bimg.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 250, 400);
        g2.dispose();
        repaint();
    }
    public int getCnt() { //定义一个获取火柴数目的方法
        return data.size();
    }
}