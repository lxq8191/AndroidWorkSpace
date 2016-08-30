package com.lxq.listviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener,OnScrollListener{
	private ListView listview;
	private ArrayAdapter<String> arr_adapter;
	private SimpleAdapter simp_adapter;
	private List<Map<String,Object>> datalist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listview = (ListView) findViewById(R.id.listView_main);
		//1.新建一个适配器
		//ArrayAdapter(上下文，当前ListView加载的每一个列表项所对应的布局文件，数据源)
		//2.适配器加载数据源
		String[] arr_data = {"imooc1","imooc2","imooc3","imooc4","imooc5"};
		arr_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr_data);
		//SimpleAdapter
		/*五个参数的说明
		 * context：上下文
		 * data：数据源List<? extends Map<String, ?>> 一个Map所组成的List集合
		 * 		每一个Map都会对应LIstView列表中的一行
		 * 		每一个Map中的键值对必须包含所有在from中所指定的键
		 * resource：列表项的布局文件
		 * from：记录Map中的键名
		 * to：绑定数据视图中的ID，与from成对应关系
		 */
		datalist = new ArrayList<Map<String, Object>>();
		simp_adapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"pic","text"}, new int[]{R.id.pic,R.id.text});
		//3.视图（listview）加载适配器
		//listview.setAdapter(arr_adapter);
		listview.setAdapter(simp_adapter);
		listview.setOnItemClickListener(this);
		listview.setOnScrollListener(this);
	}
	private List<Map<String,Object>> getData(){
		for (int i = 0; i < 20; i++) {
			Map<String,Object>map = new HashMap<String, Object>();
			map.put("pic",R.drawable.ic_launcher);
			map.put("text","imooc"+i);
			datalist.add(map);
		}
		return datalist;
	}
	@Override
	public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollstate) {
		// TODO Auto-generated method stub
		switch (scrollstate) {
		case SCROLL_STATE_FLING:
			Log.i("Main", "用户在手指离开屏幕之前用力划了一下，视图仍然依靠惯性继续滑动");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pic", R.drawable.ic_launcher);
			map.put("text", "增加新项");
			datalist.add(map);
			simp_adapter.notifyDataSetChanged();
			break;
		case SCROLL_STATE_IDLE:
			Log.i("Main", "视图已经停止滑动");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			Log.i("Main", "手指没离开屏幕，视图正在滑动");
			break;

		default:
			break;
		}
		
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		String str =listview.getItemAtPosition(position)+"";
		Toast.makeText(this, "position ="+position+"text ="+str, Toast.LENGTH_SHORT).show();
	}

}
