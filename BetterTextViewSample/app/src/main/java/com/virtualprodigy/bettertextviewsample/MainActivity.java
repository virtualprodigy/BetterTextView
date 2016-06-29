package com.virtualprodigy.bettertextviewsample;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.font_license:
                displayChangeLog();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Display the webview with the license for the Dancing font
     */
    private void displayChangeLog() {

        WebView webview = new WebView(context);
        webview.loadUrl("file:///android_asset/fonts/dancing_script_license.html");

        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle("Dancing Script License")
                .setView(webview)
                .setPositiveButton("ok",null)
                .create();
        dialog.show();

    }
}
