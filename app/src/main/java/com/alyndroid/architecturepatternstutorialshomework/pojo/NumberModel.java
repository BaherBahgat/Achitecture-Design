package com.alyndroid.architecturepatternstutorialshomework.pojo;

import com.alyndroid.architecturepatternstutorialshomework.ui.data.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.ui.data.DivisionView;

public class NumberModel {
    private int firstNum, secondNum;
    DivisionView divisionView;
    DataBase db;
    public NumberModel(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public NumberModel(DivisionView divisionView)
    {
        this.divisionView = divisionView;
        db = new DataBase();
    }

    public void getDivisionResult(){
        if(db.getNumbers().getSecondNum()==0)
        {
            divisionView.getDivisionResult(String.valueOf("Invalid Operator"));
            return;
        }

        double result = db.getNumbers().getFirstNum() / db.getNumbers().getSecondNum();
        divisionView.getDivisionResult(String.valueOf(result));
    }

    public int getFirstNum() {
        return firstNum;
    }
    public int getSecondNum() {
        return secondNum;
    }
}
