package com.example.android_etps1.facultades.facultadesClases;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_etps1.R;

import java.util.ArrayList;

public class AdapterFacRecyclerView extends RecyclerView.Adapter<AdapterFacRecyclerView.ViewHolderDatos> {

    ArrayList<DatosRecyclerViewFac> listDatos;
    OnItemClick callback;


    public AdapterFacRecyclerView(ArrayList<DatosRecyclerViewFac> listDatos, OnItemClick callback) {
        this.listDatos = listDatos;
        this.callback = callback;
    }

    public interface OnItemClick {
        void onMenuClick(DatosRecyclerViewFac facultad);
        void onContainerClick(DatosRecyclerViewFac facultad);
    }

    @NonNull
    @Override
    public AdapterFacRecyclerView.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_facultades, parent, false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, final int position) {
        holder.tvItemFac.setText(listDatos.get(position).getFacultad());
        holder.tvItemProyec.setText(listDatos.get(position).getProyecto());

        holder.imgItemButtonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onMenuClick(listDatos.get(position));
            }
        });

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onContainerClick(listDatos.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDatos.size();

    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView tvItemFac, tvItemProyec;
        ImageView imgItemButtonMore;
        View container;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            tvItemFac = itemView.findViewById(R.id.tv_facultad);
            tvItemProyec = itemView.findViewById(R.id.tv_proyecto);
            imgItemButtonMore = itemView.findViewById(R.id.img_more);
            container = itemView.findViewById(R.id.container_layout);
        }

    }
}
