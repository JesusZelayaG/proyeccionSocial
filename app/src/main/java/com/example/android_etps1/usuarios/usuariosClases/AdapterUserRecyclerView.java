package com.example.android_etps1.usuarios.usuariosClases;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_etps1.R;

import java.util.ArrayList;

public class AdapterUserRecyclerView extends RecyclerView.Adapter<AdapterUserRecyclerView.ViewHolderDatos> {

    ArrayList<DatosRecyclerViewUser> listDatos;
    OnItemClick callback;

    public AdapterUserRecyclerView(ArrayList<DatosRecyclerViewUser> listDatos, OnItemClick callback){
        this.listDatos = listDatos;
        this.callback = callback;
    }

    public interface OnItemClick{
        void onMenuClick(DatosRecyclerViewUser usuario);
    }

    @NonNull
    @Override
    public AdapterUserRecyclerView.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int i){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_usuarios, parent, false);

        return new ViewHolderDatos(view);

    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, final int position){
        holder.tvItemUser.setText(listDatos.get(position).getUsuario());
        holder.tvItemRol.setText(listDatos.get(position).getRol());

        holder.imgItemButtonMoreUser.setOnClickListener(new View.OnClickListener() {
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

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView tvItemUser, tvItemRol;
        ImageView imgItemButtonMoreUser;

        public ViewHolderDatos(View itemView){
            super(itemView);
            tvItemUser = itemView.findViewById(R.id.tv_usuario);
            tvItemRol = itemView.findViewById(R.id.tv_rol);
            imgItemButtonMoreUser = itemView.findViewById(R.id.img_more_usuario);
        }
    }
}
