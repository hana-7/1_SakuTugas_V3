package com.example.a1_sakutugas_v3;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ListTugasRepository {
    private ListTugasDao mListTugasDao;
    private LiveData<List<ListTugas>> mAllListTugas;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    ListTugasRepository(Application application) {
        ListTugasRoomDatabase db = ListTugasRoomDatabase.getDatabase(application);
        mListTugasDao = db.listTugasDao();
        mAllListTugas = mListTugasDao.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<ListTugas>> getAllListTugas() {
        return mAllListTugas;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(ListTugas listTugas) {
        ListTugasRoomDatabase.databaseWriteExecutor.execute(() -> {
            mListTugasDao.insert(listTugas);
        });
    }
}
