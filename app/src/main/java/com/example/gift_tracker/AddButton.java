package com.example.gift_tracker;

import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class AddButton {

    private static String LOG = "buttonTag";
    String message;

    public AddButton(View view, int tabIndex) {

        Log.d(LOG, String.valueOf(tabIndex));

/*        switch(tabIndex) {
            case 0:
                message = "Recipient Tab";
                Log.d(LOG, "zero");
            case 1:
                message = "Gift Tab";
                Log.d(LOG, "one");
            default:
                message = "error";
        }*/

        if(tabIndex == 0) {
            Log.d(LOG,"Recipient");
        } else if (tabIndex == 1) {
            Log.d(LOG, "Gift");
        }

        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        .setAction("Action", null).show();




    }
}
