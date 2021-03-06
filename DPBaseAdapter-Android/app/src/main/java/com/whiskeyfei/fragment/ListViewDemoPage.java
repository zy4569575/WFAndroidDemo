package com.whiskeyfei.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.fei.library.inter.DPOnItemChildViewByIdClickListener;
import com.fei.library.inter.DPOnItemChildViewByIdLongClickListener;
import com.whiskeyfei.R;
import com.whiskeyfei.adapter.DPListViewAdapter;
import com.whiskeyfei.model.DPItemModel;
import com.whiskeyfei.utils.ApiConstant;

public class ListViewDemoPage extends PageFragment<DPItemModel> implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener,DPOnItemChildViewByIdClickListener,DPOnItemChildViewByIdLongClickListener {
	
	private static final String TAG = "ListViewDemoPage";
	public static final int FRAGMENT_FLAG = ApiConstant.FRAGMENT_FLAG_1;

	private ListView mListView;
	private static final String IMAGEURL = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superplus/img/logo_white_ee663702.png";
	private DPListViewAdapter mDpListViewAdapter;

	@Override
	protected int getLayoutId() {
		return R.layout.listview;
	}

	@Override
	protected void initData() {
		for (int i = 0; i < 30; i++) {
			DPItemModel model = new DPItemModel();
			model.setItemResId(R.drawable.ic_launcher);
			model.setItemTitle("title" + i);
			model.setItemContent("content" + i);
			model.setItemIconUrl(IMAGEURL);
			mDataList.add(model);
		}
	}

	@Override
	public void initView() {
		mListView = (ListView) mMainView.findViewById(R.id.list_view);
		mDpListViewAdapter = new DPListViewAdapter(getActivity(), mDataList, R.layout.listview_item);
		mDpListViewAdapter.setOnItemChildViewByIdClickListener(this);
		mDpListViewAdapter.setOnItemChildViewByIdLongClickListener(this);
		mListView.setOnItemClickListener(this);
		mListView.setOnItemLongClickListener(this);
		mListView.setAdapter(mDpListViewAdapter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		Toast.makeText(getActivity(), "点击" + position,Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,int position, long id) {
		Toast.makeText(getActivity(), "长按" + position,Toast.LENGTH_SHORT).show();
		return false;
	}
	
	@Override
	public boolean onItemChildViewByIdLongClick(ViewGroup viewGroup,View v, int position) {
		if (v.getId() == R.id.listview_delete) {
			Toast.makeText(getActivity(), "长按了删除 " + mDpListViewAdapter.getItem(position).mItemTitle + position,Toast.LENGTH_SHORT).show();
            return true;
        }
		return false;
	}

	@Override
	public void onItemChildViewByIdClick(View v, int position) {
		if (v.getId() == R.id.listview_delete) {
			Toast.makeText(getActivity(), "按了删除 " + mDpListViewAdapter.getItem(position).mItemTitle + position,Toast.LENGTH_SHORT).show();
			mDpListViewAdapter.removeItem(position);
        }
	}
}
