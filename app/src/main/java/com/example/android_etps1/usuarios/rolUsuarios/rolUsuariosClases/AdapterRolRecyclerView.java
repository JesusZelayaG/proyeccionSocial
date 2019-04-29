package com.example.android_etps1.usuarios.rolUsuarios.rolUsuariosClases;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android_etps1.R;

import java.util.ArrayList;

public class AdapterRolRecyclerView extends RecyclerView.Adapter<AdapterRolRecyclerView.ViewHolderDatos>  {
    ArrayList<DatosRecyclerViewRol> listDatos;

    public AdapterRolRecyclerView(ArrayList<DatosRecyclerViewRol> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public AdapterRolRecyclerView.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_rol,parent,false);

        return new AdapterRolRecyclerView.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterRolRecyclerView.ViewHolderDatos holder, int position) {
        holder.textViewRol.setText(listDatos.get(position).getRol());

    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }
    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView textViewRol;

        public ViewHolderDatos (View itemView){
            super(itemView);

            textViewRol = itemView.findViewById(R.id.tv_rol);

        }

    }
}




