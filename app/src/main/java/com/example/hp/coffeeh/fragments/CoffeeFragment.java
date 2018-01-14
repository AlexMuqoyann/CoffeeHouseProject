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

/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeFragment extends Fragment {


    private Button btn_hot_coffee;
    private Button btn_ice_coffee;


    public CoffeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee, container, false);
        btn_hot_coffee = view.findViewById(R.id.btn_hot_coffee);
        btn_ice_coffee = view.findViewById(R.id.btn_ice_coffee);
        btn_hot_coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HotCoffeeFragment hotCoffeeFragment = new HotCoffeeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.main_container,hotCoffeeFragment).addToBackStack(null).commit();
            }
        });
        btn_ice_coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IceCoffeeFragment iceCoffeeFragment = new IceCoffeeFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.main_container,iceCoffeeFragment).addToBackStack(null).commit();
            }
        });
        return view;
    }
}
