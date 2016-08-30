package com.lxq.outofclass;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	private Button bt1;
	private Button bt2;
	private ImageButton imaBt;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bt1 = (Button) findViewById(R.id.button1);
        bt2 = (Button) findViewById(R.id.button2);
        imaBt = (ImageButton)findViewById(R.id.imageButton1);
        
//        bt1.setOnClickListener(new MyOnClickLisenner(){
//        	@Override
//    		public void onClick(View arg0) {
//    			// TODO Auto-generated method stub
//    			super.onClick(arg0);
//    			Toast.makeText(MainActivity.this, "bt1执行", 1).show();
//    		}
//        });
//       
//        bt2.setOnClickListener(new MyOnClickLisenner(){
//        	@Override
//        	public void onClick(View arg0) {
//        		// TODO Auto-generated method stub
//        		super.onClick(arg0);
//        		Toast.makeText(MainActivity.this, "bt2执行", 1).show();
//        	}
//        });
        
//        imaBt.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("接口实现事件监听");
//				
//			}
//		});
        imaBt.setOnClickListener(this);
        
//        bt1.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});

        /*
         * 点击事件外部类的写法
         */
        
        
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    /*
     * OnClickListener是一个接口，所以用实现implements
     */
//	class MyOnClickLisenner implements OnClickListener{
//	
//		@Override
//		public void onClick(View arg0) {
//			arg0.setAlpha(0.5f);
//		}
//		
//	}

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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Log.i("tag", "第三种方式实现");
	}

}
