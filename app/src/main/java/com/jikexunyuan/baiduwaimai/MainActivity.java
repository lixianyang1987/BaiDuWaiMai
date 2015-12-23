package com.jikexunyuan.baiduwaimai;

import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.support.design.widget.TabLayout.*;

public class MainActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager viewPager;
    private int[] imageResId;
    private String[] tabTitles;
    private EditText editText;
    private Fragment home;
    private static TabLayout tabLayout;
    private static ViewPager container;
    private static CoordinatorLayout coordinatorLayout;
    private static AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        editText= (EditText) findViewById(R.id.editText);
        coordinatorLayout= (CoordinatorLayout) findViewById(R.id.main_content);
        appBarLayout= (AppBarLayout) findViewById(R.id.appbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        imageResId = new int[]{R.drawable.tab_icon_home_selected, R.drawable.tab_icon_dingdan, R.drawable.tab_icon_me};
        tabTitles = new String[]{"首页", "订单", "我"};
        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(mSectionsPagerAdapter);
         tabLayout = (TabLayout) findViewById(R.id.tabs);
          container = (ViewPager) findViewById(R.id.container);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(getTabView(i));
            }
        }
        viewPager.setCurrentItem(0);

        tabLayout.setOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                View v = tab.getCustomView();
                ImageView img = (ImageView) v.findViewById(R.id.imageView);
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        img.setImageResource(R.drawable.tab_icon_home_selected);
                        break;
                    case 1:
                        img.setImageResource(R.drawable.tab_icon_dingdan_selected);
                        break;
                    case 2:
                        img.setImageResource(R.drawable.tab_icon_me_selected);
                        break;
                }
            }

            @Override
            public void onTabUnselected(Tab tab) {
                View v = tab.getCustomView();
                ImageView img = (ImageView) v.findViewById(R.id.imageView);

                switch (tab.getPosition()) {
                    case 0:
                        img.setImageResource(R.drawable.tab_icon_home);
                        break;
                    case 1:
                        img.setImageResource(R.drawable.tab_icon_dingdan);
                        break;
                    case 2:
                        img.setImageResource(R.drawable.tab_icon_me);
                        break;

                }
            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
    }

    public View getTabView(int position) {
        View v = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) v.findViewById(R.id.textView);
        tv.setText(tabTitles[position]);
        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        img.setImageResource(imageResId[position]);
        return v;
    }
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if(home==null){
                        home=new HomeFragment();
                    }
                    return home;
                case 1:
                    return new DdFragment();
                case 2:
                    return new MeFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }

    public static TabLayout getTabLayout() {
        return tabLayout;
    }

    public static ViewPager getContainer() {
        return container;
    }

    public static AppBarLayout getAppBarLayout() {
        return appBarLayout;
    }

    public static CoordinatorLayout getCoordinatorLayout() {
        return coordinatorLayout;
    }
}
