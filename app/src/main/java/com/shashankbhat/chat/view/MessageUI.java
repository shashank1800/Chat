package com.shashankbhat.chat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.shashankbhat.chat.R;


/**
 * Created by SHASHANK BHAT on 15-Sep-20.
 */

public class MessageUI extends AppCompatTextView {

    public MessageUI(@NonNull Context context) {
        super(context);
        init();
    }

    public MessageUI(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MessageUI);
        boolean isMe = array.getBoolean(R.styleable.MessageUI_isMe, true);

        setIsMe(isMe);

    }

    public MessageUI(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(){
        setTextAppearance(R.style.TextAppearance_AppCompat_Subhead);
    }

    public void setIsMe(boolean isMe) {
        if(isMe)
            getBackground().setTint((int)Color.parseColor("#DCF8C6"));
        else
            getBackground().setTint((int)Color.parseColor("#FFFFFF"));

    }

}
