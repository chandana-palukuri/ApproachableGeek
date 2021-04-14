package com.example.approachablegeek;

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
        Phone = findViewById(R.id.Phone);
        Email = findViewById(R.id.Email);
        Bio = findViewById(R.id.Bio);
        Image = findViewById(R.id.ProfilePicture);

        Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditName();
            }
        });

        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditPhone();
            }
        });

        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditEmail();
            }
        });

        Bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditBio();
            }
        });

//        ImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openEditBio();
//            }
//        });

        }

    private void openEditBio() {
        Intent intent = new Intent(this, BioEditActivity.class);
        startActivity(intent);
    }

    private void openEditEmail() {
        Intent intent = new Intent(this, EmailEditActivity.class);
        startActivity(intent);
    }

    private void openEditPhone() {
        Intent intent = new Intent(this, PhoneEditActivity.class);
        startActivity(intent);
    }

    private void openEditName() {
        Intent intent = new Intent(this, EditNameActivity.class);
        startActivity(intent);
    }
}