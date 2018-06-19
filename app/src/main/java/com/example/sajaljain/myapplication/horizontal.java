package com.example.sajaljain.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class horizontal extends AppCompatActivity {


    static final String TAG="sajal_activity2";
    public static int inverse_var=0,radian=0,event_fire=0;

    public static int unary_operator=0;
    public static char[] ch={'+','-','*','^','/'};
    static final Token_splitter token_splitter=new Token_splitter();

    static public void previous_anw()
    {


    }
    static public String previous_lexeme(String s)
    {
        int sz=s.length(),point=0;
        String temp="";
        for(int i=sz-1;i>=0;i--)
        {
            if(token_splitter.check(s.charAt(i))==true)
            {
                temp+=s.charAt(i);
                if(s.charAt(i)=='.')
                    point++;
            }
            else break;
        }
        System.out.println(point+" "+temp);
        if(temp.isEmpty()==true)
            return "0.";
        else if(point==0)
            return ".";


        return "";
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);

        View objj=getLayoutInflater().inflate(R.layout.activity_horizontal,null);


        Button button11 = (Button) findViewById(R.id.button11);
        final Button button22 = (Button) findViewById(R.id.button22);
        final Button button32 = (Button) findViewById(R.id.button32);
        final Button button42 = (Button) findViewById(R.id.button42);
        final TextView textView= (TextView) findViewById(R.id.et2);
        final EditText editText= (EditText)findViewById(R.id.et1);
        final Eraser eraser=new Eraser();


        button11.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);
                        if(inverse_var==0)
                        {
                            button22.setText("invsin");
                            button32.setText("invcos");
                            button42.setText("invtan");
                            inverse_var^=1;
                        }
                        else
                        {
                            button22.setText("sin");
                            button32.setText("cos");
                            button42.setText("tan");
                            inverse_var^=1;
                        }

                       // view.setText(view.getText() + "1");
                    }
                });
        Button button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "!");
                    }
                });
        /*
        Button button13 = (Button) findViewById(R.id.button13);

                 button13.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + " ");
                    }
                });
        */
        Button button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        TextView  view = (TextView)findViewById(R.id.et1);
                        if(view.getText().toString().isEmpty()==false) {

                            Eraser del = new Eraser();
                            view.setText(del.solve(view.getText().toString()));
                        }

                    }
                });
        button14.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v)
                    {
                        TextView view =(TextView)findViewById(R.id.et1);
                        TextView view2=(TextView) findViewById(R.id.et2);
                        view.setText("");
                        view2.setText("");

                        return true;
                    }

                }
        );
        Button button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "(");
                    }
                });
        Button button16 = (Button) findViewById(R.id.button16);
        button16.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + ")");
                    }
                });
        Button button17 = (Button) findViewById(R.id.button17);
        button17.setOnClickListener(
                new Button.OnClickListener() {
                    public void  onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        String temp=view.getText().toString();
                        int sz=temp.length(),b0=0,b1=0;
                        for(int i=0;i<ch.length;i++)
                        if(sz-1>=0&&temp.charAt(sz-1)==ch[i]) {
                           b0=1;
                           break;
                        }
                        if(b0==1)
                        { view.setText( eraser.solve(view.getText().toString())+"+");
                        }
                        else {
                            view.setText( (view.getText())+"+");
                        }

                    }
                });
        // -----------------------------------------------------------------------------------------------------------------------

        final Button button21 = (Button) findViewById(R.id.button21);

        button21.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        radian^=1;
                        if(radian==1)
                            button21.setText("degree");
                        else
                            button21.setText("radian");



                    }
                });

        button22.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        if(inverse_var==0)
                        view.setText(view.getText() + "sin(");
                        else
                            view.setText(view.getText()+"arcsin(");
                    }
                });
        Button button23 = (Button) findViewById(R.id.button23);
        button23.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "ln(");
                    }
                });
        Button button24 = (Button) findViewById(R.id.button24);
        button24.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "7");
                    }
                });
        Button button25 = (Button) findViewById(R.id.button25);
        button25.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "8");
                    }
                });
        Button button26 = (Button) findViewById(R.id.button26);
        button26.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "9");
                    }
                });
        Button button27 = (Button) findViewById(R.id.button27);
        button27.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        String temp=view.getText().toString();
                        int sz=temp.length(),b0=0,b1=0;
                        for(int i=0;i<ch.length;i++)
                            if(sz-1>=0&&temp.charAt(sz-1)==ch[i]) {
                                b0=1;
                                break;
                            }
                        if(b0==1)
                        { view.setText( eraser.solve(view.getText().toString())+"-");
                        }
                        else {
                            view.setText( (view.getText())+"-");
                        }
                    }
                });

        //--------------------------------------------------------------------------------------------------------------------------
        Button button31 = (Button) findViewById(R.id.button31);
        button31.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "pi");
                    }
                });
        button32.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);
                        if(inverse_var==0)
                            view.setText(view.getText() + "cos(");
                        else
                            view.setText(view.getText()+"arccos(");
                    }
                });
        Button button33 = (Button) findViewById(R.id.button33);
        button33.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "log(");
                    }
                });
        Button button34 = (Button) findViewById(R.id.button34);
        button34.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "4");
                    }
                });
        Button button35 = (Button) findViewById(R.id.button35);
        button35.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "5");
                    }
                });
        Button button36 = (Button) findViewById(R.id.button36);
        button36.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "6");
                    }
                });
        final Button button37 = (Button) findViewById(R.id.button37);
        button37.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        String temp=view.getText().toString();
                        int sz=temp.length(),b0=0,b1=0;
                        for(int i=0;i<ch.length;i++)
                            if(sz-1>=0&&temp.charAt(sz-1)==ch[i]) {
                                b0=1;
                                break;
                            }
                        if(b0==1)
                        { view.setText( eraser.solve(view.getText().toString()));
                           onClick(button37);
                        }
                        else {
                           if(sz-1>=0)
                               view.setText(temp+"*");
                        }
                    }
                });
        //--------------------------------------------------------------------------------------------------------------------------
        Button button41 = (Button) findViewById(R.id.button41);
        button41.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "e");
                    }
                });
        button42.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        if(inverse_var==0)
                            view.setText(view.getText() + "tan(");
                        else
                            view.setText(view.getText()+"arctan(");
                    }
                });
        Button button43 = (Button) findViewById(R.id.button43);
        button43.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                       view.setText(view.getText() + "sqrt(");
                    }
                });
        Button button44 = (Button) findViewById(R.id.button44);
        button44.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "1");
                    }
                });
        Button button45 = (Button) findViewById(R.id.button45);
        button45.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "2");
                    }
                });
        Button button46 = (Button) findViewById(R.id.button46);
        button46.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "3");
                    }
                });
        Button button47 = (Button) findViewById(R.id.button47);
        button47.setOnClickListener(
                new Button.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        String temp=view.getText().toString();
                        int sz=temp.length(),b0=0,b1=0;
                        for(int i=0;i<ch.length;i++)
                            if(sz-1>=0&&temp.charAt(sz-1)==ch[i]) {
                                b0=1;
                                break;
                            }
                        if(b0==1)
                        { view.setText( eraser.solve(view.getText().toString())+"/");
                        }
                        else {
                            if(sz-1>=0)
                                view.setText(temp+"/");
                        }
                    }
                });
        //---------------------------------------------------------------------------------------------------------------------------
        Button button51 = (Button) findViewById(R.id.button51);
        button51.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "abs(");
                    }
                });
        Button button52 = (Button) findViewById(R.id.button52);
        button52.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                       // view.setText(view.getText() + "1");
                    }
                });
        Button button53 = (Button) findViewById(R.id.button53);
        button53.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "^(");
                    }
                });
        Button button54 = (Button) findViewById(R.id.button54);
        button54.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);

                        view.setText(view.getText() + "0");
                    }
                });
        Button button55 = (Button) findViewById(R.id.button55);
        button55.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);



                        view.setText(view.getText() + previous_lexeme(view.getText().toString()));
                    }
                });
        Button button56 = (Button) findViewById(R.id.button56);
        button56.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView view = (TextView) findViewById(R.id.et1);
                        if(unary_operator==0)
                        {
                            //unary_operator^=1;
                            view.setText(view.getText()+"( -");
                        }
                        else
                        {

                        }

                      //  view.setText(view.getText() + "1");
                    }
                });
        Button button57 = (Button) findViewById(R.id.button57);
        button57.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {


                        event_fire=1;
                        TextView view1 = (TextView) findViewById(R.id.et1);
                        TextView view2=(TextView) findViewById(R.id.et2);
                        Evalutaion_of_string obj=new Evalutaion_of_string();

                        StringBuilder input=new StringBuilder(view1.getText().toString()) ;
                        view1.setText(obj.evaluate(input) );
                        view2.setText("  "+input);

                    }
                });




    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.overflowmenu2,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //EVENTENDANDLING OF MENUFLOW BAR
    public boolean onOptionsItemSelected(MenuItem item) {
        int value = item.getItemId();
        switch (value) {
            case R.id.calci1: {
                //CALLING SCIENCTIFIC CALCI ACTIVITY
                Toast.makeText(this,"hello",Toast.LENGTH_LONG);
                Intent temp=new Intent(horizontal.this,MainActivity.class);
                startActivity(temp);
                break;
            }

        }
        return super.onOptionsItemSelected(item);
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
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        super.onResume();
    }
}
