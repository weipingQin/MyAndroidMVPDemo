package cn.org.metter.hitogether_android.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import cn.org.metter.hitogether_android.ActDetailActivity;
import cn.org.metter.hitogether_android.HelpActivity;
import cn.org.metter.hitogether_android.IdentityCheckActivity;
import cn.org.metter.hitogether_android.NewActActivity;
import cn.org.metter.hitogether_android.R;
import cn.org.metter.hitogether_android.adapter.ActMainAdapter;
import cn.org.metter.hitogether_android.base.BaseFragment;


public class ActFragment extends BaseFragment {

    private static final String TAG = "ActFragment";

    public static ActFragment newInstance() {
        ActFragment actFragment = new ActFragment();

        return actFragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_act, container, false);

        initActList(view);

        initNewActBtn(view);

        return view;
    }

    public void initActList(View view){

        ListView listView = (ListView)view.findViewById(R.id.actlist);
        listView.setAdapter(new ActMainAdapter(getActivity()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent1 = new Intent(getActivity(), ActDetailActivity.class);
                startActivity(intent1);
            }
        });
    }

    public void initNewActBtn(View view){

        ImageView imageView = (ImageView)view.findViewById(R.id.newAct);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),NewActActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initViews(view);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}
