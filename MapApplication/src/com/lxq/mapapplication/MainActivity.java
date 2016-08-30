package com.lxq.mapapplication;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

		// �ٶȵ�ͼ�ؼ�
		private MapView mMapView = null;
		// �ٶȵ�ͼ����
		private BaiduMap bdMap;
		
//		private Button btn1;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
//			requestWindowFeature(Window.FEATURE_NO_TITLE);
//			SDKInitializer.initialize(getApplicationContext());
			setContentView(R.layout.main);
			init();
//			btn1 = (Button) findViewById(R.id.request);
//			btn1.setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View arg0) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
			
//			Intent intent = new Intent();
//			intent .setClass(MainActivity.this, LocActivity.class);//Activity1 Ϊ��ǰ�����Activity��Activity2ΪҪ��ת����
//			startActivity(intent);
//			
		}

		/**
		 * ��ʼ������
		 */
		private void init() {
			//mMapView = (MapView) findViewById(R.id.bmapview);
		}
		@Override
		protected void onResume() {
			super.onResume();
			mMapView.onResume();
		}
		@Override
		protected void onPause() {
			super.onPause();
			mMapView.onPause();
		}
		@Override
		protected void onDestroy() {
			mMapView.onDestroy();
			mMapView = null;
			super.onDestroy();
		}
}
