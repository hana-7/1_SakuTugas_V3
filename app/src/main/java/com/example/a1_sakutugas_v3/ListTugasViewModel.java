package com.example.a1_sakutugas_v3;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ListTugasViewModel extends AndroidViewModel {
    private ListTugasRepository mRepository;

    private final LiveData<List<ListTugas>> mAllListTugas;

    public ListTugasViewModel (Application application) {
        super(application);
        mRepository = new ListTugasRepository(application);
        mAllListTugas = mRepository.getAllListTugas();
    }

    LiveData<List<ListTugas>> getAllListTugas() { return mAllListTugas; }

    public void insert(ListTugas listTugas) { mRepository.insert(listTugas); }
}
