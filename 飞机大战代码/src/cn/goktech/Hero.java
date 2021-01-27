package cn.goktech;

import javax.swing.ImageIcon;

public class Hero {
		int X;
		int Y;
		ImageIcon image;
		int width;
		int height;
		//int score;
		//int life;
		int fire;
		ImageIcon [] images;
		int index;
		
		
		
		
		public Hero() {
			X = 140;
			Y = 400;
			image = main.hero1Image;
			width = image.getIconWidth();
			height = image.getIconHeight();
			//score=0;
			//life=3;
			fire=0;//初始值为0
			images=new ImageIcon[4];
			
			for (int i = 0; i < images.length; i++) {
				
				images[i]=new ImageIcon("image/hero4-"+i+".png");
			}
			index=0;
			
		}
		public void move(){
			index++;
			image=images[index/4%3];
		}
}
