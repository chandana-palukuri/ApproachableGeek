package com.example.approachablegeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BioEditActivity extends AppCompatActivity {

    Button update;
    EditText bio;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_edit);

        update = findViewById(R.id.UpdateButton);
        bio = findViewById(R.id.EditBioTextField);
        back = findViewById(R.id.Back);

        Intent intent = getIntent();
        String bio_ = intent.getStringExtra("Bio");
        bio.setText(bio_);

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
        String bio_ = bio.getText().toString().trim();
        intent.putExtra("Bio", bio_);
        setResult(RESULT_OK, intent);
        finish();
    }
}