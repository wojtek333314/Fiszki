package com.brotherhood.englishfiche.activities;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.brotherhood.fiche.R;


public class MenuActivity extends Activity {
ImageButton bt1,bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bt1 = (ImageButton)findViewById(R.id.bt_add);
        bt3 = (ImageButton)findViewById(R.id.bt_schedule);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1;
                intent1 = new Intent(MenuActivity.this, Schedule.class);

                startActivity(intent1);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MenuActivity.this, AddFiche.class);

                startActivity(intent);
            }
        });


    }



}
