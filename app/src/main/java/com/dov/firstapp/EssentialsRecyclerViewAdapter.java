package com.dov.firstapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EssentialsRecyclerViewAdapter extends RecyclerView.Adapter<EssentialsRecyclerViewAdapter.EssentialsViewHolder> {

    private ArrayList<String> essentials;
    private DeleteCallback deleteCallback;
    public interface DeleteCallback {
       void onDelete(String essential);
    }

    public EssentialsRecyclerViewAdapter(ArrayList<String> essentials, DeleteCallback deleteCallback){
        this.essentials = essentials;
        this.deleteCallback = deleteCallback;
    }

    public void setEssentials(ArrayList<String> essentials) {
        this.essentials = essentials;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EssentialsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.essentials_list_item, parent,false);
        return new EssentialsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EssentialsViewHolder holder, int position) {
        holder.bind(essentials.get(position), deleteCallback);

    }

    @Override
    public int getItemCount() {
        return essentials.size();
    }


    public class EssentialsViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView deleteIV;
        AppCompatTextView titleTV;
        public EssentialsViewHolder(@NonNull View itemView) {
            super(itemView);
            deleteIV = itemView.findViewById(R.id.delete);
            titleTV = itemView.findViewById(R.id.title);
        }

        public void  bind(String essential, DeleteCallback deleteCallback){
            titleTV.setText(essential);
            deleteIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deleteCallback.onDelete(essential);
                }
            });
        }
    }
}
