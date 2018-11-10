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

    public boolean checkIdentifier(String str) {
        if (str.matches("[a-zA-Z]+")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkExpression(String str) {
        String[] exp = str.split("=");
        if (exp.length > 1) {
            for (int i = 0; i < exp.length; i++) {
                System.out.println(" " + exp[i]);
                if (checkIdentifier(exp[i].charAt(0) + "") == false) {
                    return false;
                }
                boolean b = checkExpression(exp[i]);
                if (b == false) {
                    return false;
                }
            }
        }

        for (int i = 0; i < operations.length; i++) {
            if (false == checkoperation(str, operations[i])) {
                return false;
            }
        }

        return true;
    }
    char[] operations = {'+', '-', '/', '*', '^', '%'};

    public boolean checkoperation(String str, char op) {
        int index;
        str.replaceAll("\\s", "");
        do {
            System.out.println("" + str);
            index = str.indexOf(op);
            if (index != -1) {
                //   System.out.println(" OP=" + op + " String=" + str);
                try {
                    for (int i = 0; i < operations.length; i++) {
                        System.out.println("1" + i);
                        if (str.charAt(index - 1) == operations[i] || str.charAt(index + 1) == operations[i]) {
                            // System.out.println("" + i);
                            return false;
                        }
                        if (checkIdentifier(str.charAt(index + 1) + "") == false) {
                            return false;
                        }
                    }
                } catch (Exception e) {
                    return false;
                }
            }
            str = str.substring(index + 1);
            // System.out.println("" + str);
        } while (index != -1);
        correct=true;
        return true;
    }

    public static void main(String[] args) {
        ExpressionChecker d = new ExpressionChecker(5, "a+b-x+c+c-d");
        System.out.println("Result=" + d.checkExpression("c=a+b-x+c+c-d"));
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
