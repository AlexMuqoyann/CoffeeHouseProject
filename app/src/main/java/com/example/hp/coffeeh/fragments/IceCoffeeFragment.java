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

import com.example.hp.coffeeh.ViewHolders.IceCoffeeHolder;
import com.example.hp.coffeeh.interfaces.RecyclerViewOnClickListener;
import com.example.hp.coffeeh.models.IceCoffee;
import com.example.hp.coffeeh.prodDetails.IcecoffeeDetailFragment;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class IceCoffeeFragment extends Fragment {


    private RecyclerView recyclerView_ice_coffee;
    private DatabaseReference databaseReference;
    private FirebaseRecyclerAdapter<IceCoffee,IceCoffeeHolder>firebaseRecyclerAdapter;

    public IceCoffeeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ice_coffee, container, false);
        recyclerView_ice_coffee = view.findViewById(R.id.recyclerView_ice_coffee);
        databaseReference = FirebaseDatabase.getInstance().getReference("Icecoffee");
        recyclerView_ice_coffee.setLayoutManager(new GridLayoutManager(getActivity(),2));
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<IceCoffee, IceCoffeeHolder>(
                IceCoffee.class,R.layout.ice_coffee_holder_row,IceCoffeeHolder.class,databaseReference
        ) {
            @Override
            protected void populateViewHolder(IceCoffeeHolder viewHolder, IceCoffee model, int position) {
                viewHolder.tv_ice_cf_text.setText(model.getName());
                viewHolder.tv_ice_cf_price.setText(model.getRowPrice());
                Picasso.with(getContext()).load(model.getImage()).into(viewHolder.iv_ice_cf_image);
                viewHolder.setRecyclerViewOnClickListener(new RecyclerViewOnClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        switch (v.getId()){
                            case R.id.iv_ice_cf_image:
                                IcecoffeeDetailFragment icecoffeeDetailFragment = new IcecoffeeDetailFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("iceCoffeeId",firebaseRecyclerAdapter.getRef(position).getKey());
                                icecoffeeDetailFragment.setArguments(bundle);
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.add(R.id.main_container,icecoffeeDetailFragment).addToBackStack(null).commit();
                        }
                    }
                });
            }
        };
        recyclerView_ice_coffee.setAdapter(firebaseRecyclerAdapter);

        return view;
    }



}

