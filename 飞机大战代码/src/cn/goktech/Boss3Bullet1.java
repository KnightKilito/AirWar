package cn.goktech;

import javax.swing.ImageIcon;

public class Boss3Bullet1 {
	int X;
	int Y;
	ImageIcon image;
	int width;
	int height;
	int level;
	
	public Boss3Bullet1(int x,int y) {
		this.X=x;
		this.Y=y;
		level=4;
		image = main.boss3bullet1Image;
		width = image.getIconWidth();
		height = image.getIconHeight();
		//X=main.hero.X+main.hero.width/2-width/2;
		//Y=main.hero.Y-main.hero.height/2+height/2;
		
	}
	
	public void move() {
		this.Y +=2;
	}
}
