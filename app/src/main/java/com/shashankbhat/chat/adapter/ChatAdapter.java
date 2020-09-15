package com.shashankbhat.chat.adapter;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shashankbhat.chat.R;
import com.shashankbhat.chat.room.Message;
import com.shashankbhat.chat.view.MessageUI;

/**
 * Created by SHASHANK BHAT on 15-Sep-20.
 */

public class ChatAdapter extends PagedListAdapter<Message, ChatAdapter.MessageViewHolder> {

    public ChatAdapter() {
        super(diffCallback);
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private MessageUI messageUI;
        private LinearLayout linearLayout;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            messageUI = itemView.findViewById(R.id.messageUI);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }

    @NonNull
    @Override
    public ChatAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.MessageViewHolder holder, int position) {

        Message chat = getItem(position);
        holder.messageUI.setText(chat.getMessage());
        holder.messageUI.setIsMe(chat.isMe());

        if(chat.isMe())
            holder.linearLayout.setHorizontalGravity(Gravity.END);
        else
            holder.linearLayout.setHorizontalGravity(Gravity.START);

    }

    private static DiffUtil.ItemCallback<Message> diffCallback = new DiffUtil.ItemCallback<Message>() {
        @Override
        public boolean areItemsTheSame(@NonNull Message oldItem, @NonNull Message newItem) {
            return oldItem.getId()==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Message oldItem, @NonNull Message newItem) {
            return oldItem.equals(newItem);
        }
    };


}
