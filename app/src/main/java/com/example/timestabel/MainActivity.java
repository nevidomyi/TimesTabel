package com.example.timestabel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private ListView listViewTable;

    private ArrayList<Integer> numbers;

    private int min = 1;
    private int max = 20;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewTable = findViewById(R.id.listViewTable);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max);

        numbers = new ArrayList<>();

        final ArrayAdapter<Integer> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);
        listViewTable.setAdapter(adapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i < min) {
                    seekBar.setProgress(min);
                }
                adapter.clear();
                for ( int x = min; x <= max; x++ ) {

                    numbers.add(seekBar.getProgress() * x);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
