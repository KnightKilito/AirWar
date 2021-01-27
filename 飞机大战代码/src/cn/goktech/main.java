package cn.goktech;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JPanel {

	static int status = 0;// 0开始前，1运行中，2暂停，3游戏结束
	static int windowWidth = 560;
	static int windowHeight = 824;
	static int heroX = 200;
	static int heroY = 550;
	static int score = 0;// 初始值为0
	static int life = 5;// 初始值为5
	static ImageIcon backImage;
	static ImageIcon background1Image;
	static ImageIcon background2Image;
	static ImageIcon startImage;
	static ImageIcon pauseImage;
	static ImageIcon gameoverImage;
	static ImageIcon victoryImage;
	static ImageIcon hero1Image;
	static ImageIcon enemy1Image;
	static ImageIcon enemy2Image;
	static ImageIcon enemy3Image;
	static ImageIcon boss1Image;
	static ImageIcon boss2Image;
	static ImageIcon boss3Image;
	static ImageIcon buff1Image;
	static ImageIcon buff2Image;
	static ImageIcon bullet1Image;
	static ImageIcon bullet2Image;
	static ImageIcon boss1bullet1Image;
	static ImageIcon boss2bullet1Image;
	static ImageIcon boss3bullet1Image;
	static Hero hero;
	Enemy1[] enemy1s;// 进入游戏后才能创建
	Enemy2[] enemy2s;
	Enemy3[] enemy3s;
	Boss1[] boss1s;
	Boss2[] boss2s;
	Boss3[] boss3s;
	Buff1[] buff1s;
	Buff2[] buff2s;
	Bullet1[] bullet1s;
	Bullet2[] bullet2s;
	Boss1Bullet1[] boss1bullet1s;
	Boss2Bullet1[] boss2bullet1s;
	Boss3Bullet1[] boss3bullet1s;
	Background1 background1;
	Background2 background2;
	int enemy1Index = 0;
	int enemy2Index = 0;
	int enemy3Index = 0;
	int boss1Index = 0;
	int boss2Index = 0;
	int boss3Index = 0;
	int buff1Index = 0;
	int buff2Index = 0;
	int bullet1Index = 0;
	int bullet2Index = 0;
	int boss1bullet1Index = 0;
	int boss2bullet1Index = 0;
	int boss3bullet1Index = 0;

	public void initialization() {
		background1Image = new ImageIcon("image/background2.png");
		background2Image = new ImageIcon("image/background3.png");
		backImage = new ImageIcon("image/background1.png");
		startImage = new ImageIcon("image/start1.png");
		pauseImage = new ImageIcon("image/pause1.png");
		gameoverImage = new ImageIcon("image/gameover1.png");
		victoryImage = new ImageIcon("image/victory1.png");
		hero1Image = new ImageIcon("image/hero1-1.png");
		enemy1Image = new ImageIcon("image/enemy1.png");
		enemy2Image = new ImageIcon("image/enemy2.png");
		enemy3Image = new ImageIcon("image/enemy3.png");
		boss1Image = new ImageIcon("image/boss1.png");
		boss2Image = new ImageIcon("image/boss2.png");
		boss3Image = new ImageIcon("image/boss3.png");
		buff1Image = new ImageIcon("image/buff1.png");
		buff2Image = new ImageIcon("image/buff2.png");
		bullet1Image = new ImageIcon("image/bullet1.png");
		bullet2Image = new ImageIcon("image/bullet2.png");
		boss1bullet1Image = new ImageIcon("image/boss1bullet1.png");
		boss2bullet1Image = new ImageIcon("image/boss2bullet1.png");
		boss3bullet1Image = new ImageIcon("image/boss3bullet1.png");
		hero = new Hero();
		enemy1s = new Enemy1[0];
		enemy2s = new Enemy2[0];
		enemy3s = new Enemy3[0];
		boss1s = new Boss1[0];
		boss2s = new Boss2[0];
		boss3s = new Boss3[0];
		buff1s = new Buff1[0];
		buff2s = new Buff2[0];
		bullet1s = new Bullet1[0];
		bullet2s = new Bullet2[0];
		boss1bullet1s = new Boss1Bullet1[0];
		boss2bullet1s = new Boss2Bullet1[0];
		boss3bullet1s = new Boss3Bullet1[0];
		background1 = new Background1();
		background2 = new Background2();

	}

	public main() {
		initialization();
		action();
		startTimeTask();
	}

	// paint+alt+/
	@Override
	public void paint(Graphics g) {

		// 实现飞机大战游戏开始前的图像界面
		// 1，先读取图片，绘制图片

		g.drawImage(backImage.getImage(), 0, 0, null);

		g.drawImage(background1.image.getImage(), background1.X, background1.Y, null);
		if (hero.fire >= 4) {
			g.drawImage(background2.image.getImage(), background2.X, background2.Y, null);
		}
		switch (status) {
		case 0:
			g.drawImage(startImage.getImage(), 0, 0, null);
			break;
		case 1:

			break;
		case 2:
			g.drawImage(pauseImage.getImage(), 0, 0, null);
			break;
		case 3:
			g.drawImage(gameoverImage.getImage(), 0, 0, null);
			break;
		case 4:
			g.drawImage(victoryImage.getImage(), 0, 0, null);
			break;
		}

		// 绘制子弹
		for (int i = 0; i < bullet1s.length; i++) {
			g.drawImage(bullet1s[i].image.getImage(), bullet1s[i].X, bullet1s[i].Y, null);
		}

		for (int i = 0; i < bullet2s.length; i++) {
			g.drawImage(bullet2s[i].image.getImage(), bullet2s[i].X, bullet2s[i].Y, null);
		}

		for (int i = 0; i < boss1bullet1s.length; i++) {
			g.drawImage(boss1bullet1s[i].image.getImage(), boss1bullet1s[i].X, boss1bullet1s[i].Y, null);
		}
		for (int i = 0; i < boss2bullet1s.length; i++) {
			g.drawImage(boss2bullet1s[i].image.getImage(), boss2bullet1s[i].X, boss2bullet1s[i].Y, null);

		}
		for (int i = 0; i < boss3bullet1s.length; i++) {
			g.drawImage(boss3bullet1s[i].image.getImage(), boss3bullet1s[i].X, boss3bullet1s[i].Y, null);

		}
		// 绘制英雄机
		g.drawImage(hero.image.getImage(), hero.X, hero.Y, null);
		// 绘制敌机、boss、....
		for (int i = 0; i < enemy1s.length; i++) {
			g.drawImage(enemy1s[i].image.getImage(), enemy1s[i].X, enemy1s[i].Y, null);
		}
		for (int i = 0; i < enemy2s.length; i++) {
			g.drawImage(enemy2s[i].image.getImage(), enemy2s[i].X, enemy2s[i].Y, null);
		}
		for (int i = 0; i < enemy3s.length; i++) {
			g.drawImage(enemy3s[i].image.getImage(), enemy3s[i].X, enemy3s[i].Y, null);
		}
		for (int i = 0; i < boss1s.length; i++) {
			g.drawImage(boss1s[i].image.getImage(), boss1s[i].X, boss1s[i].Y, null);
		}
		for (int i = 0; i < boss2s.length; i++) {
			g.drawImage(boss2s[i].image.getImage(), boss2s[i].X, boss2s[i].Y, null);
		}
		for (int i = 0; i < boss3s.length; i++) {
			g.drawImage(boss3s[i].image.getImage(), boss3s[i].X, boss3s[i].Y, null);
		}
		for (int i = 0; i < buff1s.length; i++) {
			g.drawImage(buff1s[i].image.getImage(), buff1s[i].X, buff1s[i].Y, null);
		}
		for (int i = 0; i < buff2s.length; i++) {
			g.drawImage(buff2s[i].image.getImage(), buff2s[i].X, buff2s[i].Y, null);
		}

		// 2，绘制左上角文字
		// 设置画笔的文字样式，先设置再画

		g.setColor(Color.black);
		g.setFont(new Font("微软雅黑", Font.BOLD, 22));
		g.drawString("Score：" + score, 10, 30);
		g.drawString("Life ：" + life, 10, 60);
		g.drawString("Fire ：" + hero.fire, 10, 90);
	}

	// 定时器任务
	public void startTimeTask() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (status == 1) {

					// 定时产生敌机、子弹、buff、boss...
					creatEnemy1s();
					moveEnemy1s();
					creatBuff1s();
					moveBuff1s();
					hero.move();
					Enemy1HitHero();
					Buff1HitHero();
					removeEnemy1();
					removeBuff1();
					JudgeScore();
					JudgeFire();
					repaint();
				}
			}
		};
		timer.schedule(task, 10, 20);
	}

	// 判断火力值来升级导弹、地图
	public void JudgeFire() {
		if (hero.fire <= 3) {
			creatBullet1s();
			moveBullet1s();
			Bullet1HitEnemy1();
			Bullet1HitEnemy2();
			Bullet1HitEnemy3();
			Bullet1HitBoss1();
			Bullet1HitBoss2();
			Bullet1HitBoss3();
			removeBullet1();
			background1.move();
		} else if (hero.fire >= 4 /* && hero.fire<7 */) {
			// 清空页面上残留的一号子弹
			/*
			 * for (int i = 0; i < bullet1s.length; i++) { bullet1s[i] =
			 * bullet1s[bullet1s.length - 1]; bullet1s = Arrays.copyOf(bullet1s,
			 * bullet1s.length - 1); }
			 */

			moveBullet1s();
			Bullet1HitEnemy1();
			Bullet1HitEnemy2();
			Bullet1HitEnemy3();
			Bullet1HitBoss1();
			Bullet1HitBoss2();
			Bullet1HitBoss3();
			removeBullet1();

			creatBullet2s();
			moveBullet2s();
			Bullet2HitEnemy1();
			Bullet2HitEnemy2();
			Bullet2HitEnemy3();
			Bullet2HitBoss1();
			Bullet2HitBoss2();
			Bullet2HitBoss3();
			removeBullet2();
			background2.move();
		}
	}

	// 判断得分情况，增加难度、判定胜利
	public void JudgeScore() {
		if (score >= 18) {
			creatEnemy2s();
			moveEnemy2s();
			Enemy2HitHero();
			removeEnemy2();
		}
		if (score >= 20) {
			creatBuff2s();
			moveBuff2s();
			Buff2HitHero();
			removeBuff2();
		}
		if (score >= 60) {
			creatEnemy3s();
			move1Enemy3s();
			Enemy3HitHero();
			removeEnemy3();
		}
		if (score >= 140) {
			creatEnemy3s();
			move2Enemy3s();
			Enemy3HitHero();
			removeEnemy3();
		}
		if (score >= 200) {
			creatBoss1();
			moveBoss1();
			Boss1HitHero();
			creatBoss1Bullet1s();
			moveBoss1Bullet1s();
			Boss1Bullet1HitHero();
			removeBoss1Bullet1();
			removeBoss1();
		}
		if (score >= 400) {
			creatBoss2();
			moveBoss2();
			Boss2HitHero();
			creatBoss2Bullet1s();
			moveBoss2Bullet1s();
			Boss2Bullet1HitHero();
			removeBoss2Bullet1();
			removeBoss2();
		}
		if (score >= 600) {
			creatBoss3();
			moveBoss3();
			Boss3HitHero();
			creatBoss3Bullet1s();
			moveBoss3Bullet1s();
			Boss3Bullet1HitHero();
			removeBoss3Bullet1();
			removeBoss3();
		}
		if (score >= 1200) {
			initialization();
			status = 4;
		}
	}

	public void creatBullet1s() {
		if (status == 1) {
			bullet1Index++;
			if (bullet1Index % 50 == 0) {
				bullet2Index = 0;
				if (hero.fire == 1) {
					// 发射双发子弹
					Bullet1 bullet1 = new Bullet1(hero.X + hero.width / 4 - bullet1Image.getIconWidth() / 2, hero.Y);
					Bullet1 bullet2 = new Bullet1(hero.X + hero.width * 3 / 4 - bullet1Image.getIconWidth() / 2,
							hero.Y);

					bullet1s = Arrays.copyOf(bullet1s, bullet1s.length + 2);
					bullet1s[bullet1s.length - 2] = bullet1;
					bullet1s[bullet1s.length - 1] = bullet2;
					System.out.println("子弹：" + bullet1s.length);
				} else if (hero.fire == 2) {
					// 发射三发子弹
					Bullet1 bullet1 = new Bullet1(hero.X + hero.width / 4 - bullet1Image.getIconWidth() / 2, hero.Y);
					Bullet1 bullet2 = new Bullet1(hero.X + hero.width * 3 / 4 - bullet1Image.getIconWidth() / 2,
							hero.Y);
					Bullet1 bullet3 = new Bullet1(hero.X + hero.width / 2 - bullet1Image.getIconWidth() / 2, hero.Y);
					bullet1s = Arrays.copyOf(bullet1s, bullet1s.length + 3);
					bullet1s[bullet1s.length - 3] = bullet1;
					bullet1s[bullet1s.length - 2] = bullet2;
					bullet1s[bullet1s.length - 1] = bullet3;
					System.out.println("子弹：" + bullet1s.length);
				} else if (hero.fire >= 3) {
					// 发射四发子弹
					Bullet1 bullet1 = new Bullet1(hero.X + hero.width * 1 / 4 - bullet1Image.getIconWidth() / 2,
							hero.Y);
					Bullet1 bullet2 = new Bullet1(hero.X + hero.width * 2 / 4 - bullet1Image.getIconWidth() / 2,
							hero.Y);
					Bullet1 bullet3 = new Bullet1(hero.X + hero.width * 3 / 4 - bullet1Image.getIconWidth() / 2,
							hero.Y);
					Bullet1 bullet4 = new Bullet1(hero.X + hero.width * 4 / 4 - bullet1Image.getIconWidth() / 2,
							hero.Y);
					bullet1s = Arrays.copyOf(bullet1s, bullet1s.length + 4);
					bullet1s[bullet1s.length - 4] = bullet1;
					bullet1s[bullet1s.length - 3] = bullet2;
					bullet1s[bullet1s.length - 2] = bullet3;
					bullet1s[bullet1s.length - 1] = bullet4;
					System.out.println("子弹：" + bullet1s.length);
				}

				else {
					// 发射单发子弹

					bullet1Index = 0;
					Bullet1 bullet = new Bullet1(hero.X + hero.width / 2 - bullet1Image.getIconWidth() / 2, hero.Y);
					bullet1s = Arrays.copyOf(bullet1s, bullet1s.length + 1);
					bullet1s[bullet1s.length - 1] = bullet;
					System.out.println("子弹：" + bullet1s.length);
				}
			}
		}

	}

	public void creatBullet2s() {
		if (status == 1) {
			bullet2Index++;
			if (bullet2Index % 50 == 0) {
				bullet2Index = 0;
				if (hero.fire == 5) {
					// 发射双发子弹
					Bullet2 bullet1 = new Bullet2(hero.X + hero.width / 4 - bullet2Image.getIconWidth() / 2, hero.Y);
					Bullet2 bullet2 = new Bullet2(hero.X + hero.width * 3 / 4 - bullet2Image.getIconWidth() / 2,
							hero.Y);
					bullet2s = Arrays.copyOf(bullet2s, bullet2s.length + 2);
					bullet2s[bullet2s.length - 2] = bullet1;
					bullet2s[bullet2s.length - 1] = bullet2;
					System.out.println("子弹2：" + bullet2s.length);
				} else if (hero.fire == 6) {
					// 发射三发子弹
					Bullet2 bullet1 = new Bullet2(hero.X + hero.width / 4 - bullet2Image.getIconWidth() / 2, hero.Y);
					Bullet2 bullet2 = new Bullet2(hero.X + hero.width * 3 / 4 - bullet2Image.getIconWidth() / 2,
							hero.Y);
					Bullet2 bullet3 = new Bullet2(hero.X + hero.width / 2 - bullet2Image.getIconWidth() / 2, hero.Y);
					bullet2s = Arrays.copyOf(bullet2s, bullet2s.length + 3);
					bullet2s[bullet2s.length - 3] = bullet1;
					bullet2s[bullet2s.length - 2] = bullet2;
					bullet2s[bullet2s.length - 1] = bullet3;
					System.out.println("子弹2：" + bullet2s.length);
				} else if (hero.fire >= 7) {
					// 发射四发子弹
					Bullet2 bullet1 = new Bullet2(hero.X + hero.width * 1 / 4 - bullet2Image.getIconWidth(), hero.Y);
					Bullet2 bullet2 = new Bullet2(hero.X + hero.width * 2 / 4 - bullet2Image.getIconWidth(), hero.Y);
					Bullet2 bullet3 = new Bullet2(hero.X + hero.width * 3 / 4 - bullet2Image.getIconWidth(), hero.Y);
					Bullet2 bullet4 = new Bullet2(hero.X + hero.width * 4 / 4 - bullet2Image.getIconWidth(), hero.Y);
					bullet2s = Arrays.copyOf(bullet2s, bullet2s.length + 4);
					bullet2s[bullet2s.length - 4] = bullet1;
					bullet2s[bullet2s.length - 3] = bullet2;
					bullet2s[bullet2s.length - 2] = bullet3;
					bullet2s[bullet2s.length - 1] = bullet4;
					System.out.println("子弹2：" + bullet2s.length);
				}

				else {
					// 发射单发子弹

					bullet2Index = 0;
					Bullet2 bullet = new Bullet2(hero.X + hero.width / 2 - bullet2Image.getIconWidth() / 2,
							hero.Y - hero.height * 1 / 3);
					bullet2s = Arrays.copyOf(bullet2s, bullet2s.length + 1);
					bullet2s[bullet2s.length - 1] = bullet;
					System.out.println("子弹2：" + bullet2s.length);
				}
			}
		}

	}

	public void creatBoss1Bullet1s() {
		if (status == 1) {
			for (int i = 0; i < boss1s.length; i++) {
				if (boss1s[i] != null) {
					boss1bullet1Index++;
					if (boss1bullet1Index % 200 == 0) {
						boss1bullet1Index = 0;
						// 发射双发子弹
						Boss1Bullet1 bullet1 = new Boss1Bullet1(
								boss1s[i].X + boss1s[i].width / 4 - boss1bullet1Image.getIconWidth(),
								boss1s[i].Y + boss1s[i].height / 2);
						Boss1Bullet1 bullet2 = new Boss1Bullet1(
								boss1s[i].X + boss1s[i].width * 3 / 4 - boss1bullet1Image.getIconWidth(),
								boss1s[i].Y + boss1s[i].height / 2);
						boss1bullet1s = Arrays.copyOf(boss1bullet1s, boss1bullet1s.length + 2);
						boss1bullet1s[boss1bullet1s.length - 2] = bullet1;
						boss1bullet1s[boss1bullet1s.length - 1] = bullet2;
						System.out.println("Boss1子弹：" + boss1bullet1s.length);
					}
				}
			}

		}

	}

	public void creatBoss2Bullet1s() {
		if (status == 1) {
			for (int i = 0; i < boss2s.length; i++) {
				if (boss2s[i] != null) {
					boss2bullet1Index++;
					if (boss2bullet1Index % 250 == 0) {
						boss2bullet1Index = 0;
						// 发射3发子弹
						Boss2Bullet1 bullet1 = new Boss2Bullet1(
								boss2s[i].X + boss2s[i].width / 4 - boss2bullet1Image.getIconWidth(),
								boss2s[i].Y + boss2s[i].height / 2);
						Boss2Bullet1 bullet2 = new Boss2Bullet1(
								boss2s[i].X + boss2s[i].width * 3 / 4 - boss2bullet1Image.getIconWidth(),
								boss2s[i].Y + boss2s[i].height / 2);
						Boss2Bullet1 bullet3 = new Boss2Bullet1(
								boss2s[i].X + boss2s[i].width / 2 - boss2bullet1Image.getIconWidth(),
								boss2s[i].Y + boss2s[i].height / 2);
						boss2bullet1s = Arrays.copyOf(boss2bullet1s, boss2bullet1s.length + 3);
						boss2bullet1s[boss2bullet1s.length - 3] = bullet1;
						boss2bullet1s[boss2bullet1s.length - 2] = bullet2;
						boss2bullet1s[boss2bullet1s.length - 1] = bullet3;
						System.out.println("Boss2子弹：" + boss2bullet1s.length);
					}
				}
			}

		}

	}

	public void creatBoss3Bullet1s() {
		if (status == 1) {
			for (int i = 0; i < boss3s.length; i++) {
				if (boss3s[i] != null) {
					boss3bullet1Index++;
					if (boss3bullet1Index % 300 == 0) {
						boss3bullet1Index = 0;
						// 发射四发子弹
						Boss3Bullet1 bullet1 = new Boss3Bullet1(
								boss3s[i].X + boss3s[i].width * 1 / 4 - boss3bullet1Image.getIconWidth(),
								boss3s[i].Y + boss3s[i].height / 2);
						Boss3Bullet1 bullet2 = new Boss3Bullet1(
								boss3s[i].X + boss3s[i].width * 2 / 4 - boss3bullet1Image.getIconWidth(),
								boss3s[i].Y + boss3s[i].height / 2);
						Boss3Bullet1 bullet3 = new Boss3Bullet1(
								boss3s[i].X + boss3s[i].width * 3 / 4 - boss3bullet1Image.getIconWidth(),
								boss3s[i].Y + boss3s[i].height / 2);
						Boss3Bullet1 bullet4 = new Boss3Bullet1(
								boss3s[i].X + boss3s[i].width * 4 / 4 - boss3bullet1Image.getIconWidth(),
								boss3s[i].Y + boss3s[i].height / 2);
						boss3bullet1s = Arrays.copyOf(boss3bullet1s, boss3bullet1s.length + 4);
						boss3bullet1s[boss3bullet1s.length - 4] = bullet1;
						boss3bullet1s[boss3bullet1s.length - 3] = bullet2;
						boss3bullet1s[boss3bullet1s.length - 2] = bullet3;
						boss3bullet1s[boss3bullet1s.length - 1] = bullet4;
						System.out.println("Boss3子弹：" + boss3bullet1s.length);
					}
				}
			}

		}

	}

	public void creatEnemy1s() {
		// 控制住敌机生成的频率
		enemy1Index++;
		if (enemy1Index % 96 == 0) {
			enemy1Index = 0;
			Enemy1 enemy = new Enemy1();
			enemy1s = Arrays.copyOf(enemy1s, enemy1s.length + 1);
			enemy1s[enemy1s.length - 1] = enemy;
			System.out.println("敌机1：" + enemy1s.length);
		}
	}

	public void creatEnemy2s() {
		// 控制住敌机生成的频率

		enemy2Index++;
		if (enemy2Index % 111 == 0) {
			enemy2Index = 0;
			Enemy2 enemy = new Enemy2();
			enemy2s = Arrays.copyOf(enemy2s, enemy2s.length + 1);
			enemy2s[enemy2s.length - 1] = enemy;
			System.out.println("敌机2：" + enemy2s.length);
		}

	}

	public void creatEnemy3s() {
		// 控制住敌机生成的频率
		enemy3Index++;
		if (enemy3Index % 611 == 0) {
			enemy3Index = 0;
			Enemy3 enemy = new Enemy3();
			enemy3s = Arrays.copyOf(enemy3s, enemy3s.length + 1);
			enemy3s[enemy3s.length - 1] = enemy;
			System.out.println("敌机3：" + enemy3s.length);
		}

	}

	public void creatBoss1() {
		// 控制住敌机生成的频率

		boss1Index++;
		if (boss1Index % 2111 == 0) {
			boss1Index = 0;
			Boss1 boss = new Boss1();
			boss1s = Arrays.copyOf(boss1s, boss1s.length + 1);
			boss1s[boss1s.length - 1] = boss;
			System.out.println("boss1：" + boss1s.length);
		}

	}

	public void creatBoss2() {
		// 控制住敌机生成的频率

		boss2Index++;
		if (boss2Index % 2411 == 0) {
			boss2Index = 0;
			Boss2 boss = new Boss2();
			boss2s = Arrays.copyOf(boss2s, boss2s.length + 1);
			boss2s[boss2s.length - 1] = boss;
			System.out.println("boss2：" + boss2s.length);
		}

	}

	public void creatBoss3() {
		// 控制住敌机生成的频率

		boss3Index++;
		if (boss3Index % 3011 == 0) {
			boss3Index = 0;
			Boss3 boss = new Boss3();
			boss3s = Arrays.copyOf(boss3s, boss3s.length + 1);
			boss3s[boss3s.length - 1] = boss;
			System.out.println("boss3：" + boss3s.length);
		}

	}

	public void creatBuff1s() {
		// 控制住Buff生成的频率
		buff1Index++;
		if (buff1Index % 1000 == 0) {
			buff1Index = 0;
			Buff1 buff = new Buff1();
			buff1s = Arrays.copyOf(buff1s, buff1s.length + 1);
			buff1s[buff1s.length - 1] = buff;
			System.out.println("Buff：" + buff1s.length);
		}
	}

	public void creatBuff2s() {
		// 控制住Buff生成的频率
		buff2Index++;
		if (buff2Index % 1200 == 0) {
			buff2Index = 0;
			Buff2 buff2 = new Buff2();
			buff2s = Arrays.copyOf(buff2s, buff2s.length + 1);
			buff2s[buff2s.length - 1] = buff2;
			System.out.println("Buff：" + buff2s.length);
		}
	}

	public void moveEnemy1s() {
		// 面板中每架敌机都得移动
		for (int i = 0; i < enemy1s.length; i++) {
			enemy1s[i].move();
		}
	}

	public void moveEnemy2s() {
		// 面板中每架敌机都得移动
		for (int i = 0; i < enemy2s.length; i++) {
			enemy2s[i].move();
		}
	}

	public void move1Enemy3s() {
		// 面板中每架敌机都得移动
		for (int i = 0; i < enemy3s.length; i++) {
			enemy3s[i].move1();
		}
	}

	public void move2Enemy3s() {
		// 面板中每架敌机都得移动
		for (int i = 0; i < enemy3s.length; i++) {
			enemy3s[i].move2();
		}
	}

	public void moveBoss1() {
		// 面板中每架敌机都得移动
		for (int i = 0; i < boss1s.length; i++) {
			boss1s[i].move();
		}
	}

	public void moveBoss2() {
		// 面板中每架敌机都得移动
		for (int i = 0; i < boss2s.length; i++) {
			boss2s[i].move();
		}
	}

	public void moveBoss3() {
		// 面板中每架敌机都得移动
		for (int i = 0; i < boss3s.length; i++) {
			boss3s[i].move();
		}
	}

	public void moveBuff1s() {
		// 面板中每个buff都得移动
		for (int i = 0; i < buff1s.length; i++) {
			buff1s[i].move();
		}
	}

	public void moveBuff2s() {
		// 面板中每个buff都得移动
		for (int i = 0; i < buff2s.length; i++) {
			buff2s[i].move();
		}
	}

	public void moveBullet1s() {
		// 面板中每发子弹都得移动
		for (int i = 0; i < bullet1s.length; i++) {
			bullet1s[i].move();
		}
	}

	public void moveBullet2s() {
		// 面板中每发子弹都得移动
		for (int i = 0; i < bullet2s.length; i++) {
			bullet2s[i].move();
		}
	}

	public void moveBoss1Bullet1s() {
		// 面板中每发子弹都得移动
		for (int i = 0; i < boss1bullet1s.length; i++) {
			boss1bullet1s[i].move();
		}
	}

	public void moveBoss2Bullet1s() {
		// 面板中每发子弹都得移动
		for (int i = 0; i < boss2bullet1s.length; i++) {
			boss2bullet1s[i].move();
		}
	}

	public void moveBoss3Bullet1s() {
		// 面板中每发子弹都得移动
		for (int i = 0; i < boss3bullet1s.length; i++) {
			boss3bullet1s[i].move();
		}
	}

	// 移除飞出窗体的敌机
	public void removeEnemy1() {
		for (int i = 0; i < enemy1s.length; i++) {
			if (enemy1s[i] != null && enemy1s[i].Y > windowHeight * 2) {
				enemy1s[i] = enemy1s[enemy1s.length - 1];
				enemy1s = Arrays.copyOf(enemy1s, enemy1s.length - 1);
			}
		}
	}

	public void removeEnemy2() {
		for (int i = 0; i < enemy2s.length; i++) {
			if (enemy2s[i] != null && enemy2s[i].Y > windowHeight * 2) {
				// enemys[i]=null;
				enemy2s[i] = enemy2s[enemy2s.length - 1];
				enemy2s = Arrays.copyOf(enemy2s, enemy2s.length - 1);
			}
		}
	}

	public void removeEnemy3() {
		for (int i = 0; i < enemy3s.length; i++) {
			if (enemy3s[i] != null && enemy3s[i].Y > windowHeight * 2) {
				// enemys[i]=null;
				enemy3s[i] = enemy3s[enemy3s.length - 1];
				enemy3s = Arrays.copyOf(enemy3s, enemy3s.length - 1);
			}
		}
	}

	public void removeBoss1() {
		for (int i = 0; i < boss1s.length; i++) {
			if (boss1s[i] != null && boss1s[i].Y > windowHeight * 2) {
				// enemys[i]=null;
				boss1s[i] = boss1s[boss1s.length - 1];
				boss1s = Arrays.copyOf(boss1s, boss1s.length - 1);
			}
		}
	}

	public void removeBoss2() {
		for (int i = 0; i < boss2s.length; i++) {
			if (boss2s[i] != null && boss2s[i].Y > windowHeight * 2) {
				// enemys[i]=null;
				boss2s[i] = boss2s[boss2s.length - 1];
				boss2s = Arrays.copyOf(boss2s, boss2s.length - 1);
			}
		}
	}

	public void removeBoss3() {
		for (int i = 0; i < boss3s.length; i++) {
			if (boss3s[i] != null && boss3s[i].Y > windowHeight * 2) {
				// enemys[i]=null;
				boss3s[i] = boss3s[boss3s.length - 1];
				boss3s = Arrays.copyOf(boss3s, boss3s.length - 1);
			}
		}
	}

	// 移除飞出窗体的buff
	public void removeBuff1() {
		for (int i = 0; i < buff1s.length; i++) {
			if (buff1s[i] != null && buff1s[i].Y > windowHeight * 2) {
				// enemys[i]=null;
				buff1s[i] = buff1s[buff1s.length - 1];
				buff1s = Arrays.copyOf(buff1s, buff1s.length - 1);
			}
		}
	}

	public void removeBuff2() {
		for (int i = 0; i < buff2s.length; i++) {
			if (buff2s[i] != null && buff2s[i].Y > windowHeight * 2) {
				// enemys[i]=null;
				buff2s[i] = buff2s[buff2s.length - 1];
				buff2s = Arrays.copyOf(buff2s, buff2s.length - 1);
			}
		}
	}

	// 移除飞出窗体的子弹
	public void removeBullet1() {
		for (int i = 0; i < bullet1s.length; i++) {
			if (bullet1s[i] != null && bullet1s[i].Y < -windowHeight) {
				// bullets[i]=null;
				bullet1s[i] = bullet1s[bullet1s.length - 1];
				bullet1s = Arrays.copyOf(bullet1s, bullet1s.length - 1);
			}
		}
	}

	public void removeBullet2() {
		for (int i = 0; i < bullet2s.length; i++) {
			if (bullet2s[i] != null && bullet2s[i].Y < -windowHeight) {
				// bullets[i]=null;
				bullet2s[i] = bullet2s[bullet2s.length - 1];
				bullet2s = Arrays.copyOf(bullet2s, bullet2s.length - 1);
			}
		}
	}

	public void removeBoss1Bullet1() {
		for (int i = 0; i < boss1bullet1s.length; i++) {
			if (boss1bullet1s[i] != null && boss1bullet1s[i].Y < -windowHeight) {
				// bullets[i]=null;
				boss1bullet1s[i] = boss1bullet1s[boss1bullet1s.length - 1];
				boss1bullet1s = Arrays.copyOf(boss1bullet1s, boss1bullet1s.length - 1);
			}
		}
	}

	public void removeBoss2Bullet1() {
		for (int i = 0; i < boss2bullet1s.length; i++) {
			if (boss2bullet1s[i] != null && boss2bullet1s[i].Y < -windowHeight) {
				// bullets[i]=null;
				boss2bullet1s[i] = boss2bullet1s[boss2bullet1s.length - 1];
				boss2bullet1s = Arrays.copyOf(boss2bullet1s, boss2bullet1s.length - 1);
			}
		}
	}

	public void removeBoss3Bullet1() {
		for (int i = 0; i < boss3bullet1s.length; i++) {
			if (boss3bullet1s[i] != null && boss3bullet1s[i].Y < -windowHeight) {
				// bullets[i]=null;
				boss3bullet1s[i] = boss3bullet1s[boss3bullet1s.length - 1];
				boss3bullet1s = Arrays.copyOf(boss3bullet1s, boss3bullet1s.length - 1);
			}
		}
	}

	// 判断是否击中敌机
	public void Bullet1HitEnemy1() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet1s.length; i++) {
			for (int j = 0; j < enemy1s.length; j++) {
				if (bullet1s[i].X >= enemy1s[j].X && bullet1s[i].X <= enemy1s[j].X + enemy1s[j].width) {
					if (bullet1s[i].Y >= enemy1s[j].Y && bullet1s[i].Y <= enemy1s[j].Y + enemy1s[j].height) {
						score++;
						flag1 = j;
						flag2 = i;
						break;
					}
				}
			}
			while (flag1 != -1) {
				enemy1s[flag1] = enemy1s[enemy1s.length - 1];
				enemy1s = Arrays.copyOf(enemy1s, enemy1s.length - 1);
				flag1 = -1;
			}
		}
		while (flag2 != -1) {
			bullet1s[flag2] = bullet1s[bullet1s.length - 1];
			bullet1s = Arrays.copyOf(bullet1s, bullet1s.length - 1);
			flag2 = -1;
		}
	}

	public void Bullet1HitEnemy2() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet1s.length; i++) {
			for (int j = 0; j < enemy2s.length; j++) {
				if (bullet1s[i].X >= enemy2s[j].X && bullet1s[i].X <= enemy2s[j].X + enemy2s[j].width) {
					if (bullet1s[i].Y >= enemy2s[j].Y && bullet1s[i].Y <= enemy2s[j].Y + enemy2s[j].height) {
						enemy2s[j].life--;
						flag2 = i;
						if (enemy2s[j].life <= 0) {
							System.out.println("score=" + score);
							flag1 = j;
						}
						break;
					}
				}
			}
			while (flag1 != -1) {
				enemy2s[flag1] = enemy2s[enemy2s.length - 1];
				enemy2s = Arrays.copyOf(enemy2s, enemy2s.length - 1);
				score += 2;
				flag1 = -1;
			}

		}
		while (flag2 != -1) {
			bullet1s[flag2] = bullet1s[bullet1s.length - 1];
			bullet1s = Arrays.copyOf(bullet1s, bullet1s.length - 1);
			flag2 = -1;
		}
	}

	public void Bullet1HitEnemy3() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet1s.length; i++) {
			// if(enemys[i]!=null ) {
			for (int j = 0; j < enemy3s.length; j++) {
				// if(bullets[j]!=null ) {
				if (bullet1s[i].X >= enemy3s[j].X && bullet1s[i].X <= enemy3s[j].X + enemy3s[j].width) {
					if (bullet1s[i].Y >= enemy3s[j].Y && bullet1s[i].Y <= enemy3s[j].Y + enemy3s[j].height) {

						// enemys[i]=null;
						// bullets[i]=null;
						// score++;
						// enemys[i]=enemys[i+1];
						// bullets[j]=bullets[j+1];
						enemy3s[j].life--;
						flag2 = i;
						if (enemy3s[j].life <= 0) {

							System.out.println("score=" + score);
							flag1 = j;
						}
						break;
					}
				}

			}
			while (flag1 != -1) {
				enemy3s[flag1] = enemy3s[enemy3s.length - 1];
				enemy3s = Arrays.copyOf(enemy3s, enemy3s.length - 1);
				score += 3;
				flag1 = -1;

			}

			// }
			// }
		}
		while (flag2 != -1) {
			bullet1s[flag2] = bullet1s[bullet1s.length - 1];
			bullet1s = Arrays.copyOf(bullet1s, bullet1s.length - 1);
			flag2 = -1;

		}
	}

	public void Bullet1HitBoss1() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet1s.length; i++) {
			// if(enemys[i]!=null ) {
			for (int j = 0; j < boss1s.length; j++) {
				// if(bullets[j]!=null ) {
				if (bullet1s[i].X >= boss1s[j].X && bullet1s[i].X <= boss1s[j].X + boss1s[j].width) {
					if (bullet1s[i].Y >= boss1s[j].Y && bullet1s[i].Y <= boss1s[j].Y + boss1s[j].height) {

						boss1s[j].life--;
						flag2 = i;
						if (boss1s[j].life <= 0) {

							System.out.println("score=" + score);
							flag1 = j;
						}
						break;
					}
				}

			}
			while (flag1 != -1) {
				boss1s[flag1] = boss1s[boss1s.length - 1];
				boss1s = Arrays.copyOf(boss1s, boss1s.length - 1);
				score += 6;
				flag1 = -1;

			}

			// }
			// }
		}
		while (flag2 != -1) {
			bullet1s[flag2] = bullet1s[bullet1s.length - 1];
			bullet1s = Arrays.copyOf(bullet1s, bullet1s.length - 1);
			flag2 = -1;

		}
	}

	public void Bullet1HitBoss2() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet1s.length; i++) {
			// if(enemys[i]!=null ) {
			for (int j = 0; j < boss2s.length; j++) {
				// if(bullets[j]!=null ) {
				if (bullet1s[i].X >= boss2s[j].X && bullet1s[i].X <= boss2s[j].X + boss2s[j].width) {
					if (bullet1s[i].Y >= boss2s[j].Y && bullet1s[i].Y <= boss2s[j].Y + boss2s[j].height) {

						boss2s[j].life--;
						flag2 = i;
						if (boss2s[j].life <= 0) {

							System.out.println("score=" + score);
							flag1 = j;
						}
						break;
					}
				}

			}
			while (flag1 != -1) {
				boss2s[flag1] = boss2s[boss2s.length - 1];
				boss2s = Arrays.copyOf(boss2s, boss2s.length - 1);
				score += 9;
				flag1 = -1;

			}

			// }
			// }
		}
		while (flag2 != -1) {
			bullet1s[flag2] = bullet1s[bullet1s.length - 1];
			bullet1s = Arrays.copyOf(bullet1s, bullet1s.length - 1);
			flag2 = -1;
		}
	}

	public void Bullet1HitBoss3() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet1s.length; i++) {
			// if(enemys[i]!=null ) {
			for (int j = 0; j < boss3s.length; j++) {
				// if(bullets[j]!=null ) {
				if (bullet1s[i].X >= boss3s[j].X && bullet1s[i].X <= boss3s[j].X + boss3s[j].width) {
					if (bullet1s[i].Y >= boss3s[j].Y && bullet1s[i].Y <= boss3s[j].Y + boss3s[j].height) {

						boss3s[j].life--;
						flag2 = i;
						if (boss3s[j].life <= 0) {

							System.out.println("score=" + score);
							flag1 = j;
						}
						break;
					}
				}

			}
			while (flag1 != -1) {
				boss3s[flag1] = boss3s[boss3s.length - 1];
				boss3s = Arrays.copyOf(boss3s, boss3s.length - 1);
				score += 12;
				flag1 = -1;

			}

			// }
			// }
		}
		while (flag2 != -1) {
			bullet1s[flag2] = bullet1s[bullet1s.length - 1];
			bullet1s = Arrays.copyOf(bullet1s, bullet1s.length - 1);
			flag2 = -1;

		}
	}

	public void Bullet2HitEnemy1() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet2s.length; i++) {
			// if(enemys[i]!=null ) {
			for (int j = 0; j < enemy1s.length; j++) {
				// if(bullets[j]!=null ) {
				if (bullet2s[i].X >= enemy1s[j].X && bullet2s[i].X <= enemy1s[j].X + enemy1s[j].width) {
					if (bullet2s[i].Y >= enemy1s[j].Y && bullet2s[i].Y <= enemy1s[j].Y + enemy1s[j].height) {

						// enemys[i]=null;
						// bullets[i]=null;
						// score++;
						// enemys[i]=enemys[i+1];
						// bullets[j]=bullets[j+1];
						enemy1s[j].life -= bullet2s[i].level;
						flag2 = i;
						if (enemy1s[j].life <= 0) {

							System.out.println("score=" + score);
							flag1 = j;
						}
						break;
					}
				}

			}
			while (flag1 != -1) {
				enemy1s[flag1] = enemy1s[enemy1s.length - 1];
				enemy1s = Arrays.copyOf(enemy1s, enemy1s.length - 1);
				flag1 = -1;
				score++;
			}

			// }
			// }
		}
		while (flag2 != -1) {
			bullet2s[flag2] = bullet2s[bullet2s.length - 1];
			bullet2s = Arrays.copyOf(bullet2s, bullet2s.length - 1);
			flag2 = -1;

		}
	}

	public void Bullet2HitEnemy2() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet2s.length; i++) {
			for (int j = 0; j < enemy2s.length; j++) {
				if (bullet2s[i].X >= enemy2s[j].X && bullet2s[i].X <= enemy2s[j].X + enemy2s[j].width) {
					if (bullet2s[i].Y >= enemy2s[j].Y && bullet2s[i].Y <= enemy2s[j].Y + enemy2s[j].height) {

						enemy2s[j].life -= bullet2s[i].level;
						flag2 = i;
						if (enemy2s[j].life <= 0) {

							System.out.println("score=" + score);
							flag1 = j;
						}
						break;
					}
				}

			}
			while (flag1 != -1) {
				enemy2s[flag1] = enemy2s[enemy2s.length - 1];
				enemy2s = Arrays.copyOf(enemy2s, enemy2s.length - 1);
				score += 3;
				flag1 = -1;

			}

		}
		while (flag2 != -1) {
			bullet2s[flag2] = bullet2s[bullet2s.length - 1];
			bullet2s = Arrays.copyOf(bullet2s, bullet2s.length - 1);
			flag2 = -1;

		}
	}

	public void Bullet2HitEnemy3() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet2s.length; i++) {
			for (int j = 0; j < enemy3s.length; j++) {
				if (bullet2s[i].X >= enemy3s[j].X && bullet2s[i].X <= enemy3s[j].X + enemy3s[j].width) {
					if (bullet2s[i].Y >= enemy3s[j].Y && bullet2s[i].Y <= enemy3s[j].Y + enemy3s[j].height) {
						enemy3s[j].life -= bullet2s[i].level;
						flag2 = i;
						if (enemy3s[j].life <= 0) {
							System.out.println("score=" + score);
							flag1 = j;
						}
						break;
					}
				}
			}
			while (flag1 != -1) {
				enemy3s[flag1] = enemy3s[enemy3s.length - 1];
				enemy3s = Arrays.copyOf(enemy3s, enemy3s.length - 1);
				score += 3;
				flag1 = -1;
			}
		}
		while (flag2 != -1) {
			bullet2s[flag2] = bullet2s[bullet2s.length - 1];
			bullet2s = Arrays.copyOf(bullet2s, bullet2s.length - 1);
			flag2 = -1;

		}
	}

	public void Bullet2HitBoss1() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet2s.length; i++) {
			// if(enemys[i]!=null ) {
			for (int j = 0; j < boss1s.length; j++) {
				// if(bullets[j]!=null ) {
				if (bullet2s[i].X >= boss1s[j].X && bullet2s[i].X <= boss1s[j].X + boss1s[j].width) {
					if (bullet2s[i].Y >= boss1s[j].Y && bullet2s[i].Y <= boss1s[j].Y + boss1s[j].height) {

						// enemys[i]=null;
						// bullets[i]=null;
						// score++;
						// enemys[i]=enemys[i+1];
						// bullets[j]=bullets[j+1];
						boss1s[j].life -= bullet2s[i].level;
						flag2 = i;
						if (boss1s[j].life <= 0) {

							System.out.println("score=" + score);
							flag1 = j;
						}
						break;
					}
				}

			}
			while (flag1 != -1) {
				boss1s[flag1] = boss1s[boss1s.length - 1];
				boss1s = Arrays.copyOf(boss1s, boss1s.length - 1);
				score += 3;
				flag1 = -1;

			}

			// }
			// }
		}
		while (flag2 != -1) {
			bullet2s[flag2] = bullet2s[bullet2s.length - 1];
			bullet2s = Arrays.copyOf(bullet2s, bullet2s.length - 1);
			flag2 = -1;

		}
	}

	public void Bullet2HitBoss2() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet2s.length; i++) {
			// if(enemys[i]!=null ) {
			for (int j = 0; j < boss2s.length; j++) {
				// if(bullets[j]!=null ) {
				if (bullet2s[i].X >= boss2s[j].X && bullet2s[i].X <= boss2s[j].X + boss2s[j].width) {
					if (bullet2s[i].Y >= boss2s[j].Y && bullet2s[i].Y <= boss2s[j].Y + boss2s[j].height) {

						// enemys[i]=null;
						// bullets[i]=null;
						// score++;
						// enemys[i]=enemys[i+1];
						// bullets[j]=bullets[j+1];
						boss2s[j].life -= bullet2s[i].level;
						flag2 = i;
						if (boss2s[j].life <= 0) {

							System.out.println("score=" + score);
							flag1 = j;
						}
						break;
					}
				}

			}
			while (flag1 != -1) {
				boss2s[flag1] = boss2s[boss2s.length - 1];
				boss2s = Arrays.copyOf(boss2s, boss2s.length - 1);
				score += 3;
				flag1 = -1;

			}

			// }
			// }
		}
		while (flag2 != -1) {
			bullet2s[flag2] = bullet2s[bullet2s.length - 1];
			bullet2s = Arrays.copyOf(bullet2s, bullet2s.length - 1);
			flag2 = -1;

		}
	}

	public void Bullet2HitBoss3() {
		int flag1 = -1;
		int flag2 = -1;
		for (int i = 0; i < bullet2s.length; i++) {
			// if(enemys[i]!=null ) {
			for (int j = 0; j < boss3s.length; j++) {
				// if(bullets[j]!=null ) {
				if (bullet2s[i].X >= boss3s[j].X && bullet2s[i].X <= boss3s[j].X + boss3s[j].width) {
					if (bullet2s[i].Y >= boss3s[j].Y && bullet2s[i].Y <= boss3s[j].Y + boss3s[j].height) {

						// enemys[i]=null;
						// bullets[i]=null;
						// score++;
						// enemys[i]=enemys[i+1];
						// bullets[j]=bullets[j+1];
						boss3s[j].life -= bullet2s[i].level;
						flag2 = i;
						if (boss3s[j].life <= 0) {

							System.out.println("score=" + score);
							flag1 = j;
						}
						break;
					}
				}

			}
			while (flag1 != -1) {
				boss3s[flag1] = boss3s[boss3s.length - 1];
				boss3s = Arrays.copyOf(boss3s, boss3s.length - 1);
				score += 3;
				flag1 = -1;

			}

			// }
			// }
		}
		while (flag2 != -1) {
			bullet2s[flag2] = bullet2s[bullet2s.length - 1];
			bullet2s = Arrays.copyOf(bullet2s, bullet2s.length - 1);
			flag2 = -1;

		}
	}

	public void Boss1Bullet1HitHero() {

		int flag2 = -1;
		for (int i = 0; i < boss1bullet1s.length; i++) {
			// if(enemys[i]!=null ) {

			// if(bullets[j]!=null ) {
			if (boss1bullet1s[i].X >= hero.X && boss1bullet1s[i].X <= hero.X + hero.width) {
				if (boss1bullet1s[i].Y >= hero.Y && boss1bullet1s[i].Y <= hero.Y + hero.height) {

					// enemys[i]=null;
					// bullets[i]=null;
					// score++;
					// enemys[i]=enemys[i+1];
					// bullets[j]=bullets[j+1];
					life -= boss1bullet1s[i].level;
					flag2 = i;

					break;
				}
			}

		}
		while (flag2 != -1) {
			boss1bullet1s[flag2] = boss1bullet1s[boss1bullet1s.length - 1];
			boss1bullet1s = Arrays.copyOf(boss1bullet1s, boss1bullet1s.length - 1);
			flag2 = -1;

		}
		if (life <= 0) {
			initialization();
			status = 3;
		}

	}

	public void Boss2Bullet1HitHero() {

		int flag2 = -1;
		for (int i = 0; i < boss2bullet1s.length; i++) {
			// if(enemys[i]!=null ) {

			// if(bullets[j]!=null ) {
			if (boss2bullet1s[i].X >= hero.X && boss2bullet1s[i].X <= hero.X + hero.width) {
				if (boss2bullet1s[i].Y >= hero.Y && boss2bullet1s[i].Y <= hero.Y + hero.height) {

					life -= boss2bullet1s[i].level;
					flag2 = i;

					break;
				}
			}

		}
		while (flag2 != -1) {
			boss2bullet1s[flag2] = boss2bullet1s[boss2bullet1s.length - 1];
			boss2bullet1s = Arrays.copyOf(boss2bullet1s, boss2bullet1s.length - 1);
			flag2 = -1;

		}
		if (life <= 0) {
			initialization();
			status = 3;
		}

	}

	public void Boss3Bullet1HitHero() {

		int flag2 = -1;
		for (int i = 0; i < boss3bullet1s.length; i++) {
			// if(enemys[i]!=null ) {

			// if(bullets[j]!=null ) {
			if (boss3bullet1s[i].X >= hero.X && boss3bullet1s[i].X <= hero.X + hero.width) {
				if (boss3bullet1s[i].Y >= hero.Y && boss3bullet1s[i].Y <= hero.Y + hero.height) {

					// enemys[i]=null;
					// bullets[i]=null;
					// score++;
					// enemys[i]=enemys[i+1];
					// bullets[j]=bullets[j+1];
					life -= boss3bullet1s[i].level;
					flag2 = i;

					break;
				}
			}

		}
		while (flag2 != -1) {
			boss3bullet1s[flag2] = boss3bullet1s[boss3bullet1s.length - 1];
			boss3bullet1s = Arrays.copyOf(boss3bullet1s, boss3bullet1s.length - 1);
			flag2 = -1;

		}
		if (life <= 0) {
			initialization();
			status = 3;
		}

	}

	// 判断敌机是否击中
	public void Enemy1HitHero() {
		for (int i = 0; i < enemy1s.length; i++) {
			if (enemy1s[i] != null) {
				if ((hero.X - hero.width / 2 >= enemy1s[i].X
						&& hero.X - hero.width / 2 <= enemy1s[i].X + enemy1s[i].width)
						|| (hero.X + hero.width / 2 >= enemy1s[i].X
								&& hero.X + hero.width / 2 <= enemy1s[i].X + enemy1s[i].width)) {
					if ((hero.Y  >= enemy1s[i].Y
							&& hero.Y  <= enemy1s[i].Y + enemy1s[i].height)
							|| (hero.Y + hero.height / 2 >= enemy1s[i].Y
									&& hero.Y + hero.height / 2 <= enemy1s[i].Y + enemy1s[i].height)) {
						life--;
						enemy1s[i] = enemy1s[enemy1s.length - 1];
						enemy1s = Arrays.copyOf(enemy1s, enemy1s.length - 1);

						if (life <= 0) {
							initialization();
							status = 3;
						}
					}
				}
			}
		}
	}

	// 判断敌机2是否击中
	public void Enemy2HitHero() {
		for (int i = 0; i < enemy2s.length; i++) {
			if (enemy2s[i] != null) {
				if ((hero.X - hero.width / 2 >= enemy2s[i].X
						&& hero.X - hero.width / 2 <= enemy2s[i].X + enemy2s[i].width)
						|| (hero.X + hero.width / 2 >= enemy2s[i].X
								&& hero.X + hero.width / 2 <= enemy2s[i].X + enemy2s[i].width)) {
					if ((hero.Y >= enemy2s[i].Y
							&& hero.Y <= enemy2s[i].Y + enemy2s[i].height)
							|| (hero.Y + hero.height / 2 >= enemy2s[i].Y
									&& hero.Y + hero.height / 2 <= enemy2s[i].Y + enemy2s[i].height)) {
						life-=2;
						enemy2s[i] = enemy2s[enemy2s.length - 1];
						enemy2s = Arrays.copyOf(enemy2s, enemy2s.length - 1);

						if (life <= 0) {
							initialization();
							status = 3;
						}
					}
				}
			}
		}
	}

	public void Enemy3HitHero() {
		for (int i = 0; i < enemy3s.length; i++) {
			if (enemy3s[i] != null) {
				if ((hero.X - hero.width / 2 >= enemy3s[i].X
						&& hero.X - hero.width / 2 <= enemy3s[i].X + enemy3s[i].width)
						|| (hero.X + hero.width / 2 >= enemy3s[i].X
								&& hero.X + hero.width / 2 <= enemy3s[i].X + enemy3s[i].width)) {
					if ((hero.Y  >= enemy3s[i].Y
							&& hero.Y <= enemy3s[i].Y + enemy3s[i].height)
							|| (hero.Y + hero.height / 2 >= enemy3s[i].Y
									&& hero.Y + hero.height / 2 <= enemy3s[i].Y + enemy3s[i].height)) {
						life-=3;
						enemy3s[i] = enemy3s[enemy3s.length - 1];
						enemy3s = Arrays.copyOf(enemy3s, enemy3s.length - 1);

						if (life <= 0) {
							initialization();
							status = 3;
						}
					}
				}
			}
		}
	}

	public void Boss1HitHero() {
		for (int i = 0; i < boss1s.length; i++) {
			if (boss1s[i] != null) {
				if ((hero.X - hero.width / 2 >= boss1s[i].X && hero.X - hero.width / 2 <= boss1s[i].X + boss1s[i].width)
						|| (hero.X + hero.width / 2 >= boss1s[i].X
								&& hero.X + hero.width / 2 <= boss1s[i].X + boss1s[i].width)) {
					if ((hero.Y  >= boss1s[i].Y
							&& hero.Y  <= boss1s[i].Y + boss1s[i].height)
							|| (hero.Y + hero.height / 2 >= boss1s[i].Y
									&& hero.Y + hero.height / 2 <= boss1s[i].Y + boss1s[i].height)) {
						life -= boss1s[i].life;
						boss1s[i] = boss1s[boss1s.length - 1];
						boss1s = Arrays.copyOf(boss1s, boss1s.length - 1);
						if (life <= 0) {
							initialization();
							status = 3;
						}
					}
				}
			}
		}
	}

	public void Boss2HitHero() {
		for (int i = 0; i < boss2s.length; i++) {
			if (boss2s[i] != null) {
				if ((hero.X - hero.width / 2 >= boss2s[i].X && hero.X - hero.width / 2 <= boss2s[i].X + boss2s[i].width)
						|| (hero.X + hero.width / 2 >= boss2s[i].X
								&& hero.X + hero.width / 2 <= boss2s[i].X + boss2s[i].width)) {
					if ((hero.Y  >= boss2s[i].Y
							&& hero.Y  <= boss2s[i].Y + boss2s[i].height)
							|| (hero.Y + hero.height / 2 >= boss2s[i].Y
									&& hero.Y + hero.height / 2 <= boss2s[i].Y + boss2s[i].height)) {

						// enemys[i]=null;
						// bullets[i]=null;
						life -= boss2s[i].life;
						boss2s[i] = boss2s[boss2s.length - 1];
						boss2s = Arrays.copyOf(boss2s, boss2s.length - 1);

						if (life <= 0) {
							initialization();
							status = 3;
						}
					}
				}
			}
		}
	}

	public void Boss3HitHero() {
		for (int i = 0; i < boss3s.length; i++) {
			if (boss3s[i] != null) {
				if ((hero.X - hero.width / 2 >= boss3s[i].X && hero.X - hero.width / 2 <= boss3s[i].X + boss3s[i].width)
						|| (hero.X + hero.width / 2 >= boss3s[i].X
								&& hero.X + hero.width / 2 <= boss3s[i].X + boss3s[i].width)) {
					if ((hero.Y  >= boss3s[i].Y
							&& hero.Y  <= boss3s[i].Y + boss3s[i].height)
							|| (hero.Y + hero.height / 2 >= boss3s[i].Y
									&& hero.Y + hero.height / 2 <= boss3s[i].Y + boss3s[i].height)) {
						life -= boss3s[i].life;
						boss3s[i] = boss3s[boss3s.length - 1];
						boss3s = Arrays.copyOf(boss3s, boss3s.length - 1);

						if (life <= 0) {
							initialization();
							status = 3;
						}
					}
				}
			}
		}
	}

	// 判断Buff1是否击中
	public void Buff1HitHero() {
		for (int i = 0; i < buff1s.length; i++) {
			if (buff1s[i] != null) {
				if ((hero.X - hero.width / 2 >= buff1s[i].X && hero.X - hero.width / 2 <= buff1s[i].X + buff1s[i].width)
						|| (hero.X + hero.width / 2 >= buff1s[i].X
								&& hero.X + hero.width / 2 <= buff1s[i].X + buff1s[i].width)) {
					if ((hero.Y >= buff1s[i].Y
							&& hero.Y  <= buff1s[i].Y + buff1s[i].height)
							|| (hero.Y + hero.height / 2 >= buff1s[i].Y
									&& hero.Y + hero.height / 2 <= buff1s[i].Y + buff1s[i].height)) {

						buff1s[i] = buff1s[buff1s.length - 1];
						buff1s = Arrays.copyOf(buff1s, buff1s.length - 1);
						life += 5;
					}
				}
			}
		}
	}

	// 判断Buff2是否击中
	public void Buff2HitHero() {
		for (int i = 0; i < buff2s.length; i++) {
			if (buff2s[i] != null) {
				if ((hero.X - hero.width / 2 >= buff2s[i].X && hero.X - hero.width / 2 <= buff2s[i].X + buff2s[i].width)
						|| (hero.X + hero.width / 2 >= buff2s[i].X
								&& hero.X + hero.width / 2 <= buff2s[i].X + buff2s[i].width)) {
					if ((hero.Y  >= buff2s[i].Y
							&& hero.Y  <= buff2s[i].Y + buff2s[i].height)
							|| (hero.Y + hero.height / 2 >= buff2s[i].Y
									&& hero.Y + hero.height / 2 <= buff2s[i].Y + buff2s[i].height)) {

						buff2s[i] = buff2s[buff2s.length - 1];
						buff2s = Arrays.copyOf(buff2s, buff2s.length - 1);
						hero.fire++;
						life += 2;
					}
				}
			}
		}
	}

	// 如何实现事件的绑定和处理
	public void action() {

		// 1，确定事件源：面板对象jPanel
		// 2，创建监视器：点击事件、移动事件
		// 3，为相应的事件处理写好代码逻辑
		MouseAdapter adapter = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("鼠标点击事件");
				// 通过输变电及实现游戏状态的改变
				System.out.println("status =" + status);
				switch (status) {
				case 0:
					status = 1;
					startTimeTask();
					break;
				case 1:
					status = 2;
					break;
				case 2:
					status = 1;
					break;
				case 3:
					status = 0;
					score = 0;
					life = 5;
					break;
				case 4:
					status = 0;
					score = 0;
					life = 5;
					break;
				}
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// System.out.println("鼠标移动事件");
				if (status == 1) {
					// 获取鼠标位置
					hero.X = e.getX() - hero.width / 2;
					hero.Y = e.getY() - hero.height / 2;
					repaint();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// System.out.println("鼠标移入事件");
				if (status == 2) {
					status = 1;
					repaint();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// System.out.println("鼠标移出事件");
				if (status == 1) {
					status = 2;
					repaint();
				}
			}

		};
		this.addMouseListener(adapter);
		this.addMouseMotionListener(adapter);
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();

		jf.setTitle("欧美飞机大战！");
		jf.setSize(windowWidth, windowHeight);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(true);

		main jPanel = new main();
		// jPanel.action();
		jf.add(jPanel);
		jf.setVisible(true);
	}

}
