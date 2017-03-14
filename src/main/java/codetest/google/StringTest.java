package codetest.google;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wa on 2017/2/19.
 */
public class StringTest{
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader("d:A-small-attempt5.in"));

        int totalCases=Integer.parseInt(reader.readLine());
       System.out.println("total:"+totalCases);
        for (int i=0;i<totalCases;i++){
            int caseSize=Integer.parseInt(reader.readLine());
            System.out.println("caseSize:"+caseSize);
            int line=0;
            int maxLength=0;
            String maxString=null;
            while (line<caseSize){

                //maxString=
                String currentLine=reader.readLine();
                System.out.println(currentLine);
                int length=getSetLength(currentLine);
                if (length>maxLength){
                    maxLength=length;
                    maxString=currentLine;
                }
                line++;
            }
            //System.out.println("Case #"+(i+1)+": "+maxString);
        }
        //testInput();

    }
    public static int getLength(String line){
        char[] chars=line.toCharArray();
        int[] flag=new int[26];
        for (int i=0;i<chars.length;i++){
            int ch=chars[i]-65;
            if (ch>=0&&ch<=25){
                flag[ch]=1;
            }
        }
        int length=0;
        for(int i=0;i<flag.length;i++){
            length+=flag[i];
        }
        return length;
    }

    public static void testInput() throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader("d:test.txt"));
        String test=null;
        int maxLength=0;
        String maxString=null;
        while ((test=reader.readLine())!=null){
            int length=getSetLength(test);
            System.out.println(length+":"+test);
            if (length>maxLength){
                maxLength=length;
                maxString=test;
                System.out.println("max"+maxLength+":"+maxString);
            }
        }
       // System.out.println("total"+getLength("TJRRDORAFLLWVPMGRVKU"));
    }

    public static int getSetLength(String line){
        Set<Character> characters=new HashSet<Character>();
        char[] chars=line.toCharArray();
        for (int i=0;i<chars.length;i++){
            characters.add(chars[i]);
        }
        return characters.size();
    }

}
