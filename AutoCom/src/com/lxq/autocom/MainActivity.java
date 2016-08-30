package com.lxq.autocom;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	private AutoCompleteTextView acTextView;
	private String[] text = {"neu","neu1","shanxi","shanxi1"};
	private MultiAutoCompleteTextView mcTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * 1.��ʼ���ؼ�
		 * 2.��Ҫһ��������
		 * 3.��ʼ������Դ--ƥ���ı��������������
		 * 4.��adapter�뵱ǰautocompletetextview�ؼ���
		 */
		acTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,text);
		acTextView.setAdapter(adapter);
		/*
		 * 1.��ʼ���ؼ�
		 * 2.��Ҫһ��������
		 * 3.��ʼ������Դ--ƥ���ı��������������
		 * 4.��adapter�뵱ǰautocompletetextview�ؼ���
		 * 5.���÷ָ���
		 */
		mcTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
		mcTextView.setAdapter(adapter);
		//�����Զ���Ϊ�ָ��������ķ���
		mcTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
