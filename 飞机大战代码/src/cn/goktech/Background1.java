package cn.goktech;

import javax.swing.ImageIcon;

public class Background1 {
	int X=0;
	int Y=-1612;
	ImageIcon image;
	int width;
	int height;
	int ySpeed;

	public Background1() {

		image = main.background1Image;
		width = image.getIconWidth();
		height = image.getIconHeight();

		ySpeed = 1;
	}

	public void move() {
		this.Y += ySpeed;
		//System.out.println("this.Y="+this.Y);
		if (this.Y >= 10) {
			this.Y = -1612;
		}
	}

}
