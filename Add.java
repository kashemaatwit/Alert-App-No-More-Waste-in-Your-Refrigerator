package edu.wit.mobileappdevelopment.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Add extends AppCompatActivity {
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
    EditText inputExpirationDate, InputBoughtDate, inputAmountOfItem,inputNameOfItem; //Abdul
    Button addItemButton; //Abdul
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        inputNameOfItem = findViewById(R.id.inputNameOfItem); //Abdul
        inputAmountOfItem = findViewById(R.id.inputAmountOfItem); //Abdul
        InputBoughtDate = findViewById(R.id.InputBoughtDate);//Abdul
        inputExpirationDate = findViewById(R.id.inputExpirationDate);//Abdul


         backButton = findViewById(R.id.backItem);
         addItemButton = findViewById(R.id.addItem); //Abdul
        AddData(); //Abdul
    }
    //Created by Abdul
    public void AddData() {
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = dataBaseHelper.addOne(inputNameOfItem.getText().toString(), inputAmountOfItem.getText().toString(), InputBoughtDate.getText().toString(), inputExpirationDate.getText().toString());

                if(inserted = true)
                {
                    Toast.makeText(Add.this, "Data Inserted", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(Add.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        }


        );
    }

       /*
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(Add.this, MainActivity.class);

                startActivity(intent);
            }

        });
// created by Abdul


*/







    }
