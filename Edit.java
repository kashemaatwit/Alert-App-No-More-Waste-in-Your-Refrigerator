package edu.wit.mobileappdevelopment.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        backButton = (Button) findViewById(R.id.backEdit);

        Bundle bundle = this.getIntent().getExtras();

        String name = bundle.getString("NameOfItem");
        String count = bundle.getString("CountOfItem");
        String purchaseDate = bundle.getString("PurchaseDateOfItem");
        String expirationDate = bundle.getString("ExpirationDateOfItem");

        EditText nameField = (EditText) findViewById(R.id.inputNameOfItemEdit);
        EditText countField = (EditText) findViewById(R.id.inputNameOfItemEdit);
        EditText purchaseDateField = (EditText) findViewById(R.id.inputBoughtDateEdit);
        EditText expirationDateField = (EditText) findViewById(R.id.inputExpirationDateEdit);

        nameField.setText(name);
        countField.setText(count);
        purchaseDateField.setText(purchaseDate);
        expirationDateField.setText(expirationDate);

        goBack();

    }

    public void goBack(){
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(Edit.this, MainActivity.class);

                startActivity(intent);
            }

        });
    }
}