package com.haili.yassine.facturation.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
@Entity
public class Client {

    @NonNull
    @PrimaryKey( autoGenerate = true)
    private int ID_CLIENT;
    private String NOM_CLIENT;
    private String Adresse_CLIENT;
    private String infoClient;

    public Client() {
    }

    public Client(String NOM_CLIENT, String adresse_CLIENT, String infoClient) {
        this.NOM_CLIENT = NOM_CLIENT;
        Adresse_CLIENT = adresse_CLIENT;
        this.infoClient = infoClient;
    }

    public int getID_CLIENT() {
        return ID_CLIENT;
    }

    public void setID_CLIENT(int ID_CLIENT) {
        this.ID_CLIENT = ID_CLIENT;
    }

    public String getNOM_CLIENT() {
        return NOM_CLIENT;
    }

    public void setNOM_CLIENT(String NOM_CLIENT) {
        this.NOM_CLIENT = NOM_CLIENT;
    }

    public String getAdresse_CLIENT() {
        return Adresse_CLIENT;
    }

    public void setAdresse_CLIENT(String adresse_CLIENT) {
        Adresse_CLIENT = adresse_CLIENT;
    }

    public String getInfoClient() {
        return infoClient;
    }

    public void setInfoClient(String infoClient) {
        this.infoClient = infoClient;
    }
}
