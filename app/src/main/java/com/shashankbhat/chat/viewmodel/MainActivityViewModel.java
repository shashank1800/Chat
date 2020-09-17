package com.shashankbhat.chat.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.shashankbhat.chat.room.ChatRepository;
import com.shashankbhat.chat.room.Message;

import java.util.List;


/**
 * Created by SHASHANK BHAT on 15-Sep-20.
 */

public class MainActivityViewModel extends AndroidViewModel {

    public LiveData<PagedList<Message>> getAllMessage;
    private ChatRepository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        repository = new ChatRepository(application);
        getAllMessage = new LivePagedListBuilder<>(repository.listOfMessages, 10).build();
    }

    public void insert(Message message){
        repository.insert(message);
    }

    public List<Message> getAllChat(){
        return repository.getAllChat();
    }

}
