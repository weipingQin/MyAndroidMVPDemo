package cn.org.metter.hitogether_android;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.apkfuns.logutils.LogUtils;

import cn.org.metter.hitogether_android.base.BaseActivity;
import cn.org.metter.hitogether_android.view.InputView;
import cn.org.metter.hitogether_android.view.LogAnim;

public class LoginActivity extends BaseActivity {

    /**
     * 此处代码引用一个日志打印的第三方库
     * https://github.com/pengwei1024/LogUtils
     *
     */
    private ImageView imgShow,btnScaning;
    private InputView inputView;
    private Intent intent;//设置相应的intent跳转

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 初始化View相关 并设置相应的监听效果
     */
    private void initView(){
        inputView =(InputView)findViewById(R.id.activity_login_inputview_username);
        imgShow = (ImageView)findViewById(R.id.activity_login_icon);
        btnScaning = (ImageView)findViewById(R.id.activity_login_icon);

        inputView.setOnClickListener(onClickListener);
        imgShow.setOnClickListener(onClickListener);
        btnScaning.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.activity_login_icon:
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.activity_login_inputview_username:
                    ObjectAnimator animator= ObjectAnimator.ofInt(new LogAnim(imgShow),
                            "width", 10);
                    animator.setDuration(2000);//设置动画持续的时间
                    animator.setRepeatCount(2);//设置动画重复的次数
                    animator.start();//开启动画
                    LogUtils.d("qinweiping");
                    break;
            }
        }
    };
}
