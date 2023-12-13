package com.example.fonctionstrigonomtriques.model;

import java.text.DecimalFormat;

public class Trigonometrie {
    // Les attributs du Model
    double angle, valeur;
    String method;

    public Trigonometrie(double angle, String method) {
        this.angle = angle;
        this.method = method;
        setValeur();
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur() {

        // Conversion des degrés en radians
        double angleEnRadian = Math.toRadians(angle);

       // calcule de la fonction trigonomtrique suivant le choix de l'utilisateur ( sin, cos ou tan )
        if (method.equals("Sinus")){
            valeur=Math.sin(angleEnRadian);
        } else if (method.equals("Cosinus")) {
            valeur=Math.cos(angleEnRadian);
        }else valeur = Math.tan(angleEnRadian);
        DecimalFormat dtime = new DecimalFormat("#.###");
        valeur = Double.valueOf(dtime.format(valeur));

    }
}
