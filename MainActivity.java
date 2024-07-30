package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgLevel;
    private CheckBox cbJava, cbDatabase, cbWeb;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgLevel = findViewById(R.id.rgLevel);
        cbJava = findViewById(R.id.cbJava);
        cbDatabase = findViewById(R.id.cbDatabase);
        cbWeb = findViewById(R.id.cbWeb);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedLevelId = rgLevel.getCheckedRadioButtonId();
                if (selectedLevelId == -1) {
                    Toast.makeText(MainActivity.this, "Please select a level", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedLevel = findViewById(selectedLevelId);
                String level = selectedLevel.getText().toString();

                boolean isJavaSelected = cbJava.isChecked();
                boolean isDatabaseSelected = cbDatabase.isChecked();
                boolean isWebSelected = cbWeb.isChecked();

                if (!isJavaSelected && !isDatabaseSelected && !isWebSelected) {
                    Toast.makeText(MainActivity.this, "Please select at least one subject", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, CourseActivity.class);
                intent.putExtra("level", level);
                intent.putExtra("isJavaSelected", isJavaSelected);
                intent.putExtra("isDatabaseSelected", isDatabaseSelected);
                intent.putExtra("isWebSelected", isWebSelected);
                startActivity(intent);
            }
        });
    }
}