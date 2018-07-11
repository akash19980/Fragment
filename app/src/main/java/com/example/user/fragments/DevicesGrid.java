package com.example.user.fragments;

import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DevicesGrid extends AppCompatActivity {
    GridView grid;
    ArrayList<String> deviceName;
    int deviceImage[] ={R.drawable.mobiles,R.drawable.laptops,R.drawable.led,R.drawable.headphones,R.drawable.speaker};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices_grid);
        grid = (GridView)findViewById(R.id.gridView);

        deviceName = new ArrayList<>();
        deviceName.addAll(Arrays.asList(getResources().getStringArray(R.array.devices)));

//--------------------------------------CustomAdapter-----------------------------------------------//

        //CustomAdapter custom = new CustomAdapter(getApplicationContext(),deviceImage);
        //grid.setAdapter(custom);

//------------------------------------ItemClickListener---------------------------------------------//

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                if(i==0)
                {
                    Intent intent = new Intent(DevicesGrid.this, WelcomePage.class);
                    startActivity(intent);
                }
            }
        });

//------------------------------------ArrayListAndHashMap-------------------------------------------//

        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for(int i=0;i<deviceImage.length;i++)
        {
            HashMap<String,String> join= new HashMap<>();
            join.put("NAME", deviceName.get(i));
            join.put("IMAGE",deviceImage[i]+"");
            arrayList.add(join);
        }
        String[] from ={"NAME","IMAGE"};
        int[] to ={R.id.textView2,R.id.imageView2};
        final SimpleAdapter sa = new SimpleAdapter(this,arrayList,R.layout.activity_custom_adapter,from,to);
        grid.setAdapter(sa);

    }
}
