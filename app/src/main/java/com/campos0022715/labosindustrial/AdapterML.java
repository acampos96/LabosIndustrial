package com.campos0022715.labosindustrial;

import android.app.Activity;
import android.content.Context;
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

public class AdapterML extends CustomRecyclerViewAdapter {
    Usuario user;
    private Activity activity;
    private ArrayList<Laboratorio> Labos;
    private int screenWidth;
    Context context;
    static final String NOMBRE ="nombre", HORARIO="horario", DIA="dia", SALON="salon", INSTRUCTOR="instructor", MATERIA="materia", ID="id";
    /*
    * public AdapterML(final Activity activity, ArrayList<Laboratorio> Labos, Usuario user) {
        this.activity = activity;
        this.Labos = Labos;
        this.user=user;
    }

    * */



    public AdapterML(Context context, ArrayList<Laboratorio> Labos, Usuario user) {
        this.context= context;
        this.Labos = Labos;
        this.user=user;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.labo_list_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomRecycleViewHolder holder, int position) {
        final ViewHolder myHolder = (ViewHolder) holder;
        myHolder.poster.setText(Labos.get(position).getMateria());
        myHolder.title.setText(Labos.get(position).getNombre());
        myHolder.horario.setText(Labos.get(position).getDia()+" "+Labos.get(position).getHorario());

        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Laboratorio labo = Labos.get(position);
                Intent intent = new Intent(context,DetallesMLabos.class);
                intent.putExtra("usuario", user);
                intent.putExtra("labo",labo);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Labos.size();
    }

    public class ViewHolder extends CustomRecycleViewHolder {
        private TextView poster;
        private TextView title;
        private TextView horario;
        private CardView card;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = (TextView) itemView.findViewById(R.id.NomMateria);
            title = (TextView) itemView.findViewById(R.id.NomLabo);
            horario = (TextView) itemView.findViewById(R.id.HorLabo);
            card = (CardView) itemView.findViewById(R.id.LabosCardView);
        }
    }

}
