package be.howest.nmct.talkee;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import be.howest.nmct.talkee.Fragments.PageFinishFragment;
import be.howest.nmct.talkee.Fragments.PageHomeFragment;
import be.howest.nmct.talkee.Fragments.PageOrientedFragment;
import be.howest.nmct.talkee.Fragments.PagePhoneticFragment;
import be.howest.nmct.talkee.Fragments.PagePhonologicalFragment;

public class MainActivity extends FragmentActivity {
    private static final int NUMBER_OF_PAGES = 5;

    private ViewPager _pager;
    private PagerAdapter _pagerAdapter;

    public static Animation SHAKE_ANIMATION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _pager = (ViewPager)findViewById(R.id.pager);
        _pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        _pager.setAdapter(_pagerAdapter);

        SHAKE_ANIMATION = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
    }

    @Override
    public void onBackPressed() {
        if (_pager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            _pager.setCurrentItem(_pager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new PageHomeFragment();
                case 1:
                    return new PageOrientedFragment();
                case 2:
                    return new PagePhonologicalFragment();
                case 3:
                    return new PagePhoneticFragment();
                case 4:
                    return new PageFinishFragment();
                default:
                    return new PageHomeFragment();
            }
        }

        @Override
        public int getCount() {
            return NUMBER_OF_PAGES;
        }
    }
}
