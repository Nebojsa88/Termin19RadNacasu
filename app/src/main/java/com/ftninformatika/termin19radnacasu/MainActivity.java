package com.ftninformatika.termin19radnacasu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RvAdapter.onClickListener {

    RecyclerView rvItems;
    String podaci [] = {"jedan", "dva", "tri", "cetiri", "pet"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvItems = findViewById(R.id.rvItems);

        rvItems.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvItems.setLayoutManager(manager);

        RvAdapter adapter = new RvAdapter(podaci, this);
        rvItems.setAdapter(adapter);


    }

    @Override
    public void onClick(String text) {
        Toast.makeText(this, "Kliknuli ste na " + text , Toast.LENGTH_SHORT).show();
    }
}
