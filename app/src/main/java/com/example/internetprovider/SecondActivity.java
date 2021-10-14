package com.example.internetprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import model.ClientProvider;

public class SecondActivity extends AppCompatActivity {

    TextView tvClOrder,tvTotal;
    ArrayList<ClientProvider> listOfOrders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();
    }

    private void initialize()
    {
        tvClOrder = findViewById(R.id.tvClOrder);
        tvTotal = findViewById(R.id.tvTotalOrders);
        listOfOrders = (ArrayList<ClientProvider>) getIntent().getExtras().getSerializable("orders");

        StringBuilder list = new StringBuilder("");
        float totalOrders = 0;

        for(ClientProvider oneOrder:listOfOrders)
        {
            list.append(oneOrder + "\n");
            totalOrders+=oneOrder.getTotal();
        }

        tvClOrder.setText(list);
        tvTotal.append(totalOrders+"");
    }
}