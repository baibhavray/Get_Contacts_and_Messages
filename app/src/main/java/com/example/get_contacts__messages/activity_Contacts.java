package com.example.get_contacts__messages;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class activity_Contacts extends AppCompatActivity {
    ListView lvContact;
    ArrayList al = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__contacts);

        lvContact=findViewById(R.id.lvContact);
        Cursor cur = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC");
        //.query = rawQuery
        //WE can't get data directly from an app's db, so our app will get the data from other app's content provider(It's like a source where all the data are stored from db)
        while(cur.moveToNext()){
            String name = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            //"cur.getColumnIndex()" is used because we don't know the exact index number
            //As we don't know the index number "ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME" is used for display name
            String mobileno = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            //Same to get the mobile number
            al.add(name+"\n"+mobileno);
        }
        cur.close();
        ArrayAdapter aa = new ArrayAdapter(activity_Contacts.this,android.R.layout.simple_list_item_1,al);
        lvContact.setAdapter(aa);
    }
}