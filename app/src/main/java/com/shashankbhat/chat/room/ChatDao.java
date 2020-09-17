package com.shashankbhat.chat.room;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


/**
 * Created by SHASHANK BHAT on 15-Sep-20.
 */

@Dao
public interface ChatDao {

    @Insert
    void insert(Message message);

    @Query("SELECT * FROM chat_table ORDER BY id DESC")
    DataSource.Factory<Integer, Message> getAllMessages();

    @Query("SELECT * FROM chat_table")
    List<Message> getAllChats();
}
