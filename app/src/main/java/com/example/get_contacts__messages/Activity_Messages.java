package com.example.get_contacts__messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity_Messages extends AppCompatActivity {
    ListView lvSMS;
    ArrayList al = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__messages);


        lvSMS = findViewById(R.id.lvSMS);
        // content://sms/sent, content://sms/draft - these are for draft and sent messages
        Cursor cur = getContentResolver().query(Uri.parse("content://sms/inbox"),new String[]{"address","body"},null,null,null);
        //.query = rawQuery
        //Here we only want to get the address and body of the message so "new String[]{"address","body"}" is there (those are default names
        //WE can't get data directly from an app's db, so our app will get the data from other app's content provider(It's like a source where all the data are stored from db)
        while(cur.moveToNext()){
            String address = cur.getString(0);
            //getString(0) = address
            String body = cur.getString(1);
            //getString(1) = body
            al.add(address+"\n"+body);
        }
        cur.close();
        ArrayAdapter aa = new ArrayAdapter(Activity_Messages.this,android.R.layout.simple_list_item_1,al);
        lvSMS.setAdapter(aa);
    }
}