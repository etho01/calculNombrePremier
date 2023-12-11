package com.example.calcule_nombres_premiers.modele;

import android.util.Log;
public class CalculNomprePremier {

    public   static  boolean isPremier(int nombre)
    {
        int reste;
        for (int i = 2 ; i <= nombre/2 ; i++)
        {
            reste = (nombre % i);
            Log.i( "isPremier", nombre + " " + i + " " + reste);
            if (reste == 0)
            {
                return  false;
            }
        }
        return true;
    }
}
