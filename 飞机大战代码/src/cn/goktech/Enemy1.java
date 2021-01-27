package cn.goktech;

import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy1 {
	int X;
	int Y;
	ImageIcon image;
	int width;
	int height;
	int life;
	int ySpeed;
	int xSpeed;
	
	public Enemy1() {
		
		image = main.enemy1Image;
		width = image.getIconWidth();
		height = image.getIconHeight();
		life=1;
		
		Random r = new Random();
		X = r.nextInt(main.windowWidth-width);
		Y = -height;
		
		ySpeed=3;
		xSpeed=3;
	}
	
	public void move() {
		this.Y += ySpeed;
		this.X += xSpeed;
		//如果碰到有边框就得往左移动
		if(this.X+this.width>=main.windowWidth) {
			xSpeed=-3;
		}
		if(this.X<=0) {
			xSpeed=3;
		}
		
	}
	
	
	
}
