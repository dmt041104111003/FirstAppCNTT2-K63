package com.example.firstappcntt2_k63;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtPhone;
    RadioGroup radioGroupGender;
    RadioButton radioMale, radioFemale;
    Spinner spinnerLocation;
    Button btnAdd;
    ListView listView;
    CheckBox chkMusic, chkSport;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        spinnerLocation = findViewById(R.id.spinnerLocation);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);
        chkMusic = findViewById(R.id.chkMusic);
        chkSport = findViewById(R.id.chkSport);


        String[] locations = {"Ha Noi", "Nam Dinh", "Ha Nam", "TP.HCM"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locations);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocation.setAdapter(spinnerAdapter);


        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);


        btnAdd.setOnClickListener(view -> {
            String name = edtName.getText().toString();
            String phone = edtPhone.getText().toString();
            String gender = radioMale.isChecked() ? "Male" : "Female";
            String location = spinnerLocation.getSelectedItem().toString();


            String hobbies = "";
            if (chkMusic.isChecked()) hobbies += " Music";
            if (chkSport.isChecked()) hobbies += " Sports";


            String data = name + " - " + gender + " - " + phone + " - " + location + " - " + hobbies;


            arrayList.add(data);
            adapter.notifyDataSetChanged();
        });
    }
}
