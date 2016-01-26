package cn.org.metter.hitogether_android.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.org.metter.hitogether_android.R;
import cn.org.metter.hitogether_android.base.BaseFragment;
import cn.org.metter.hitogether_android.view.TopIndicator;


public class HistoryActFragment extends BaseFragment implements TopIndicator.OnTopIndicatorListener{

    private static final String TAG = "HistoryActFragment";

    private Activity mActivity;
    private ViewPager mViewPager;
    private TabPagerAdapter mPagerAdapter;
    private TopIndicator mTopIndicator;

    public static HistoryActFragment newInstance() {

        HistoryActFragment historyActFragment = new HistoryActFragment();

        return historyActFragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_act, container, false);
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDisplay();
    }

    private void initViews(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mPagerAdapter = new TabPagerAdapter(getFragmentManager());

        mTopIndicator = (TopIndicator) view.findViewById(R.id.top_indicator);
        mTopIndicator.setOnTopIndicatorListener(this);
    }

    private void initDisplay() {
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.invalidate();
        mPagerAdapter.notifyDataSetChanged();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private class TabPagerAdapter extends FragmentStatePagerAdapter implements
            ViewPager.OnPageChangeListener {

        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
            mViewPager.setOnPageChangeListener(this);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0){
                HistoryActTab1Fragment fragment = new HistoryActTab1Fragment();
                return fragment;}
            else{
                HistoryActTab2Fragment fragment = new HistoryActTab2Fragment();
                return fragment;}
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mTopIndicator.setTabsDisplay(mActivity, position);
        }
    }

    @Override
    public void onIndicatorSelected(int index) {
        mViewPager.setCurrentItem(index);
    }


}
