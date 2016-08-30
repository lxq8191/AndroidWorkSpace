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
		//1.�½�һ��������
		//ArrayAdapter(�����ģ���ǰListView���ص�ÿһ���б�������Ӧ�Ĳ����ļ�������Դ)
		//2.��������������Դ
		String[] arr_data = {"imooc1","imooc2","imooc3","imooc4","imooc5"};
		arr_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr_data);
		//SimpleAdapter
		/*���������˵��
		 * context��������
		 * data������ԴList<? extends Map<String, ?>> һ��Map����ɵ�List����
		 * 		ÿһ��Map�����ӦLIstView�б��е�һ��
		 * 		ÿһ��Map�еļ�ֵ�Ա������������from����ָ���ļ�
		 * resource���б���Ĳ����ļ�
		 * from����¼Map�еļ���
		 * to����������ͼ�е�ID����from�ɶ�Ӧ��ϵ
		 */
		datalist = new ArrayList<Map<String, Object>>();
		simp_adapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"pic","text"}, new int[]{R.id.pic,R.id.text});
		//3.��ͼ��listview������������
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
			Log.i("Main", "�û�����ָ�뿪��Ļ֮ǰ��������һ�£���ͼ��Ȼ�������Լ�������");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pic", R.drawable.ic_launcher);
			map.put("text", "��������");
			datalist.add(map);
			simp_adapter.notifyDataSetChanged();
			break;
		case SCROLL_STATE_IDLE:
			Log.i("Main", "��ͼ�Ѿ�ֹͣ����");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			Log.i("Main", "��ָû�뿪��Ļ����ͼ���ڻ���");
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