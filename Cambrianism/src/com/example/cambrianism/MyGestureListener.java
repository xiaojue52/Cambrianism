package com.example.cambrianism;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Window;
import android.widget.Toast;
public class MyGestureListener extends SimpleOnGestureListener {
	private Context mContext;
	public boolean move = true;
	MyGestureListener(Context context) {
		mContext = context;
	}
	@Override
	public boolean onDown(MotionEvent e) {
		//Toast.makeText(mContext, "DOWN " + MainActivity.color1+"..."+e.getX()+"...."+e.getY()+"..."+MainActivity.xx+"....."+MainActivity.yy, Toast.LENGTH_SHORT).show();
		if (MainActivity.color1!=1&&MainActivity.color1!=2&&MainActivity.color1!=3&&MainActivity.color1!=4&&MainActivity.color1!=5&&MainActivity.color1!=6&&MainActivity.color1!=7&&MainActivity.color1!=8){
			if (((MainActivity.xx-40)<=e.getX()&&e.getX()<=(MainActivity.xx+40))&&((MainActivity.yy-20)<=e.getY()&&(e.getY()<=(MainActivity.yy+40)))){
				move = false;
				Toast.makeText(mContext, "you win!", Toast.LENGTH_SHORT).show();
				return false;
			}
			
		}
		//move = true;
		return false;
	}
	@Override
	public void onShowPress(MotionEvent e) {
		//Toast.makeText(mContext, "SHOW " + e.getAction(), Toast.LENGTH_SHORT).show();
	}
	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		//Toast.makeText(mContext, "SINGLE UP " + e.getAction(),Toast.LENGTH_SHORT).show();
		return false;
	}
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2,
	float distanceX, float distanceY) {
		//Toast.makeText(mContext, "SCROLL " + e2.getAction(), Toast.LENGTH_SHORT).show();
		return false;
	}
	@Override
	public void onLongPress(MotionEvent e) {
		//Toast.makeText(mContext, "LONG " + e.getAction(), Toast.LENGTH_SHORT).show();
	}
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
	float velocityY) {
		//Toast.makeText(mContext, "FLING " + e2.getAction(), Toast.LENGTH_SHORT).show();
		return false;
	}
	@Override
	public boolean onDoubleTap(MotionEvent e) {
		//Toast.makeText(mContext, "DOUBLE " + e.getAction(), Toast.LENGTH_SHORT).show();
		return false;
	}
	@Override
	public boolean onDoubleTapEvent(MotionEvent e) {
		//Toast.makeText(mContext, "DOUBLE EVENT " + e.getAction(),Toast.LENGTH_SHORT).show();
		return false;
	}
	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		//Toast.makeText(mContext, "SINGLE CONF " + e.getAction(),Toast.LENGTH_SHORT).show();
		return false;
	}
}
