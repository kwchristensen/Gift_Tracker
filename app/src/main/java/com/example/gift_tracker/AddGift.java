package com.example.gift_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddGift extends AppCompatActivity {

    EditText txtGiftName;
    EditText txtGiftDescription;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gift);

        txtGiftName = findViewById(R.id.textInputGiftName);
        txtGiftDescription = findViewById(R.id.textInputGiftDescription);

        btnSubmit = findViewById(R.id.btnSubmitGift);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = DatabaseHelper.getInstance(getApplicationContext());

                if(txtGiftName.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    /*Toast toast = Toast.makeText(getApplicationContext(), "Nice work, your typing skills amaze me", Toast.LENGTH_LONG);
                    toast.show();*/

                    Gift newGift = new Gift(txtGiftName.getText().toString(), txtGiftDescription.getText().toString());


                    
                }
            }
        });

    }
}