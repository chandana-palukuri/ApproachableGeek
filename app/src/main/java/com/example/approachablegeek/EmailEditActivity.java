package com.example.approachablegeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EmailEditActivity extends AppCompatActivity {

    Button update;
    EditText email;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_edit);

        update =  findViewById(R.id.UpdateButton);
        email = findViewById(R.id.EmailTextField);
        back = findViewById(R.id.Back);

        Intent intent = getIntent();
        String email_ = intent.getStringExtra("Email");
        email.setText(email_);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmailEditActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
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
        String email_ = email.getText().toString().trim();
        String regex_ = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(email_.matches(regex_)){
            intent.putExtra("Email", email_);
            setResult(RESULT_OK, intent);
            finish();
        }
        else {
            Toast.makeText(EmailEditActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
        }
    }
}