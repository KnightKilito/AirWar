package cn.goktech;

import java.util.Random;

import javax.swing.ImageIcon;

public class Bullet1 {
	int X;
	int Y;
	ImageIcon image;
	int width;
	int height;
	
	
	public Bullet1(int x,int y) {
		this.X=x;
		this.Y=y;
		image = main.bullet1Image;
		width = image.getIconWidth();
		height = image.getIconHeight();
		//X=main.hero.X+main.hero.width/2-width/2;
		//Y=main.hero.Y-main.hero.height/2+height/2;
		
	}
	
	public void move() {
		this.Y -=2;
	}
}
