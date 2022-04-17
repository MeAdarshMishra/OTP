package com.example.otp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText_otp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_otp=findViewById(R.id.editText_otp);
        requestPermissions();
        new OTP_Reciever().setEditText_otp(editText_otp);
    }

    private void requestPermissions() {
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECEIVE_SMS)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                    Manifest.permission.RECEIVE_SMS
            },100);
        }
    }
}