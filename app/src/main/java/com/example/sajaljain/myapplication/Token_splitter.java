package com.example.sajaljain.myapplication;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sajal jain on 6/8/2018.
 */

public class Token_splitter {
    public  HashMap<String,Integer> lexeme=new HashMap<String,Integer>();
    public  int Invalid_Input=0;
    public static String wrong_input="INVALID INPUT";
    public  boolean check(char ch)
    {
        if(ch=='.')
            return true ;
        for(int i=0;i<=9;i++)
            if(i==ch-48) {
                return true;
            }
        return false;

    }

    public  void  solve(StringBuilder s,ArrayList<String> v)
    {

        {
            lexeme.put("sin",1);
            lexeme.put("tan",1);
            lexeme.put("cos",1);
            lexeme.put("arcsin",1);
            lexeme.put("arccos",1);
            lexeme.put("arctan",1);
            lexeme.put("log",1);
            lexeme.put("ln",1);
            lexeme.put("abs",1);
            lexeme.put("!",1);
            lexeme.put("+",1);
            lexeme.put("*",1);
            lexeme.put("-",1);
            lexeme.put("/",1);
            lexeme.put("^",1);
            lexeme.put("e",1);
            lexeme.put("(",1);
            lexeme.put(")",1);
            lexeme.put("@",1);
            lexeme.put("sqrt",1);
        }
        int sz=s.length(),cnt=0;

        for(int i=0;i<sz;)
        {
            if(s.charAt(i)==' ')
            {
              //  System.out.println("0--");
                i++;
                continue;
            }
            String temp=new String("");
            if(check(s.charAt(i))==true)
            {
               // System.out.println("1"+" "+s.charAt(i));

                while(i<sz&&check(s.charAt(i))==true)
                {
                    temp+=s.charAt(i);
                    i++;
                }
                v.add(temp);
            }
            else
            {
               // System.out.println("2"+" "+s.charAt(i));
                int b0=0;
                for(int j=i;j<sz;j++)
                {
                    temp+=s.charAt(j);
                    if(lexeme.get(temp)!=null)
                    {
                        i=j+1;
                        v.add(temp);
                        b0=1;
                        break;
                    }
                }
                if(b0==0)
                {
                    v.clear();v.add(wrong_input);return ;
                }

                if(temp.compareTo("(")==0)
                    cnt++;
                else if (temp.compareTo(")")==0 )
                         {
                             cnt--;
                             if(cnt<0)
                             {
                                 v.clear();
                                 v.add(wrong_input);
                                 return ;
                             }

                }

            }
        }
        while(cnt-->0)
        {
            s.append(')');
            v.add(")");
        }
      //  System.out.println(v);

    }
}
