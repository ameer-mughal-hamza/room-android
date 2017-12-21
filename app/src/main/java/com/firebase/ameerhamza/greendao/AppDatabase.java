package com.firebase.ameerhamza.greendao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Ameer Hamza on 12/19/2017.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase Instance;

    public abstract UserDao userDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (Instance == null) {
            Instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "production")
                    .allowMainThreadQueries()
                    .build();
        }
        return Instance;
    }
}
