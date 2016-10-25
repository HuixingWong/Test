package com.example.huixing.fragmentandviewpage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {

    //初始位置的偏移量
    private int offset;

    //图片的宽度
    private int imagewidth;

    //当前显示界面的编号
    private int current;

    private TextView tv_1,tv_2,tv_3;
    private ImageView iv_indiator;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        init();
        tv_1 = (TextView) findViewById(R.id.main_title_music);
        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vp.setCurrentItem(0);

            }
        });

        tv_2 = (TextView) findViewById(R.id.main_title_movie);
        tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(1);
//                Toast.makeText(MainActivity.this, "lalaalala", Toast.LENGTH_SHORT).show();
            }
        });


        tv_3 = (TextView) findViewById(R.id.main_title_game);
        tv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vp.setCurrentItem(2);

            }
        });






        iv_indiator = (ImageView) findViewById(R.id.main_iv_indiator);

        imagewidth = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher).getWidth();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        offset = (screenWidth/3 - imagewidth)/2;

        Matrix matrix = new Matrix();
        matrix.postTranslate(offset,0);
        iv_indiator.setImageMatrix(matrix);






        //构造适配器
        List<Fragment> fragments=new ArrayList<Fragment>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), fragments);

        //设定适配器
         vp = (ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new MypageChangeListener());
    }





    private void init() {

            }






    private class MypageChangeListener implements ViewPager.OnPageChangeListener {

        int one = offset * 2 + imagewidth;// 页卡1 -> 页卡2 偏移量
        int two = one * 2;// 页卡1 -> 页卡3 偏移量

        @Override
        public void onPageScrolled
                (int position, float positionOffset, int positionOffsetPixels) {

//            Toast.makeText(MainActivity.this, "onPageScrolled", Toast.LENGTH_SHORT).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle("onPageScrolled");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
//            builder.create().show();

        }

        @Override
        public void onPageSelected(int position) {


//            Animation animation = new TranslateAnimation();
            Animation animation = new TranslateAnimation(one*current, one*position, 0, 0);
            current= position;
            animation.setFillAfter(true);// True:图片停在动画结束位置
            animation.setDuration(300);
            iv_indiator.startAnimation(animation);
//            Toast.makeText(MainActivity.this, "您选择了"+
//                    main_vp.getCurrentItem()+"页卡", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onPageScrollStateChanged(int state) {

//            Toast.makeText(MainActivity.this, "onPageScrollStateChanged", Toast.LENGTH_SHORT).show();
        }
    }


}






//
/*可能会出现的问题：
 * fragments.add(new Fragment1());
 * 提示无法将Fragment1()转换为fragment；这是因为导入包不一致，一般的问题在于
 * 在Fragment1中导入的是android.app.Fragment，
 * 而在这里导入类确是：android.support.v4.app.Fragment,包不同当然无法转换
 * 统一导入为android.support.v4.app.Fragment之后就正常了.
 *
 * 相关网址：http://blog.csdn.net/jason0539/article/details/9712273
 * */
