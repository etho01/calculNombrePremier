package com.example.calcule_nombres_premiers.AsyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.calcule_nombres_premiers.MainActivity;
import com.example.calcule_nombres_premiers.modele.CalculNomprePremier;

public class CalculNombrePremierAsyncTask extends AsyncTask<Long, Integer, Integer> {

    private MainActivity activity;
    public CalculNombrePremierAsyncTask(
            MainActivity activity
    )
    {
        this.activity = activity;
        this.activity.getNumberInProgress().setText("efe");
    }

    @Override
    protected Integer doInBackground(Long... longs) {
        long max = longs[0];
        for (int i = 0 ; i < max ; i++)
        {
            Log.i("fr", "" + i);
            publishProgress(i);
            CalculNomprePremier.isPremier(i);
        }

        return  1;
    }

    @Override
    protected  void onProgressUpdate(Integer ...result)
    {
        this.activity.getNumberInProgress().setText(result[0]  +"");
    }
    @Override
    protected void onPostExecute(int nbSeconde)
    {
        this.activity.setDurration(nbSeconde);
    }
}
