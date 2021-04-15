package com.example.approachablegeek;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Name;
    private TextView Phone;
    private TextView Email;
    private TextView Bio;
    private ImageView Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.Name);
        Phone = findViewById(R.id.PhoneNo);
        Email = findViewById(R.id.Email);
        Bio = findViewById(R.id.Bio);
        Image = findViewById(R.id.ProfilePicture);

        Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] name_ = Name.getText().toString().split(" ");
                Intent intent = new Intent(MainActivity.this, EditNameActivity.class);
                intent.putExtra("FirstName", name_[0]);
                intent.putExtra("LastName", name_[1]);
                startActivityForResult(intent, 1);
            }
        });

        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_no = Phone.getText().toString();
                Intent intent = new Intent(MainActivity.this, PhoneEditActivity.class);
                intent.putExtra("PhoneNo", phone_no);
                startActivityForResult(intent, 2);
            }
        });

        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_ = Email.getText().toString();
                Intent intent = new Intent(MainActivity.this, EmailEditActivity.class);
                intent.putExtra("Email", email_);
                startActivityForResult(intent, 3);
            }
        });

        Bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bio_ = Bio.getText().toString();
                Intent intent = new Intent(MainActivity.this, BioEditActivity.class);
                intent.putExtra("Bio", bio_);
                startActivityForResult(intent, 4);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String firstName = data.getStringExtra("FirstName");
                    String lastName = data.getStringExtra("LastName");
                    if (!firstName.equals("") && !lastName.equals("")) {
                        Name.setText(firstName + " " + lastName);
                    }
                }
                break;
            case 2:
                if (resultCode == RESULT_OK){
                    Phone.setText(data.getStringExtra("PhoneNo"));
                }
                break;
            case 3:
                if (resultCode == RESULT_OK){
                    Email.setText(data.getStringExtra("Email"));
                }
                break;
            case 4:
                if (resultCode == RESULT_OK){
                    Bio.setText(data.getStringExtra("Bio"));
                }
                break;
        }
    }
}