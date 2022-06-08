package com.xjj.java.match;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Matches extends Exception{

    private static final long serialVersionUID = 1L;
    private static final int Min_Matchs = 20; //Define a constant that sets the minimum number of matches to 20
    private static final int Max_Matchs = 50; //Define a constant that sets the maximum number of matches to 20
    private static final int MAX_TAKE = 3; //Define a constant and set the maximum number of matches to 3
    private static final int Delay = 100; //Define a constant that sets the delay time to 100
    private JFrame Frame; //Define main frame variables
    private PaintPanel[] paints; //Define my own panel array variables
    private JButton compBtn; //Define computer button properties
    private JButton start; //Define initialization button properties
    private JButton back; //Define back button properties
    private JButton userBtn1; //Define the button for players to take a match
    private JButton userBtn2; //Define the button for players to take two matches
    private JButton userBtn3; //Define the button for players to take three matches
    private int takeCnt; //Define a variable to count the number of matches held by the computer last time
    private int count_u; //Define a variable to count the number of matches held by the user last time
    private JLabel compText; //Define a label that prints the number of matches held by the computer
    private Timer timer; //Define timer variables
    Matches() {
        /*
         * Define a construction method to complete the initialization of the game interface
         *
         */
        Frame = new JFrame();//Instantiate a main window
        Frame.setResizable(false);//The specified size is not variable
        Frame.setTitle("Match game");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();//Instantiate a main panel
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(3200,1600)); //Define the size of a panel
        Font font = new Font("Dialog", 1, 50);//Define font style
        Frame.add(mainPanel);
        JLabel label_C = new JLabel("Computer"); //Define a computer label
        label_C.setFont(font);
        label_C.setHorizontalAlignment(JLabel.CENTER);
        label_C.setBounds(30,50,270,130);
        mainPanel.add(label_C);

        /*
         * Defines the properties of the initialization button
         */
        start = new JButton("Start");
        start.addActionListener(new ActionListener() { //Define the click event of the start button
            //Create event listener
            @Override
            public void actionPerformed(ActionEvent e) {
                takeCnt = 0;
                count_u = 0;
                init();
                compText.setText("");
                start.setToolTipText("Press here will restart the game.");
            }
        });
        start.setToolTipText("Press here will start the game.");
        start.setBounds(1250,150,120,50);
        mainPanel.add(start);
        JLabel label_P = new JLabel("Player");
        label_P.setHorizontalAlignment(JLabel.CENTER);
        label_P.setBounds(1300,50,170,130);
        label_P.setFont(font);
        mainPanel.add(label_P);

        compBtn = new JButton("Computer First"); // Define the button for computer first access
        compBtn.addActionListener(new ActionListener() { //Set the click event of the computer first take button
            //Create event listener
            @Override
            public void actionPerformed(ActionEvent e) {
                compTake();
                back.setEnabled(true);
            }
        });
        compBtn.setBounds(40,150,250,130);
        compBtn.setToolTipText("Press here computer will pick up first!");
        compBtn.setFont(new Font("Dialog", 1, 30));
        mainPanel.add(compBtn);

        compText = new JLabel();
        compText.setBounds(40,150,400,80);
        compText.setFont(font);
        mainPanel.add(compText);

        userBtn1 = new JButton("1"); //定义玩家取1根火柴的按钮
        userBtn1.addActionListener(new ActionListener() { //设置玩家取1根火柴的点击事件
            //创建事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                userTake userTake = new userTake();
                userTake.take(1);  //调用玩家取火柴的方法
                back.setEnabled(true);
            }
        });
        userBtn1.setBounds(1250,210,90,40); //固定按钮的位置和大小
        mainPanel.add(userBtn1);

        userBtn2 = new JButton("2"); //定义玩家取2根火柴的按钮
        userBtn2.addActionListener(new ActionListener() { //设置玩家取2根火柴的点击事件
            //创建事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                userTake userTake = new userTake();
                userTake.take(2);  //调用玩家取火柴的方法
                back.setEnabled(true);
            }
        });
        userBtn2.setBounds(1340,210,90,40); //固定按钮的位置和大小
        mainPanel.add(userBtn2);

        userBtn3 = new JButton("3"); //定义玩家取3根火柴的按钮
        userBtn3.addActionListener(new ActionListener() { //设置玩家取3根火柴的点击事件
            //创建事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                userTake userTake = new userTake();
                userTake.take(3);  //调用玩家取火柴的方法
                back.setEnabled(true);
            }
        });
        userBtn3.setBounds(1430,210,90,40); //固定按钮的位置和大小
        mainPanel.add(userBtn3);

        back = new JButton("Back");  //定义后退的按钮
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                back_M();  //调用类中的后退方法
                compText.setText("Computer backs " + takeCnt + " matches.");
                back.setEnabled(false);
            }
        });
        back.setBounds(1400,150,120,50); //固定按钮的位置和大小
        back.setToolTipText("Press here you can step back."); //设置back按钮停留的提示信息
        mainPanel.add(back);

        paints = new PaintPanel[3]; //调用MyPaintPanel类，实例化三个面板图片
        for(int i=0;i<3;i++) {
            paints[i] = new PaintPanel();
            paints[i].setBounds(150+(500*i),300,1000,1000); //定义面板的位置和大小
            mainPanel.add(paints[i]);
        }
        Frame.pack();
        Frame.setVisible(true); //设置窗口可见
        begin(); //程序运行开始界面展示
    }
    private void begin() { //定义程序开始界面的属性
        if(timer != null) {  //判断是否为程序刚运行时刻
            timer.cancel();
        }
        timer = new Timer();
        compText.setText("");
        compBtn.setEnabled(false); //设置按钮不可用
        userBtn1.setEnabled(false);
        userBtn2.setEnabled(false);
        userBtn3.setEnabled(false);
        back.setVisible(false);
        paints[0].reset();
        paints[1].reset();
        paints[2].reset();
    }
    private void init() {
        paints[0].reset();
        paints[1].reset();
        paints[2].reset();
        compBtn.setEnabled(true);
        userBtn1.setEnabled(true);
        userBtn2.setEnabled(true);
        userBtn3.setEnabled(true);
        back.setVisible(true);
        back.setEnabled(false);
        int num = Min_Matchs + (int)((Max_Matchs + 1 - Min_Matchs) * Math.random());
        for(int i=0;i<num;i++) {
            paints[1].add(i+1);
        }
    }
    private void back_M() {
        for(int i=0;i<count_u;i++) {
            int index = paints[2].remove();
            paints[1].add(index);
        }

        for(int i=0;i<takeCnt;i++) {
            int index = paints[0].remove();
            paints[1].add(index);
        }
    }
    class userTake {
        private void take(int j) {
            count_u = j;
            compBtn.setEnabled(false);
            int rel = paints[1].getCnt();
            if(j > rel) {
                JOptionPane.showMessageDialog(Frame, "There are only " + rel + " matches.");
                return;
            }
            for(int i=0;i<j;i++) {
                int index = paints[1].remove();
                paints[2].add(index);
            }
            if(j == rel) {
                JOptionPane.showMessageDialog(Frame, "Victory!");
                start.setToolTipText("Press here will start the game.");
                begin();
            }
            else {
                compTake();
            }
        }
    }
    private void compTake() {
        compBtn.setEnabled(false);
        comTake comtake = new comTake();
        timer.schedule(comtake,Delay); //Timer是JDK中的定时调度类，主要用来定时触发任务
    }
    class comTake extends TimerTask { //定义电脑拿火柴的类
        public void run() {  //定义运行方法
            int rel = paints[1].getCnt();
            if(rel <= MAX_TAKE) { //当剩余火柴数小于等于最大可取火柴数时，取的火柴数目为剩下的数目
                takeCnt = rel;
            }
            else if(rel % (MAX_TAKE + 1) > 0) { //当大于最大可取火柴数时，取的数目为剩余的火柴数目对3取余加一
                takeCnt = rel % MAX_TAKE + 1;
            }
            else {
                takeCnt = 1 + (int)(MAX_TAKE * Math.random()); //当剩余火柴数目为4的倍数时，取的火柴数目为随机数
            }
            for(int i=0;i<takeCnt;i++) {
                int index = paints[1].remove();
                paints[0].add(index);
            }
            compText.setText("Computer takes " + takeCnt + " matches.");
            compText.setFont(new Font("Dialog", 1, 20));
            if(takeCnt == rel) {
                JOptionPane.showMessageDialog(Frame, "Defeated\n");
                start.setToolTipText("Press here will start the game.");
                begin();
            }
        }
    }
}
