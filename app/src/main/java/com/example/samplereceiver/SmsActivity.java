package com.example.samplereceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);
        ed3 = findViewById(R.id.editText3);
        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    private void processIntent(Intent passedIntent) {
        if (passedIntent != null) {
            String sender = passedIntent.getStringExtra("sender");
            String contents = passedIntent.getStringExtra("contents");
            String receivedDate = passedIntent.getStringExtra("receivedDate");
            ed1.setText(sender);
            ed2.setText(contents);
            ed3.setText(receivedDate);
        }
    }

    public void checkSms(View view) {
        finish();
    }
}