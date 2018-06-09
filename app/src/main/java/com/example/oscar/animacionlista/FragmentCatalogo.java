package com.example.oscar.animacionlista;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Oscar on 07/06/2018.
 */

public class FragmentCatalogo extends Fragment {

    public LinearLayoutManager linearLayoutManager;
    public RecyclerView rcvCatalogo;
    private byte NUMERO_COMLUNAS_CATALOGO=2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_catalago,container,false);
        linearLayoutManager = new LinearLayoutManager(getContext());
        rcvCatalogo = view.findViewById(R.id.rcvCatalogo);
        rcvCatalogo.setLayoutManager(new GridLayoutManager(getContext(), NUMERO_COMLUNAS_CATALOGO));
        AdaptadorCatalago adapter = new AdaptadorCatalago(getContext(), Articulos.getCourses());
        rcvCatalogo.setAdapter(adapter);
        setupWindowAnimations();
        return view;
    }

    private void setupWindowAnimations() {
        getActivity().getWindow().setReenterTransition(new Explode().setDuration(300));//Cundo regresa a la ventana
        getActivity().getWindow().setExitTransition(new Explode().setDuration(300));//Cuando sale de la ventana
    }

}