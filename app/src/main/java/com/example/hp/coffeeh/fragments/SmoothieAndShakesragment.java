package com.example.hp.coffeeh.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hp.coffeeh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SmoothieAndShakesragment extends Fragment {
   private Button btn_smoothie;

    public SmoothieAndShakesragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_smoothie_and_shakesragment, container, false);
        btn_smoothie = view.findViewById(R.id.btn_smoothie);
        btn_smoothie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                SmoothiesFragment smoothiesFragment = new SmoothiesFragment();
                transaction.add(R.id.main_container,smoothiesFragment).addToBackStack(null).commit();
            }
        });
        return view;
    }

}
