package com.example.arjun_mu.roomexample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by arjun_mu on 4/26/2018.
 */

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private LiveData<List<Word>> mAllWords;


    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository=new WordRepository(application);
        mAllWords=mRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }
    public void insert(Word word){
        mRepository.insert(word);
    }
}
