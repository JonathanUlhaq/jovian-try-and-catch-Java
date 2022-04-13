package com.example.randomnumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.system.ErrnoException;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    int randomNumbber;

    public void setRandomNumbberGenerator(){

        Random rand = new Random();
        randomNumbber = rand.nextInt(20)+1;

    }

    public void onTebak(View view)
    {


        try {
            EditText jawaban;
            jawaban=findViewById(R.id.jawaban);
            int tebakan = Integer.parseInt(jawaban.getText().toString());
            if(tebakan < randomNumbber && tebakan <= 20)
            {

                Toast.makeText(this, "Terlalu Rendah", Toast.LENGTH_SHORT).show();
            } else if (tebakan > randomNumbber && tebakan <= 20)
            {
                Toast.makeText(this, "Terlalu Tinggi", Toast.LENGTH_SHORT).show();
            } else if (tebakan == randomNumbber && tebakan <= 20)
            {
                Toast.makeText(this, "Yaps Tebakan anda tepat ! yaitu: "+randomNumbber, Toast.LENGTH_SHORT).show();
                setRandomNumbberGenerator();
            } else if (tebakan > 20) {

                jawaban.setError("Angka tidak boleh lebih dari 20");
            }

        } catch (Exception e)
        {
           EditText jawaban=findViewById(R.id.jawaban);
           jawaban.setError("Jawaban Harus Berupa Ankga");
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumbber = rand.nextInt(20)+1;
    }
}