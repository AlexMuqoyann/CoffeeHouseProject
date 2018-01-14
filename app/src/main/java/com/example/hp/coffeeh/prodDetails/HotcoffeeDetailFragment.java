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
import com.example.hp.coffeeh.models.HotCoffee;
import com.example.hp.coffeeh.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Date;


public class HotcoffeeDetailFragment extends Fragment {
  private TextView tv_hot_cf_detail_name,tv_hot_coffee_detail_price;
  private ImageView iv_hot_cf_detail;
  private EditText et_hot_cf_sugar;
  private CollapsingToolbarLayout collapsingToolbarLayout;
  private FloatingActionButton fl_hot_coffee;
  private ElegantNumberButton elegantNumberButton;
  private DatabaseReference htcDetails;
  private RadioGroup order;
  private String orderIn;
  private String count;
  private String coffeeId = "";
  private String Type = "Hot";
  private DatabaseReference Slavonic;
  private DatabaseReference Aleq_Manukyan;
  private DatabaseReference Bryusov;
  private DatabaseReference Asue;
  private DatabaseReference Polytech;
    public HotcoffeeDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotcoffee_detail, container, false);
        htcDetails = FirebaseDatabase.getInstance().getReference("Hotcoffee");
        Slavonic =FirebaseDatabase.getInstance().getReference("Slavonic");
        Aleq_Manukyan = FirebaseDatabase.getInstance().getReference("AleqManukyan");
        Bryusov = FirebaseDatabase.getInstance().getReference("Bryusov");
        Asue = FirebaseDatabase.getInstance().getReference("Asue");
        Polytech = FirebaseDatabase.getInstance().getReference("Polytech");
        elegantNumberButton = view.findViewById(R.id.hot_cf_detail_elButton);
        fl_hot_coffee = view.findViewById(R.id.fl_hot_cf_detail);
        et_hot_cf_sugar = view.findViewById(R.id.et_hot_cf_sugar);
        tv_hot_cf_detail_name = view.findViewById(R.id.tv_hot_cf_detail_name);
        order = view.findViewById(R.id.rg_order);
        tv_hot_coffee_detail_price = view.findViewById(R.id.tv_hot_coffee_detail_price);
        iv_hot_cf_detail = view.findViewById(R.id.iv_hot_cf_detail);
        collapsingToolbarLayout = view.findViewById(R.id.collapsing_hot_cf);


        Bundle bundle = getArguments();
        if (bundle != null) {
            coffeeId = bundle.getString("coffeeId");
            if (!coffeeId.isEmpty()){
                getDetailCoffee(coffeeId);
            }
        }
        fl_hot_coffee.setOnClickListener(new View.OnClickListener() {
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
                        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Cb_slavonic.isChecked()){
                                    String coffeeName = tv_hot_cf_detail_name.getText().toString();
                                    String coffePrice = tv_hot_coffee_detail_price.getText().toString();
                                    String sugar = et_hot_cf_sugar.getText().toString();
                                    String id = Slavonic.push().getKey();
                                    CoffeeDetail detail = new CoffeeDetail(coffeeName,coffePrice,count,sugar,orderIn,id,Type,new Date(System.currentTimeMillis()).toString());
                                    Slavonic.child(id).setValue(detail);

                                }
                                else if (Cb_aleq_manukyan.isChecked()){
                                    String coffeeName = tv_hot_cf_detail_name.getText().toString();
                                    String coffePrice = tv_hot_coffee_detail_price.getText().toString();
                                    String sugar = et_hot_cf_sugar.getText().toString();
                                    String id = Aleq_Manukyan.push().getKey();
                                    CoffeeDetail detail = new CoffeeDetail(coffeeName,coffePrice,count,sugar,orderIn,id,Type,new Date(System.currentTimeMillis()).toString());
                                    Aleq_Manukyan.child(id).setValue(detail);

                                }
                                else if (Cb_bryusov.isChecked()){
                                    String coffeeName = tv_hot_cf_detail_name.getText().toString();
                                    String coffePrice = tv_hot_coffee_detail_price.getText().toString();
                                    String sugar = et_hot_cf_sugar.getText().toString();
                                    String id = Bryusov.push().getKey();
                                    CoffeeDetail detail = new CoffeeDetail(coffeeName,coffePrice,count,sugar,orderIn,id,Type,new Date(System.currentTimeMillis()).toString());
                                    Bryusov.child(id).setValue(detail);

                                }
                                else if (Cb_asue.isChecked()){
                                    String coffeeName = tv_hot_cf_detail_name.getText().toString();
                                    String coffePrice = tv_hot_coffee_detail_price.getText().toString();
                                    String sugar = et_hot_cf_sugar.getText().toString();
                                    String id = Asue.push().getKey();
                                    CoffeeDetail detail = new CoffeeDetail(coffeeName,coffePrice,count,sugar,orderIn,id,Type,new Date(System.currentTimeMillis()).toString());
                                    Asue.child(id).setValue(detail);

                                }
                                else if (Cb_polytech.isChecked()){
                                    String coffeeName = tv_hot_cf_detail_name.getText().toString();
                                    String coffePrice = tv_hot_coffee_detail_price.getText().toString();
                                    String sugar = et_hot_cf_sugar.getText().toString();
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
        order.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rb_5){
                    orderIn = "5 min";
                }
                else if(checkedId==R.id.rb_10){
                    orderIn = "10 min";
                }
                else if(checkedId == R.id.rb_15){
                    orderIn = "15 min";
                }
                else if(checkedId == R.id.rb_20){
                    orderIn = "20 min";
                }
                else  if(checkedId == R.id.rb_25){
                    orderIn = "25 min";
                }
                else if(checkedId == R.id.rb_30){
                    orderIn = "30 min";
                }
            }
        });elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                count = elegantNumberButton.getNumber();
            }
        });
        return view;
    }

    private void getDetailCoffee(String coffeeId) {
        htcDetails.child(coffeeId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HotCoffee hotCoffee = dataSnapshot.getValue(HotCoffee.class);

                Picasso.with(getContext()).load(hotCoffee.getImage()).into(iv_hot_cf_detail);
                tv_hot_cf_detail_name.setText(hotCoffee.getName());
                tv_hot_coffee_detail_price.setText(hotCoffee.getPrice());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
