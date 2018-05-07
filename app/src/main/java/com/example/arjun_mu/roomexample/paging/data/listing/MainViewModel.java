package com.example.arjun_mu.roomexample.paging.data.listing;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;

import com.example.arjun_mu.roomexample.paging.data.Pokemon;
import com.example.arjun_mu.roomexample.paging.data.PokemonApplication;
import com.example.arjun_mu.roomexample.paging.data.PokemonDao;
import com.example.arjun_mu.roomexample.paging.data.PokemonDataBase;


public class MainViewModel extends ViewModel {

    private static final int INITIAL_LOAD_KEY = 0;
    private static final int PAGE_SIZE = 20;
    private static final int PREFETCH_DISTANCE = 5;

    public final LiveData<PagedList<Pokemon>> pokemonList;

    public MainViewModel() {
        PokemonDao pokemonDao = PokemonDataBase.getInstance(PokemonApplication.getContext()).pokemonDao();
        pokemonList = pokemonDao.pokemons().create(INITIAL_LOAD_KEY, new PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setPrefetchDistance(PREFETCH_DISTANCE)
                .setEnablePlaceholders(true)
                .build()
        );
    }
}
