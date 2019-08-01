package com.agunwgn.simadesa.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.agunwgn.simadesa.TabNoRutin;
import com.agunwgn.simadesa.TabRutin;

public class PageAdapter extends FragmentStatePagerAdapter {

    int countTab;

    public PageAdapter(FragmentManager fm, int countTab) {
        super(fm);
        this.countTab = countTab;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                TabRutin tabRutin = new TabRutin();
                return tabRutin;
            case 1:
                TabNoRutin tabNoRutin = new TabNoRutin();
                return tabNoRutin;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return countTab;
    }
}
