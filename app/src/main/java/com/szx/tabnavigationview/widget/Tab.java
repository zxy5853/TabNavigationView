package com.szx.tabnavigationview.widget;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.szx.tabnavigationview.listener.OnTabSelectedListener;
import com.szx.tabnavigationview.tools.DisplayUtil;

/**
 * Created by chengxi on 17/4/26.
 */
public class Tab {
    public static final int LEFT = 1;
    public static final int TOP = 2;
    public static final int RIGHT = 3;
    public static final int BOTTOM = 4;

    private Context context;
    private int index;
    //是否被选中
    private boolean isSelected;

    /**
     * 文本信息
     */
    private String text;
    private int textColor;
    private int selectedTextColor;
    private int textSize;
    private int drawablePadding;
    private int drawableTo;

    /**
     * icon信息
     */
    private int iconImage;
    private int selectedIconImage;
    private int iconHeight;
    private int iconWidth;

    private int tabHeight;
    private int tabBgColor;
    /**
     * Tab布局信息
     */
    private RelativeLayout childView;
    private LinearLayout rootView;
    private ImageView iconImageView;
    private TextView textTextView;

    /**
     * tab选中监听
     */
    private OnTabSelectedListener onTabSelectedListener;

    public Tab(Context context, String text, int textSize, int textColor, int selectedTextColor,
               int drawablePadding, int iconWidth, int iconHeight, int iconImage,
               int selectedIconImage, int index, boolean hasMsg, int tabHeight,
               int drawableTo, int tabBgColor) {
        this.context = context;
        this.text = text;
        this.textSize = textSize;
        this.textColor = textColor;
        this.selectedTextColor = selectedTextColor;
        this.drawablePadding = drawablePadding;
        this.drawableTo = drawableTo;

        this.iconImage = iconImage;
        this.selectedIconImage = selectedIconImage;
        this.index = index;
        this.iconHeight = iconHeight;
        this.iconWidth = iconWidth;

        this.tabHeight = tabHeight;
        this.tabBgColor = tabBgColor;

        init();
    }

    private void init() {
        initView();

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabSelected();
            }
        });
    }

    private void initView() {
        rootView = new LinearLayout(context);
        rootView.setBackgroundColor(tabBgColor);
        childView = new RelativeLayout(context);
        LinearLayout.LayoutParams rootViewLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.dip2px(context, tabHeight));
        rootViewLp.weight = 1;
        rootView.setOrientation(LinearLayout.VERTICAL);
        rootView.setPadding(0, 0, 0, 0);
        rootView.setLayoutParams(rootViewLp);
        textTextView = new TextView(context);
        iconImageView = new ImageView(context);

        //使用Linearlayout包裹 iconImageView 和 textTextView
        LinearLayout tabLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams tabLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tabLayout.setOrientation(LinearLayout.HORIZONTAL);
        tabLayout.setGravity(Gravity.CENTER);
        tabLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        tabLayout.setLayoutParams(tabLayoutParams);

        /**
         *  icon view
         */
        iconImageView.setImageResource(iconImage);
        RelativeLayout.LayoutParams iconParam = new RelativeLayout.LayoutParams(iconWidth == 0 ? ViewGroup.LayoutParams.WRAP_CONTENT : iconWidth, iconHeight == 0 ? ViewGroup.LayoutParams.WRAP_CONTENT : iconHeight);
        iconImageView.setLayoutParams(iconParam);
        tabLayout.addView(iconImageView);

        /**
         *  text view
         */
        textTextView.setText(text);
        textTextView.setTextColor(textColor);
        textTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        switch (drawableTo) {
            case LEFT:
                textTextView.setPadding(drawablePadding, 0, 0, 0);
                break;
            case TOP:
                textTextView.setPadding(0, drawablePadding, 0, 0);
                break;
            case RIGHT:
                textTextView.setPadding(0, 0, drawablePadding, 0);
                break;
            case BOTTOM:
                textTextView.setPadding(0, 0, 0, drawablePadding);
                break;
            default:
                break;
        }
        RelativeLayout.LayoutParams txParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        textTextView.setLayoutParams(txParam);
        tabLayout.addView(textTextView);
        childView.addView(tabLayout);

        /*if(hasMsg){
            ImageView circleView=new ImageView(context);
            RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(30,30);
            param.addRule(RelativeLayout.RIGHT_OF,iconImageView.getId());
            circleView.setBackgroundResource(R.drawable.common_red_round);
            circleView.setLayoutParams(param);
            childView.addView(circleView);
        }*/
        RelativeLayout.LayoutParams childParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        childView.setLayoutParams(childParam);
        rootView.addView(childView);
    }

    /**
     * 选中Tab
     */
    private void tabSelected() {
        if (onTabSelectedListener != null) onTabSelectedListener.onTabSelected(this);
    }

    /**
     * 得到rootView
     */
    public LinearLayout getRootView() {
        return rootView;
    }

    public int getIndex() {
        return index;
    }

    public String getText() {
        return text;
    }

    public void setTabIsSelected(boolean isSelected) {
        if (this.isSelected == isSelected) return;

        iconImageView.setImageResource(isSelected ? selectedIconImage : iconImage);
        textTextView.setTextColor(isSelected ? selectedTextColor : textColor);
        this.isSelected = isSelected;
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.onTabSelectedListener = onTabSelectedListener;
    }

}
