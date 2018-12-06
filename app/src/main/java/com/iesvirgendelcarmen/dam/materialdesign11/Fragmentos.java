package com.iesvirgendelcarmen.dam.materialdesign11;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragmentos extends Fragment {

    public Fragmentos(){}

    public static final String ARG_SECTION_TITLE = "opcion";
    public static Fragmentos newInstance(String sectionTitle){
        Fragmentos fragmento = new Fragmentos();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragmento.setArguments(args);
        return fragmento;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentos,container,false);
        String title = getArguments().getString(ARG_SECTION_TITLE);
        TextView titulo = (TextView) view.findViewById(R.id.tituloFrag);
        titulo.setText(title);
        return view;
    }
}
