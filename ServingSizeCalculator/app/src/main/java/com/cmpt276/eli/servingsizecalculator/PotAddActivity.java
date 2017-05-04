package com.cmpt276.eli.servingsizecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
*Activity for creating a new pot. Users can set the name and weight of their new pot.
 */
public class PotAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pot_add);

        setupOkBtn();
        setupCancelBtn();
    }

    private void setupCancelBtn() {
        Button btnCancel = (Button) findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }

    private void setupOkBtn() {
        Button btnOk = (Button) findViewById(R.id.btnOk);
        final EditText potNameEdit = (EditText) findViewById(R.id.potNameEditBox);
        final EditText potWeightEdit = (EditText) findViewById(R.id.potWeightEditBox);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int potWeight = 0;
                String potName = "";
                boolean reEnter = false;
                if(!potWeightEdit.getText().toString().isEmpty() && !potNameEdit.getText().toString().isEmpty()){
                    potName = potNameEdit.getText().toString();
                    potWeight = Integer.parseInt(potWeightEdit.getText().toString());
                    reEnter = false;
                    if( potWeight <= 0){
                        reEnter =true;
                        Toast toast = Toast.makeText(getApplicationContext(), "please enter a non empty name and a positive non zero weight", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "please enter a non empty name and a positive non zero weight", Toast.LENGTH_LONG);
                    toast.show();
                    reEnter = true;
                }
                if(!reEnter){
                    Intent intent = new Intent();
                    intent.putExtra("Weight", potWeight);
                    intent.putExtra("Name", potName);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
