package com.example.lucasfutch.surveyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import java.util.ArrayList;

import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class SurveyActivity extends AppCompatActivity {

    private String selectedSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        Spinner surveySpinner = (Spinner)findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Main Survey");
        arrayList.add("Survey2");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        surveySpinner.setAdapter(arrayAdapter);
        surveySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String surveysName = parent.getItemAtPosition(position).toString();
                selectedSurvey = surveysName;
                Toast.makeText(parent.getContext(), "Selected: " + surveysName, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void makeSurvey(View view) {
        Intent intent = new Intent(this, CreateSurveyActivity.class);
        startActivity(intent);
    }


//    public void startSurvey(View view) {
//        Intent intent = new Intent(this, Questions.class);
//        Intent.putExtra("SurveyName", selectedSurvey);
//        startActivity(intent);
//    }

//    public void openLogin(View view) {
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
//    }
}
