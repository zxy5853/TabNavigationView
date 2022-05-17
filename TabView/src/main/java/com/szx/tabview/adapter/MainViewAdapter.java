package com.szx.tabview.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * Created by chengxi on 17/4/26.
 */
public class MainViewAdapter extends BaseAdapter {

    private Fragment[] fragmentArray;
    private FragmentManager fragmentManager;
    private String[] textArray;
    private int[] iconImageArray;
    private int[] selectedIconImageArray;
    private int hasMsgIndex = 0;

    public void setHasMsgIndex(int hasMsgIndex) {
        this.hasMsgIndex = hasMsgIndex;
    }

    public MainViewAdapter(FragmentManager fragmentManager, Fragment[] fragmentArray) {
        this.fragmentManager = fragmentManager;
        this.fragmentArray = fragmentArray;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public int hasMsgIndex() {
        return hasMsgIndex;
    }

    public void setTextArray(String[] textArray) {
        this.textArray = textArray;
    }

    @Override
    public String[] getTextArray() {
        return textArray;
    }

    public void setIconImageArray(int[] iconImageArray) {
        this.iconImageArray = iconImageArray;
    }

    @Override
    public Fragment[] getFragmentArray() {
        return fragmentArray;
    }

    @Override
    public int[] getIconImageArray() {
        return iconImageArray;
    }

    public void setSelectedIconImageArray(int[] selectedIconImageArray) {
        this.selectedIconImageArray = selectedIconImageArray;
    }

    @Override
    public int[] getSelectedIconImageArray() {
        return selectedIconImageArray;
    }

    @Override
    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }
}
