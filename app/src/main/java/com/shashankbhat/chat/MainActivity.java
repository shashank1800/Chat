package com.shashankbhat.chat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.shashankbhat.chat.adapter.ChatAdapter;
import com.shashankbhat.chat.databinding.ActivityMainBinding;
import com.shashankbhat.chat.room.Message;
import com.shashankbhat.chat.ui.ShowAllChat;
import com.shashankbhat.chat.viewmodel.MainActivityViewModel;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("Main", "ada");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        final ChatAdapter adapter = new ChatAdapter();

        binding.chatRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        binding.chatRecycler.setHasFixedSize(true);
        binding.chatRecycler.setAdapter(adapter);

        viewModel.getAllMessage.observe(this, new Observer<PagedList<Message>>() {
            @Override
            public void onChanged(PagedList<Message> messages) {
                adapter.submitList(messages);
                binding.chatRecycler.smoothScrollToPosition(0);
            }
        });

        binding.send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chat = binding.messageEt.getText().toString();
                if(!chat.isEmpty()){
                    sendMessage(chat, false);
                    binding.messageEt.setText("");
                }
            }
        });

        binding.send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chat = binding.messageEt.getText().toString();
                if(!chat.isEmpty()){
                    sendMessage(chat, true);
                    binding.messageEt.setText("");
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(MainActivity.this, ShowAllChat.class));
        return super.onOptionsItemSelected(item);
    }

    public void sendMessage(String chat, boolean isMe){
        Message message = new Message(chat, isMe);
        viewModel.insert(message);
    }

}