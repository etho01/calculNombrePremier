package com.example.calcule_nombres_premiers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextClock;
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
                    for(int index = (listNombrePremier).getChildCount() - 1; index >= 0; index--) {
                        View child = (listNombrePremier).getChildAt(index);
                        listNombrePremier.removeView(child);
                    }
                    long nbMaxVal = Long.parseLong(nbMax.getText().toString());
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

    public void setDurration(int time)
    {
        this.timeExecution.setText(time + " ms");
    }


    public void addNombrePremier(int nb)
    {
        TextView nombrePremier = new TextView(this);
        nombrePremier.setText(nb + " est un nombre premier");
        listNombrePremier.addView(nombrePremier);
    }

    public void updateNumberProcess(int number)
    {
        numberInProgress.setText("calcul du nombre " + number);
    }

    public void setNombreResult(int nbResult)
    {
        numberInProgress.setText(nbResult  + " nombres premiers trouvés");
    }
}