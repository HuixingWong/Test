package com.example.huixing.demo2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //定义控件
    private ViewPager mViewPager;
    //FragmentpagerAdapter适配器
    private FragmentPagerAdapter mAdpter;
    //Fragment集合
    private List<Fragment> mFragments = new ArrayList<>();


    //四个Tab每个Tab都有一个按钮
    private LinearLayout mTabMyCircle;
    private LinearLayout mTabMyDiscovery;
    private LinearLayout mTabMyMsg;
    private LinearLayout mTabMyCenter;
    //四个按钮
    private ImageButton myCircleImg;
    private ImageButton myDiscoveryImg;
    private ImageButton myMsgImg;
    private ImageButton myCenterImg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        atributes.screenwith= metrics.widthPixels;

        initViews();//初始化控件
        initEvent();//监听逻辑事件


        initViewPages();//初始化viewpager
    }


    private void initViews() {

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        //初始化四个布局
        mTabMyCircle = (LinearLayout) findViewById(R.id.id_tab_mycircle);
        mTabMyDiscovery = (LinearLayout) findViewById(R.id.id_tab_discovery);
        mTabMyMsg = (LinearLayout) findViewById(R.id.id_tab_message);
        mTabMyCenter = (LinearLayout) findViewById(R.id.id_tab_setting);
        //初始化四个按钮
        myCircleImg = (ImageButton) findViewById(R.id.id_tab_mycirlceImg);
        myDiscoveryImg = (ImageButton) findViewById(R.id.id_tab_discovery_img);
        myMsgImg = (ImageButton) findViewById(R.id.id_tab_message_img);
        myCenterImg = (ImageButton) findViewById(R.id.id_tab_setting_img);
    }

    private void initViewPages() {
        //初始化四个布局
        Fragment01 tab01 = new Fragment01();
        Fragment02 tab02 = new Fragment02();
        Fragment03 tab03 = new Fragment03();
        Fragment04 tab04 = new Fragment04();
        mFragments.add(tab01);
        mFragments.add(tab02);
        mFragments.add(tab03);
        mFragments.add(tab04);
        //初始化Adapter这里使用FragmentPagerAdapter
        mAdpter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }


        };
        mViewPager.setAdapter(mAdpter);

    }


    private void initEvent() {
        //设置监听器
        myCircleImg.setOnClickListener(this);
        myDiscoveryImg.setOnClickListener(this);
        myMsgImg.setOnClickListener(this);
        myCenterImg.setOnClickListener(this);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当viewPager滑动的时候
                int currentPage = mViewPager.getCurrentItem();
                switch (currentPage) {
                    case 0:
                        reSetImg();
                        myCircleImg.setImageResource(R.mipmap.content_jizhang_press_icon);
                        break;
                    case 1:
                        reSetImg();
                        myDiscoveryImg.setImageResource(R.mipmap.content_baobiao_press_icon);
                        break;
                    case 2:
                        reSetImg();
                        myMsgImg.setImageResource(R.mipmap.content_zijin_press_icon);
                        break;
                    case 3:
                        reSetImg();
                        myCenterImg.setImageResource(R.mipmap.heart);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void reSetImg() {
        myCircleImg.setImageResource(R.mipmap.content_jizhang_icon);
        myDiscoveryImg.setImageResource(R.mipmap.content_baobiao_icon);
        myMsgImg.setImageResource(R.mipmap.content_zijin_icon);
        myCenterImg.setImageResource(R.mipmap.heart);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tab_mycirlceImg:
                //设置当前Fragment
                mViewPager.setCurrentItem(0);
                //调用resetImg方法，将imagebutton的图片置为默认样式
                reSetImg();
                //设置选中的图片改变
                myCircleImg.setImageResource(R.mipmap.content_jizhang_press_icon);
                break;
            case R.id.id_tab_discovery_img:
                mViewPager.setCurrentItem(1);
                reSetImg();
                myDiscoveryImg.setImageResource(R.mipmap.content_baobiao_press_icon);
                break;
            case R.id.id_tab_message_img:
                mViewPager.setCurrentItem(2);
                reSetImg();
                myMsgImg.setImageResource(R.mipmap.content_zijin_press_icon);
                break;
            case R.id.id_tab_setting_img:
                mViewPager.setCurrentItem(3);
                reSetImg();
                myCenterImg.setImageResource(R.mipmap.heart);
                break;
            default:
                break;


        }


    }


}
