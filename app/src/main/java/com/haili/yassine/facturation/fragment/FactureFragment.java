package com.haili.yassine.facturation.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.haili.yassine.facturation.MainActivity;
import com.haili.yassine.facturation.R;
import com.haili.yassine.facturation.adapter.FacturDetailAdapter;
import com.haili.yassine.facturation.dao.MPDatabase;
import com.haili.yassine.facturation.dao.MpDao;
import com.haili.yassine.facturation.model.Client;
import com.haili.yassine.facturation.model.FactureDerails;
import com.haili.yassine.facturation.model.FactureEntete;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FactureFragment extends Fragment implements View.OnClickListener {
    private Button btn_next,btn_previous,btn_save, addlineFacture;
    private LinearLayout inlcuedClient, includeDeatiFacture;
    private EditText libele, pu, qte;
    private EditText editclient,editadresse,editInfo,edit_dateFacture;
    private RecyclerView recyclerView;
    private FacturDetailAdapter adapter;
    private LinearLayoutManager layoutManager;
    private Client client = null;
    private int counter=0;

    public FactureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        configRecyclerView();
    }

    private void configRecyclerView() {
        List<FactureDerails> factureDerails = new ArrayList<>();
        adapter = new FacturDetailAdapter(factureDerails);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initView(View view) {
        btn_next = (Button) view.findViewById(R.id.btn_next);
        btn_previous = (Button) view.findViewById(R.id.btn_preview);
        btn_save = (Button) view.findViewById(R.id.btn_save);
        btn_next.setOnClickListener(this);
        btn_previous.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        addlineFacture = (Button) view.findViewById(R.id.add_line);
        addlineFacture.setOnClickListener(this);
        inlcuedClient = (LinearLayout) view.findViewById(R.id.incluedClient);
        includeDeatiFacture = (LinearLayout) view.findViewById(R.id.detail_facture);
        recyclerView = (RecyclerView) view.findViewById(R.id.reclerview_detail);
        libele = (EditText) view.findViewById(R.id.libelle);
        pu = (EditText) view.findViewById(R.id.edit_pu);
        qte = (EditText) view.findViewById(R.id.edit_qte);

        editclient=(EditText) view.findViewById(R.id.edit_client);
        editadresse=(EditText) view.findViewById(R.id.edit_clientAdresse);
        editInfo=(EditText) view.findViewById(R.id.edit_clientInfo);
        edit_dateFacture=(EditText) view.findViewById(R.id.edit_date_facture);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_facture, container, false);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_next) {
            if(counter==0){
            inlcuedClient.setVisibility(View.GONE);
            includeDeatiFacture.setVisibility(View.VISIBLE);
            counter++;
            }
            else if(counter==1){
                client= new Client(editclient.getText().toString(),
                        editadresse.getText().toString(),
                        editInfo.getText().toString());
                counter++;
                btn_save.setVisibility(View.VISIBLE);
            }
        }
        else  if (v.getId() == R.id.btn_preview) {
            inlcuedClient.setVisibility(View.VISIBLE);
            includeDeatiFacture.setVisibility(View.GONE);
            counter--;
        }
        else if (v.getId() == R.id.add_line) {
            FactureDerails factureDerails = new FactureDerails(0, libele.getText().toString(),
                    Integer.parseInt(qte.getText().toString()),
                    Float.parseFloat(pu.getText().toString()));
            adapter.addDetails(factureDerails);
        }
        else  if (v.getId() == R.id.btn_save) {
            if(client!=null){
                if(!adapter.getFactureDerailsList().isEmpty()){
                    FactureEntete factureEntete = new FactureEntete();
                    factureEntete.setDateFacture(edit_dateFacture.getText().toString());
                    factureEntete.setIdClient((int)MPDatabase.getInstance(getContext()).MpDao().addClient(client));
                    factureEntete.setMnt_Total_HT(0);
                    factureEntete.setMnt_Total_taxe(0);
                    factureEntete.setMnt_Total_TTC(0);
                    MPDatabase.getInstance(getContext()).MpDao().addFactureEntete(factureEntete);
                    ((MainActivity)getActivity()).startListFactureFragment();
                }
            }
        }
    }
}
