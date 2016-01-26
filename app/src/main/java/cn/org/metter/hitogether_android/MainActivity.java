package cn.org.metter.hitogether_android;

import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import cn.org.metter.hitogether_android.adapter.DrawerAdapter;

import cn.org.metter.hitogether_android.base.BaseActivity;
import cn.org.metter.hitogether_android.constant.Constant;
import cn.org.metter.hitogether_android.fragment.ActFragment;
import cn.org.metter.hitogether_android.fragment.ConnectionFragment;
import cn.org.metter.hitogether_android.fragment.HistoryActFragment;
import cn.org.metter.hitogether_android.fragment.PropertyFragment;

public class MainActivity extends BaseActivity {

    HistoryActFragment mHistoryActFragment ;
    ConnectionFragment mConnectionFragment ;
    PropertyFragment mPropertyFragment ;
    ActFragment mActFragment;
    private FragmentManager mFragmentManager;


    LinearLayout settingBtn,helpBtn;

    private DrawerLayout mDrawerLayout = null;
    private ActionBarDrawerToggle mDrawerToggle = null;
    private NavigationView mNavigationView = null;
    private Toolbar mToolbar;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    //设置相应的List
    private ListView menuDrawerList;
    private DrawerAdapter mDrawerAdapter;

    //设置全局信息
    private String currentContentTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        initFragment();

        init();
    }

    /**
     * 初始化
     */
    private void init(){
        ///初始化ToolBar
        initToolBar();
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.drawer_open,R.string.drawer_close);
        if(mDrawerToggle!=null) {
            mDrawerToggle.syncState();
            mDrawerLayout.setDrawerListener(mDrawerToggle);
        }
        currentContentTitle = getString(R.string.my_account);

        //初始化NavigationView
        mNavigationView = (NavigationView)findViewById(R.id.navigation_view);
        setUpDrawerContent(mNavigationView);
      //  menuDrawerList = (ListView)findViewById(R.id.left_drawer);
      //  menuDrawerList.setAdapter(getAdapter());
      //  menuDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private void initFragment(){

        ActFragment actFragment = new ActFragment();
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.content_frame, actFragment);
        transaction.commit();

    }

    private  void setUpDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setCheckable(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    /**
     * 获取相应的Adapter
     * @return
     */
    private DrawerAdapter getAdapter(){
        if(mDrawerAdapter==null){
            Resources res = getResources();
            String[] Labels = res.getStringArray(R.array.system_set_item);
            mDrawerAdapter = new DrawerAdapter(this,Labels);
        }
        return mDrawerAdapter;
    }

    /**侧滑菜单单击事件监听器*/
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            selectItem(position);
            onFragmentSelected(position);
            view.setBackgroundColor(Color.parseColor("#424242"));
            mDrawerLayout.closeDrawer(Gravity.LEFT);

        }

        //此处填写跳转到相应的Fragment的相关代码
        public void selectItem(int position) {
            Bundle bundle = new Bundle();
            if(bundle !=null){
                //bundle.putString("",mDrawerAdapter.getItem(position).getMenuTitle());
            }
        }
    }

        private void initToolBar(){
            mToolbar= (Toolbar)findViewById(R.id.toolbar);
            if(mToolbar !=null){
                mToolbar.setTitle("活动");
                //mToolbar.setTitleTextColor(R.color.btg_global_light_white);
                setSupportActionBar(mToolbar);
                getSupportActionBar().setHomeButtonEnabled(true);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

    public void onFragmentSelected(int index) {

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        switch (index) {
            case Constant.HISTORY_ACT_FRAGMENT_INDEX:
                if (null == mHistoryActFragment) {
                    mHistoryActFragment = new HistoryActFragment();
                    transaction.replace(R.id.content_frame, mHistoryActFragment);
                } else {
                    transaction.replace(R.id.content_frame, mHistoryActFragment);
                }
                break;
            case Constant.CONNECTION_FRAGMENT_INDEX:
                if (null == mConnectionFragment) {
                    mConnectionFragment = new ConnectionFragment();
                    transaction.replace(R.id.content_frame, mConnectionFragment);
                } else {
                    transaction.replace(R.id.content_frame, mConnectionFragment);
                }
                break;
            case Constant.PROPERTY_FRAGMENT_INDEX:
                if (null == mPropertyFragment) {
                    mPropertyFragment = new PropertyFragment();
                    transaction.replace(R.id.content_frame, mPropertyFragment);
                } else {
                    transaction.replace(R.id.content_frame, mPropertyFragment);
                }
                break;
            case Constant.ACT_FRAGMENT_INDEX:
                if (null == mActFragment) {
                    mActFragment = new ActFragment();
                    transaction.replace(R.id.content_frame, mActFragment);
                } else {
                    transaction.replace(R.id.content_frame, mActFragment);
                }
                break;

            default:
                break;
        }
        transaction.commit();
    }

    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            // 点击了快速操作按钮
            case R.id.settingBtn:
                Intent intent = new Intent(this,SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.helpBtn:
                Intent intent1 = new Intent(this,HelpActivity.class);
                startActivity(intent1);
                break;
            case R.id.checkoutBtn:
                Intent intent2 = new Intent(this,IdentityCheckActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }



}


