package com.example.gift_tracker;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class AddButton {

    public AddButton(View view, int tabIndex) {
            Snackbar.make(view, String.valueOf(tabIndex), Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();




    }
}

