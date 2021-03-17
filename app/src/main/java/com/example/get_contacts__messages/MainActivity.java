package com.example.get_contacts__messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnMessages,btnContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMessages = findViewById(R.id.btnMessages);
        btnContacts = findViewById(R.id.btnContacts);

        if (Build.VERSION.SDK_INT >=23)
        {
            if(ContextCompat.checkSelfPermission(MainActivity.this,"android.permission.READ_SMS")!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{"android.permission.READ_SMS"},1);
            }
            if(ContextCompat.checkSelfPermission(MainActivity.this,"android.permission.READ_CONTACTS")!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{"android.permission.READ_CONTACTS"},1);
            }
        }

        btnMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activity_Messages.class);
                startActivity(intent);
            }
        });
        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,activity_Contacts.class);
                startActivity(intent);
            }
        });
    }
}