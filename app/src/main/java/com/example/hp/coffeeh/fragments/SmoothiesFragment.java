package com.example.hp.coffeeh.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.coffeeh.R;
import com.example.hp.coffeeh.ViewHolders.SmoothiesHolder;
import com.example.hp.coffeeh.interfaces.RecyclerViewOnClickListener;
import com.example.hp.coffeeh.models.Smoothies;
import com.example.hp.coffeeh.prodDetails.SmoothieDetailsFragment;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class SmoothiesFragment extends Fragment  {


    private RecyclerView recyclerView_m_shakes;
    private DatabaseReference databaseReference;
    private FirebaseRecyclerAdapter<Smoothies,SmoothiesHolder>smoothiesAdapter;


    public SmoothiesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_smoothies, container, false);
        recyclerView_m_shakes = view.findViewById(R.id.recyclerView_m_shakes);
        databaseReference = FirebaseDatabase.getInstance().getReference("Smoothie");
        recyclerView_m_shakes.setLayoutManager(new GridLayoutManager(getActivity(),2));

        smoothiesAdapter = new FirebaseRecyclerAdapter<Smoothies, SmoothiesHolder>(
                Smoothies.class,R.layout.fragment_smoothies_holder,SmoothiesHolder.class,databaseReference
        ) {
            @Override
            protected void populateViewHolder(SmoothiesHolder viewHolder, Smoothies model, int position) {
                viewHolder.tv_smoothie_text.setText(model.getName());
                viewHolder.tv_smoothie_price.setText(model.getPrice());
                Picasso.with(getContext()).load(model.getImage()).into(viewHolder.iv_smoothies);
                viewHolder.setRecyclerViewOnClickListener(new RecyclerViewOnClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        switch (v.getId()){
                            case R.id.iv_smoothie:
                                SmoothieDetailsFragment smoothieDetailsFragment = new SmoothieDetailsFragment();
                                Bundle args = new Bundle();
                                args.putString("smoothieId",smoothiesAdapter.getRef(position).getKey());
                                smoothieDetailsFragment.setArguments(args);
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.add(R.id.main_container,smoothieDetailsFragment).addToBackStack(null).commit();
                        }
                    }
                });
            }
        };
        recyclerView_m_shakes.setAdapter(smoothiesAdapter);
        return view;
    }




}