package com.haili.yassine.facturation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haili.yassine.facturation.R;
import com.haili.yassine.facturation.model.FactureDerails;

import java.util.List;

public class FacturDetailAdapter extends RecyclerView.Adapter<FactureDetailHolder> {
    private List<FactureDerails> factureDerailsList;

    public FacturDetailAdapter(List<FactureDerails> factureDerailsList) {
        this.factureDerailsList = factureDerailsList;
    }

    @NonNull
    @Override
    public FactureDetailHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.raw_detail_facture, viewGroup, false);
        return new FactureDetailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FactureDetailHolder factureDetailHolder, int i) {
        factureDetailHolder.display(factureDerailsList.get(i));
    }

    @Override
    public int getItemCount() {
        return factureDerailsList.size();
    }

    public void addDetails(FactureDerails factureDerails){
        this.factureDerailsList.add(factureDerails);
        notifyDataSetChanged();
    }

    public List<FactureDerails> getFactureDerailsList() {
        return factureDerailsList;
    }
}
