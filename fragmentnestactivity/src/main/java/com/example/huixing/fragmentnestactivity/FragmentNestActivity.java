package com.example.huixing.fragmentnestactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 嵌套Fragment使用
 *
 * @author 农民伯伯
 *
 */
public class FragmentNestActivity extends FragmentActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_fragment_nest);

        findViewById(R.id.btnModule1).setOnClickListener(this);
        findViewById(R.id.btnModule2).setOnClickListener(this);
        findViewById(R.id.btnModule3).setOnClickListener(this);

        findViewById(R.id.btnModule1).performClick();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnModule1:
                addFragmentToStack(FragmentParent.newInstance(0));
                break;
            case R.id.btnModule2:
                addFragmentToStack(FragmentParent.newInstance(1));
                break;
            case R.id.btnModule3:
                addFragmentToStack(FragmentParent.newInstance(2));
                break;
        }
    }

    private void addFragmentToStack(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_in_left);
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }

    /** 嵌套Fragment */
    public final static class FragmentParent extends Fragment {

        public static final FragmentParent newInstance(int position) {
            FragmentParent f = new FragmentParent();
            Bundle args = new Bundle(2);
            args.putInt("position", position);
            f.setArguments(args);
            return f;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View convertView = inflater.inflate(R.layout.viewpager_fragments, container, false);
            ViewPager pager = (ViewPager) convertView.findViewById(R.id.pager);

            final int parent_position = getArguments().getInt("position");
            //注意这里的代码
            pager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {

                @Override
                public Fragment getItem(final int position) {
                    return new Fragment() {
                        @Override
                        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                            TextView convertView = new TextView(getActivity());
                            convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
                            convertView.setGravity(Gravity.CENTER);
                            convertView.setTextSize(30);
                            convertView.setTextColor(Color.BLACK);
                            convertView.setText("Page " + position);
                            return convertView;
                        }
                    };
                }

                @Override
                public int getCount() {
                    return 3;
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return "Page " + parent_position + " - " + position;
                }

            });

            return convertView;
        }
    }
}