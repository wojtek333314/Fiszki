package com.brotherhood.englishfiche.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import com.brotherhood.englishfiche.utilities.ServerRequest;
import com.brotherhood.fiche.R;


public class Starting extends Activity {

    private static String file_url = "http://datastore.waw.pl/Fiche/get.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_activity);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                starter();
            }
        }).start();
/*
        IO io = new IO(this);
        io.putData("jakisrtring","jakisklucz");
        io.getData("klicz");

        */

    }

    void starter()
    {
        final ServerRequest download = new ServerRequest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(download.isDownloading)
                {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(Starting.this,MenuActivity.class);
                startActivity(intent);
            }
        }).start();
        download.execute(file_url);

    }

}
