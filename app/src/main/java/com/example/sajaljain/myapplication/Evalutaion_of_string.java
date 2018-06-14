package com.example.sajaljain.myapplication;

import android.util.Pair;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Sajal jain on 6/6/2018.
 */

public class Evalutaion_of_string {

    static HashMap<Pair<String,String>,Boolean> mm=new HashMap<Pair<String,String> ,Boolean > ();
    static HashMap<String,Integer> tokens=new HashMap<String,Integer> ();
    static HashMap<String,Integer> trignometric_sign=new HashMap<String,Integer>();
    static String e="2.71828182846";
    static double exp;
    static String wrong_input="INVALID INPUT";

    static String perform(double val1,double val2,String s)
    {
        //  System.out.println(val1+" "+val2+" "+s);

        if(s.charAt(0)=='+')
            return String.valueOf(val1+val2);
        if(s.charAt(0)=='-')
            return String.valueOf(val1-val2);
        if(s.charAt(0)=='*')
            return String.valueOf(val1*val2);
        //System.out.println(val1+" "+val2);
        if(s.charAt(0)=='/')
            return String.valueOf(val1/val2);
        if(s.charAt(0)=='^')
            return String.valueOf( Math.pow(val1,val2) );
        if(s.charAt(0)=='@')
            return String.valueOf(val1*val2);
        return wrong_input;
    }
    static  double change(String s1,String s)
    {
        double val=Double.parseDouble(s1);
        if(s.charAt(0)=='-')
            val*=(-1);

        return (val);
    }
    static boolean priority(String s1,String s2)
    {
        return mm.get(new Pair<String,String> (s1,s2));
    }
    public static ArrayList<String> unaryminus(ArrayList<String> v)
    {
        ArrayList<String> v1 = new ArrayList<String>();
        for (int i = 0; i < v.size(); i++) {
            if (i <=v.size() - 2 && v.get(i).compareTo("(") == 0 && (v.get(i + 1).compareTo("-") == 0 || v.get(i + 1).compareTo("+") == 0)) {
                v1.add("(");
                if(v.get(i+1).compareTo("-")==0)
                {
                    v1.add("-1");
                    v1.add("*");

                }
                i++;

            } else
                v1.add(v.get(i));
        }
        return v1;
    }
    public static ArrayList<String> exponentialconvert(ArrayList<String> lexeme)
    {
        for(int i=0;i<lexeme.size();i++)
            if(lexeme.get(i).compareTo("e")==0)
                lexeme.set(i,e);
        return lexeme;
    }
    public static void trignometric_converion(ArrayList<String> lexeme)
    {
        for(int i=0;i<lexeme.size();i++)
        {
            if(trignometric_sign.get(lexeme.get(i))!=null&&trignometric_sign.get(lexeme.get(i))!=11)
            {
                lexeme.add(i,"1");
                lexeme.add(i+1,"@");
                i+=2;
            }
        }
    }
    public static void postfixexpression(ArrayList<String> postfixexp,ArrayList<String> lexeme)
    {
        Stack<String> stack=new Stack<String> ();

        for(int i=0;i<lexeme.size();i++ )
        {
            if(tokens.get(lexeme.get(i))!=null)
            {
                while(priority(stack.peek(),lexeme.get(i))==true)
                {
                    postfixexp.add(stack.peek());
                    stack.pop();
                }
                stack.push(lexeme.get(i));
            }
            else if(lexeme.get(i).compareTo("(")==0)
            {
                stack.push(lexeme.get(i));
            }
            else if(lexeme.get(i).compareTo(")")==0)
            {
                while(stack.peek().compareTo("(")!=0)
                {
                    postfixexp.add(stack.peek());
                    stack.pop();
                }
                stack.pop();
            }
            else
                postfixexp.add(lexeme.get(i));

            // System.out.println(postfixexp);
            // System.out.println(stack);
        }
    }
    public static long factorial(double n)
    {
        long ans=1;
        for(long i = 2; i<=(long) n; i++)
            ans*=i;
        return ans;
    }
    public static double trignometric_value(int id,double value)
    {
        if(horizontal.radian==1&&id>=1&&id<=6)
        {
            value=(value*11)/630;
        }
        if(id==1)
            return Math.sin(value);
        else if(id==2)
            return Math.cos(value);
        else if(id==3)
            return Math.tan(value);
        else if(id==4)
            return Math.asin(value);
        else if(id==5)
            return Math.acos(value);
        else if(id==6)
            return Math.atan(value);
        else if(id==7)
             return Math.log(value);
        else if(id==8)
        {
            if(exp!=1)
                return Math.log(value)/Math.log(exp);
            else
            {
                return Math.log(value);
            }
        }
        else if(id==9)
        return Math.abs(value);
        else if(id==10)
            return Math.sqrt(value);
       // else if(id==11)
            return (double)factorial(value);



    }

    public static String evaluationofpostfixexpression(ArrayList<String> postfixexp)
    {
        System.out.println(postfixexp);
        Stack<String> stack=new Stack<String>();
        for(int i=0;i<postfixexp.size();i++)
        {
            if(tokens.get(postfixexp.get(i))==null)
            {

                if(trignometric_sign.get(postfixexp.get(i))!=null&&trignometric_sign.get(postfixexp.get(i))==11)
                {
                    System.out.println("sajal");
                    try {
                        double temp1 = Double.valueOf(stack.peek());
                        stack.pop();
                        stack.push(String.valueOf(trignometric_value(11, temp1)));
                    }
                    catch (Exception e)
                    {
                        return wrong_input;
                    }
                }
                else
                stack.push(postfixexp.get(i));
            }
            else
            {
                String operator=postfixexp.get(i);
                try {
                    double temp1 = Double.valueOf(stack.peek());
                    stack.pop();
                    while (trignometric_sign.get(stack.peek()) != null) {
                        int id = trignometric_sign.get(stack.peek());
                        temp1 = trignometric_value(id, temp1);
                        stack.pop();

                    }
                    double temp2 = Double.valueOf(stack.peek());

                    stack.pop();
                    System.out.println(temp2 + " " + temp1 + " " + perform(temp2, temp1, operator) + " ");
                    stack.push(perform(temp2, temp1, operator));
                }catch (Exception e)
                {
                    return wrong_input;
                }
            }
            System.out.println(stack);
        }

            if(stack.size()<=1)
            return (stack.peek());
            else return wrong_input;



    }

    public static String evaluate(StringBuilder  s)
    {
        {
            mm.put(new Pair<String,String> ("-","-"),true);
            mm.put(new Pair<String,String> ("+","+"),true);
            mm.put(new Pair<String,String> ("/","/"),true);
            mm.put(new Pair<String,String> ("*","*"),true);
            mm.put(new Pair<String,String> ("^","^"),true);

            mm.put(new Pair<String,String> ("^","+"),true);
            mm.put(new Pair<String,String> ("^","/"),true);
            mm.put(new Pair<String,String> ("^","*"),true);
            mm.put(new Pair<String,String> ("^","-"),true);
            mm.put(new Pair<String,String> ("-","^"),false);
            mm.put(new Pair<String,String> ("+","^"),false);
            mm.put(new Pair<String,String> ("/","^"),false);
            mm.put(new Pair<String,String> ("*","^"),false);

            mm.put(new Pair<String,String> ("+","*"),false);
            mm.put(new Pair<String,String> ("*","+"),true);
            mm.put(new Pair<String,String> ("*","-"),true);
            mm.put(new Pair<String,String> ("+","-"),true);
            mm.put(new Pair<String,String> ("-","+"),true);
            mm.put(new Pair<String,String> ("+","/"),false);
            mm.put(new Pair<String,String> ("/","+"),true);
            mm.put(new Pair<String,String> ("-","*"),false);
            mm.put(new Pair<String,String> ("-","/"),false);
            mm.put(new Pair<String,String> ("/","-"),true);
            mm.put(new Pair<String,String> ("*","/"),false);
            mm.put(new Pair<String,String> ("/","*"),true);

            mm.put(new Pair<String,String> ("(","*"),false);
            mm.put(new Pair<String,String> ("(","+"),false);
            mm.put(new Pair<String,String> ("(","/"),false);
            mm.put(new Pair<String,String> ("(","-"),false);
            mm.put(new Pair<String,String> ("(","^"),false);
            mm.put(new Pair<String,String> ("(","@"),false);

            mm.put(new Pair<String,String> ("@","*"),true);
            mm.put(new Pair<String,String> ("@","+"),true);
            mm.put(new Pair<String,String> ("@","/"),true);
            mm.put(new Pair<String,String> ("@","-"),true);
            mm.put(new Pair<String,String> ("@","!"),true);
            mm.put(new Pair<String,String> ("@","@"),true);
            mm.put(new Pair<String,String> ("-","@"),false);
            mm.put(new Pair<String,String> ("+","@"),false);
            mm.put(new Pair<String,String> ("/","@"),false);
            mm.put(new Pair<String,String> ("*","@"),false);
            mm.put(new Pair<String,String> ("^","@"),false);
            mm.put(new Pair<String,String> ("!","@"),false);
            mm.put(new Pair<String,String> ("@","^"),true);

           /* mm.put(new Pair<String,String> ("!","*"),true);
            mm.put(new Pair<String,String> ("!","+"),true);
            mm.put(new Pair<String,String> ("!","/"),true);
            mm.put(new Pair<String,String> ("!","-"),true);
            mm.put(new Pair<String,String> ("!","!"),true);
            mm.put(new Pair<String,String> ("-","!"),false);
            mm.put(new Pair<String,String> ("+","!"),false);
            mm.put(new Pair<String,String> ("/","!"),false);
            mm.put(new Pair<String,String> ("*","!"),false);
            mm.put(new Pair<String,String> ("^","!"),false);
            mm.put(new Pair<String,String> ("!","^"),true);
            */
        }
        {
            tokens.put("+",1);
            tokens.put("*",1);
            tokens.put("-",1);
            tokens.put("+",1);
            tokens.put("/",1);
            tokens.put("^",1);
            tokens.put("@",1);

        }
        {
            trignometric_sign.put("sin",1);
            trignometric_sign.put("cos",2);
            trignometric_sign.put("tan",3);
            trignometric_sign.put("arctan",6);
            trignometric_sign.put("arcsin",4);
            trignometric_sign.put("arccos",5);
            trignometric_sign.put("log",7);
            trignometric_sign.put("ln",8);
            trignometric_sign.put("abs",9);
            trignometric_sign.put("sqrt",10);
            trignometric_sign.put("!",11);
            //trignometric_sign.put("",1);
            //trignometric_sign.put("sin",1);

        }


        //  System.out.println(Math.tan(22/14));



        exp=2.71828182846;
         s.insert(0,"( ");
        s.insert(s.length()," )");

        ArrayList<String> lexeme=new ArrayList<String> ();
        Token_splitter split=new Token_splitter();
        split.solve(s,lexeme);
        s.deleteCharAt(0);
        s.deleteCharAt(s.length()-1);
        System.out.println(lexeme);

        if(lexeme.get(0).compareTo(wrong_input)==0)
            return lexeme.get(0);
        lexeme=unaryminus(lexeme);
        lexeme=exponentialconvert(lexeme);
        trignometric_converion(lexeme);

        System.out.println(lexeme);
        ArrayList<String> postfixexp=new ArrayList<String> ();
        postfixexpression(postfixexp,lexeme);
        System.out.println(postfixexp);

        try {
            double ans = Double.valueOf(evaluationofpostfixexpression(postfixexp));
            DecimalFormat obj = new DecimalFormat("#.######");

            System.out.println(obj.format((double) ans));

            return String.valueOf(obj.format((double) ans));
        }
        catch (Exception e)
        {
            return wrong_input;
        }


        //

        //if(!stck2.isEmpty())

        //System.out.println(obj.format(Double.parseDouble(stck2.peek()))  );

        //

    }
}

