package com.haili.yassine.facturation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.haili.yassine.facturation.R;
import com.haili.yassine.facturation.model.FactureDerails;

public class FactureDetailHolder extends RecyclerView.ViewHolder {
    private TextView liblle,qte,pu,total;
    public FactureDetailHolder(@NonNull View itemView) {
        super(itemView);
        liblle=(TextView)itemView.findViewById(R.id.textview_liblele);
        qte=(TextView)itemView.findViewById(R.id.textview_qte);
        pu=(TextView)itemView.findViewById(R.id.textview_pu);
        total=(TextView)itemView.findViewById(R.id.textview_total);
    }

    public void display(FactureDerails factureDerails){
        liblle.setText(factureDerails.getNomProduits());
        qte.setText(String.valueOf(factureDerails.getQte()));
        pu.setText(String.valueOf(factureDerails.getPrix_unitaire()));
        total.setText(String.valueOf(factureDerails.getPrix_unitaire()*factureDerails.getQte()));
    }
}
