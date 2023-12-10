package com.example.calcule_nombres_premiers.modele;

import android.util.Log;
public class CalculNomprePremier {

    public   static  boolean isPremier(int nombre)
    {
        for (int i = 1 ; i < nombre/2 ; i++)
        {
            int reste = nombre % i;
            Log.i("frd", reste + " " + nombre);
            if (reste == 0)
            {
                return  false;
            }
        }
        return true;
    }
}
