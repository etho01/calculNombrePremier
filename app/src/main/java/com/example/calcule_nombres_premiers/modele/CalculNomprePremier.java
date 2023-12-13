package com.example.calcule_nombres_premiers.modele;

import android.util.Log;
public class CalculNomprePremier {

    public   static  boolean isPremier(int nombre)
    {
        if (nombre  <= 1)
        {
            return false;
        }

        for (int i = 2 ; i <= nombre/2 ; i++)
        {
            if (nombre % i == 0)
            {
                return  false;
            }
        }
        return true;
    }
}
