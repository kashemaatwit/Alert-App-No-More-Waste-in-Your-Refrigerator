package edu.wit.mobileappdevelopment.seniorproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
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
        ArrayList<String> theList = new ArrayList<>();
        ListView ItemList = (ListView) findViewById(R.id.ItemList);

        Cursor data = dataBaseHelper.getAllData();

        if (data.moveToFirst()) {

            do {


                theList.add("Name: " + data.getString(1));
                theList.add("Quantity: " + data.getString(2));
                theList.add("Purchase Date: " + data.getString(3));
                theList.add("Expiration Date: " + data.getString(4));
            }

            while (data.moveToNext());
        }


        ListAdapter listAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, theList);
        ItemList.setAdapter(listAdapter);
        System.out.print( "Items " + ItemList);



    }




  /*

       List<Itemmodel_database> show  = dataBaseHelper.getall();


        ArrayAdapter adapter = new ArrayAdapter<Itemmodel_database>(MainActivity.this, android.R.layout.simple_list_item_1, show);
        ItemList.setAdapter(adapter);

*/


        //ListView list = findViewById(R.id.ItemList);
       // list.setAdapter(adapter);

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
        public void filter()
        {
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
