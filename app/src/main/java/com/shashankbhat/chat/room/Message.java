package com.shashankbhat.chat.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

import static com.shashankbhat.chat.utils.Constants.TABLE_NAME;

/**
 * Created by SHASHANK BHAT on 15-Sep-20.
 */
@Entity(tableName = TABLE_NAME)
public class Message {


    @PrimaryKey(autoGenerate = true)
    private int id;

    private String message;

    private boolean isMe;

    public Message(String message, boolean isMe) {
        this.message = message;
        this.isMe = isMe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMe() {
        return isMe;
    }

    public void setMe(boolean me) {
        isMe = me;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message1 = (Message) o;
        return id == message1.id &&
                isMe == message1.isMe &&
                Objects.equals(message, message1.message);
    }


}
