package com.example.gift_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecipient extends AppCompatActivity {

    private Button btnSubmit;
    private EditText txtRecipientName;
    private Recipient newRecipient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipient);

        txtRecipientName = findViewById(R.id.textInputRecipientName);

        btnSubmit = findViewById(R.id.btnRecipientSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = DatabaseHelper.getInstance(getApplicationContext());

                if(txtRecipientName.getText().toString().equals("")) {

                    Toast toast = Toast.makeText(getApplicationContext(), "Nice work, your typing skills amaze me", Toast.LENGTH_LONG);
                    toast.show();

                } else {

                    Recipient recipient = new Recipient(txtRecipientName.getText().toString());

                    db.addRecipient(recipient);

                    Toast toast = Toast.makeText(getApplicationContext(), "Total Records: " + db.getRecipientCount(), Toast.LENGTH_LONG);
                    toast.show();

                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    getApplicationContext().startActivity(intent);
                }
            }
        });
    }


}