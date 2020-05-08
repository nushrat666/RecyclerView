package com.mononsoft.reccyclerviewandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContactAdapter.ClickListener {

    EditText nameET;
    EditText phoneNoET;
    RecyclerView recyclerView;

    String name;
    String phoneNo;

    ArrayList<Contact> contactList;

    ContactAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET=findViewById(R.id.nameET);
        phoneNoET=findViewById(R.id.phoneNoET);
        recyclerView=findViewById(R.id.recycler_view);

        contactList=new ArrayList<>();
        adapter=new ContactAdapter(MainActivity.this,contactList,MainActivity.this);


        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
recyclerView.setLayoutManager(manager);


        recyclerView.setAdapter(adapter);

    }

    public void createList(View view) {
        name=nameET.getText().toString();
        phoneNo=phoneNoET.getText().toString();

        Contact contact=new Contact(name,phoneNo);

        contactList.add(contact);

        adapter.updateData(contactList);

    }

    @Override
    public void onClick(Contact contact) {

        Toast.makeText(this, contact.getName(), Toast.LENGTH_SHORT).show();

    }
}
