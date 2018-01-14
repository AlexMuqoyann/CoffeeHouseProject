package com.example.hp.coffeeh.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.coffeeh.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class IceTeaFragment extends Fragment{


    private RecyclerView recyclerView_ice_tea;


    public IceTeaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ice_tea, container, false);
        recyclerView_ice_tea = view.findViewById(R.id.recyclerView_ice_tea);

        recyclerView_ice_tea.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }




}