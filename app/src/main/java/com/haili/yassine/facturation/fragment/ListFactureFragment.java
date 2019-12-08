package com.haili.yassine.facturation.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haili.yassine.facturation.MainActivity;
import com.haili.yassine.facturation.R;
import com.haili.yassine.facturation.adapter.FactureEntete_Adapter;
import com.haili.yassine.facturation.dao.MPDatabase;
import com.haili.yassine.facturation.model.FactureEntete;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFactureFragment extends Fragment implements View.OnClickListener {
    private FloatingActionButton btnAdd;
    private RecyclerView recyclerView;
    private FactureEntete_Adapter adapter;
    private LinearLayoutManager manager;
    private List<FactureEntete> factureEntetes;


    public ListFactureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        configRecyclerView();
    }

    private void configRecyclerView() {
        factureEntetes= MPDatabase.getInstance(getContext()).MpDao().selectAllFacture();
        adapter= new FactureEntete_Adapter(factureEntetes,getContext());
        manager= new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }

    private void initView(View view) {
        btnAdd=(FloatingActionButton)view.findViewById(R.id.floatingActionAdd);
        btnAdd.setOnClickListener(this);
        recyclerView=(RecyclerView)view.findViewById(R.id.fragment_liste_facture_recyclerview);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_facture, container, false);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.floatingActionAdd){
            ((MainActivity)getActivity()).startFactureFragment();
        }
    }
}
