package gabriel.luoyer.promonkey;

import cn.waps.AppConnect;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import gabriel.luoyer.promonkey.slidingmenu.LeftMenuFragment;
import gabriel.luoyer.promonkey.slidingmenu.LeftMenuFragment.onLeftMenuItemClickListener;
import gabriel.luoyer.promonkey.slidingmenu.RightMenuFragment;
import gabriel.luoyer.promonkey.slidingmenu.left.*;
import gabriel.luoyer.promonkey.utils.Utils;
import gabriel.luoyer.thirdlib.slidingmenu.SlidingMenu;
import gabriel.luoyer.thirdlib.slidingmenu.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity implements onLeftMenuItemClickListener {
	private static final String TAG = "MainActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentViews();
		AppConnect ac = AppConnect.getInstance(this);
		ac.setCrashReport(false);
		ac.initAdInfo();
		ac.initPopAd(this);
		showDeclaration();
	}
	
	private void setContentViews() {
		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.slide_menu_shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setMode(SlidingMenu.LEFT_RIGHT);
		
		// set the Above View
		setContentView(R.layout.slide_menu_content_frame);
		LeftMenuFragment lmf = new LeftMenuFragment();
		getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.content_frame, lmf.getDefaultFragment(), lmf.getDefaultTag())
			.addToBackStack(lmf.getDefaultTag())
			.commit();

		// set the Behind View
		setBehindContentView(R.layout.slide_menu_frame);
		getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.menu_frame, lmf)
			.commit();

		// set the second Behind View
		sm.setSecondaryMenu(R.layout.slide_menu_frame_two);
		sm.setSecondaryShadowDrawable(R.drawable.slide_menu_shadowright);
		getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.menu_frame_two, new RightMenuFragment())
			.commit();
	}

	public void switchContent(Fragment fragment, String tag) {
		Utils.logh(TAG, "switchContent tag: " + tag);
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.content_frame, fragment, tag);
			ft.addToBackStack(tag);
			ft.commit();
		getSlidingMenu().showContent();
	}

	@Override
	public void onLeftMenuIntroClick(String tag) {
		if(null == tag) {
			getSlidingMenu().showContent();
		} else {
			Fragment frg = getSupportFragmentManager().findFragmentByTag(tag);
			if(null == frg) {
				frg = new IntroFragment();
			}
			switchContent(frg, tag);
		}
	}

	@Override
	public void onLeftMenuMyDemoClick(String tag) {
		if(null == tag) {
			getSlidingMenu().showContent();
		} else {
			Fragment frg = getSupportFragmentManager().findFragmentByTag(tag);
			if(null == frg) {
				frg = new MyDemoFragment();
			}
			switchContent(frg, tag);
		}
	}

	@Override
	public void onLeftMenuThirdDemoClick(String tag) {
		if(null == tag) {
			getSlidingMenu().showContent();
		} else {
			Fragment frg = getSupportFragmentManager().findFragmentByTag(tag);
			if(null == frg) {
				frg = new ThirdDemoFragment();
			}
			switchContent(frg, tag);
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(KeyEvent.KEYCODE_BACK == keyCode) {
			// @see SlidingFragmentActivity
			if(getSlidingMenu().isMenuShowing()) {
				return true;
			}
			showExitDialog(this);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	public void showExitDialog(final Context context) {
		Resources res = context.getResources();
		final Dialog dialog = new Dialog(context, R.style.alert_dialog_style);
		View view = View.inflate(context, R.layout.dialog_exit, null);
		TextView msg = (TextView) view.findViewById(R.id.exit_dialog_title);
		msg.setText(String.format(res.getString(R.string.str_dialog_exit_msg),
				res.getString(R.string.app_name)));
		view.findViewById(R.id.exit_dialog_btn_exit)
			.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if(dialog != null){
						dialog.cancel();
					}
					System.exit(0);
				}
			});
		view.findViewById(R.id.exit_dialog_btn_cancel)
			.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if(dialog != null){
						dialog.cancel();
					}
				}
			});
		dialog.setContentView(view);
		// pop adview
		Button moreBtn = (Button) view.findViewById(R.id.exit_dialog_btn_more);
		final LinearLayout adView = (LinearLayout) view.findViewById(R.id.exit_dialog_pop_adview);
		Utils.setGone(moreBtn, adView);
		if(AppConnect.getInstance(context).hasPopAd(context)) {
			final LinearLayout pop_layout = AppConnect.getInstance(context).getPopAdView(context);
			if(pop_layout != null){
				Utils.setVisible(moreBtn, adView);
				moreBtn.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v) {
						AppConnect.getInstance(context).showOffers(context);
						if(dialog != null){
							dialog.cancel();
						}
					}
				});
				adView.addView(pop_layout, 0);
				dialog.setOnCancelListener(new OnCancelListener(){
					@Override
					public void onCancel(DialogInterface dialog) {
						adView.removeViewAt(0);
					}
				});
			}
		}

		dialog.show();
	}
	
	private void showDeclaration() {
		new AlertDialog.Builder(this)
		.setTitle(R.string.str_declare_dialog_title)
		.setMessage(R.string.str_declare_dialog_msg)
		.setNegativeButton(R.string.str_declare_dialog_btn_refuse, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            	finish();
            }
		})
		.setPositiveButton(R.string.str_declare_dialog_btn_accept,  new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            	dialog.dismiss();
            }
		})
        .setCancelable(false)
		.create()
		.show();
	}
	
	@Override
	protected void onDestroy() {
		AppConnect.getInstance(this).close();
		super.onDestroy();
	}
}
