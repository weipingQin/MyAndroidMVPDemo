package cn.org.metter.hitogether_android.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.org.metter.hitogether_android.R;

/**
 * Created by qwp on 2015/12/30.
 */

/**
 * 定义菜单的单项
 */


public class DrawerAdapter extends BaseAdapter{

    //存储侧滑菜单的各个菜单项数据
    private String[] mLabels ;
    private int[] mDrawableIds = new int[]{ R.drawable.systemset0,R.drawable.systemset1,
            R.drawable.systemset2, R.drawable.systemset3};
    private Context mContext;

    //定义两个int常量标记不同的Item视图
    public static final int SYSTEM_INFORM_ITEM = 0;
    public static final int SYSTEM_SET_ITEM = 1;

    public DrawerAdapter(Context context,String[] Labels){

        this.mContext = context;
        this.mLabels = Labels;

    }

    @Override
    public int getItemViewType(int position) {

        if(position == 0) {
            return SYSTEM_INFORM_ITEM;
        } else {
            return SYSTEM_SET_ITEM;
        }
    }

    @Override
    public int getViewTypeCount() {
        //因为有两种视图，所以返回2
        return 2;
    }



    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return mLabels.length + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            if(getItemViewType(position) == SYSTEM_INFORM_ITEM) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.list_system_inform,parent,false);

            } else {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.list_system_set,parent,false);
                ImageView imageView = (ImageView)convertView.findViewById(R.id.coin);
                TextView textView = (TextView)convertView.findViewById(R.id.coin_name);
                imageView.setImageResource(mDrawableIds[position - 1]);
                textView.setText(mLabels[position - 1]);

            }
        }

        return convertView;
    }


}
