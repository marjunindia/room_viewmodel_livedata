package com.example.arjun_mu.roomexample.paging.data.listing;


import android.arch.paging.PagedListAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arjun_mu.roomexample.R;
import com.example.arjun_mu.roomexample.paging.data.Pokemon;


public class PokemonAdapter extends PagedListAdapter<Pokemon, PokemonViewHolder> {


    public PokemonAdapter() {
        super(Pokemon.DIFF_CALLBACK);
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        Pokemon pokemon = getItem(position);

        if (pokemon != null) {
            holder.bindTo(pokemon);
        } else {
            holder.clear();
        }
    }
}
