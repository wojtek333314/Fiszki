package com.brotherhood.englishfiche.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.brotherhood.fiche.R;
import com.brotherhood.fiche.adapters.RowAdapter;
import com.brotherhood.fiche.adapters.RowBean;

public class Schedule extends Activity {

    private ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);

        RowBean RowBean_data[] = new RowBean[] {

                new RowBean(false, "Poniedziałek"),
                new RowBean(false, "Wtorek"),
                new RowBean(false, "Środa"),
                new RowBean(false, "Czwartek"),
                new RowBean(false, "Piątek"),
                new RowBean(false, "Sobota"),
                new RowBean(false, "Niedziela"),

        };

        RowAdapter adapter = new RowAdapter(this,
                R.layout.list_view_element, RowBean_data);

        listView1 = (ListView)findViewById(R.id.Lista);
        listView1.setAdapter(adapter);
    }
}