package com.hacktiv.mechanicalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvCurrentCalculation, tvResult;
    private Button btnDot,btnAllClear,btnPercent,btnBagi,btnKali,btnMin,btnPlus, btnEqual,btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    private ImageButton btnBackspace;
    private final ArrayList<Calculation> calculationList = new ArrayList<Calculation>();
    private boolean finalized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCurrentCalculation = findViewById(R.id.tvCalculation);
        tvResult = findViewById(R.id.tvResult);
        btnDot = findViewById(R.id.btnDot);
        btnAllClear = findViewById(R.id.btnAllClear);
        btnBackspace = findViewById(R.id.btnBackspace);
        btnPercent = findViewById(R.id.btnPercent);
        btnBagi = findViewById(R.id.btnBagi);
        btnKali = findViewById(R.id.btnKali);
        btnMin = findViewById(R.id.btnMin);
        btnPlus = findViewById(R.id.btnPlus);
        btnEqual = findViewById(R.id.btnEqual);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tvCurrentCalculation.getText().equals("0"))
                    onNumPressed(((Button) v).getText().toString());
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumPressed(((Button) v).getText().toString());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumPressed(((Button) v).getText().toString());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumPressed(((Button) v).getText().toString());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumPressed(((Button) v).getText().toString());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumPressed(((Button) v).getText().toString());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumPressed(((Button) v).getText().toString());
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumPressed(((Button) v).getText().toString());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumPressed(((Button) v).getText().toString());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumPressed(((Button) v).getText().toString());
            }
        });

        btnAllClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tvCurrentCalculation.getText().equals("0")) {
                    calculationList.remove(calculationList.size()-1);
                    tvCurrentCalculation.setText("0");
                    tvCurrentCalculation.setTextSize(50);
                    tvCurrentCalculation.setTextColor(getResources().getColor(R.color.black, null));
                    tvResult.setTextSize(35);
                    tvResult.setTextColor(getResources().getColor(R.color.blackLight, null));
                    tvResult.setVisibility(View.GONE);
                    finalized = false;
                }
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(finalized) {
                    calculationList.add(new Calculation("."));
                    showCurrentCalc();

                    tvCurrentCalculation.setTextSize(50);
                    tvCurrentCalculation.setTextColor(getResources().getColor(R.color.black, null));
                    tvResult.setTextSize(35);
                    tvResult.setTextColor(getResources().getColor(R.color.blackLight, null));
                    finalized = false;
                } else {
                    if (tvCurrentCalculation.getText().equals("0")) {
                        calculationList.add(new Calculation("."));
                        tvResult.setVisibility(View.VISIBLE);
                    } else {
                        calculationList.get(calculationList.size() - 1).addDot();
                    }
                    showCurrentCalc();
                }
            }
        });
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!finalized) {
                    if (!tvCurrentCalculation.getText().equals("0")) {
                        calculationList.get(calculationList.size() - 1).backspace();
                        if (calculationList.get(calculationList.size() - 1).getCalculationStr().equals("")) {
                            calculationList.remove(calculationList.size() - 1);
                            tvCurrentCalculation.setText("0");
                            tvResult.setVisibility(View.GONE);
                        } else
                            showCurrentCalc();
                    }
                }
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(finalized) {
                    String prevResult = tvResult.getText().toString();
                    Double percentaged = Double.parseDouble(prevResult) * 0.01;
                    calculationList.add(new Calculation(String.valueOf(percentaged)));
                    showCurrentCalc();

                    tvCurrentCalculation.setTextSize(50);
                    tvCurrentCalculation.setTextColor(getResources().getColor(R.color.black, null));
                    tvResult.setTextSize(35);
                    tvResult.setTextColor(getResources().getColor(R.color.blackLight, null));
                    finalized = false;
                } else {
                    if (!tvCurrentCalculation.getText().equals("0")) {
                        calculationList.get(calculationList.size() - 1).onPercentPressed();
                        showCurrentCalc();
                    }
                }
            }
        });
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorPressed(((Button)v).getText().toString());
            }
        });
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorPressed(((Button)v).getText().toString());
            }
        });
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorPressed(((Button)v).getText().toString());
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorPressed(((Button)v).getText().toString());
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvCurrentCalculation.setTextSize(35);
                tvCurrentCalculation.setTextColor(getResources().getColor(R.color.blackLight, null));
                tvResult.setTextSize(50);
                tvResult.setTextColor(getResources().getColor(R.color.black, null));
                finalized = true;
            }
        });
    }

    void onNumPressed(String text) {
        if(finalized) {
            calculationList.add(new Calculation(text));
            showCurrentCalc();
            tvCurrentCalculation.setTextSize(50);
            tvCurrentCalculation.setTextColor(getResources().getColor(R.color.black, null));
            tvResult.setTextSize(35);
            tvResult.setTextColor(getResources().getColor(R.color.blackLight, null));
            finalized = false;
        } else {
            if (tvCurrentCalculation.getText().equals("0")) {
                calculationList.add(new Calculation(text));
                tvResult.setVisibility(View.VISIBLE);
            } else {
                calculationList.get(calculationList.size() - 1).addNumber(text);
            }
            showCurrentCalc();
        }
    }

    void onOperatorPressed(String text) {
        if(finalized) {
            String prevResult = tvResult.getText().toString();
            calculationList.add(new Calculation(prevResult.concat(text)));
            showCurrentCalc();

            tvCurrentCalculation.setTextSize(50);
            tvCurrentCalculation.setTextColor(getResources().getColor(R.color.black, null));
            tvResult.setTextSize(35);
            tvResult.setTextColor(getResources().getColor(R.color.blackLight, null));
            finalized = false;
        } else {
            if (tvCurrentCalculation.getText().equals("0")) {
                calculationList.add(new Calculation(text));
                tvResult.setVisibility(View.VISIBLE);
            } else {
                calculationList.get(calculationList.size() - 1).addOperator(text);
            }
            showCurrentCalc();
        }
    }

    void showCurrentCalc() {
        tvCurrentCalculation.setText(calculationList.get(calculationList.size()-1).getCalculationStr());
        Double result = calculationList.get(calculationList.size()-1).getResult();
        if(result%1 == 0)
            tvResult.setText(String.valueOf(result));
        else {
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(8);
            tvResult.setText(df.format(result));
        }
    }
}