package com.newproject.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etName,etNumber;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        etNumber=findViewById(R.id.etNumber);
        btnAdd=findViewById(R.id.btnAdd);

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String number = etNumber.getText().toString();

                databaseHelper.contactsDao().addTx(
                        new Contacts("Shashank", "9945425476")
                );
                ArrayList<Contacts> arrExpenses =(ArrayList<Contacts>) databaseHelper.contactsDao().getAllContacts();
                for(int i=0;i<arrExpenses.size();i++){
                    Log.d("Id:  ","Name:  "+arrExpenses.get(i).getName()+"Number:  "+arrExpenses.get(i).getNumber());
                }
            }
        });

    }
}