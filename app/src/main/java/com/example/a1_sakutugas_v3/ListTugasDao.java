package com.example.a1_sakutugas_v3;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ListTugasDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ListTugas listTugas);

    @Query("DELETE FROM listTugas_table")
    void deleteAll();

    @Query("SELECT * FROM listTugas_table ORDER BY listTugas ASC")
    LiveData<List<ListTugas>> getAlphabetizedWords();
}
