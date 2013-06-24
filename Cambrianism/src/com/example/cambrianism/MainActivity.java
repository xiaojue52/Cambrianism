package com.example.cambrianism;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
	public static int xx;
	public static int yy;
	private int x,y;
	private int r;
	public static int color1;
	private int color;
	private GestureDetector mGestureDetector;
	private MyGestureListener test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		class MyView extends View {
			public MyView(Context context) {
				super(context);
			}

			@Override
			protected void onDraw(Canvas canvas) {
				super.onDraw(canvas);
				// 设置画布的背景颜色
				canvas.drawColor(Color.WHITE);
				// 建立画笔
				Paint paint = new Paint();
				paint.setStyle(Paint.Style.FILL);
				// 设置画笔的颜色
				xx=x;yy=y;color1=color;
				switch (color) {
				case 1:
					paint.setColor(Color.BLACK);
					break;
				case 2:
					paint.setColor(Color.BLUE);
					break;
				case 3:
					paint.setColor(Color.YELLOW);
					break;
				case 4:
					paint.setColor(Color.WHITE);
					break;
				case 5:
					paint.setColor(Color.GREEN);
					break;
				case 6:
					paint.setColor(Color.GRAY);
					break;
				case 7:
					paint.setColor(Color.CYAN);
					break;
				case 8:
					paint.setColor(Color.TRANSPARENT);
					break;
				default:
					xx=x;yy=y;color1=color;
					paint.setColor(Color.RED);
				}

				// 在屏幕绘图
				canvas.drawCircle(x, y, r, paint);
				// canvas.drawARGB(x,y,x+r,y+r);

			}
		}
		final MyView myView = new MyView(this);
		final Handler mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 110) {
					setContentView(myView);
				}
			}

		};
		class HSTTimerTask extends TimerTask {
			public void run() {
				Random a = new Random();
				x = a.nextInt(240);// 像素 随机数
				y = a.nextInt(350);
				r = 40;
				color = a.nextInt(10);

				if (test.move){
					Message m = new Message();// 消息验证
					m.what = 110;
					mHandler.sendMessage(m);
				}
			}
		}
		test = new MyGestureListener(this);
		Timer t = new Timer();// 2
		HSTTimerTask myTimerTask = new HSTTimerTask();// 3 实例化
		t.schedule(myTimerTask, 0, 1000);// 4
		
		mGestureDetector = new GestureDetector(this,test);
	} 
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return mGestureDetector.onTouchEvent(event);
	}

}
