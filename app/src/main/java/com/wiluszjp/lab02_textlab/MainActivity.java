package com.wiluszjp.lab02_textlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView nameBox, cycleBox;
    EditText nameEditSpace;
    Button nameButton, cycleButton;
    Resources res;
    String[] mutableArr;
    Integer mutableInd = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();
        mutableArr = res.getStringArray(R.array.stringListAlterable);
        nameBox = findViewById(R.id.textBox);
        nameEditSpace = findViewById(R.id.nameEntry);
        cycleBox = findViewById(R.id.cycleText);
        nameButton = findViewById(R.id.submission);
        cycleButton = findViewById(R.id.cycleButton);
        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = getString(R.string.inputChecker, nameEditSpace.getText().toString());
                nameBox.setText(newText);
                nameEditSpace.setText("");
            }
        });
        cycleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycleBox.setText(mutableArr[mutableInd]);
                if(mutableInd + 1 == mutableArr.length)
                    mutableInd = 0;
                else
                    mutableInd += 1;
            }
        });
    }
}
