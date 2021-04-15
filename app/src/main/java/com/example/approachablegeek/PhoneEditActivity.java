package com.example.approachablegeek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PhoneEditActivity extends AppCompatActivity {

    Button update;
    EditText phone;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_edit);

        update = findViewById(R.id.UpdateButton);
        phone = findViewById(R.id.editPhoneNumber);
        back = findViewById(R.id.Back);

        Intent intent = getIntent();
        String phone_no = intent.getStringExtra("PhoneNo");
        phone.setText(phone_no);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOpenMainActivity();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void onClickOpenMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        String phone_no = phone.getText().toString().trim();
        if (phone_no.length() != 10){
            Toast toast = Toast.makeText(getApplicationContext(),"Please enter a valid phone number", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            intent.putExtra("PhoneNo", phone_no);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}