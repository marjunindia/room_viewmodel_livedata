package com.example.arjun_mu.roomexample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by arjun_mu on 4/26/2018.
 */

@Dao
public interface WordDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWord();

    @Insert
    void insert(Word word);


    @Query("DELETE FROM word_table")
    void deleteAll();
}
