package com.mtha.mycontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MyContact> data = new ArrayList<>();
    ListView myList;
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();//khoi tao du lieu mau
        contactAdapter = new ContactAdapter(MainActivity.this,data);
        myList = findViewById(R.id.lvMyContact);
        myList.setAdapter(contactAdapter);
    }

    private void initData(){
        data.add(new MyContact(R.drawable.user,
                "Ha","09876543"));
        data.add(new MyContact(R.drawable.user,"Thuan",
                "2345678"));
        data.add(new MyContact(R.drawable.user,"Minh",
                "345678798"));
        data.add(new MyContact(R.drawable.user,"Khanh",
                "56789"));
        data.add(new MyContact(R.drawable.user,"Hoang",
                "67890"));
    }
}