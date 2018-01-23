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
import com.example.hp.coffeeh.viewHolders.HotCoffeeHolder;
import com.example.hp.coffeeh.interfaces.RecyclerViewOnClickListener;
import com.example.hp.coffeeh.models.HotCoffee;
import com.example.hp.coffeeh.prodDetails.HotcoffeeDetailFragment;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotCoffeeFragment extends Fragment  {

    private RecyclerView recyclerView_hot_coffee;
    private DatabaseReference databaseReference;
    private FirebaseRecyclerAdapter<HotCoffee,HotCoffeeHolder>firebaseRecyclerAdapter;


    public HotCoffeeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hot_coffee, container, false);
        databaseReference = FirebaseDatabase.getInstance().getReference("Hotcoffee");
        recyclerView_hot_coffee = view.findViewById(R.id.recyclerView_hot_coffee);


        recyclerView_hot_coffee.setLayoutManager(new GridLayoutManager(getActivity(),2));
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<HotCoffee, HotCoffeeHolder>(
                HotCoffee.class,R.layout.hot_coffee_holder_row,HotCoffeeHolder.class,databaseReference
        ) {
            @Override
            protected void populateViewHolder(HotCoffeeHolder viewHolder, HotCoffee model, int position) {
                viewHolder.tv_hot_cf.setText(model.getName());
                viewHolder.tv_hot_cf_price.setText(model.getRowPrice());
                Picasso.with(getContext()).load(model.getImage()).into(viewHolder.iv_hot_cf);
                viewHolder.setRecyclerViewOnClickListener(new RecyclerViewOnClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        switch (v.getId()){
                            case R.id.iv_hot_cf:
                                HotcoffeeDetailFragment htfDetail = new HotcoffeeDetailFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("coffeeId",firebaseRecyclerAdapter.getRef(position).getKey());
                                htfDetail.setArguments(bundle);
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.add(R.id.main_container,htfDetail).addToBackStack(null).commit();
                        }
                    }
                });
            }
        };
        recyclerView_hot_coffee.setAdapter(firebaseRecyclerAdapter);

        return view;
    }


    }



