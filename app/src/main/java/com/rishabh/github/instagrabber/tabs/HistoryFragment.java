package com.rishabh.github.instagrabber.tabs;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.rishabh.github.instagrabber.MainActivity;
import com.rishabh.github.instagrabber.R;
import com.rishabh.github.instagrabber.adaptor.ImageRecyclerAdaptor;
import com.rishabh.github.instagrabber.database.DBController;

public class HistoryFragment extends Fragment implements MainActivity.FragmentRefresh {

	ImageView ivSettings;
	private FragmentActivity mContext;
	private RecyclerView rvInsta;

	//DB
	private DBController dbcon;
	private ImageRecyclerAdaptor imageRecyclerAdaptor;

	public static HistoryFragment newInstance() {
		//Bundle args = new Bundle();
		//args.putString(ARG_PAGE, title);
		HistoryFragment fragment = new HistoryFragment();
		//fragment.setRetainInstance(true);
		//fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("Tag1","MoviesFrag");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_history, container, false);
		mContext =getActivity();
		//DB
		dbcon = new DBController(mContext);

		rvInsta= (RecyclerView) rootView.findViewById(R.id.rvInstaImages);
		imageRecyclerAdaptor = new ImageRecyclerAdaptor(mContext);
		rvInsta.setAdapter(imageRecyclerAdaptor);
		rvInsta.setLayoutManager(new LinearLayoutManager(mContext));

		rvInsta.setHasFixedSize(true);
		rvInsta.setItemViewCacheSize(20);
		rvInsta.setDrawingCacheEnabled(true);
		rvInsta.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
		//rvInsta.s/

		imageRecyclerAdaptor.notifyDataSetChanged();
		return rootView;
	}

	@Override public void refresh() {
		if (imageRecyclerAdaptor!=null) {
			imageRecyclerAdaptor.onRefreshh();
		}
	}
}