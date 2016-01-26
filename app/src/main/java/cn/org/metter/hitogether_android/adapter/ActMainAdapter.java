package cn.org.metter.hitogether_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.org.metter.hitogether_android.R;
import cn.org.metter.hitogether_android.useclass.ActInformation;

/**
 * Created by Administrator on 2016/1/1.
 */
public class ActMainAdapter extends BaseAdapter{

    //存储侧滑菜单的各个菜单项数据
    private List<ActInformation> mArrayList ;
    private Context mContext;

    //定义两个int常量标记不同的Item视图
    public static final int SYSTEM_INFORM_ITEM = 0;
    public static final int SYSTEM_SET_ITEM = 1;

    public ActMainAdapter(Context context){

        this.mContext = context;
        //this.mArrayList = ArrayList;

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
        return 10;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            if(getItemViewType(position) == SYSTEM_INFORM_ITEM) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.list_act_main,parent,false);

            } else {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.list_act_main,parent,false);

            }
        }

        return convertView;
    }
}
