package gabriel.luoyer.promonkey.slidingmenu;

import gabriel.luoyer.promonkey.R;
import gabriel.luoyer.promonkey.slidingmenu.left.IntroFragment;
import gabriel.luoyer.promonkey.utils.Utils;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class LeftMenuFragment extends Fragment implements OnClickListener {
	private static final String TAG = "LeftMenuFragment";
	private onLeftMenuItemClickListener mItemClickListener;
	private HashMap<String, View> mSelectViewMap = null;
	private final static String CONT_TAG_INTRO = "ctg_about";
	private final static String CONT_TAG_MY_DEMO = "ctg_my_demo";
	private final static String CONT_TAG_THIRD_DEMO = "ctg_third_demo";
	private String mCurTag;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mItemClickListener = (onLeftMenuItemClickListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.getClass().getName() 
                    + " must implement onLeftMenuItemClickListener");
		}
		mCurTag = getDefaultTag();
		if(null == mSelectViewMap) {
			mSelectViewMap = new HashMap<String, View>();
		}
		if(!mSelectViewMap.isEmpty()) {
			mSelectViewMap.clear();
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frg_left_menu, null);
		getAndSetViews(view);
		return view;
	}

	private void getAndSetViews(View view) {
		View about = view.findViewById(R.id.id_left_menu_intro);
		about.setOnClickListener(this);
		addSelectView(about, CONT_TAG_INTRO);
		View myDemo = view.findViewById(R.id.id_left_menu_my_demo);
		myDemo.setOnClickListener(this);
		addSelectView(myDemo, CONT_TAG_MY_DEMO);
		View thirdDemo = view.findViewById(R.id.id_left_menu_third_demo);
		thirdDemo.setOnClickListener(this);
		addSelectView(thirdDemo, CONT_TAG_THIRD_DEMO);
		
		mSelectViewMap.get(mCurTag).setSelected(true);
	}

	/**
	 * Add view to hash map by tag while get views from resources,
	 * so, we can change the select status when click navigation item,
	 * to display different background.
	 * @param view The map value.
	 * @param tag The map key.
	 * @see resetSelection
	 */
	private void addSelectView(View view, String tag) {
		//Utils.logh(TAG, "addSelectView :  " + tag);
		view.setTag(tag);
		view.setSelected(false);
		mSelectViewMap.put(tag, view);
	}
	
	/**
	 * Reset the selection background by select status
	 * @param tag The map key
	 * @return null: if the same as current selection;
	 * @see addSelectView
	 */
	private String resetSelection(String tag) {
		if(!tag.equals(mCurTag)) {
			final String pre = mCurTag;
			mCurTag = tag;
			mSelectViewMap.get(pre).setSelected(false);
			mSelectViewMap.get(mCurTag).setSelected(true);
			return tag;
		} else {
			Utils.logh(TAG, "resetSelection not changed ~~~");
			return null;
		}
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.id_left_menu_intro:
				mItemClickListener.onLeftMenuIntroClick(resetSelection(CONT_TAG_INTRO));
				break;
			case R.id.id_left_menu_my_demo:
				mItemClickListener.onLeftMenuMyDemoClick(resetSelection(CONT_TAG_MY_DEMO));
				break;
			case R.id.id_left_menu_third_demo:
				mItemClickListener.onLeftMenuThirdDemoClick(resetSelection(CONT_TAG_THIRD_DEMO));
				break;
		}
	}

	public String getDefaultTag() {
		return CONT_TAG_INTRO;
	}
	
	public Fragment getDefaultFragment() {
		return new IntroFragment();
	}
	
	public interface onLeftMenuItemClickListener {
		public abstract void onLeftMenuIntroClick(String tag);
		public abstract void onLeftMenuMyDemoClick(String tag);
		public abstract void onLeftMenuThirdDemoClick(String tag);
	}
}
