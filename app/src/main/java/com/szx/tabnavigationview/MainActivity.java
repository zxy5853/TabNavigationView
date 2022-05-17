package com.szx.tabnavigationview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.szx.tabview.adapter.MainViewAdapter;
import com.szx.tabview.listener.OnTabSelectedListener;
import com.szx.tabview.widget.Tab;
import com.szx.tabview.widget.TabContainerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_container);
        TabContainerView tabContainerView = (TabContainerView) findViewById(R.id.tab_container);
        MainViewAdapter mainViewAdapter = new MainViewAdapter(getSupportFragmentManager(),
                new Fragment[]{new TabFragment1(), new TabFragment2(), new TabFragment3(), new TabFragment4(), new TabFragment5()});
        mainViewAdapter.setHasMsgIndex(5);
        mainViewAdapter.setTextArray(new String[]{"首页", "分类", "惊喜", "购物车", "我的"});
        mainViewAdapter.setIconImageArray(new int[]{R.mipmap.new_life_icon_grey, R.mipmap.new_find_icon_grey, R.mipmap.new_fininal_icon_grey, R.mipmap.new_shoppingcar_icon_grey, R.mipmap.new_myhome_icon_grey});
        mainViewAdapter.setSelectedIconImageArray(new int[]{R.mipmap.new_life_icon, R.mipmap.new_find_icon, R.mipmap.new_finial_icon, R.mipmap.new_shoppingcar_icon, R.mipmap.new_myhome_icon});
        tabContainerView.setAdapter(mainViewAdapter);
        tabContainerView.setOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {

            }
        });


    }
}
