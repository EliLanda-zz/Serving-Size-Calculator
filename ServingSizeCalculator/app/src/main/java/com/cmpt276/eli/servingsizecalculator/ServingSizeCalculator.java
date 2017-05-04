package com.cmpt276.eli.servingsizecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
/*
*shows current list of pots.
* lets you navigate to the Add pot activity for adding new pots to the list.
 * this page displays and lets you select a pot from that list to be used in the CalculateServingSize activity
 */
public class ServingSizeCalculator extends AppCompatActivity {
    private final PotCollection potCollection = new PotCollection();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serving_size_calculator);

        setupAddPotBtn();
        populateTextViewList();
        registerClickCallback();
    }

    private void registerClickCallback() {

        ListView list = (ListView) findViewById(R.id.listViewMain);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ServingSizeCalculator.this, CalculateServingSizeActivity.class);
                intent.putExtra("name of pot", potCollection.getPot(position).getName());
                intent.putExtra("weight of pot", potCollection.getPot(position).getWeightInG());
                startActivity(intent);
            }
        });
    }

    private void populateTextViewList() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.items_in_pot_list,potCollection.getPotDescriptions());
        ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setAdapter(adapter);
    }

    private void setupAddPotBtn() {
        Button btnAddPot = (Button) findViewById(R.id.Add_Pot_Button);

        btnAddPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServingSizeCalculator.this, PotAddActivity.class);
                startActivityForResult(intent, 42);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case 42:
                if (resultCode == Activity.RESULT_OK) {
                    int potWeight = data.getIntExtra("Weight", 0);
                    String potName = data.getStringExtra("Name");
                    ServingSizeCalculator.this.potCollection.addPot(new Pot(potName,potWeight));
                    populateTextViewList();
                    break;
                }
        }
    }
}
