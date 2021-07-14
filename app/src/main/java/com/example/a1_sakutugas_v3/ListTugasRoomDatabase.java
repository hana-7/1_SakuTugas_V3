package com.example.a1_sakutugas_v3;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ListTugas.class}, version = 1, exportSchema = false)
public abstract class ListTugasRoomDatabase extends RoomDatabase {
    public abstract ListTugasDao listTugasDao();

    private static volatile ListTugasRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ListTugasRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ListTugasRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ListTugasRoomDatabase.class, "listTugas_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                ListTugasDao dao = INSTANCE.listTugasDao();
                dao.deleteAll();

                ListTugas listTugas = new ListTugas("Artikel Pancasila", "11-07-2020", "Materi Berbangsa dan Bernegara");
                dao.insert(listTugas);

                listTugas = new ListTugas("Video corona", "26-7-2020", "-");
                dao.insert(listTugas);
//                listTugas = new ListTugas("Essay Bahasa Inggris", "5-8-2020", "-");
//                dao.insert(listTugas);
//                listTugas = new ListTugas("StatProb, Data", "6-8-2020", "Data sebanyak 50");
//                dao.insert(listTugas);
//                listTugas = new ListTugas("PPT APSI", "22-9-2020", "-");
//                dao.insert(listTugas);
            });
        }
    };
}
