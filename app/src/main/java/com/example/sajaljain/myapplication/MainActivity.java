package com.example.sajaljain.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    static final String TAG = "sajal_activity";
    static public int count = 0;
    public static char[] ch = {'+', '-', '*', '^', '/'};
    final Eraser eraser = new Eraser();
    final Token_splitter token_splitter = new Token_splitter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");


        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        view.setText(view.getText() + "1");
                    }
                });
       /* button1.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v)
                    {
                        TextView view =(TextView)findViewById(R.id.et);
                        view.setText(view.getText()+" sin");
                        return true;
                    }

                }
        );
        */
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        view.setText(view.getText() + "2");
                    }
                });
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);

                        view.setText(view.getText() + "3");
                    }
                });
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        view.setText(view.getText() + "4");
                    }
                });
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        view.setText(view.getText() + "5");
                    }
                });
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);

                        view.setText(view.getText() + "6");
                    }
                });
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        view.setText(view.getText() + "7");
                    }
                });
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);

                        view.setText(view.getText() + "8");
                    }
                });
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        view.setText(view.getText() + "9");

                    }
                });
        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        view.setText(view.getText() + "0");

                    }
                });
        Button addition = (Button) findViewById(R.id.Addition);
        addition.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        String temp = view.getText().toString();
                        int sz = temp.length(), b0 = 0, b1 = 0;
                        for (int i = 0; i < ch.length; i++)
                            if (sz - 1 >= 0 && temp.charAt(sz - 1) == ch[i]) {
                                b0 = 1;
                                break;
                            }
                        if (b0 == 1) {
                            view.setText(eraser.solve(view.getText().toString()) + "+");
                        } else {
                            view.setText((view.getText()) + "+");
                        }

                    }
                });

        Button point = (Button) findViewById(R.id.point);
        point.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        TextView view = (TextView) findViewById(R.id.et);
                        view.setText(view.getText() + ".");

                    }
                });
        Button substract = (Button) findViewById(R.id.substraction);
        substract.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        String temp = view.getText().toString();
                        int sz = temp.length(), b0 = 0, b1 = 0;
                        for (int i = 0; i < ch.length; i++)
                            if (sz - 1 >= 0 && temp.charAt(sz - 1) == ch[i]) {
                                b0 = 1;
                                break;
                            }
                        if (b0 == 1) {
                            view.setText(eraser.solve(view.getText().toString()) + "-");
                        } else {
                            view.setText((view.getText()) + "-");
                        }
                    }
                });
        Button Erase = (Button) findViewById(R.id.erase);
        TextView view;

        Erase.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        if (view.getText().toString().isEmpty() != true) {
                            Eraser del = new Eraser();
                            view.setText(del.solve(view.getText().toString()));
                        }
                    }
                });
        Button openbracket = (Button) findViewById(R.id.openbracket);
        openbracket.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        view.setText(view.getText() + " (");

                    }
                }
        );
        Button closebracket = (Button) findViewById(R.id.closebracket);
        closebracket.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);

                        view.setText(view.getText() + " )");

                    }
                }
        );

        final Button multiply = (Button) findViewById(R.id.multiply);
        multiply.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        String temp = view.getText().toString();
                        int sz = temp.length(), b0 = 0, b1 = 0;
                        for (int i = 0; i < ch.length; i++)
                            if (sz - 1 >= 0 && temp.charAt(sz - 1) == ch[i]) {
                                b0 = 1;
                                break;
                            }
                        if (b0 == 1) {
                            view.setText(eraser.solve(view.getText().toString()));
                            onClick(multiply);
                        } else {
                            if (sz - 1 >= 0 && token_splitter.check(temp.charAt(sz - 1)) == true)
                                view.setText(temp + "*");
                        }
                    }
                }
        );
        final Button divison = (Button) findViewById(R.id.divsion);
        divison.setOnClickListener(

                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et);
                        String temp = view.getText().toString();
                        int sz = temp.length(), b0 = 0, b1 = 0;
                        for (int i = 0; i < ch.length; i++)
                            if (sz - 1 >= 0 && temp.charAt(sz - 1) == ch[i]) {
                                b0 = 1;
                                break;
                            }
                        if (b0 == 1) {
                            view.setText(eraser.solve(view.getText().toString()));
                            onClick(divison);
                        } else {
                            if (sz - 1 >= 0 && token_splitter.check(temp.charAt(sz - 1)))
                                view.setText(temp + "/");
                        }

                    }
                }
        );


        Button equal = (Button) findViewById(R.id.equal);
        equal.setOnClickListener(

                new Button.OnClickListener() {
                    public void onClick(View v) {
                        EditText text = (EditText) findViewById(R.id.et);
                        StringBuilder stt = new StringBuilder(text.getText().toString() );
                        Evalutaion_of_string obj = new Evalutaion_of_string();
                        String ans = obj.evaluate(stt);
                        // TextView view=(TextView)findViewById(R.id.et);
                        text.setText(ans);
                    }
                }
        );
    }

    //MENUFLOW BAR
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.overflowmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onstart");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "ondestroy");
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onresume");
        super.onResume();
    }

    //EVENTENDANDLING OF MENUFLOW BAR
    public boolean onOptionsItemSelected(MenuItem item) {
        int value = item.getItemId();
        switch (value) {
            case R.id.calci: {
                //CALLING SCIENCTIFIC CALCI ACTIVITY
                Intent temp = new Intent(MainActivity.this, horizontal.class);
                startActivity(temp);
            }

        }
        return super.onOptionsItemSelected(item);
    }


    /*
      public void onClick(View v)

      {
          EditText text=(EditText)findViewById(R.id.et);
          String stt=text.getText().toString();
          Evalutaion_of_string obj=new Evalutaion_of_string();
          String ans=obj.evaluate(stt);
          TextView view=(TextView)findViewById(R.id.et);
          view.setText(ans);




      }
      */


}