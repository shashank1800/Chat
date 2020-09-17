package com.shashankbhat.chat.asynctaskloader;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.shashankbhat.chat.room.ChatDatabase;
import com.shashankbhat.chat.room.Message;

/**
 * Created by SHASHANK BHAT on 17-Sep-20.
 */

public class TaskLoader extends AsyncTaskLoader<String> {

    Context context;
    public TaskLoader(@NonNull Context context) {
        super(context);
        this.context = context;
        Log.i("Chat","Task");
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {

        String result = "";
        for(Message message : ChatDatabase.getInstance(context).getChatDao().getAllChats())
            result += message.toString() + "\n";

        return result;
    }
}