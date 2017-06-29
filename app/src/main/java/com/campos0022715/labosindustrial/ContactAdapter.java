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

public class ContactAdapter extends CustomRecyclerViewAdapter {

    private Activity activity;
    //private ArrayList<ContactRepository.Contact> Contactos;
    private ArrayList<ContactRepository.Contact> Contactos;
    private int screenWidth;
    Context context;
    static final String NOMBRE ="nombre", CORREO ="correo", PUESTO ="rol", ID="id";

    public ContactAdapter(final Activity activity, ArrayList<ContactRepository.Contact> contactos) {
        this.activity = activity;
        this.Contactos = contactos;
    }

    public ContactAdapter(Context context, ArrayList<Contact> contactos) {
        this.context = context;
        //this.Contactos = contactos;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.contact_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomRecycleViewHolder holder, int position) {
        final ViewHolder myHolder = (ViewHolder) holder;
        myHolder.nombre.setText(Contactos.get(position).getName());
        myHolder.puesto.setText(Contactos.get(position).getRol());
        myHolder.correo.setText(Contactos.get(position).getCorreo());

        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return Contactos.size();
    }

    public class ViewHolder extends CustomRecycleViewHolder {
        private TextView nombre;
        private TextView puesto;
        private TextView correo;
        private CardView card;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.NomPersonal);
            puesto = (TextView) itemView.findViewById(R.id.Puesto);
            correo = (TextView) itemView.findViewById(R.id.Correo);
            card = (CardView) itemView.findViewById(R.id.PersonalCardView);
        }
    }

}
