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
public class ExpressionChecker {
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

    public ExpressionChecker(int lineNo, String Data) {
        this.lineNo = lineNo;
        this.Data = Data;
        Condition = new ArrayList<>();
    }
    public boolean checkIdentifier(String str)
    {
        if(str.matches("[a-zA-Z]+"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean checkExpression() {
       
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
