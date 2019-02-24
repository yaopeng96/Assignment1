package com.example.assignment1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText value = (EditText) findViewById(R.id.value);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.converter);
        final RadioButton rb1 = (RadioButton) findViewById(R.id.radiobutton);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
        final RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton4);
        final RadioButton rb5 = (RadioButton) findViewById(R.id.radioButton5);
        final RadioButton rb6 = (RadioButton) findViewById(R.id.radioButton6);
        final TextView viewResult = (TextView)findViewById(R.id.viewResult);

        Button convert = findViewById(R.id.convertBTN);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double v1 = new Double(value.getText().toString());

                if (rb1.isChecked())
                {
                    v1 = unitConverter.convertMetersToInches(v1);
                }
                else if (rb2.isChecked())
                {
                    v1 = unitConverter.convertMetersToYards(v1);
                }
                else if (rb3.isChecked())
                {
                    v1 = unitConverter.convertInchesToMeters(v1);
                }
                else if (rb4.isChecked())
                {
                    v1 = unitConverter.convertInchesToYards(v1);
                }
                else if (rb5.isChecked())
                {
                    v1 = unitConverter.convertYardsToMeters(v1);
                }
                else if (rb6.isChecked())
                {
                    v1 = unitConverter.convertYardsToInches(v1);
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Please select the convert button");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();;
                }

                viewResult.setText(""+v1);
            }
        });

    Button reset = (Button)findViewById(R.id.resetBTN);
    reset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            value.setText("");
            viewResult.setText("");
            rg.clearCheck();
        }
    });
    }
}
