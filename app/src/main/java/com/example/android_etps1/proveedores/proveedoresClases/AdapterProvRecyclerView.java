package com.example.android_etps1.proveedores.proveedoresClases;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_etps1.R;

import java.util.ArrayList;

public class AdapterProvRecyclerView extends RecyclerView.Adapter<AdapterProvRecyclerView.ViewHolderDatos>{

    ArrayList<DatosRecyclerViewProv> listDatos;
    OnItemClick callback;

    public AdapterProvRecyclerView(ArrayList<DatosRecyclerViewProv> listDatos, OnItemClick callback) {
        this.listDatos = listDatos;
        this.callback = callback;
    }
    public interface OnItemClick {
        void onMenuClick(DatosRecyclerViewProv proveedor);
    }

    @NonNull
    @Override
    public AdapterProvRecyclerView.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_proveedores,parent,false);

        return new AdapterProvRecyclerView.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterProvRecyclerView.ViewHolderDatos holder, final int position) {
        holder.tvAdapterProv.setText(listDatos.get(position).getProveedor());
        holder.tvAdapterEst.setText(listDatos.get(position).getEstado());

        holder.imgItemButtonMoreProv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onMenuClick(listDatos.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView tvAdapterProv, tvAdapterEst;
        ImageView imgItemButtonMoreProv;

        public ViewHolderDatos (View itemView){
            super(itemView);

            tvAdapterProv = itemView.findViewById(R.id.tv_proveedor);
            tvAdapterEst = itemView.findViewById(R.id.tv_estado);

            imgItemButtonMoreProv = itemView.findViewById(R.id.img_more_prov);
        }

    }
}

