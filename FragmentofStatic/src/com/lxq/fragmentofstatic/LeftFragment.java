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
        // ��һ�����������Fragment��Ҫ��ʾ�Ľ��沼��,�ڶ������������Fragment������Activity,�����������Ǿ�����fragment�Ƿ�����Activity
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
