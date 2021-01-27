package cn.goktech;

import java.util.Random;

import javax.swing.ImageIcon;

public class Buff2 {
	int X;
	int Y;
	ImageIcon image;
	int width;
	int height;
	int ySpeed;
	int xSpeed;

	public Buff2() {
		
		image = main.buff2Image;
		width = image.getIconWidth();
		height = image.getIconHeight();
		
		Random r = new Random();
		X = r.nextInt(main.windowWidth-width);
		Y = -height;
		
		ySpeed=1;
		xSpeed=1;
	}

	public void move() {
		this.Y += ySpeed;
		this.X += xSpeed;
		// 如果碰到有边框就得往左移动
		if (this.X + this.width >= main.windowWidth) {
			xSpeed = -1;
		}
		if (this.X <= 0) {
			xSpeed = 1;
		}

	}
}
