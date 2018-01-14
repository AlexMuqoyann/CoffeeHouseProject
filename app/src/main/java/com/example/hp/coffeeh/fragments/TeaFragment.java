package com.example.hp.coffeeh.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hp.coffeeh.R;

import info.hoang8f.widget.FButton;

public class TeaFragment extends Fragment {

    private FButton btn_hot_tea;
    private FButton btn_ice_tea;

    public TeaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tea, container, false);
        btn_hot_tea = view.findViewById(R.id.btn_hot_tea);
        btn_ice_tea = view.findViewById(R.id.btn_ice_tea);

        btn_hot_tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HotTeaFragment hotTeaFragment = new HotTeaFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.main_container, hotTeaFragment).addToBackStack(null).commit();

            }
        });
        btn_ice_tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IceTeaFragment iceTeaFragment = new IceTeaFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.main_container,iceTeaFragment).addToBackStack(null).commit();
            }
        });
        return view;
    }

}
