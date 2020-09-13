package com.example.cookit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static java.util.Arrays.asList;


public class Recipies extends AppCompatActivity {
    //private FirebaseDatabase mDatabase;
    //private DatabaseReference mReferenceMenu;
    public void clickFunction(View view){
        startActivity(new Intent(Recipies.this, Cart.class));

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipies);
        ListView myListView = findViewById(R.id.myLIstViewID);
        final ArrayList<String> myMenu = new ArrayList<String>(asList("Pasta","Pizza","Chicken"));
        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,myMenu);
        myListView.setAdapter(arrayAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), myMenu.get(i)+" "+"Added to Cart", Toast.LENGTH_LONG).show();

            }
        });





        /*mDatabase= FirebaseDatabase.getInstance();
        mReferenceMenu = mDatabase.getReference("recipes");
        mReferenceMenu.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot keynode:dataSnapshot.getChildren() ){
                  myMenu.add(keynode);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/





    }
}
