package com.example.android_etps1.descripciones.descripcionesClases;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android_etps1.R;
import java.util.ArrayList;

public class AdapterDescRecyclerView extends RecyclerView.Adapter<AdapterDescRecyclerView.ViewHolderDatos>  {
    ArrayList<DatosRecyclerViewDesc> listDatos;

    public AdapterDescRecyclerView(ArrayList<DatosRecyclerViewDesc> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public AdapterDescRecyclerView.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_descripciones,parent,false);

        return new AdapterDescRecyclerView.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterDescRecyclerView.ViewHolderDatos holder, int position) {
        holder.textViewDesc.setText(listDatos.get(position).getDescripciones());

    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }
    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView textViewDesc;

        public ViewHolderDatos (View itemView){
            super(itemView);

            textViewDesc = (TextView) itemView.findViewById(R.id.tv_descripciones);

        }

    }
}


