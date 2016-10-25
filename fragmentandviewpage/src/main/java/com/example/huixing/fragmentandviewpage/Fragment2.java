package com.example.huixing.fragmentandviewpage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment2 extends Fragment {

	private Button add1,add2,add3;



	private void addFragment(Fragment fragment,String tag){

		FragmentManager manager = getFragmentManager();
		FragmentTransaction transation = manager.beginTransaction();
		transation.add(R.id.fragment_container, fragment, tag);
		transation.addToBackStack(tag);
		transation.commit();


	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.layout2, container, false);

		add1 = (Button) view.findViewById(R.id.add1);
		add2 = (Button) view.findViewById(R.id.add2);
		add3 = (Button) view.findViewById(R.id.add3);


		add1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Fragment4 fragment4= new Fragment4();
				addFragment(fragment4,"fragment4");
			}
		});

		add2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Fragment5 fragment5 = new Fragment5();
				addFragment(fragment5,"fragment5");
			}
		});

		add3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Fragment6 fragment6 = new Fragment6();
				addFragment(fragment6,"fragment6");
			}
		});


		return view;
	}


}
