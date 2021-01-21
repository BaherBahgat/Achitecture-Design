package com.alyndroid.architecturepatternstutorialshomework.ui.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumberViewModel extends ViewModel {
    public MutableLiveData<String> MultiResultLiveData;
    DataBase db = new DataBase();

    public NumberViewModel(){
        db = new DataBase();
        MultiResultLiveData = new MutableLiveData<>();
    }
    public void getMultiResult(){
        int multi = db.getNumbers().getFirstNum() * db.getNumbers().getSecondNum();
        String result = String.valueOf(multi);
        MultiResultLiveData.setValue(result);
    }
}
