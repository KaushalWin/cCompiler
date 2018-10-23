/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StandardStatement;

import java.util.ArrayList;

/**
 *
 * @author peace
 */
public class Declaration {
    String data;
    int line;
    String type;
    String name;
    String value;
    int pointer;
    int array;
    ArrayList ArrSize;

    public Declaration(String data, int line, String type, String name, String value, int pointer, int array, ArrayList ArrSize) {
        this.data = data;
        this.line = line;
        this.type = type;
        this.name = name;
        this.value = value;
        this.pointer = pointer;
        this.array = array;
        this.ArrSize = ArrSize;
    }
    
    
    public static ArrayList<Declaration> createVariables(String stmt,int line){
        ArrayList<Declaration> dec=null;
        String back=stmt;
        stmt=stmt.trim();
        String type=null;
        int start=0;
        if(!stmt.endsWith(";")){
            return null;
        }
        stmt=stmt.substring(0,stmt.length()-1);
        if(stmt.startsWith("int ")){
           type="int";
           start=3;
        }else if(stmt.startsWith("char ")){
            type="char";
            start=4;
        }else if(stmt.startsWith("float ")){
            type="float";
            start=5;
        }else if(stmt.startsWith("double ")){
            type="double";
            start=6;
        }else{
            return null;
        }
        dec=createTypeVariable(type,stmt.substring(start),line,back);
        return dec;
    }
    static String error;
    public static ArrayList<Declaration> createTypeVariable(String type, String vars, int line,String back){
        ArrayList<Declaration> dec=new ArrayList<>();
        String vname[]=vars.trim().split(",");
        int array;
        int pointer;
        String temp,t1,val,varr[];
        
        int i,j,k;
        ArrayList<Integer> arrSize=new ArrayList<>();
        for(String var:vname){
            
            var=var.trim();
            varr=var.split("=");
            if(varr.length>2)return null;
            var=varr[0].trim();
            if(varr.length==2){
                val=varr[1].trim();
                if(val.length()==0)return null;
            }else{
                val=null;
            }
            array=0;
            pointer=0;
            while(var.startsWith("*")){
                pointer++;
                var=var.substring(1).trim();
                if(var==null) return null;
                if(var.length()==0)return null;
            }
            
            if((i=var.indexOf("["))!=-1){
                
                var=var.substring(0,i).trim();
                temp=var.substring(i);
                if(var==null) return null;
                if(var.length()==0)return null;
                while((i=temp.indexOf("["))!=-1){
                    j=temp.indexOf("]");
                    if(j==-1) return null;
                    t1=temp.substring(i+1,j).trim();
                    if(j!=temp.length()-1)
                    temp=temp.substring(j).trim();
                    else temp="";
                    if(t1==null) return null;
                    if(t1.equals(""))return null;
                    try{
                        arrSize.add(Integer.parseInt(t1));
                        
                    }catch(Exception e){
                        return null;
                    }
                    array++;
                }
            }
            
            if(!var.matches("[a-zA-Z]+")){
                return null;
            }
            dec.add(new Declaration(back, line,type ,var , val, pointer, array,arrSize));
            
            
        }
        return dec;
    }
    
    
}
