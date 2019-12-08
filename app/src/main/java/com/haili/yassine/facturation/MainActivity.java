package com.haili.yassine.facturation;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.haili.yassine.facturation.dao.MPDatabase;
import com.haili.yassine.facturation.fragment.FactureFragment;
import com.haili.yassine.facturation.fragment.ListFactureFragment;
import com.haili.yassine.facturation.fragment.SteFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(MPDatabase.getInstance(this).MpDao().selectSte(1)==null)
            startSteFragment();
        else
            startListFactureFragment();
    }

    public void startSteFragment() {
        SteFragment configFragment = new SteFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_Frame, configFragment)
                .commit();
    }

    public void startListFactureFragment() {
        ListFactureFragment listFactureFragment = new ListFactureFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_Frame, listFactureFragment)
                .commit();
    }

    public void startFactureFragment() {
        FactureFragment factureFragment = new FactureFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_Frame, factureFragment)
                .commit();
    }
}
