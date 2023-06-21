package com.example.uasppab2;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class CustomButton extends AppCompatButton {

    boolean mBoolean = false;

    public CustomButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setTextColor(Color.BLACK);
        setBackgroundColor(Color.RED);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBoolean==true){

                    setBackgroundColor(Color.RED);
                    mBoolean = false;
                } else{

                    setBackgroundColor(Color.GREEN);
                    mBoolean = true;
                }

            }
        });
    }
}
