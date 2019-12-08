package com.haili.yassine.facturation.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class FactureDerails {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int idDetailFacture;
    @NonNull
    private int idFacture;
    @NonNull
    private String nomProduits;
    private int qte;
    private float prix_unitaire;

    public FactureDerails() {
    }

    public FactureDerails(int idFacture, @NonNull String nomProduits, int qte, float prix_unitaire) {
        this.idFacture = idFacture;
        this.nomProduits = nomProduits;
        this.qte = qte;
        this.prix_unitaire = prix_unitaire;
    }

    public int getIdDetailFacture() {
        return idDetailFacture;
    }

    public void setIdDetailFacture(int idDetailFacture) {
        this.idDetailFacture = idDetailFacture;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    @NonNull
    public String getNomProduits() {
        return nomProduits;
    }

    public void setNomProduits(@NonNull String nomProduits) {
        this.nomProduits = nomProduits;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }
}
