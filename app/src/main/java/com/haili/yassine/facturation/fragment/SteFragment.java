package com.haili.yassine.facturation.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.haili.yassine.facturation.MainActivity;
import com.haili.yassine.facturation.R;
import com.haili.yassine.facturation.dao.MPDatabase;
import com.haili.yassine.facturation.model.Ste;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SteFragment extends Fragment implements View.OnClickListener {
    private Button btnSave;
    private EditText editSte, editadress, editVille, editFix, editFax, editIce, editCnss, editPatente, editRc;

    private OnFragmentInteractionListener mListener;

    public SteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
    }

    private void initView(View view) {
        btnSave = (Button) view.findViewById(R.id.btn_save_ste);
        btnSave.setOnClickListener(this);
        editSte = (EditText) view.findViewById(R.id.edit_ste);
        editadress = (EditText) view.findViewById(R.id.edit_steAdresse);
        editVille = (EditText) view.findViewById(R.id.edit_steVille);
        editFix = (EditText) view.findViewById(R.id.edit_steFix);
        editFax = (EditText) view.findViewById(R.id.edit_steFax);
        editIce = (EditText) view.findViewById(R.id.edit_Ice);
        editCnss = (EditText) view.findViewById(R.id.edit_steCNSS);
        editPatente = (EditText) view.findViewById(R.id.edit_stePatente);
        editRc = (EditText) view.findViewById(R.id.edit_steRc);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ste, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_save_ste){
            Ste ste = new Ste(editSte.getText().toString(),
                    editadress.getText().toString(),
                    editVille.getText().toString(),
                    editFix.getText().toString(),
                    editFax.getText().toString(),
                    "",
                    editIce.getText().toString(),
                    editPatente.getText().toString(),
                    editCnss.getText().toString(),
                    editRc.getText().toString());
            MPDatabase.getInstance(getContext()).MpDao().addSte(ste);
            ((MainActivity)getActivity()).startListFactureFragment();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
