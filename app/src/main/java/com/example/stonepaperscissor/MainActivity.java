package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button startButton;
    private static EditText nameInput;

    public static EditText getNameInput() {
        return nameInput;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);
        nameInput = findViewById(R.id.nameInput);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Welcome "+nameInput.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,GameActivity.class);
                intent.putExtra("name",nameInput.getText().toString());
                startActivity(intent);
            }
        });
    }
}