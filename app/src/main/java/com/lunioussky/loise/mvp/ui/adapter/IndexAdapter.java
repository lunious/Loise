package com.lunioussky.loise.mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lunioussky.loise.mvp.ui.fragment.IndexListFragment;

import java.util.ArrayList;

public class IndexAdapter extends FragmentPagerAdapter {

    private ArrayList<String> mList = new ArrayList<>();
    private ArrayList<Fragment> mFragment = new ArrayList<>();



    public IndexAdapter(ArrayList<String> list,FragmentManager fm) {
        super(fm);
        this.mList = list;

        for (int i = 0; i < mList.size(); i++) {
            mFragment.add(IndexListFragment.newInstance(mList.get(i)));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }
}
