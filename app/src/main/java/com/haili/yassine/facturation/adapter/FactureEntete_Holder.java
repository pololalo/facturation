package com.haili.yassine.facturation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.haili.yassine.facturation.R;
import com.haili.yassine.facturation.dao.MPDatabase;
import com.haili.yassine.facturation.model.Client;
import com.haili.yassine.facturation.model.FactureEntete;

public class FactureEntete_Holder extends RecyclerView.ViewHolder {
    private TextView nomClient,dateFacture,mntFacture;
    public FactureEntete_Holder(@NonNull View itemView) {
        super(itemView);
        nomClient=(TextView)itemView.findViewById(R.id.raw_facture_entete_nomClient);
        dateFacture=(TextView)itemView.findViewById(R.id.raw_facture_entete_dateFacture);
        mntFacture=(TextView)itemView.findViewById(R.id.raw_facture_entete_mntFacture);
    }

    public void display(FactureEntete factureEntete, Context context){
        Client client= MPDatabase.getInstance(context).MpDao().selectClient(factureEntete.getIdClient());
        nomClient.setText(client.getNOM_CLIENT());
        dateFacture.setText(factureEntete.getDateFacture());
        mntFacture.setText(String.valueOf(factureEntete.getMnt_Total_TTC()));
    }
}
