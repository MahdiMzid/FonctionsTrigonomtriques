package com.example.fonctionstrigonomtriques.controller;

import com.example.fonctionstrigonomtriques.model.Trigonometrie;

public class Controller {
    // Instanciation du contrôleur
    private static Controller instance = null;
    private Controller(){super();}
    public static final Controller getInstance(){
        if (Controller.instance == null){
            Controller.instance = new Controller();
        }
        return Controller.instance;
    }
    private static Trigonometrie trigonometrie;

    public void createTrigonometrie(double angle ,String method){
        trigonometrie = new Trigonometrie(angle,method);
    }
    public double getValeur() {
        return trigonometrie.getValeur();
    }

}
