package vn.edu.usth.twitterproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class TwitterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(5);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.header);
        tabLayout.setupWithViewPager(pager);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Weather", "onStart() called");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Weather", "onPause() called");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Weather", "onStop() called");
    }
    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 5;
        private String titles[] = new String[] { "Post", "Replies", "Highlight", "Media", "Likes" };
        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return PAGE_COUNT; // number of pages for a ViewPager
        }
        @Override
        public Fragment getItem(int page) {
// returns an instance of Fragment corresponding to the specified page
            switch (page) {
                case 0: return new PostProfileFragment();
                case 1: return new RepliesProfileFragment();
                case 2: return new PostProfileFragment();
                case 3: return new MediaProfileFragment();
                case 4: return new PostProfileFragment();
            }
            return new Fragment(); // failsafe
        }
        @Override
        public CharSequence getPageTitle(int page) {
// returns a tab title corresponding to the specified page
            return titles[page];
        }
    }


}
