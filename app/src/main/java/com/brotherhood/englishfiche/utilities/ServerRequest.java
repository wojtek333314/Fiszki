package com.brotherhood.englishfiche.utilities;

import android.os.AsyncTask;

import com.brotherhood.englishfiche.utilities.IO;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class ServerRequest extends AsyncTask<String,Void,String>
{
    String baza;
    public boolean isDownloading = true;
    @Override
    protected String doInBackground(String... params) {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(params[0]);
        HttpResponse response = null;

        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream in = null;
        try
        {
            if (response != null) {
                in = response.getEntity().getContent();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new InputStreamReader(in,"iso-8859-2"), 8);
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        StringBuilder str = new StringBuilder();

        String line = null;
        try
        {
            if (reader != null) {
                while((line = reader.readLine()) != null)
                {
                    str.append(line);
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            in.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        String html = str.toString();
        onExecute(html);
        isDownloading = true;
        System.out.println(html);
        IO io = new IO();// dokoncz
        io.putData(baza,"zapisanaBaza");
        io.getData(html);
        return html;



    }


    public void onExecute(String response)
    {

    }
}
