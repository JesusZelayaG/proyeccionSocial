package com.example.android_etps1.vehiculos.vehiculosClases;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_etps1.R;

import java.util.ArrayList;

public class AdapterVehRecyclerView extends RecyclerView.Adapter<AdapterVehRecyclerView.ViewHolderDatos>{

    ArrayList<DatosRecyclerViewVeh> listDatos;
    OnItemClick callback;

    public AdapterVehRecyclerView(ArrayList<DatosRecyclerViewVeh> listDatos, OnItemClick callback) {
        this.listDatos = listDatos;
        this.callback = callback;
    }
    public interface OnItemClick {
        void onMenuClick(DatosRecyclerViewVeh vehiculo);
    }
    @NonNull
    @Override
    public AdapterVehRecyclerView.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_vehiculos,parent,false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, final int position) {
        holder.tvAdapterVeh.setText(listDatos.get(position).getVehiculo());
        holder.tvAdapterPrec.setText(listDatos.get(position).getPrecio());

        holder.imgItemButtonMoreVeh.setOnClickListener(new View.OnClickListener() {
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
        TextView tvAdapterVeh, tvAdapterPrec;
        ImageView imgItemButtonMoreVeh;

        public ViewHolderDatos (View itemView){
            super(itemView);

            tvAdapterVeh = itemView.findViewById(R.id.tv_vehiculo);
            tvAdapterPrec = itemView.findViewById(R.id.tv_precio);
            imgItemButtonMoreVeh = itemView.findViewById(R.id.img_more_veh);
        }

    }
}
