package com.example.communityservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.DatePicker;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class AddEvent extends AppCompatActivity {
    EditText eventName, eventOrg;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        eventName = findViewById(R.id.eventName);
        eventOrg = findViewById(R.id.eventOrg);
        datePicker = findViewById(R.id.datePicker);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(AddEvent.this.getFilesDir(), "text");
                if (!file.exists()) file.mkdir();
                try {
                    File orgs = new File(file, "orgs");
                    FileWriter writer = new FileWriter(orgs);
                    writer.append(eventName.getText().toString());
                    writer.append('`');
                    writer.append(eventOrg.getText().toString());
                    writer.append('`');

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                    writer.append(calendar.getTime().toString());

                    writer.flush();
                    writer.close();
                    Toast.makeText(AddEvent.this, "Event added successfully." + AddEvent.this.getFilesDir().toString(), Toast.LENGTH_LONG).show();
                } catch (Exception e) { }
            }
        });
    }
}