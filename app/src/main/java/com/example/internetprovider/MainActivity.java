package com.example.internetprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import model.ClientProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    EditText edClNumber,edNbMonths;
    RadioGroup rgProvider;
    TextView tvSubAmount,tvTps,tvTvq,tvTotal;
    Button btnSave,btnShowAll,btnExit;

    RadioButton rbBell,rbVideotron,rbAcanac;

    ArrayList<ClientProvider> listOfInternetProviders;
    String internetType = "";
    ClientProvider provider;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize()
    {
        edClNumber = findViewById(R.id.edClNumber);
        edNbMonths = findViewById(R.id.edNbMonths);
        rgProvider = findViewById(R.id.rgProvider);

        tvSubAmount = findViewById(R.id.tvSubAmountValue);
        tvTps = findViewById(R.id.tvTpsValue);
        tvTvq = findViewById(R.id.tvTvqValue);
        tvTotal = findViewById(R.id.tvTotalValue);

        btnExit = findViewById(R.id.btnExit);
        btnSave = findViewById(R.id.btnSave);
        btnShowAll = findViewById(R.id.btnShowAll);

        btnSave.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        btnShowAll.setOnClickListener(this);

        rbBell = findViewById(R.id.rbBell);
        rbVideotron = findViewById(R.id.rbVideotron);
        rbAcanac = findViewById(R.id.rbAcanac);

        rbBell.setOnClickListener(this);
        rbVideotron.setOnClickListener(this);
        rbAcanac.setOnClickListener(this);

        edNbMonths.addTextChangedListener(this);

    listOfInternetProviders = new ArrayList<ClientProvider>();

    }

    @Override
    public void onClick(View view)
    {
        int id = view.getId();
        switch(id)
        {
            case R.id.btnSave:
                saveClientProvider(view);
                break;

            case R.id.btnExit:
                quitApp();
                break;

            case R.id.btnShowAll:
                showAllClientInfo();
                break;

            case R.id.rbBell:
                internetType = rbBell.getText().toString();
                showAmount();
                break;

            case R.id.rbAcanac:
                internetType = rbAcanac.getText().toString();
                showAmount();
                break;

            case R.id.rbVideotron:
                internetType = rbVideotron.getText().toString();
                showAmount();
                break;




        }
    }

    private void showAmount()
    {
        try {
            float price = getPrice(internetType);
            int nbMonths = Integer.valueOf(edNbMonths.getText().toString());
            float amount = nbMonths*price;
            tvTotal.setText(String.valueOf(amount));
        }
        catch(Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private float getPrice(String internetType) throws Exception
    {
        float totalAmount=0;
        int monthValue = Integer.valueOf(edNbMonths.getText().toString());


        if(internetType.equals("Bell"))
            if(monthValue <= 11)
            {
                float amount = 60;
                float monthcost = amount * monthValue;
                tvSubAmount.setText(String.valueOf(monthcost));
                double tpsAmount = 3.6;
                tvTps.setText(String.valueOf(tpsAmount));
                double tvqAmount = 6.042;
                tvTvq.setText(String.valueOf(tvqAmount));
                totalAmount = (float)(monthcost + tpsAmount +tvqAmount);
                tvTotal.setText(String.valueOf(totalAmount));
            }else if (monthValue == 12)
            {
                float amount = 600;
                tvSubAmount.setText(String.valueOf(amount));
                double tpsAmount = 36;
                tvTps.setText(String.valueOf(tpsAmount));
                double tvqAmount = 60.42;
                tvTvq.setText(String.valueOf(tvqAmount));
                totalAmount = (float)(amount + tpsAmount +tvqAmount);
                tvTotal.setText(String.valueOf(totalAmount));
            }
        if (internetType.equals("Videotron"))
            if(monthValue < 6)
            {
                float amount = 70;
                float monthcost = amount * monthValue;
                tvSubAmount.setText(String.valueOf(monthcost));
                double tpsAmount = 4.2;
                tvTps.setText(String.valueOf(tpsAmount));
                double tvqAmount = 7.049;
                tvTvq.setText(String.valueOf(tvqAmount));
                totalAmount = (float)(amount + tpsAmount +tvqAmount);
                tvTotal.setText(String.valueOf(monthcost));
            }
        else if (monthValue > 6 && monthValue < 12)
            {
                float amount = 70;
                float monthcost = amount * monthValue;
                tvSubAmount.setText(String.valueOf(monthcost));
                double tpsAmount = 4.2;
                tvTps.setText(String.valueOf(tpsAmount));
                double tvqAmount = 7.049;
                tvTvq.setText(String.valueOf(tvqAmount));
                totalAmount = (float)(amount + tpsAmount +tvqAmount);
                tvTotal.setText(String.valueOf(monthcost));
            }
            else if (monthValue == 6)
            {
                float amount = 350;
                tvSubAmount.setText(String.valueOf(amount));
                double tpsAmount = 21;
                tvTps.setText(String.valueOf(tpsAmount));
                double tvqAmount = 35.245;
                tvTvq.setText(String.valueOf(tvqAmount));
                totalAmount = (float)(amount + tpsAmount +tvqAmount);
                tvTotal.setText(String.valueOf(totalAmount));
            }

            else if (monthValue == 12)
            {
                float amount = 588;
                tvSubAmount.setText(String.valueOf(amount));
                double tpsAmount = 35.28;
                tvTps.setText(String.valueOf(tpsAmount));
                double tvqAmount = 59.2116;
                tvTvq.setText(String.valueOf(tvqAmount));
                totalAmount = (float)(amount + tpsAmount +tvqAmount);
                tvTotal.setText(String.valueOf(totalAmount));
            }
        if(internetType.equals("Acanac"))
            if(monthValue <= 11)
            {
                float amount = 45;
                tvSubAmount.setText(String.valueOf(amount));
                double tpsAmount = 2.7;
                tvTps.setText(String.valueOf(tpsAmount));
                double tvqAmount = 4.5315;
                tvTvq.setText(String.valueOf(tvqAmount));
                totalAmount = (float)(amount + tpsAmount +tvqAmount);
                tvTotal.setText(String.valueOf(totalAmount));
            }else if (monthValue == 12)
            {
                float amount = 495;
                tvSubAmount.setText(String.valueOf(amount));
                double tpsAmount = 29.7;
                tvTps.setText(String.valueOf(tpsAmount));
                double tvqAmount = 49.8465;
                tvTvq.setText(String.valueOf(tvqAmount));
                totalAmount = (float)(amount + tpsAmount +tvqAmount);
                tvTotal.setText(String.valueOf(totalAmount));
            }


        else
            throw new Exception("Please select a internet provider");

        return totalAmount;
    }

    private void showAllClientInfo()
    {
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("orders",listOfInternetProviders);
        startActivity(i);
    }

    private void quitApp()
    {
        System.exit(0);
    }

    private void saveClientProvider(View view)
    {
        try {


            // in order to convert to integer use integer.valueof
            int clNumber = Integer.valueOf(edClNumber.getText().toString());
            int nbMonths = Integer.valueOf(edNbMonths.getText().toString());



            provider = new ClientProvider(clNumber, internetType, nbMonths);
            listOfInternetProviders.add(provider);


            Snackbar.make(view, "Order created succesfully", Snackbar.LENGTH_LONG).show();

            clearWidgets();
        }catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void clearWidgets()
    {
        edClNumber.setText(null);
        edNbMonths.setText(null);
        rgProvider.clearCheck();
        tvTotal.setText(null);
        tvTvq.setText(null);
        tvTps.setText(null);
        tvSubAmount.setText(null);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable)
    {
        showAmount();
    }
}