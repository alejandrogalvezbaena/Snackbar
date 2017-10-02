package com.example.usuario.snackbar;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button show, change, parent;
    CoordinatorLayout coordinatorLayout;
    LinearLayout parentLinearLayout;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        show = (Button) findViewById(R.id.button);
        show.setOnClickListener(this);
        change = (Button) findViewById(R.id.button2);
        change.setOnClickListener(this);
        parent = (Button) findViewById(R.id.button3);
        parent.setOnClickListener(this);
        coordinatorLayout=(CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        parentLinearLayout=(LinearLayout) findViewById(R.id.parentLinearLayout);


    }

    View.OnClickListener snackbarClickListener=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            snackbar.dismiss();
        }
    };

    @Override
    public void onClick(View v) {
        if (v == show)
            Snackbar.make(coordinatorLayout, "Mensaje", Snackbar.LENGTH_SHORT).show();
        if (v==change) {
            snackbar = Snackbar.make(coordinatorLayout, "Mensaje de otro color", Snackbar.LENGTH_INDEFINITE).setAction("Dismiss", snackbarClickListener);
            snackbar.setActionTextColor(Color.RED);
            View view1 = snackbar.getView();
            view1.setBackgroundColor(Color.BLACK);
            snackbar.show();
        }
        if (v==parent) {
            snackbar = Snackbar.make(parentLinearLayout, "Mensaje en el LinearLayout", Snackbar.LENGTH_INDEFINITE).setAction("Dismiss", snackbarClickListener);
            snackbar.setActionTextColor(Color.GREEN);
            View view1 = snackbar.getView();
            view1.setBackgroundColor(Color.GRAY);
            snackbar.show();
        }

    }
}
