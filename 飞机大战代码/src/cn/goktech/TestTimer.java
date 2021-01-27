package cn.goktech;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
		static int i=0;
		public static void main(String[] args) {
			
			
			Timer timer = new Timer();
			//创建一个定时任务
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					i++;
					System.out.println("i="+i);
				}
			};
			//启动定时器
			timer.schedule(task, 7000, 1000);
			
		}
}
