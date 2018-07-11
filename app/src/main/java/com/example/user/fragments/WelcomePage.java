package com.example.user.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WelcomePage extends AppCompatActivity {
String username;
ListView list ;
SearchView search;
ArrayList<String> brandNames  ;
int [] brandImages={R.drawable.asus,R.drawable.oneplus,R.drawable.honor,R.drawable.samsung,R.drawable.oppo,R.drawable.xiaomi,R.drawable.vivo};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        Intent intent=getIntent();
        username=intent.getStringExtra("USERNAME");
        Toast.makeText(this, "Welcome "+username+"", Toast.LENGTH_SHORT).show();
        list=(ListView)findViewById(R.id.listView);

        brandNames = new ArrayList<>();
        brandNames.addAll(Arrays.asList(getResources().getStringArray(R.array.brands)));
//----------------------------------AdapterListAndHashMap-------------------------------------------//
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for(int i=0;i<brandImages.length;i++)
        {
            HashMap<String,String> join= new HashMap<>();
            join.put("NAME", brandNames.get(i));
            join.put("IMAGE",brandImages[i]+"");
            arrayList.add(join);
        }
        String[] from ={"NAME","IMAGE"};
        int[] to ={R.id.textView,R.id.imageView};
        final SimpleAdapter sa = new SimpleAdapter(this,arrayList,R.layout.dummy,from,to);
        list.setAdapter(sa);
//-------------------------------------ListViewListener---------------------------------------------//
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), brandNames.get(i) +"", Toast.LENGTH_SHORT).show();
            }
        });

//----------------------------------------SearchView------------------------------------------------//
        search=(SearchView)findViewById(R.id.searchView);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (brandNames.contains(query))
                {
                    sa.getFilter().filter(query);
                }
                else
                {
                    Toast.makeText(WelcomePage.this, "Nothing Found", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                sa.getFilter().filter(newText);
                return false;
            }
        });

    }
}
