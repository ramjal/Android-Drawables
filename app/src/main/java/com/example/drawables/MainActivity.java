package com.example.drawables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int currentLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentLevel = 1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {
        MenuItem item = menu.getItem(0);
        item.setIcon(getBatteryIcon());
        return true;
    }

    public void button1clicked(View view) {
        ImageButton imageButton = findViewById(R.id.btnDisableTest);
        imageButton.setEnabled(!imageButton.isEnabled());
        TextView textView = findViewById(R.id.txtDisableButton);
        textView.setEnabled(imageButton.isEnabled());
    }

    public void btn_increase_clicked(View view) {
        ImageButton imageButton = findViewById(R.id.battery);
        if (currentLevel < 6)
            currentLevel += 1;
        imageButton.setImageLevel(currentLevel);
        invalidateOptionsMenu();
    }

    public void btn_decrease_clicked(View view) {
        ImageButton imageButton = findViewById(R.id.battery);
        if (currentLevel > 1)
            currentLevel -= 1;
        imageButton.setImageLevel(currentLevel);
        invalidateOptionsMenu();
    }

    private int getBatteryIcon() {
        String name = "ic_battery_" + currentLevel;
        if (currentLevel == 6) name = "ic_battery_full";
        return getResources().getIdentifier(name, "drawable", getPackageName());
    }

}