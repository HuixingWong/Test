package com.example.huixing.demo2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import adapter.GridAdapter;
import adapter.GridAdapter2;
import adapter.pop_adapter;

public class ClickPenactivity extends AppCompatActivity {

    private PopupWindow pop;
    private TextView fukuanfangshi;
    private ImageView jiantou,iv_left;
    private GridView gridView;
    GridAdapter adapter;
    GridAdapter2 adapter2;
    pop_adapter adapter3;

    private ListView pop_list;

    private LinearLayout liner;

    private Button zhichu,shouru;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_penactivity);
         adapter = new GridAdapter(this);
         adapter2 = new GridAdapter2(this);

        init();

        gridView.setAdapter(adapter);





    }

    public void init(){

        jiantou = (ImageView) findViewById(R.id.jiantou_left);

        jiantou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        iv_left = (ImageView) findViewById(R.id.iv_left);

        liner = (LinearLayout) findViewById(R.id.liner);

        gridView = (GridView) findViewById(R.id.gridview);

        zhichu = (Button) findViewById(R.id.zhichu);
        zhichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridView.setAdapter(adapter);
                liner.setBackgroundColor(Color.rgb(85, 212, 176));
            }
        });

        shouru = (Button) findViewById(R.id.shouru);

        shouru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridView.setAdapter(adapter2);
                liner.setBackgroundColor(Color.rgb(249, 154, 184));
            }
        });


        fukuanfangshi = (TextView) findViewById(R.id.fukunfangshi);
        fukuanfangshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getPopwindow();

                pop.showAsDropDown(v,0,0);

//                pop.showAtLocation(v, Gravity.CENTER,
//                        WindowManager.LayoutParams.MATCH_PARENT,200);


            }
        });


    }

    private void getPopwindow() {

        if (pop != null){
            pop.dismiss();
            return;
        }else {
            initPopwindow();
        }
    }

    //初始化一个popwindow
    private void initPopwindow() {

        final View contentView = View.inflate(this, R.layout.popwindow_view, null);
        pop_list = (ListView) contentView.findViewById(R.id.pop_list);
        adapter3 = new pop_adapter(this);

        //设置popwindow里面的listview的监听事件
        pop_list.setAdapter(adapter3);
        pop_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               switch (position){
                   case 0:

                       iv_left.setImageResource(R.mipmap.add_activity_xianjin_icon);
                       fukuanfangshi.setText("现金");
                       pop.dismiss();

                       break;
                   case 1:
                       iv_left.setImageResource(R.mipmap.add_activity_chuxuka_icon);
                       fukuanfangshi.setText("储蓄卡");
                       pop.dismiss();



                       break;
                   case 2:
                       iv_left.setImageResource(R.mipmap.add_activity_xinyongka_icon);

                       fukuanfangshi.setText("信用卡");
                       pop.dismiss();


                       break;
                   case 3:
                       iv_left.setImageResource(R.mipmap.add_activity_zhifubao_icon);

                       fukuanfangshi.setText("支付宝");
                       pop.dismiss();


                       break;
               }

            }
        });


        pop = new PopupWindow(contentView,500,500,true);

        contentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (pop != null && pop.isShowing()){

                    pop.dismiss();
                    pop = null;
                }

                return false;
            }
        });

    }

}
