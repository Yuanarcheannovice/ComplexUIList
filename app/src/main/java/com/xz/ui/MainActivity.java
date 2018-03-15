package com.xz.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.xz.ui.fragment.OneFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> mTitles = new ArrayList<>();
    List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tableLayout = findViewById(R.id.am_tl);
        ViewPager viewPager = findViewById(R.id.am_vp);
        tableLayout.setupWithViewPager(viewPager);

        mTitles.add("One");
        mFragments.add(new OneFragment());

        for (String title : mTitles) {
            tableLayout.addTab(tableLayout.newTab().setText(title));
        }

        viewPager.setAdapter(new FragmentVpAdapter(getSupportFragmentManager()));
    }

    class FragmentVpAdapter extends FragmentPagerAdapter {


        public FragmentVpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mTitles.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

    }
}
