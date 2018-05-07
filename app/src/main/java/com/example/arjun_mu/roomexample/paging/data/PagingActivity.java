package com.example.arjun_mu.roomexample.paging.data;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.arjun_mu.roomexample.R;
import com.example.arjun_mu.roomexample.paging.data.listing.MainViewModel;
import com.example.arjun_mu.roomexample.paging.data.listing.PokemonAdapter;


public class PagingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        final PokemonAdapter adapter = new PokemonAdapter();
        viewModel.pokemonList.observe(this, adapter::setList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_pokemons);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.span_count)));
        recyclerView.setAdapter(adapter);
    }
}
