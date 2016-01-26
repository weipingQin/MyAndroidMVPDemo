package cn.org.metter.hitogether_android;

import android.app.Application;

import com.bugtags.library.Bugtags;

import cn.org.metter.hitogether_android.constant.Constant;

/**
 * Created by Administrator on 2015/12/29.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Bugtags.start(Constant.BUGTAGS_KEY,this,Bugtags.BTGInvocationEventBubble);
    }
}
