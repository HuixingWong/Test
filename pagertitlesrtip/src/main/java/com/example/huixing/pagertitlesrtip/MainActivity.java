package com.example.huixing.pagertitlesrtip;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private PagerTitleStrip pts;

    private View view1,view2,view3;
    private List<View> viewlist = new ArrayList<View>();
    private List<String>  titlelist;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LayoutInflater inflater = getLayoutInflater();

        view1 = inflater.inflate(R.layout.layout1,null);
        view2 = inflater.inflate(R.layout.layout2,null);
        view3 = inflater.inflate(R.layout.layout3,null);

        viewlist.add(view1);
        viewlist.add(view2);
        viewlist.add(view3);

        titlelist = new ArrayList<String>();
        titlelist.add("music");
        titlelist.add("movie");
        titlelist.add("game");

        adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewlist.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {



//                return view == viewlist.get((int)Integer.parseInt(object.toString()));

                return  view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                container.addView(viewlist.get(position));

//                return position;
                return viewlist.get(position);
            }



            @Override
            public CharSequence getPageTitle(int position) {


                return titlelist.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

               container.removeView(viewlist.get(position));
            }
        };



        vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(adapter);

    }



    private void init() {






    }
}
