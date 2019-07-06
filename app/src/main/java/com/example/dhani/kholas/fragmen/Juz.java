package com.example.dhani.kholas.fragmen;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dhani.kholas.BaseJuz;
import com.example.dhani.kholas.R;
import com.example.dhani.kholas.TampilQuranActivity;
import com.example.dhani.kholas.adapter.JuzAdapter;
import com.example.dhani.kholas.adapter.SuratAdapter;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Juz extends Fragment {
    private final static String JSON_LIST_JUZ = "json/data-juz.json";

    private JuzAdapter juzAdapter;
    private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_juz, container, false);

        List<BaseJuz> list = new ArrayList<BaseJuz>();
        String json = getAssetsJSON(JSON_LIST_JUZ);

        JSONArray array = null;
        try {
            array = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (array.length() > 0) {
            Gson gson = new Gson();
            int i = 0;
            while (i < array.length()) {
                try {
                    list.add(gson.fromJson(array.getJSONObject(i).toString(), BaseJuz.class));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i++;
            }
        } else {
            Toast.makeText(getContext(), "No Objects", Toast.LENGTH_LONG).show();
        }


        listView = view.findViewById(R.id.lv_daftar_juz);
        juzAdapter = new JuzAdapter(this, list);
        listView.setAdapter(juzAdapter);

        return view;
    }

    public String getAssetsJSON(String fileName) {
        String json = null;
        try {
            InputStream inputStream = this.getContext().getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}