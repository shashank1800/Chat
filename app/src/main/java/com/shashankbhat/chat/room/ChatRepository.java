package com.shashankbhat.chat.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.paging.DataSource;


/**
 * Created by SHASHANK BHAT on 15-Sep-20.
 */

public class ChatRepository {
    private ChatDatabase chatDatabase;
    private ChatDao chatDao;

    public DataSource.Factory<Integer, Message> listOfMessages;

    public ChatRepository(Application application){
        chatDatabase = ChatDatabase.getInstance(application);
        chatDao = chatDatabase.getChatDao();
        listOfMessages = chatDao.getAllMessages();
    }

    public void insert(Message message) {
        new InsertTask(message).execute();
    }

    class InsertTask extends AsyncTask<Void, Void, Void>{

        private Message message;

        public InsertTask(Message message) {
            this.message = message;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            chatDao.insert(message);
            return null;
        }
    }
}
