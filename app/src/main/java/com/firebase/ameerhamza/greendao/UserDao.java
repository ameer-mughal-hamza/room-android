package com.firebase.ameerhamza.greendao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Ameer Hamza on 12/19/2017.
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert
    void insertAll(User... user);

    @Delete
    public void delete(User user);
}
