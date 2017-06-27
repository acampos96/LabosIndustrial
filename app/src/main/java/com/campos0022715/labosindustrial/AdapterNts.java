package com.campos0022715.labosindustrial;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Ale Campos on 25/6/2017.
 */

public class AdapterNts extends CustomRecyclerViewAdapter {

    private Activity activity;
    private ArrayList<Nota> notas;
    private int screenWidth;

    public AdapterNts(final Activity activity, ArrayList<Nota> notas) {
        this.activity = activity;
        this.notas = notas;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.notas_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomRecycleViewHolder holder, int position) {
        final ViewHolder myHolder = (ViewHolder) holder;
        myHolder.title.setText(notas.get(position).getActividad());
        myHolder.grade.setText(notas.get(position).getCalificacion()+"");

        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends CustomRecycleViewHolder {

        private TextView title;
        private TextView grade;
        private LinearLayout card;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.NomNota);
            grade = (TextView) itemView.findViewById(R.id.CalNota);
            card = (LinearLayout) itemView.findViewById(R.id.NotasLinearLayout);
        }
    }

}