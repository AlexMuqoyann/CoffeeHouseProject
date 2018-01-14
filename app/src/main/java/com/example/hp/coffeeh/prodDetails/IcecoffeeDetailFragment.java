package com.example.hp.coffeeh.prodDetails;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.hp.coffeeh.R;
import com.example.hp.coffeeh.models.CoffeeDetail;
import com.example.hp.coffeeh.models.IceCoffee;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class IcecoffeeDetailFragment extends Fragment {
    private TextView tv_ice_cf_detail_name, tv_ice_coffee_detail_price;
    private ElegantNumberButton ice_cf_detail_elButton;
    private ImageView iv_ice_cf_detail;
    private FloatingActionButton fl_ice_cf_detail;
    private DatabaseReference iceCfDetails;
    private DatabaseReference Slavonic;
    private DatabaseReference Aleq_Manukyan;
    private DatabaseReference Bryusov;
    private DatabaseReference Asue;
    private DatabaseReference Polytech;
    private RadioGroup order;
    private String orderIn;
    private EditText ice_sugar;
    private String count;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private String iceCoffeeId = "";
    private String Type = "Ice";

    public IcecoffeeDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_icecoffee_detail, container, false);
        iceCfDetails = FirebaseDatabase.getInstance().getReference("Icecoffee");
        Slavonic = FirebaseDatabase.getInstance().getReference("Slavonic");
        Aleq_Manukyan = FirebaseDatabase.getInstance().getReference("AleqManukyan");
        Bryusov = FirebaseDatabase.getInstance().getReference("Bryusov");
        Asue = FirebaseDatabase.getInstance().getReference("Asue");
        Polytech = FirebaseDatabase.getInstance().getReference("Polytech");
        iv_ice_cf_detail = view.findViewById(R.id.iv_ice_cf_detail);
        tv_ice_cf_detail_name = view.findViewById(R.id.tv_ice_cf_detail_name);
        tv_ice_coffee_detail_price = view.findViewById(R.id.tv_ice_coffee_detail_price);
        ice_cf_detail_elButton = view.findViewById(R.id.ice_cf_detail_elButton);
        order = view.findViewById(R.id.Rg_order_ice);
        fl_ice_cf_detail = view.findViewById(R.id.fl_ice_cf_detail);
        ice_sugar = view.findViewById(R.id.ice_cf_sugar);
        collapsingToolbarLayout = view.findViewById(R.id.collapsing_ice_cf);
        Bundle bundle = getArguments();
        if (bundle != null) {
            iceCoffeeId = bundle.getString("iceCoffeeId");
            if (!iceCoffeeId.isEmpty()) {
                getDetailCoffee(iceCoffeeId);
            }
        }
        ice_cf_detail_elButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                count = ice_cf_detail_elButton.getNumber();
            }
        });
        order.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rb_5min_ice){
                    orderIn = "5 min";
                }
                else if(checkedId==R.id.rb_10min_ice){
                    orderIn = "10 min";
                }
                else if(checkedId == R.id.rb_15min_ice){
                    orderIn = "15 min";
                }
                else if(checkedId == R.id.rb_20min_ice){
                    orderIn = "20 min";
                }
                else  if(checkedId == R.id.rb_25min_ice){
                    orderIn = "25 min";
                }
                else if(checkedId == R.id.rb_30min_ice){
                    orderIn = "30 min";
                }
            }
        });
        fl_ice_cf_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                LayoutInflater layoutInflater;
                layoutInflater = LayoutInflater.from(getActivity());
                View myView = layoutInflater.inflate(R.layout.custom_dialog,null);
                final CheckBox Cb_slavonic = myView.findViewById(R.id.Cb_slavonic);
                final CheckBox Cb_aleq_manukyan = myView.findViewById(R.id.Cb_aleq_manukyan);
                final CheckBox Cb_bryusov = myView.findViewById(R.id.Cb_bryusov);
                final CheckBox Cb_asue = myView.findViewById(R.id.Cb_asue);
                final CheckBox Cb_polytech = myView.findViewById(R.id.Cb_polytech);
                mBuilder.setView(myView);
                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Cb_slavonic.isChecked()){
                            String coffeeName = tv_ice_cf_detail_name.getText().toString();
                            String coffePrice = tv_ice_coffee_detail_price.getText().toString();
                            String sugar = ice_sugar.getText().toString();
                            String id = Slavonic.push().getKey();
                            CoffeeDetail detail = new CoffeeDetail(coffeeName,coffePrice,count,sugar,orderIn,id,Type,new Date(System.currentTimeMillis()).toString());
                            Slavonic.child(id).setValue(detail);
                        }
                        else if(Cb_aleq_manukyan.isChecked()){
                            String coffeeName = tv_ice_cf_detail_name.getText().toString();
                            String coffePrice = tv_ice_coffee_detail_price.getText().toString();
                            String sugar = ice_sugar.getText().toString();
                            String id = Aleq_Manukyan.push().getKey();
                            CoffeeDetail detail = new CoffeeDetail(coffeeName,coffePrice,count,sugar,orderIn,id,Type,new Date(System.currentTimeMillis()).toString());
                            Aleq_Manukyan.child(id).setValue(detail);
                        }
                        else if(Cb_bryusov.isChecked()){
                            String coffeeName = tv_ice_cf_detail_name.getText().toString();
                            String coffePrice = tv_ice_coffee_detail_price.getText().toString();
                            String sugar = ice_sugar.getText().toString();
                            String id = Bryusov.push().getKey();
                            CoffeeDetail detail = new CoffeeDetail(coffeeName,coffePrice,count,sugar,orderIn,id,Type,new Date(System.currentTimeMillis()).toString());
                            Bryusov.child(id).setValue(detail);
                        }
                        else if(Cb_asue.isChecked()){
                            String coffeeName = tv_ice_cf_detail_name.getText().toString();
                            String coffePrice = tv_ice_coffee_detail_price.getText().toString();

                            String sugar = ice_sugar.getText().toString();
                            String id = Asue.push().getKey();
                            CoffeeDetail detail = new CoffeeDetail(coffeeName,coffePrice,count,sugar,orderIn,id,Type,new Date(System.currentTimeMillis()).toString());
                            Asue.child(id).setValue(detail);
                        }
                        else if(Cb_polytech.isChecked()){
                            String coffeeName = tv_ice_cf_detail_name.getText().toString();
                            String coffePrice = tv_ice_coffee_detail_price.getText().toString();
                            String sugar = ice_sugar.getText().toString();
                            String id = Polytech.push().getKey();
                            CoffeeDetail detail = new CoffeeDetail(coffeeName,coffePrice,count,sugar,orderIn,id,Type,new Date(System.currentTimeMillis()).toString());
                            Polytech.child(id).setValue(detail);
                        }
                    }
                });
                mBuilder.create();
                mBuilder.show();


            }
        });
        return view;
    }

    private void getDetailCoffee(String iceCoffeeId) {
        iceCfDetails.child(iceCoffeeId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                IceCoffee iceCoffee = dataSnapshot.getValue(IceCoffee.class);
                Picasso.with(getContext()).load(iceCoffee.getImage()).into(iv_ice_cf_detail);
                tv_ice_cf_detail_name.setText(iceCoffee.getName());
                tv_ice_coffee_detail_price.setText(iceCoffee.getPrice());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
