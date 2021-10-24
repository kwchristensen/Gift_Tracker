package com.example.gift_tracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.gift_tracker.ui.main.SectionsPagerAdapter;
import com.example.gift_tracker.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ActivityResultLauncher<Intent> addNewRecipientToDb = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK) {
                        Log.d("test", "success");
                        Log.d("test", result.toString());
                    } else {
                        Log.d("test", "successful failure");
                        Log.d("test", result.toString());
                    }

                    updateRecyclerView();
                }

            }
    );

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
                    addNewRecipient();
                } else if (tabs.getSelectedTabPosition() == 1) {

                    Intent intent = new Intent(view.getContext(), AddGift.class);
                    view.getContext().startActivity(intent);
                }
            }
        });
    }

    private void addNewRecipient() {
       Intent intent = new Intent(MainActivity.this, AddRecipient.class);
        /* startActivity(intent);*/

        addNewRecipientToDb.launch(intent);
    }

    public void updateRecyclerView() {
        //RecipientTab recipientTab = (RecipientTab) getSupportFragmentManager().findFragmentById(R.id.view_pager);

        ViewPager viewPager = binding.viewPager;
        Fragment selectedTab = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.view_pager + ":" + viewPager.getCurrentItem());

        ((RecipientTab)selectedTab).updateRecipientList();

        /*if(recipientTab != null && recipientTab.isAdded()) {
            recipientTab.updateRecipientList();
            //recipientTab.updateRecipientList(getSupportFragmentManager().getPrimaryNavigationFragment().requireView());
        }*/
    }
}