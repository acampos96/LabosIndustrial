package com.campos0022715.labosindustrial;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ale Campos on 25/6/2017.
 */

public class AdapterAn extends CustomRecyclerViewAdapter {

    private Activity activity;
    private ArrayList<Anuncio> anuncios;
    private int screenWidth;
    static final String NOMBRE ="nombre",ANUNCIO="anuncio", LABO="labo", MATERIA="materia", ID="id";

    public AdapterAn(final Activity activity, ArrayList<Anuncio> Labos) {
        this.activity = activity;
        this.anuncios = Labos;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.labo_list_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomRecycleViewHolder holder, int position) {
        final ViewHolder myHolder = (ViewHolder) holder;
        myHolder.materia.setText(anuncios.get(position).getMateria());
        myHolder.title.setText(anuncios.get(position).getTitulo());
        myHolder.Labo.setText(anuncios.get(position).getLaboXMateria());

        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Anuncio announcement = anuncios.get(position);
                Intent intent = new Intent(activity,AnuncioInfo.class);
                intent.putExtra(NOMBRE,announcement.getTitulo());
                intent.putExtra(MATERIA, announcement.getMateria());
                intent.putExtra(LABO, announcement.getLaboXMateria());
                intent.putExtra(ANUNCIO,announcement.getAnuncio());
                intent.putExtra(ID, announcement.getIdAnuncio());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return anuncios.size();
    }

    public class ViewHolder extends CustomRecycleViewHolder {
        private TextView materia;
        private TextView title;
        private TextView Labo;
        private CardView card;

        public ViewHolder(View itemView) {
            super(itemView);
            materia = (TextView) itemView.findViewById(R.id.NomMateria);
            title = (TextView) itemView.findViewById(R.id.NomLabo);
            Labo = (TextView) itemView.findViewById(R.id.HorLabo);
            card = (CardView) itemView.findViewById(R.id.LabosCardView);
        }
    }

}