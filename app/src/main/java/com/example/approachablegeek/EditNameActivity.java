package com.example.approachablegeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EditNameActivity extends AppCompatActivity {

    Button update;
    EditText firstName;
    EditText lastName;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);

        update = findViewById(R.id.UpdateButton);
        firstName = findViewById(R.id.FirstName);
        lastName = findViewById(R.id.LastName);
        back = findViewById(R.id.Back);

        Intent intent = getIntent();
        String firstName_ = intent.getStringExtra("FirstName");
        String lastName_ = intent.getStringExtra("LastName");
        firstName.setText(firstName_);
        lastName.setText(lastName_);

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
        String firstName_ = firstName.getText().toString().trim();
        String lastName_ = lastName.getText().toString().trim();
        intent.putExtra("FirstName", firstName_);
        intent.putExtra("LastName", lastName_);
        setResult(RESULT_OK, intent);
        finish();
    }
}