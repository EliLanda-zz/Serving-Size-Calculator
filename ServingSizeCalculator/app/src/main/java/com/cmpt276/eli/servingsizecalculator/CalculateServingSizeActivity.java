package com.cmpt276.eli.servingsizecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/*
* Activity that shows how many grams of food are in your pot and how many grams of food should be in each serving
 */
public class CalculateServingSizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_serving_size);

        Intent intent = getIntent();
        String potName = intent.getStringExtra("name of pot");
        final int potWeight = intent.getIntExtra("weight of pot", 0);

        TextView potNameTextView = (TextView) findViewById(R.id.potName);
        final TextView weightOfFoodTextView = (TextView) findViewById(R.id.weightOfFood);
        TextView potWeightTextView = (TextView) findViewById(R.id.potWeight);
        final TextView servingWeight = (TextView) findViewById(R.id.servingWeight);

        final EditText potWeightWithFoodEditText = (EditText) findViewById(R.id.potWeightWithFood);
        final EditText numberOfServings = (EditText) findViewById(R.id.numberOfServings);

        potNameTextView.setText(potName);
        potWeightTextView.setText("" + potWeight);

        potWeightWithFoodEditText.setText("" + potWeight);
        numberOfServings.setText("" + 1);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int weightOfFood = 0;
                int potWeightWithFood = 0;
                if(!potWeightWithFoodEditText.getText().toString().isEmpty()){
                    potWeightWithFood = Integer.parseInt(potWeightWithFoodEditText.getText().toString());
                }
                if(potWeightWithFood < potWeight){
                    potWeightWithFood = potWeight;
                }

                weightOfFood = potWeightWithFood - potWeight;

                int weightOfServing = 0;
                int amountOfServings = 1;
                if(!numberOfServings.getText().toString().isEmpty()){
                    amountOfServings = Integer.parseInt(numberOfServings.getText().toString());
                }
                if(amountOfServings <= 0){
                    amountOfServings = 1;
                }
                weightOfServing = (int)(weightOfFood/amountOfServings);

                weightOfFoodTextView.setText("" + weightOfFood);
                servingWeight.setText("" + weightOfServing);

            }
        };
        potWeightWithFoodEditText.addTextChangedListener(watcher);
        numberOfServings.addTextChangedListener(watcher);
        setupBackBtn();

    }

    private void setupBackBtn() {
        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
