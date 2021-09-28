package com.example.gift_tracker;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.gift_tracker.ui.main.SectionsPagerAdapter;
import com.example.gift_tracker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AddButton addButton = new AddButton(view, tabs.getSelectedTabPosition());

                if(tabs.getSelectedTabPosition() == 0) {
                    //Log.d(LOG,"Recipient");
                    //message = "Recipient Tab";

                    Intent intent = new Intent(view.getContext(), AddRecipient.class);
                    view.getContext().startActivity(intent);
                } else if (tabs.getSelectedTabPosition() == 1) {

                    Intent intent = new Intent(view.getContext(), AddGift.class);
                    view.getContext().startActivity(intent);
                    //Log.d(LOG, "Gift");
                    //message = "Gift Tab";
                }
            }
        });
    }
}