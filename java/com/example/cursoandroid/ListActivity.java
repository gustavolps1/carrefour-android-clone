package com.example.cursoandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListActivity extends Activity {

    private String[] itens = {
            "Maçâ", "Laranja", "Melancia", "Feijão", "Banana", "Abacate"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView list = findViewById(R.id.list);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                itens

                );

        list.setAdapter(adaptador);


    }
}
