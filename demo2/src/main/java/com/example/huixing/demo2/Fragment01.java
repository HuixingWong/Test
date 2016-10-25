package com.example.huixing.demo2;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by huixing on 2016/10/8.
 */

public class Fragment01 extends Fragment {


    private TextView rili_tv;

    private String dateshow;

    private int imagewith;

    ImageButton main_btn;

    private RelativeLayout layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment01, container, false);

        layout = (RelativeLayout) view.findViewById(R.id.laout);
        init();



        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

        Date date = new Date(System.currentTimeMillis());
        dateshow =  dateFormat.format(date);

        rili_tv = (TextView) view.findViewById(R.id.rili_tv);

        rili_tv.setText(dateshow);
        layout.addView(main_btn);


        return view;
    }


    @Override
    public void onResume() {


        super.onResume();
    }

    public void init(){



        main_btn = new ImageButton(getActivity());

       main_btn.setImageResource(R.mipmap.accountpager_pen_icon);

        imagewith = BitmapFactory.decodeResource(getResources(), R.mipmap.accountpager_pen_icon).getWidth();

        main_btn.setX((atributes.screenwith-imagewith*2)/2);

        main_btn.setBackgroundResource(R.drawable.pen_shape);

        main_btn.setY(100);
        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Fragment01.this.getActivity(),ClickPenactivity.class);
                startActivity(intent);

            }
        });




    }
}
