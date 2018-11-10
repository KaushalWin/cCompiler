/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StandardStatement;

import java.util.ArrayList;

/**
 *
 * @author jay
 */
public class WhileLoop {

    int lineNo;
    boolean correct = false;
    String Data;
    String SS;
    ArrayList<String> Condition;

    public String getSS() {
        return SS;
    }

    public void setSS(String SS) {
        this.SS = SS;
    }

    public WhileLoop(int lineNo, String Data) {
        this.lineNo = lineNo;
        this.Data = Data;
        Condition = new ArrayList<>();
    }

    public boolean checkLoop() {
        Data.trim();
        int start = Data.indexOf("(");
        int end = Data.indexOf(")");
        System.out.println("Start="+start+" end="+end+" Data="+Data.length());
        String condition = Data.substring((start + 1), end);
        System.out.println("Data="+condition);
        String Remaining = Data.substring(end + 2, Data.length()-1);
        System.out.println("Remaining="+Remaining);
        //  String[] conditionSplit=condition.split("[\|\| |&&]");
        String[] splits = condition.split("\\|\\||&&");
        for (String split : splits) {
            split.trim();
            
            System.out.println("Splits="+split);
        }
        for (String split : splits) {
            split=split.replaceAll("\\s","");
            if(split.length()>4)
            {
                System.out.println("MISTAKE Lenght"+split);
                return false;
            }
            else if(split.contains("<>") || split.contains("><") ||split.contains("<<") || split.contains(">>") ||split.contains("=>") ||split.contains("=<"))
            {
                System.out.println("MISTAKE Syntaxt"+split);
                return false;
            }
            String[] splitter = split.split("==|!=|<=|>=|<|>");
            for (String splitter1 : splitter) {
                splitter1.trim();
                System.out.println("STIRNG="+splitter1);
            }
            if (splitter.length > 1) {
                try {
                    correct=true;
                   // Float.parseFloat(splitter[1]);
                } catch (Exception e) {
                    System.out.println("HEREE");
                    return false;
                }
            }
        }
        // Condition.addAll();
        return true;
    }
    public static void main(String[] args) {
        String Check="while(a<<b || c<d && e==f)"
                + "{"
                + "C=A+b"
                + "}";
        WhileLoop a=new WhileLoop(38, Check);
        a.checkLoop();
        System.out.println(" "+a.isCorrect());
    }
    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

}
