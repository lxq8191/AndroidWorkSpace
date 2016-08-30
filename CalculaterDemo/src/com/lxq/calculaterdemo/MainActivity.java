package com.lxq.calculaterdemo;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	Button btn_0;//0���ְ�ť
	Button btn_1;//1���ְ�ť
	Button btn_2;//2���ְ�ť
	Button btn_3;//3���ְ�ť
	Button btn_4;//4���ְ�ť
	Button btn_5;//5���ְ�ť
	Button btn_6;//6���ְ�ť
	Button btn_7;//7���ְ�ť
	Button btn_8;//8���ְ�ť
	Button btn_9;//9���ְ�ť
	Button btn_dian;//С���㰴ť
	Button btn_add;//�ӺŰ�ť
	Button btn_min;//���Ű�ť
	Button btn_mul;//�˺Ű�ť
	Button btn_div;//���Ű�ť
	Button btn_equal;//�ȺŰ�ť
	Button btn_del;//ɾ����ť
	Button btn_clear;//��հ�ť
	EditText et_input;
	boolean clear_flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//ʵ�����ؼ�
		btn_0 = (Button) findViewById(R.id.btn_0);
		btn_1 = (Button) findViewById(R.id.btn_1);
		btn_2 = (Button) findViewById(R.id.btn_2);
		btn_3 = (Button) findViewById(R.id.btn_3);
		btn_4 = (Button) findViewById(R.id.btn_4);
		btn_5 = (Button) findViewById(R.id.btn_5);
		btn_6 = (Button) findViewById(R.id.btn_6);
		btn_7 = (Button) findViewById(R.id.btn_7);
		btn_8 = (Button) findViewById(R.id.btn_8);
		btn_9 = (Button) findViewById(R.id.btn_9);
		btn_dian = (Button) findViewById(R.id.btn_dian);
		btn_add = (Button) findViewById(R.id.btn_add);
		btn_min = (Button) findViewById(R.id.btn_min);
		btn_mul = (Button) findViewById(R.id.btn_mul);
		btn_div = (Button) findViewById(R.id.btn_div);
		btn_equal = (Button) findViewById(R.id.btn_equal);
		btn_del = (Button) findViewById(R.id.btn_del);
		btn_clear = (Button) findViewById(R.id.btn_clear);
		et_input = (EditText) findViewById(R.id.et_input);
		
		//ʵ�ֵ���¼�
		//��Ϊ���������activityʵ����OnClickListener�ӿڣ�������setOnClickListener��ֱ��дthis����
		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);
		btn_dian.setOnClickListener(this);
		btn_add.setOnClickListener(this);
		btn_min.setOnClickListener(this);
		btn_mul.setOnClickListener(this);
		btn_div.setOnClickListener(this);
		btn_equal.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
		et_input.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String str = et_input.getText().toString();//����editview�������ַ���
		
		switch(arg0.getId()){
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
		case R.id.btn_dian:
			if(clear_flag){
				clear_flag = false;
				str="";
				et_input.setText("");
			}
			et_input.setText(str+((Button)arg0).getText());
			break;
		case R.id.btn_add:
		case R.id.btn_min:
		case R.id.btn_mul:
		case R.id.btn_div:
			if(clear_flag){
				clear_flag = false;
				str="";
				et_input.setText("");
			}
			et_input.setText(str+" "+((Button)arg0).getText()+" ");
			//���������ʱ�������ǰ�����һ���� ����Ŀ���Ƿ���֮�������
			break;
		
		case R.id.btn_del:
			if(clear_flag){
				clear_flag = false;
				str="";//���ַ������
				et_input.setText("");
			}else	if(str!=null&&!str.equals("")){
				et_input.setText(str.substring(0, str.length()-1));
			}
			break;
		case R.id.btn_clear:
			clear_flag = false;
			str="";
			et_input.setText(" ");
		case R.id.btn_equal:
			getResult();
			break;
		}
	}
	private void getResult(){
		String exp = et_input.getText().toString();
		if(exp!=null&&exp.equals(" ")){
			return;
		}
		if(!exp.contains(" ")){
			return;
		}
		if(clear_flag){
			clear_flag = false;
			return;
		}
		clear_flag = true;
		double result = 0;
		//��editview�е����ݸ��ݡ� �����ָ  ����  �����  ����
		String s1 = exp.substring(0, exp.indexOf(" "));
		String op = exp.substring(exp.indexOf(" ")+1, exp.indexOf(" ")+2);
		String s2 = exp.substring(exp.indexOf(" ")+3);
		if(!s1.equals("")&&!s2.equals("")){
			//��Double��װ������String���͵��ַ���ת��double����
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			
			if(op.equals("+")){
				result = d1+d2;
			}else if(op.equals("-")){
				result = d1-d2;
			}else if(op.equals("��")){
				result = d1*d2;
			}else if(op.equals("��")){
				if(d2==0){
					result = 0;
				}else{
					result = d1/d2;
				}				
			}	
			if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("��")){
				int r = (int) result;
				et_input.setText(r+" ");
			}else{
				et_input.setText(result+" ");
			}			
		}else if(!s1.equals("")&&s2.equals("")){//s1���գ�s2��
			et_input.setText(exp);			
		}else if(s1.equals("")&&!s2.equals("")){//s1�գ�s2����
			double d2 = Double.parseDouble(s2);
			if(op.equals("+")){
				result = 0+d2;
			}else if(op.equals("-")){
				result = 0-d2;
			}else if(op.equals("��")){
				result = 0;
			}else if(op.equals("��")){
					result = 0;
			}	
			if(!s2.contains(".")){
				int r = (int) result;
				et_input.setText(r+" ");
			}else{
				et_input.setText(result+"");
			}			
		}
		else{
			et_input.setText("");
		}
	}


}
