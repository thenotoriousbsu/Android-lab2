package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView conf = null;
    private int orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conf = findViewById(R.id.screenOrientation);
        this.orientation = this.getResources().getConfiguration().orientation;
        defineScreenOrientation();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        orientation = newConfig.orientation;
        defineScreenOrientation();
    }

    private void defineScreenOrientation() {
        int stringResource;
        switch (orientation) {
            case (Configuration.ORIENTATION_LANDSCAPE):
                stringResource = R.string.landscape_view;
                break;
            case (Configuration.ORIENTATION_PORTRAIT):
                stringResource = R.string.portrait_view;
                break;
            default:
                stringResource = R.string.view;
                break;
        }
        conf.setText(getString(stringResource));
    }
}