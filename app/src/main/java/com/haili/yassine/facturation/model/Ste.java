package com.haili.yassine.facturation.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Ste {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int idSte;
    private String nomSte;
    private String adresseSte;
    private String villeSte;
    private String fixSte;
    private String faxSte;
    private String mailSte;
    private String iceSte;
    private String patenteSte;
    private String cnssSte;
    private String rcSte;

    public Ste() {
    }

    public Ste(String nomSte, String adresseSte, String villeSte, String fixSte, String faxSte, String mailSte, String iceSte, String patenteSte, String cnssSte, String rcSte) {
        this.nomSte = nomSte;
        this.adresseSte = adresseSte;
        this.villeSte = villeSte;
        this.fixSte = fixSte;
        this.faxSte = faxSte;
        this.mailSte = mailSte;
        this.iceSte = iceSte;
        this.patenteSte = patenteSte;
        this.cnssSte = cnssSte;
        this.rcSte = rcSte;
    }

    public int getIdSte() {
        return idSte;
    }

    public void setIdSte(int idSte) {
        this.idSte = idSte;
    }

    public String getNomSte() {
        return nomSte;
    }

    public void setNomSte(String nomSte) {
        this.nomSte = nomSte;
    }

    public String getAdresseSte() {
        return adresseSte;
    }

    public void setAdresseSte(String adresseSte) {
        this.adresseSte = adresseSte;
    }

    public String getVilleSte() {
        return villeSte;
    }

    public void setVilleSte(String villeSte) {
        this.villeSte = villeSte;
    }

    public String getFixSte() {
        return fixSte;
    }

    public void setFixSte(String fixSte) {
        this.fixSte = fixSte;
    }

    public String getFaxSte() {
        return faxSte;
    }

    public void setFaxSte(String faxSte) {
        this.faxSte = faxSte;
    }

    public String getMailSte() {
        return mailSte;
    }

    public void setMailSte(String mailSte) {
        this.mailSte = mailSte;
    }

    public String getIceSte() {
        return iceSte;
    }

    public void setIceSte(String iceSte) {
        this.iceSte = iceSte;
    }

    public String getPatenteSte() {
        return patenteSte;
    }

    public void setPatenteSte(String patenteSte) {
        this.patenteSte = patenteSte;
    }

    public String getCnssSte() {
        return cnssSte;
    }

    public void setCnssSte(String cnssSte) {
        this.cnssSte = cnssSte;
    }

    public String getRcSte() {
        return rcSte;
    }

    public void setRcSte(String rcSte) {
        this.rcSte = rcSte;
    }
}
