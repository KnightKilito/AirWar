package cn.goktech;

import java.util.Random;

import javax.swing.ImageIcon;

public class Boss2 {
	int X;
	int Y;
	ImageIcon image;
	int width;
	int height;
	int life;
	int ySpeed;
	int xSpeed;
	
	public Boss2() {
		
		image = main.boss2Image;
		width = image.getIconWidth();
		height = image.getIconHeight();
		life=450;
		
		Random r = new Random();
		X = r.nextInt(main.windowWidth-width);
		Y = -height;
		
		ySpeed=1;
		xSpeed=1;
	}
	
	public void move() {
		this.Y += ySpeed;
		this.X += xSpeed;
		//如果碰到有边框就得往左移动
		if(this.X+this.width>=main.windowWidth) {
			xSpeed=-1;
		}
		if(this.X<=0) {
			xSpeed=1;
		}
		if(this.Y>=100) {
			ySpeed=0;
		}
		
	}
}
