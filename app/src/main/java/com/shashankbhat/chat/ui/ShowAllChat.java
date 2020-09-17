package com.shashankbhat.chat.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;


import android.os.Bundle;
import android.util.Log;


import com.shashankbhat.chat.R;
import com.shashankbhat.chat.asynctaskloader.TaskLoader;
import com.shashankbhat.chat.databinding.ActivityShowAllChatBinding;

import com.shashankbhat.chat.viewmodel.MainActivityViewModel;

public class ShowAllChat extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private ActivityShowAllChatBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_all_chat);
        binding.setLifecycleOwner(this);

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        Log.i("Chat","onCreate");

        LoaderManager.getInstance(this).initLoader(0,null,this);

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        Log.i("Chat","onCreateLoader");
        return new TaskLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {

        Log.i("Chat","onLoadFinished");
        binding.textView.setText(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }


}