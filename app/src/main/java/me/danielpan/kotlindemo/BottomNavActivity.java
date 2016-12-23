package me.danielpan.kotlindemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import me.danielpan.kotlindemo.fragment.ContentFragment;

public class BottomNavActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private ContentFragment mHome, mCollection, mCommunity, mNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.btm_nvg_home:
                showToast(R.string.bottom_nav_title_home);
                getSupportActionBar().setSubtitle(R.string.bottom_nav_title_home);
                if (mHome == null) {
                    mHome = ContentFragment.newInstance(0, getSupportActionBar().getSubtitle().toString());
                }
                fragmentTransaction.replace(R.id.content, mHome);
                break;
            case R.id.btm_nvg_collection:
                showToast(R.string.bottom_nav_title_collection);
                getSupportActionBar().setSubtitle(R.string.bottom_nav_title_collection);
                if (mCollection == null) {
                    mCollection = ContentFragment.newInstance(1, getSupportActionBar().getSubtitle().toString());
                }
                fragmentTransaction.replace(R.id.content, mCollection);
                break;
            case R.id.btm_nvg_community:
                showToast(R.string.bottom_nav_title_community);
                getSupportActionBar().setSubtitle(R.string.bottom_nav_title_community);
                if (mCommunity == null) {
                    mCommunity = ContentFragment.newInstance(2, getSupportActionBar().getSubtitle().toString());
                }
                fragmentTransaction.replace(R.id.content, mCommunity);
                break;
            case R.id.btm_nvg_notification:
                showToast(R.string.bottom_nav_title_notification);
                getSupportActionBar().setSubtitle(R.string.bottom_nav_title_notification);
                if (mNotification == null) {
                    mNotification = ContentFragment.newInstance(3, getSupportActionBar().getSubtitle().toString());
                }
                fragmentTransaction.replace(R.id.content, mNotification);
                break;
        }
        fragmentTransaction.commit();
        return true;
    }

    private void showToast(@StringRes int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }
}
