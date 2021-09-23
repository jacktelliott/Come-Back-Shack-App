package com.example.comebackshack.ui.main;

import android.content.Intent;
import android.os.Bundle;

import com.example.comebackshack.CouponFragment;
import com.example.comebackshack.ProfileFragment;
import com.example.comebackshack.QRFragment;
import com.example.comebackshack.R;
import com.example.comebackshack.ui.login.LoginActivity;
import com.example.comebackshack.ui.main.PlaceholderFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.comebackshack.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static int loggedIn = 0;
    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (loggedIn == 0) {
            loggedIn++;
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting.");

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            email = extras.getString("email");
        }

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.view_pager);
        //this.viewPager.setAdapter(sectionsPagerAdapter);
        setupViewPager(viewPager);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        /*
        TabItem profileTab = (TabItem) findViewById(R.id.profileTab);
        TabItem qrTab = (TabItem) findViewById(R.id.qrTab);
        TabItem couponTab = (TabItem) findViewById(R.id.couponTab);

        tabs.addTab(tabs.newTab().setText("Profile"));
        tabs.addTab(tabs.newTab().setText("QR Code"));
        tabs.addTab(tabs.newTab().setText("Coupons"));
         */

        //tabs.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        sectionsPagerAdapter.addFragment(new ProfileFragment(), "Profile");
        sectionsPagerAdapter.addFragment(new QRFragment(email), "QR Code");
        sectionsPagerAdapter.addFragment(new CouponFragment(), "Coupons");
        viewPager.setAdapter(sectionsPagerAdapter);
    }

    public String getEmail(){
        return email;
    }
}