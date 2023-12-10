package com.example.calcule_nombres_premiers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calcule_nombres_premiers.AsyncTask.CalculNombrePremierAsyncTask;

public class MainActivity extends AppCompatActivity {

    private EditText nbMax;
    private Button btnLaunch;

    private TextView numberInProgress;

    private LinearLayout listNombrePremier;
    private TextView timeExecution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nbMax = findViewById(R.id.maxNumber);
        btnLaunch = findViewById(R.id.btnEmpiler);
        numberInProgress = findViewById(R.id.numberInProgress);
        listNombrePremier = findViewById(R.id.listNombrePremier);
        timeExecution = findViewById(R.id.timeExecution);

        MainActivity self = this;

        btnLaunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    long nbMaxVal = Integer.parseInt(nbMax.getText().toString());
                    CalculNombrePremierAsyncTask asyncTask = new CalculNombrePremierAsyncTask(
                            self
                    );
                    asyncTask.execute(nbMaxVal);
                } catch (NumberFormatException nfe) {
                    Toast.makeText( MainActivity.this,"Entier Attendu\nMauvais format", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public TextView getNumberInProgress()
    {
        return numberInProgress;
    }

    public void setDurration(int time)
    {
        this.timeExecution.setText(time + " ms");
    }
}