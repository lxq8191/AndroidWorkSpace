package com.lxq.fragmentofstatic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LeftFragment extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        System.out.println("LeftFragment onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        System.out.println("LeftFragment onCreateView");
        // 第一个参数是这个Fragment将要显示的界面布局,第二个参数是这个Fragment所属的Activity,第三个参数是决定此fragment是否附属于Activity
        return inflater.inflate(R.layout.leftfragment, container, true);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        System.out.println("LeftFragment onResume");
    }
    
    @Override
    public void onPause()
    {
        super.onPause();
        System.out.println("LeftFragment onPause");
    }
    
    
    @Override
    public void onStop()
    {
        super.onStop();
        System.out.println("LeftFragment onStop");
    }
}
