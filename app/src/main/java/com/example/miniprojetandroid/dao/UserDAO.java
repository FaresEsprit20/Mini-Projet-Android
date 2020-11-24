package com.example.miniprojetandroid.dao;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.miniprojetandroid.models.User;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM users WHERE email LIKE :email AND password LIKE :password LIMIT 1")
    User findByEmailAndPassword(String email, String password);

    @Query("SELECT * FROM users WHERE email == :email LIMIT 1")
    User findByEmail(String email);

    @Insert
    void insertAll(User... users);

    @Insert
    void insertOne(User user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);

}
