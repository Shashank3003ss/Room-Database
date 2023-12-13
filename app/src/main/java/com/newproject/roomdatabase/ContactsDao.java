package com.newproject.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.jar.Attributes;

@Dao
public interface ContactsDao {

    @Query("select * from Contact_Details")
    List<Contacts> getAllContacts();

    @Insert
    void addTx(Contacts contacts);

    @Update
    void updateTx(Contacts contacts);

    @Delete
    void deleteTx(Contacts contacts);
}
