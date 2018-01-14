package com.example.hp.coffeeh.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hp.coffeeh.fragments.CoffeeFragment;
import com.example.hp.coffeeh.fragments.SmoothieAndShakesragment;
import com.example.hp.coffeeh.fragments.SmoothiesFragment;
import com.example.hp.coffeeh.fragments.TeaFragment;



public class PagerAdapter extends FragmentStatePagerAdapter{
    private int countOfTabs;

    public PagerAdapter(FragmentManager fm, int countOfTabs) {
        super(fm);
        this.countOfTabs = countOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CoffeeFragment coffeeFragment = new CoffeeFragment();
                return  coffeeFragment;
            case 1:
                SmoothieAndShakesragment smoothieAndShakesragment = new SmoothieAndShakesragment();
            return smoothieAndShakesragment;
            case 2:
                TeaFragment teaFragment = new TeaFragment();
                return teaFragment;
            default:
                return null;
        }


    }


    @Override
    public int getCount() {
        return countOfTabs;
    }
}
