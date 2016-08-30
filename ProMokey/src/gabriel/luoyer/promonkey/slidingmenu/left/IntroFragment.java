package gabriel.luoyer.promonkey.slidingmenu.left;

import gabriel.luoyer.promonkey.R;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class IntroFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.slidingmenu_frg_intro, null);
		TextView versionTv = (TextView) view.findViewById(R.id.intro_version);
		try {
			versionTv.setText(
					getActivity().getPackageManager().getPackageInfo(
							getActivity().getPackageName(), 0)
						.versionName);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return view;
	}
}
