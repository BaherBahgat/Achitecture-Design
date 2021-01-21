package com.alyndroid.architecturepatternstutorialshomework.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;
import com.alyndroid.architecturepatternstutorialshomework.ui.data.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.ui.data.DivisionView;
import com.alyndroid.architecturepatternstutorialshomework.ui.data.NumberViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DivisionView {

    Button plusBtn, divisionBtn, multiBtn;
    TextView plusTextView, divisionTextView, multiTextView;
    DataBase data;
    NumberModel numberModel;
    NumberViewModel numberViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEvent();
        numberViewModel.MultiResultLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                multiTextView.setText(s);
            }
        });
    }

    private void init(){
        // Text Views
        plusTextView = findViewById(R.id.plus_result_textView);
        divisionTextView = findViewById(R.id.div_result_textView);
        multiTextView = findViewById(R.id.mul_result_textView);

        //Buttons
        divisionBtn = findViewById(R.id.div_button);
        plusBtn = findViewById(R.id.plus_button);
        multiBtn = findViewById(R.id.mul_button);

        //Classes
        data = new DataBase();
        numberModel = new NumberModel(this);
        numberViewModel = ViewModelProviders.of(this).get(NumberViewModel.class);

    }

    private void setEvent(){
        plusBtn.setOnClickListener(this);
        divisionBtn.setOnClickListener(this);
        multiBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //----------------MVC---------------
        if(view.getId() == R.id.plus_button)
        {
            int result = data.getNumbers().getFirstNum() +
                         data.getNumbers().getSecondNum();

            plusTextView.setText(String.valueOf(result));
        }

        //------------MVP------------------------
        else if(view.getId() == R.id.div_button)
        {
            numberModel.getDivisionResult();
        }

        //-----------MVM-----------
        else if(view.getId() == R.id.mul_button)
        {
            numberViewModel.getMultiResult();
        }
    }

    @Override
    public void getDivisionResult(String result) {
        this.divisionTextView.setText(result);
    }
}
