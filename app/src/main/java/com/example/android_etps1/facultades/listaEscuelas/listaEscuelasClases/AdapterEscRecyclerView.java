package com.example.android_etps1.facultades.listaEscuelas.listaEscuelasClases;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import com.example.android_etps1.R;
import java.util.ArrayList;

public class AdapterEscRecyclerView extends RecyclerView.Adapter<AdapterEscRecyclerView.ViewHolderDatos> {

    ArrayList<DatosRecyclerViewEsc> listDatos;


    public AdapterEscRecyclerView(ArrayList<DatosRecyclerViewEsc> listDatos) {
        this.listDatos = listDatos;

    }


    @NonNull
    @Override
    public AdapterEscRecyclerView.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_escuela, parent, false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, final int position) {
        holder.tvItemEsc.setText(listDatos.get(position).getEscuela());
        holder.tvItemProyecEsc.setText(listDatos.get(position).getProyecto());


    }

    @Override
    public int getItemCount() {
        return listDatos.size();

    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView tvItemEsc, tvItemProyecEsc;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            tvItemEsc = itemView.findViewById(R.id.tv_escuela);
            tvItemProyecEsc = itemView.findViewById(R.id.tv_proyecto_escuela);

        }
    }
}

