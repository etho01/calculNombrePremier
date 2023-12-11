package com.example.calcule_nombres_premiers.AsyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.calcule_nombres_premiers.MainActivity;
import com.example.calcule_nombres_premiers.modele.CalculNomprePremier;

import java.util.ArrayList;

public class CalculNombrePremierAsyncTask extends AsyncTask<Long, Integer, Integer> {

    private MainActivity activity;
    private ArrayList<Integer> listNombrePremier;
    public CalculNombrePremierAsyncTask(
            MainActivity activity
    )
    {
        this.activity = activity;
        this.listNombrePremier = new ArrayList<Integer>();
    }

    @Override
    protected Integer doInBackground(Long... longs) {
        long max = longs[0];
        int isPremier;
        long beginTime = System.currentTimeMillis();
        for (int i = 0 ; i <= max ; i++)
        {
            isPremier = 0;
            if (CalculNomprePremier.isPremier(i))
            {
                this.listNombrePremier.add(i);
                isPremier = 1;
            }
            publishProgress(i, isPremier);
        }
        long endTime = System.currentTimeMillis();

        return (int) (endTime - beginTime);
    }

    @Override
    protected  void onProgressUpdate(Integer ...result)
    {
        this.activity.updateNumberProcess(result[0]);
        if (result[1] == 1)
        {
            this.activity.addNombrePremier(result[0]);
        }
    }

    @Override
    protected void onPostExecute(Integer time) {
        this.activity.setDurration(time);
        this.activity.setNombreResult(this.listNombrePremier.size());
    }
}
