package com.nawin.androidragger.viewpagerexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    static int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        pager.setClipToPadding(false);
        pager.setPageMargin(12);
        pager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                pos = position;
                return ItemFragment.getInstance(position);
            }

            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public float getPageWidth(int position) {
                return 0.93f;
            }
        });
        pager.setCurrentItem(pos + 1);

        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });

    }

}
