package com.shaon.nagadapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.shaon.nagadapp.R;

public class MainActivity extends AppCompatActivity {

    private Switch themeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        themeSwitch = findViewById(R.id.theme_switch);

        // Set the initial state of the switch based on the current theme
        if (getResources().getConfiguration().uiMode == Configuration.UI_MODE_NIGHT_YES) {
            themeSwitch.setChecked(true);
        } else {
            themeSwitch.setChecked(false);
        }

        // Add an event listener to the switch
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Switch the theme when the user toggles the switch
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                 // Restart the activity to apply the new theme
            }
        });
    }
}
