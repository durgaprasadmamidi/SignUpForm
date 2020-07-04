package com.durgaprasad.signupform;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private TextView emailWarning;
    private EditText passwordEditText;
    private TextView passwordWarning;
    private EditText reenterPassEditText;
    private TextView reenterPassWarning;
    private EditText nameEditText;
    private TextView nameWarning;
    private RadioGroup genderRadioGroup;
    private Spinner countrySpinner;
    private Button editImageBtn;
    private Button submitBtn;
    private CheckBox agreementCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        editImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Great Work", Toast.LENGTH_SHORT).show();
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    Toast.makeText(MainActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                    nameEditText.setText("");
                    emailEditText.setText("");
                    passwordEditText.setText("");
                    reenterPassEditText.setText("");
                    genderRadioGroup.check(R.id.maleRadioButton);
                    agreementCheckBox.setChecked(false);
                    nameWarning.setVisibility(View.GONE);
                    emailWarning.setVisibility(View.GONE);
                    passwordWarning.setVisibility(View.GONE);
                    reenterPassWarning.setVisibility(View.GONE);

                    Intent intent = new Intent(MainActivity.this,SecondScreenActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void init(){
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        reenterPassEditText = findViewById(R.id.reenterPasswordEditText);
        nameEditText = findViewById(R.id.nameEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        countrySpinner = findViewById(R.id.countrySpinner);
        editImageBtn = findViewById(R.id.editImageButton);
        submitBtn = findViewById(R.id.submitButton);
        agreementCheckBox = findViewById(R.id.agreementCheckBox);
        emailWarning = findViewById(R.id.emailWarning);
        nameWarning = findViewById(R.id.nameWarning);
        passwordWarning = findViewById(R.id.passwordWarning);
        reenterPassWarning = findViewById(R.id.retypePasswordWarning);

    }
    private boolean validate(){
        if(nameEditText.getText().toString().equals("")){

            nameWarning.setVisibility(View.VISIBLE);
            return false;
        }
        if(emailEditText.getText().toString().equals("")){
            emailWarning.setVisibility(View.VISIBLE);
            return false;
        }
        if(passwordEditText.getText().toString().equals("")){
            passwordWarning.setVisibility(View.VISIBLE);
            return false;
        }
        if(!reenterPassEditText.getText().toString().equals(passwordEditText.getText().toString())){
            reenterPassWarning.setVisibility(View.VISIBLE);
            return false;
        }
        if(!agreementCheckBox.isChecked()){
            Toast.makeText(this, "you should agree the licence", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}