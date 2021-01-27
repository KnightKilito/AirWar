package cn.goktech;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TestJPanel {
		public static void main(String[] args) {
			//1，介绍JFrame容器
			//1，默认不可见
			//2，默认宽高为0
			//3，JFrame之间不可互相嵌套
			JFrame jf = new JFrame();
			
			jf.setVisible(true);
			//设置标题
			jf.setTitle("飞鸟游戏");
			//设置宽高
			jf.setSize(400, 600);
			//设置居中
			jf.setLocationRelativeTo(null);
			//设置窗体的关闭模式
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel jPanel = new main();
			
			jf.add(jPanel);
			
			JButton jBotton = new JButton();
			jBotton.setText("登录按钮");
			jBotton.setBackground(Color.BLUE);
			jBotton.setEnabled(true);
			jBotton.setFont(new Font("微软雅黑",Font.BOLD,18));
			
			JTextField jTextField = new JTextField();
			jTextField.setBackground(Color.white);
			jTextField.setEnabled(true);
			jTextField.setForeground(Color.PINK);
			
			//5，将组件放在JPanel上
			jPanel.add(jTextField);
			jPanel.add(jBotton);
			
			JPasswordField pwd = new JPasswordField("888");
			jPanel.add(pwd);
			System.out.println(pwd.getText());
			
			
			
			
		}
}
