package com.example.alexbuicescu.androidworkshop.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.alexbuicescu.androidworkshop.Interfaces.OnChangeListener;
import com.example.alexbuicescu.androidworkshop.Models.MainModel;
import com.example.alexbuicescu.androidworkshop.R;

/**
 * Created by alexbuicescu on 05.08.2015.
 */
public class MainLayout extends LinearLayout implements OnChangeListener<MainModel> {

    private MainModel model;

    private TextView firstNameTextview;
    private TextView lastNameTextview;
    private TextView ageTextview;

    public MainLayout(Context context) {
        super(context);
    }

    public MainLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MainLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initLayout();
    }

    public void initLayout()
    {
        firstNameTextview = (TextView) findViewById(R.id.activity_main_first_name_textview);
        lastNameTextview = (TextView) findViewById(R.id.activity_main_last_name_textview);
        ageTextview = (TextView) findViewById(R.id.activity_main_age_textview);
    }

    public MainModel getModel() {
        return model;
    }

    public void setModel(MainModel model) {
        this.model = model;
        this.model.addListener(this);
        updateView();
    }

    private void updateView()
    {
        firstNameTextview.setText(getModel().getFirstName());
        lastNameTextview.setText(getModel().getLastName());
        ageTextview.setText(getModel().getAge() + "");
    }

    @Override
    public void onChange() {
        updateView();
    }
}
