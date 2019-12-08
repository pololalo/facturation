package com.haili.yassine.facturation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haili.yassine.facturation.R;
import com.haili.yassine.facturation.model.FactureEntete;

import java.util.List;

public class FactureEntete_Adapter extends RecyclerView.Adapter<FactureEntete_Holder> {
    private List<FactureEntete>factureEntetes;
    private Context context;

    public FactureEntete_Adapter(List<FactureEntete> factureEntetes, Context context) {
        this.factureEntetes = factureEntetes;
        this.context = context;
    }

    @NonNull
    @Override
    public FactureEntete_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.raw_facture_entete, viewGroup, false);
        return new FactureEntete_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FactureEntete_Holder factureEntete_holder, int i) {
                factureEntete_holder.display(factureEntetes.get(i),context);
    }

    @Override
    public int getItemCount() {
        return factureEntetes.size();
    }

    public List<FactureEntete> getFactureEntetes() {
        return factureEntetes;
    }
}
