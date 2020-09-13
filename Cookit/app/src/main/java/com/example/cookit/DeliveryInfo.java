package com.example.cookit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DeliveryInfo extends AppCompatActivity {

    public void buttonClicked(View view){
        Toast.makeText(getApplicationContext(),"Ingredients will be Delivered at your doorstep", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_info);
    }
}
