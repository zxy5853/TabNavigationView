package com.szx.tabnavigationview.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * Created by chengxi on 17/4/26.
 */
public abstract class BaseAdapter {

    /**
     *  tab数量
     */
    public abstract int getCount();
    public abstract int hasMsgIndex();
    /**
     * tab text 数组
     */
    public abstract String[] getTextArray();

    /**
     * tab icon 数组
     */
    public abstract int[] getIconImageArray();

    /**
     * tab icon 选中 数组
     */
    public abstract int[] getSelectedIconImageArray();

    /**
     * fragment 数组
     */
    public abstract Fragment[] getFragmentArray();

    public abstract FragmentManager getFragmentManager();



}
