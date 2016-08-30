package com.lxq.viewpager;

import java.util.ArrayList;
import java.util.List;

import android.R.color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private List<View> viewList;
	private ViewPager pager;
	private PagerTabStrip pagertabstirp;
	private List<String> titleList;
	private List<Fragment> fragList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		viewList = new ArrayList<View>();
		/*
		 * 通过View对象作为ViewPager的数据源
		 */
		View view1 = View.inflate(this, R.layout.view1, null);
		View view2 = View.inflate(this, R.layout.view2, null);
		View view3 = View.inflate(this, R.layout.view3, null);
		View view4 = View.inflate(this, R.layout.view4, null);
		
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);
		
		/*
		 * 通过Fragment作为ViewPager的数据源
		 */
		fragList = new ArrayList<Fragment>();
		fragList.add(new Fragment1());
		fragList.add(new Fragment2());
		fragList.add(new Fragment3());
		fragList.add(new Fragment4());
		
		//初始化标题集合
		titleList = new ArrayList<String>();
		titleList.add("第一页");
		titleList.add("第二页");
		titleList.add("第三页");
		titleList.add("第四页");
		
		//为PagerTabStrip设置属性
		pagertabstirp = (PagerTabStrip) findViewById(R.id.tab);
		pagertabstirp.setBackgroundColor(color.holo_orange_light);
		pagertabstirp.setTextColor(color.holo_red_dark);
		pagertabstirp.setDrawFullUnderline(false);
		pagertabstirp.setTabIndicatorColor(color.holo_blue_dark);
		
		
		//初始化ViewPager
		pager = (ViewPager) findViewById(R.id.pager);
		
		//创建适配器
		MyPaggerAdapter adapter = new MyPaggerAdapter(viewList,titleList);
		
		//ViewPager加载适配器
		pager.setAdapter(adapter);
	}


}
