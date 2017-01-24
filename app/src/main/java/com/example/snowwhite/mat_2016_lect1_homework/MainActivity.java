package com.example.snowwhite.mat_2016_lect1_homework;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mButtonSubmit;
    EditText mEditTextName;
    EditText mEditTextCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("App_onCreate", "We started the APP");

        mEditTextName = (EditText) findViewById(R.id.editText1);
        mEditTextCountry = (EditText) findViewById(R.id.editText2);
        mButtonSubmit = (Button) findViewById(R.id.button1);
        mButtonSubmit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("mEditTextName:", mEditTextName.getText().toString());
                Log.v("mEditTextCountry:", mEditTextCountry.getText().toString());
                //If the edit boxes are empty
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                if (mEditTextName.getText().toString().equals("") ||
                        mEditTextCountry.getText().toString().equals("")) {
                    Log.v("mButtonSubmit_onClick", "Invalid input provided");
                    builder.setMessage("You have provided an invalid input. Please retry!").show();
                    return;
                }
                //If edit box is not empty then it displays the Name and Country entered
                builder.setMessage("Your name is: "+ mEditTextName.getText().toString()
                        + " and Your Country is: "+ mEditTextCountry.getText().toString()).show();
            }
        });


        DialogInterface.OnClickListener dialogClickListener1 = new DialogInterface.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Ok button clicked
                        Log.d("App_Details_OkBtn", "Ok Button Was Pressed");
                        break;
                }
            }
        };

    }

    public void onBackPressed() {
        Log.d("App_onBackPressed", "onBackPressed was invoked");
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        // Close App
                        Log.d("App_onBackPressed_YBtn", "Yes Button Was Pressed");
                        finish(); // finish activity
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        Log.d("App_onBackPressed_NBtn", "No Button Was Pressed");
                        break;
                }
            }
        };

        // get application context
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to Exit?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    @Override
    public void onPause() {
        //Hides the app on pressing center button of phone
        super.onPause();
        Log.d("App_onPause", "App has been moved to background");
    }

    @Override
    public void onResume() {
        //Resumes the app after it has been paused
        super.onResume();
        Log.d("App_onResume", "App has regained focus");
    }


}
