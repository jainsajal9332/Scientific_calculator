package com.example.sajaljain.myapplication;
import java.util.HashMap;

/**
 * Created by Sajal jain on 6/10/2018.
 */

public class Eraser {

    public static HashMap<String,Integer> map=new HashMap<String,Integer>();
    public static String wrong_input="INVALID INPUT";

    public static String  solve(String s1)
    {
        map.put("sin(",1);
        map.put("cos(",1);
        map.put("tan(",1);
        map.put("arcsin(",1);
        map.put("arccos(",1);
        map.put("arctan(",1);
        map.put("ln(",2);
        map.put("log(",2);
        map.put("abs(",2);
        map.put("sqrt",2);
        map.put("!",2);
        map.put(wrong_input,2);
        map.put("pi",2);


        StringBuilder s=new StringBuilder(s1);
        StringBuilder s2=new StringBuilder("");

        int sz=s.length();
        int b1=0,b2=13;
        for(int i=sz-1;i>=0&&b2--!=0;i--)
        {
            s2.append(s.charAt(i));
            s2.reverse();
            //  System.out.println(s2);

            if(map.get(s2.toString())!=null)
            {
                b1=1;
                // System.out.println("1--");
                if(map.get(s2.toString())==1)
                {
                    int b0=0;
                    s2.reverse();
                    for(int j=i-1;j>=0&&b2--!=0;j--)
                    {

                        s2.append(s.charAt(j));
                        s2.reverse();
                        //  System.out.println(s2);
                        if( map.get(s2.toString() )!=null)
                        {
                            b0=1;
                            s.delete(j,sz);
                            break;
                        }

                        s2.reverse();
                    }
                    if(b0==0)
                        s.delete(i,sz);
                    break;

                }
                else
                {
                    s.delete(i,sz);
                    break;
                }
            }
            s2.reverse();
        }
        if(b1==0)
            s.deleteCharAt(sz-1);
        return s.toString();

    }


}
