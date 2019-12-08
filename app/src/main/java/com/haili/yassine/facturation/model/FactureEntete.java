package com.haili.yassine.facturation.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class FactureEntete {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int idFacture;
    @NonNull
    @ColumnInfo(name = "idClient")
    private int idClient;
    @NonNull
    private String dateFacture;
    private double mnt_Total_HT;
    private double mnt_Total_TTC;
    private double mnt_Total_taxe;

    public FactureEntete() {
    }

    public FactureEntete(int idClient, @NonNull String dateFacture, double mnt_Total_HT, double mnt_Total_TTC, double mnt_Total_taxe) {
        this.idClient = idClient;
        this.dateFacture = dateFacture;
        this.mnt_Total_HT = mnt_Total_HT;
        this.mnt_Total_TTC = mnt_Total_TTC;
        this.mnt_Total_taxe = mnt_Total_taxe;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @NonNull
    public String getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(@NonNull String dateFacture) {
        this.dateFacture = dateFacture;
    }

    public double getMnt_Total_HT() {
        return mnt_Total_HT;
    }

    public void setMnt_Total_HT(double mnt_Total_HT) {
        this.mnt_Total_HT = mnt_Total_HT;
    }

    public double getMnt_Total_TTC() {
        return mnt_Total_TTC;
    }

    public void setMnt_Total_TTC(double mnt_Total_TTC) {
        this.mnt_Total_TTC = mnt_Total_TTC;
    }

    public double getMnt_Total_taxe() {
        return mnt_Total_taxe;
    }

    public void setMnt_Total_taxe(double mnt_Total_taxe) {
        this.mnt_Total_taxe = mnt_Total_taxe;
    }
}
