package com.shashankbhat.chat.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import static com.shashankbhat.chat.utils.Constants.DB_NAME;

/**
 * Created by SHASHANK BHAT on 15-Sep-20.
 */

@Database(entities = Message.class, exportSchema = false, version = 1)
public abstract class ChatDatabase extends RoomDatabase{

    public static ChatDatabase instance;
    public abstract ChatDao getChatDao();


    public static synchronized ChatDatabase getInstance(Context context){
        if(instance==null)
            instance = Room.databaseBuilder(context,ChatDatabase.class, DB_NAME).build();

        return instance;
    }
}
