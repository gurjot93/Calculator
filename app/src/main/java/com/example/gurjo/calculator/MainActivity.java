package com.example.gurjo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Creating Buttons
    Button b_mc,b_mplus,b_mminus,b_mr,b_clear,b_plusminus,b_divide,b_multiply,b_one,b_two,b_three,b_four,b_five,b_six,b_seven,b_eight,b_nine,b_zero,b_plus,b_minus,b_equal,b_point;
    //TextView to display results
    TextView t_result;
    double a=0,b=0,result=0,plusminus;      //variables to store data for computation
    double memory_cal=0;                    //local memory
    boolean plus,divide,multiply,minus;     //booleans to store the particular operation
    String decimal,last_clicked,limit_data_string;  //to store the particular operation
    double limit_data;
    int count_digits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casting of all the buttons
        b_mc=(Button) findViewById(R.id.mc);
        b_mplus=(Button) findViewById(R.id.mplus);
        b_mminus=(Button) findViewById(R.id.mminus);
        b_mr=(Button) findViewById(R.id.mr);
        b_clear=(Button) findViewById(R.id.clear);
        b_plusminus=(Button) findViewById(R.id.plusminus);
        b_divide=(Button) findViewById(R.id.divide);
        b_multiply=(Button) findViewById(R.id.multiply);
        b_plus=(Button) findViewById(R.id.add);
        b_minus=(Button) findViewById(R.id.subtract);
        b_equal=(Button) findViewById(R.id.equal);
        b_point=(Button) findViewById(R.id.point);
        b_zero=(Button) findViewById(R.id.zero);
        b_one=(Button) findViewById(R.id.one);
        b_two=(Button) findViewById(R.id.two);
        b_three=(Button) findViewById(R.id.three);
        b_four=(Button) findViewById(R.id.four);
        b_five=(Button) findViewById(R.id.five);
        b_six=(Button) findViewById(R.id.six);
        b_seven=(Button) findViewById(R.id.seven);
        b_eight=(Button) findViewById(R.id.eight);
        b_nine=(Button) findViewById(R.id.nine);

        //casting fo textview Result
        t_result=(TextView) findViewById(R.id.result);

        //creating onclicklistener for 0 digit
        b_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limit_digit_display()) {
                    setClickedTrue();
                    display_digit("0");
                    last_clicked = " ";
                    b_plus.setEnabled(true);
                }
            }
        });
        //onclicklistener for button 1
        b_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limit_digit_display()) {
                    setClickedTrue();
                    display_digit("1");
                    last_clicked = " ";
                }
            }
        });
        //onclicklistener for button 2
        b_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limit_digit_display()) {
                    setClickedTrue();
                    display_digit("2");
                    last_clicked = " ";
                }
            }
        });
        //onclicklistener for button 3
        b_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limit_digit_display()) {
                    setClickedTrue();
                    display_digit("3");
                    last_clicked = " ";
                }
            }
        });
        //onclicklistener for button 4
        b_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limit_digit_display()) {
                    setClickedTrue();
                    display_digit("4");
                    last_clicked = " ";
                }
            }
        });
        //onclicklistener for button 5
        b_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limit_digit_display()) {
                    setClickedTrue();
                    display_digit("5");
                    last_clicked = " ";
                }
            }
        });
        //onclicklistener for button 6
        b_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limit_digit_display()) {
                    setClickedTrue();
                    display_digit("6");
                    last_clicked = " ";
                }
            }
        });
        //onclicklistener for button 7
        b_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limit_digit_display()){
                    setClickedTrue();
                    display_digit("7");
                    last_clicked=" ";
                }
            }
        });
        //onclicklistener for button 8
        b_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limit_digit_display()) {
                    setClickedTrue();
                    display_digit("8");
                    last_clicked = " ";
                }
            }
        });
        //onclicklistener for button 9
        b_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (limit_digit_display()) {
                    setClickedTrue();
                    display_digit("9");
                    last_clicked = " ";
                }
            }
        });

        //to add decimal at the end
        b_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decimal=(t_result.getText()+"");
                if(decimal.contains("."))
                {
                    //decimal already added
                    t_result.setText(decimal);
                }
                else
                {
                    t_result.setText(decimal+".");
                }

            }
        });
        //onclicklistener for toggle button
        b_plusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                plusminus=Double.parseDouble(t_result.getText()+"");
                t_result.setText(plusminus*(-1)+"");


            }
        });

        //Functianility for addition
        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last_clicked="+";
                setClickedFalse();
                b=Double.parseDouble(t_result.getText()+"");
                result=b;
                Calculator();
                a=Double.parseDouble(t_result.getText()+"");
                plus=true;

                t_result.setText(result+"");


            }
        });

        //Functianility for subtract
        b_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickedFalse();
                last_clicked="-";
                b=Double.parseDouble(t_result.getText()+"");

                result=b;
                Calculator();
                a=Double.parseDouble(t_result.getText()+"");
                minus=true;
                t_result.setText(result+"");
            }
        });

        //Functianility for divide
        b_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickedFalse();
                last_clicked="/";
                b=Double.parseDouble(t_result.getText()+"");

                result=b;
                Calculator();
                a=Double.parseDouble(t_result.getText()+"");
                divide=true;
                t_result.setText(result+"");
            }
        });

        //Functianility for multiply
        b_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickedFalse();
                last_clicked="*";
                b=Double.parseDouble(t_result.getText()+"");

                result=b;
                Calculator();
                a=Double.parseDouble(t_result.getText()+"");
                multiply=true;
                t_result.setText(result+"");
            }
        });

        //Functianility for clear button
        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator_clear();
            }
        });

        //to generate result
        b_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last_clicked="=";
                b=Double.parseDouble(t_result.getText()+"");

                Calculator();
            }
        });
        //Functionality for Memory Clear
        b_mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last_clicked="mc";
                memory_clear();
                //calculator_clear();
            }
        });
        //Functionality for Memory Plus
        b_mplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory_plus();
            }
        });

        //Functionality for Memory Subtract
        b_mminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memory_minus();
            }
        });

        //Functionality for Memory Display
        b_mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t_result.setText(memory_cal+"");
            }
        });
    }
    //to disable buttons +,-,/,* during a particular operation
    private void setClickedFalse()
    {
        b_plus.setClickable(false);
        b_minus.setClickable(false);
        b_divide.setClickable(false);
        b_multiply.setClickable(false);
    }

    //to enable buttons +,-,/,* after a particular operation
    private void setClickedTrue()
    {
        b_plus.setClickable(true);
        b_minus.setClickable(true);
        b_divide.setClickable(true);
        b_multiply.setClickable(true);
    }

    //Function for Clear
    private void calculator_clear()
    {
        result=0;
        last_clicked="clear";
        t_result.setText(result+"");
        a=0;
        b=0;
        plus=false;
        divide=false;
        multiply=false;
        minus=false;
    }

    //Function to perform all the calculations
    private void Calculator()
    {
        try {
            if (plus == true) {
                result = a + b;
                t_result.setText(a + b + "");
                plus = false;

            }
            if (minus == true) {
                result = a - b;
                t_result.setText(a - b + "");
                minus = false;

            }
            if (divide == true) {

                result = a / b;

                t_result.setText(a / b + "");
                divide = false;

            }
            if (multiply == true) {
                result = a * b;
                t_result.setText(a * b + "");
                multiply = false;

            }
        }
        catch (ArithmeticException e)
        {
            t_result.setText(e.toString()+"");
        }
    }

    //function to use buttons 0-9
    private void display_digit(String digit)
    {
        if(last_clicked=="=" || last_clicked=="+" || last_clicked=="-" || last_clicked=="/" || last_clicked=="*"|| last_clicked=="mc" || last_clicked=="clear")
        {
            t_result.setText(digit);
        }
        else
        {
            t_result.setText(t_result.getText() + digit);
        }
    }

    //function for memory add
    private void memory_plus()
    {

        memory_cal+=Double.parseDouble(t_result.getText()+"");


    }

    //function for memory subtract
    private void memory_minus()
    {

        memory_cal=memory_cal-Double.parseDouble(t_result.getText()+"");

    }
    //to clear the memory
    private void memory_clear()
    {
        memory_cal=0;
        //t_result.setText(memory_cal+"");
    }

    // function for 10-digit display
    private boolean limit_digit_display()
    {
        count_digits=0;
        limit_data_string=t_result.getText()+"";

        for (int i=0; i < limit_data_string.length(); i++)
        {
            if(Character.isDigit(limit_data_string.charAt(i)))
            {
                count_digits+=1;
            }
        }
        //digits increased by 10
        if(count_digits>=10)
        {
            return false;
        }
        //digits less than 10
        else
        {
            return true;
        }
    }
}
