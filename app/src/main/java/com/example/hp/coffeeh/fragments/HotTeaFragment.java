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
import com.example.hp.coffeeh.ViewHolders.HotTeaHolder;
import com.example.hp.coffeeh.interfaces.RecyclerViewOnClickListener;
import com.example.hp.coffeeh.models.HotTea;
import com.example.hp.coffeeh.prodDetails.HotTeaDetailFragment;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class HotTeaFragment extends Fragment  {

    private RecyclerView recyclerView_hot_tea;
    private DatabaseReference htTearef;
    private FirebaseRecyclerAdapter<HotTea,HotTeaHolder> htTea;




    public HotTeaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hot_tea, container, false);
        recyclerView_hot_tea = view.findViewById(R.id.recyclerView_hot_tea);
        recyclerView_hot_tea.setLayoutManager(new GridLayoutManager(getActivity(),2));
        htTearef = FirebaseDatabase.getInstance().getReference("Hottea");
         htTea = new FirebaseRecyclerAdapter<HotTea, HotTeaHolder>(
                 HotTea.class,R.layout.hot_tea_holder_row,HotTeaHolder.class,htTearef
         ) {
             @Override
             protected void populateViewHolder(HotTeaHolder viewHolder, HotTea model, int position) {
//                 viewHolder.tv_hot_tea_name.setText(model.getName());
                viewHolder.tv_hot_tea_price.setText(model.getRowPrice());
                 Picasso.with(getContext()).load(model.getImage()).into(viewHolder.iv_hot_tea);
                 viewHolder.setRecyclerViewOnClickListener(new RecyclerViewOnClickListener() {
                     @Override
                     public void onItemClick(View v, int position) {
                         switch (v.getId()){
                             case R.id.iv_hot_tea:
                                 HotTeaDetailFragment hotTeaDetailFragment = new HotTeaDetailFragment();
                                 Bundle bundle = new Bundle();
                                 bundle.putString("hotTeaId",htTea.getRef(position).getKey());
                                 hotTeaDetailFragment.setArguments(bundle);
                                 FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                 fragmentTransaction.add(R.id.main_container,hotTeaDetailFragment).addToBackStack(null).commit();
                                 break;
                         }
                     }
                 });

             }
         };
         recyclerView_hot_tea.setAdapter(htTea);




        return view;
    }


}