package com.example.hp.coffeeh;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;

import com.example.hp.coffeeh.adapters.PagerAdapter;
import com.example.hp.coffeeh.fragments.AboutUs;
import com.google.firebase.auth.FirebaseAuth;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MenuActivity extends AppCompatActivity {
    private PagerAdapter pagerAdapter;
    private Toolbar toolbar;
    private Drawer.Result drawer = null;
    private FirebaseAuth maAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        maAuth = FirebaseAuth.getInstance();

        drawer = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHeader(R.layout.header)
                .withActionBarDrawerToggle(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.home).withIcon(FontAwesome.Icon.faw_home),
                        new PrimaryDrawerItem().withName(R.string.facebook).withIcon(FontAwesome.Icon.faw_facebook_official),
                        new PrimaryDrawerItem().withName(R.string.boughtCoffee).withIcon(FontAwesome.Icon.faw_coffee),
                        new PrimaryDrawerItem().withName(R.string.SignOut).withIcon(FontAwesome.Icon.faw_sign_out),
                        new SectionDrawerItem().withName(R.string.Settings),
                        new DividerDrawerItem()
                       // new SecondaryDrawerItem().withName(R.string.SingOut).withIcon(FontAwesome.Icon.faw_github)

                ).withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        InputMethodManager inputMethodManager = (InputMethodManager) MenuActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(MenuActivity.this.getCurrentFocus().getWindowToken(), 0);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {

                    }
                }).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {

                         if(position == 2){
                            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                            AboutUs aboutUs = new AboutUs();
                            transaction1.add(R.id.main_container,aboutUs).addToBackStack(null).commit();
                        }
                        else if(position==4){
                             maAuth.signOut();
                             finish();
                             startActivity(new Intent(MenuActivity.this,LoginActivity.class));
                         }


                    }
                }).build();

        TabLayout tablayout =  (TabLayout)findViewById(R.id.tab_layout);
        tablayout.addTab(tablayout.newTab().setText(R.string.coffee));
        tablayout.addTab(tablayout.newTab().setText(R.string.milkshakes));
        tablayout.addTab(tablayout.newTab().setText(R.string.Tea));


        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewpager = (ViewPager) findViewById(R.id.view_pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewpager.setAdapter(pagerAdapter);

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }




}

