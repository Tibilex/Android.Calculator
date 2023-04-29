package com.example.calculatorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView solutionField, resultFiled;
    String operator = "", firstNumber = "", result = "";
    boolean resultCheck = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solutionField = findViewById(R.id.inputField);
        resultFiled = findViewById(R.id.resultField);
    }

    public void numberClickEvent(View view) {
        if(resultCheck){
            solutionField.setText("");
        }
        resultCheck = false;

        String solutionNumber = solutionField.getText().toString();

        switch (view.getId()){
            case R.id.zeroBtn:
                solutionNumber += "0";
                break;
            case R.id.oneBtn:
                solutionNumber += "1";
                break;
            case R.id.twoBtn:
                solutionNumber += "2";
                break;
            case R.id.threeBtn:
                solutionNumber += "3";
                break;
            case R.id.fourBtn:
                solutionNumber += "4";
                break;
            case R.id.fiveBtn:
                solutionNumber += "5";
                break;
            case R.id.sixBtn:
                solutionNumber += "6";
                break;
            case R.id.sevenBtn:
                solutionNumber += "7";
                break;
            case R.id.eightBtn:
                solutionNumber += "8";
                break;
            case R.id.nineBtn:
                solutionNumber += "9";
                break;
            case R.id.plusMinusBtn:
                solutionNumber = "-" + solutionNumber;
                break;
            case R.id.dotBtn:
                solutionNumber += ".";
                break;
        }

        solutionField.setText(solutionNumber);
    }

    public void operatorClickEvent(View view) {
        resultCheck = true;
        firstNumber = solutionField.getText().toString();

        switch (view.getId()){
            case R.id.minusBtn:
                operator = "-";
                break;
            case R.id.plusBtn:
                operator = "+";
                break;
            case R.id.divideBtn:
                operator = "/";
                break;
            case R.id.multiplyBtn:
                operator = "x";
                break;
            case R.id.percentBtn:
                operator = "%";
                break;
            case R.id.clearBtn:
                solutionField.setText("");
                resultFiled.setText("0");
                resultCheck = true;
                break;
        }
    }

    public void equalsEventClick(View view){
        String secondNumber = solutionField.getText().toString();
        double result = 0.0;
        switch (operator) {
            case "+":
                result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                break;
            case "-":
                result = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                break;
            case "/":
                if (secondNumber.equals("0")) {
                    Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_SHORT).show();
                    break;
                }
                result = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                break;
            case "x":
                result = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                break;
            case "%":
                result = (Double.parseDouble(firstNumber) / 100) * Double.parseDouble(secondNumber);
                resultCheck = true;
                break;
        }
            if (solutionField.equals("") && resultFiled.equals("0")){
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
                return;
            }
            resultFiled.setText(result + "");
    }

}