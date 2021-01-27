package cn.goktech;

import javax.swing.ImageIcon;

public class Background2 {
	int X=0;
	int Y=-6250;
	ImageIcon image;
	int width;
	int height;
	int ySpeed;

	public Background2() {

		image = main.background2Image;
		width = image.getIconWidth();
		height = image.getIconHeight();

		ySpeed = 1;
	}

	public void move() {
		this.Y += ySpeed;
		//System.out.println("this.Y="+this.Y);
		if (this.Y >= -15) {
			this.Y = -6250;
		}
	}
}
