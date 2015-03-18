package com.brotherhood.englishfiche.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;

public class IO
{

    private SharedPreferences preferences;//klasa zapisu danych .. mniej wiecej

    private SharedPreferences.Editor preferencesEditor;
    public static final String prename = "save";

    public IO(Context context)
    {
        preferences = context.getSharedPreferences(prename, Context.MODE_PRIVATE);
        preferencesEditor = preferences.edit();
        File folder = new File(getData("path"));
        if (!folder.exists()) {
            folder.mkdir();
        }


    }

    public void putData(String data,String key){ //wklada dane pod podany klucz
        preferencesEditor.putString(key, data);
        preferencesEditor.commit();//commit danych
    }

    public String getData(String key)
    {
        return  preferences.getString(key, "null");
    }

    public int getInteger(String key)
    {
        if(getData(key).equals("null"))
            return 0;

        return Integer.parseInt(getData(key));
    }

    public boolean getBoolean(String key)
    {
        return !getData(key).equals("null") && Boolean.parseBoolean(getData(key));
    }


}
