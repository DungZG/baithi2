package com.example.myapplication;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private ListView lvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        lvCourses = findViewById(R.id.lvCourses);

        String level = getIntent().getStringExtra("level");
        boolean isJavaSelected = getIntent().getBooleanExtra("isJavaSelected", false);
        boolean isDatabaseSelected = getIntent().getBooleanExtra("isDatabaseSelected", false);
        boolean isWebSelected = getIntent().getBooleanExtra("isWebSelected", false);

        List<String> courses = new ArrayList<>();

        if (isJavaSelected) {
            courses.add("Lập trình Java");
        }
        if (isDatabaseSelected) {
            courses.add("Lập trình cơ sở dữ liệu");
        }
        if (isWebSelected) {
            courses.add("Lập trình web");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        lvCourses.setAdapter(adapter);
    }
}

