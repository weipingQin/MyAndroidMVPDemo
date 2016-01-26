package cn.org.metter.hitogether_android.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import cn.org.metter.hitogether_android.R;

/**
 * Created by Administrator on 2015/12/26.
 */
public class LogAnim {

    private View view;
    private int width;
    private int height;
    public LogAnim(View view){
        this.view=view;
    }
    public int getWidth() {
        return view.getLayoutParams().width;
    }
    public void setWidth(int width) {
        this.width = width;
        view.getLayoutParams().width=width;//修改View的高度
        view.requestLayout();//刷新View的布局
    }
    public int getHeight() {
        return view.getLayoutParams().height;
    }
    public void setHeight(int height) {
        this.height=height;
        view.getLayoutParams().height = height;
        view.requestLayout();
    }
}
