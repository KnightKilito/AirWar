package cn.goktech;

import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy2 {
		int X;
		int Y;
		ImageIcon image;
		int width;
		int height;
		int life;
		int ySpeed;
		int xSpeed;
		
		public Enemy2() {
			
			image = main.enemy2Image;
			width = image.getIconWidth();
			height = image.getIconHeight();
			life=6;
			
			Random r = new Random();
			X = r.nextInt(main.windowWidth-width);
			Y = -height;
			
			ySpeed=2;
			xSpeed=2;
		}
		
		public void move() {
			this.Y += ySpeed;
			this.X += xSpeed;
			//如果碰到有边框就得往左移动
			if(this.X+this.width>=main.windowWidth) {
				xSpeed=-2;
			}
			if(this.X<=0) {
				xSpeed=2;
			}
			
		}
		
}
