package gabriel.luoyer.promonkey.slidingmenu.left;

import gabriel.luoyer.promonkey.R;
import gabriel.luoyer.promonkey.cptslide.ChapterSlideActivity;
import gabriel.luoyer.promonkey.doublefrglist.DoubleFrgListActivity;
import gabriel.luoyer.promonkey.explist.ExpListSelectActivity;
import gabriel.luoyer.promonkey.licc.LiChildClickActivity;
import gabriel.luoyer.promonkey.navi.BottomNavigateActivity;
import gabriel.luoyer.promonkey.titlebarani.TitleBarAniActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class MyDemoFragment extends Fragment implements OnClickListener {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.slidingmenu_frg_my_demo, null);
		getAndSetViews(view);
		return view;
	}

	private void getAndSetViews(View view) {
		view.findViewById(R.id.my_demo_chapter_slide).setOnClickListener(this);
		view.findViewById(R.id.my_demo_double_frg_list).setOnClickListener(this);
		view.findViewById(R.id.my_demo_explist_select).setOnClickListener(this);
		view.findViewById(R.id.my_demo_listitem_child_click).setOnClickListener(this);
		view.findViewById(R.id.my_demo_navigate).setOnClickListener(this);
		view.findViewById(R.id.my_demo_title_bar_animator).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.my_demo_chapter_slide: {
				Intent intent = new Intent();
				intent.setClass(getActivity(), ChapterSlideActivity.class);
				startActivity(intent);
				break;
			}
			case R.id.my_demo_double_frg_list: {
				Intent intent = new Intent();
				intent.setClass(getActivity(), DoubleFrgListActivity.class);
				startActivity(intent);
				break;
			}
			case R.id.my_demo_explist_select: {
				Intent intent = new Intent();
				intent.setClass(getActivity(), ExpListSelectActivity.class);
				startActivity(intent);
				break;
			}
			case R.id.my_demo_listitem_child_click: {
				Intent intent = new Intent();
				intent.setClass(getActivity(), LiChildClickActivity.class);
				startActivity(intent);
				break;
			}
			case R.id.my_demo_navigate: {
				BottomNavigateActivity.startBottomNavigateActivity(getActivity());
				break;
			}
			case R.id.my_demo_title_bar_animator: {
				Intent intent = new Intent();
				intent.setClass(getActivity(), TitleBarAniActivity.class);
				startActivity(intent);
				break;
			}
		}
	}
}
