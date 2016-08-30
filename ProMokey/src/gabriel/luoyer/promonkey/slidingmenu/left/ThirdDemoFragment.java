package gabriel.luoyer.promonkey.slidingmenu.left;

import gabriel.luoyer.promonkey.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class ThirdDemoFragment extends Fragment implements OnClickListener {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.slidingmenu_frg_third_demo, null);
		getAndSetViews(view);
		return view;
	}

	private void getAndSetViews(View view) {
		view.findViewById(R.id.third_demo_slidingmenu).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.third_demo_slidingmenu: {
				showDeclaration();
				break;
			}
//			case R.id.third_demo_pulllistview: {
//				break;
//			}
		}
	}
	
	private void showDeclaration() {
		new AlertDialog.Builder(getActivity())
		.setTitle(R.string.str_slidingmenu_dialog_title)
		.setMessage(R.string.str_slidingmenu_dialog_msg)
		.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            	dialog.dismiss();
            }
		})
		.setPositiveButton(android.R.string.ok,  new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            	dialog.dismiss();
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.str_ma_hompage)));
				startActivity(intent);
            }
		})
        .setCancelable(false)
		.create()
		.show();
	}
}
