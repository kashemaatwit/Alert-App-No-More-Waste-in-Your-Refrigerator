package edu.wit.mobileappdevelopment.seniorproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
    Button addButton;
    Button filterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.Add);
        filterButton = findViewById(R.id.Filter);
        Add();
        filter();
        viewAll();

    }

//Created by Abdul
    public void viewAll() {
        ArrayList<CustomListItems> theList = new ArrayList<>();
        ListView ItemList = (ListView) findViewById(R.id.ItemList);

        Cursor data = dataBaseHelper.getAllData();

        // Database fullList
        // Database filteredList = Query of fulllist

        if (data.moveToFirst()) {

            do {

                CustomListItems item = new CustomListItems();
                item.name = data.getString(1);
                item.count = data.getString(2);
                item.purchaseDate = data.getString(3);
                item.expirationDate = data.getString(4);
                theList.add(item);
            }

            while (data.moveToNext());
        }

        //for testing
        CustomListItems anItem = new CustomListItems();
        anItem.name = "Test";
        anItem.count = "1";
        anItem.purchaseDate = "7/17/2021";
        anItem.expirationDate = "17/17/2021";
        theList.add(anItem);

        CustomListAdapter listAdapter = new CustomListAdapter(this, 0, theList);
        ItemList.setAdapter(listAdapter);

        ItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomListItems selectedItem = theList.get(position);
                Intent intent = new Intent(MainActivity.this, Edit.class);
                Bundle bundle = new Bundle();
                bundle.putString("NameOfItem", selectedItem.name);
                bundle.putString("CountOfITem", selectedItem.count);
                bundle.putString("PurchaseDateOfItem", selectedItem.purchaseDate);
                bundle.putString("ExpirationDateOfItem", selectedItem.expirationDate);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void Add() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent();
                addIntent.setClass(MainActivity.this, Add.class);
                startActivity(addIntent);
            }
        });

    }

    public void filter() {
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent filterIntent = new Intent();
                filterIntent.setClass(MainActivity.this, Filter.class);

                startActivity(filterIntent);
            }
        });
    }
}
