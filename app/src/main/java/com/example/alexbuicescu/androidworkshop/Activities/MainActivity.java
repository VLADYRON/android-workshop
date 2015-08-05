package com.example.alexbuicescu.androidworkshop.Activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.alexbuicescu.androidworkshop.Models.MainModel;
import com.example.alexbuicescu.androidworkshop.R;
import com.example.alexbuicescu.androidworkshop.Views.MainLayout;

public class MainActivity extends AppCompatActivity {

    private Activity activity;

    private MainLayout layout;
    private MainModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = MainActivity.this;

        initModel();
        initLayout();

        setContentView(layout);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        model.setFirstName("alex2", true);
                    }
                });
            }
        }).start();
    }

    private void initLayout()
    {
        layout = (MainLayout) View.inflate(activity, R.layout.activity_main, null);

        layout.setModel(model);
    }

    private void initModel()
    {
        model = new MainModel();
        model.setFirstName("alex1");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
