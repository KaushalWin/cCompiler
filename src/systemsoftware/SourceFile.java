/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemsoftware;

import java.util.ArrayList;

/**
 *
 * @author peace
 */
public class SourceFile {
    boolean flag;
    ArrayList<String> error;
    String code;
    ArrayList<String> meta;
    int line;
    ArrayList<String> globalVar;
    public SourceFile(String code) {
        line=0;
        code = code.replaceAll("\\r", "");
        this.code = code;
        meta=new ArrayList<String>();
        globalVar=new ArrayList<String>();
        flag=false;
        error=new ArrayList<String>();
       
    }
    ArrayList<Procedurer> pl;
    public void compile(){
        getMeta();
       
        Procedurer p =null;
        while((p=getFunction())!=null){
            if(p.error.size()>0){
                System.out.println("Error in FUnction:"+p);
            }else{
                System.out.println("Function Details:-");
                System.out.println("Name:"+p.name+"\tReturn type:"+p.returnType);
                System.out.println("parameters are :-");
                for(Procedurer.Parameter k:p.parameters)System.out.println("Type:"+k.getDataType()+"\tName:"+k.name);
            }
            
        }
        
    }
    private void getMeta() {
        String s;
        while ((s=getLine())!=null) {
            line++;
            if(s.length()==0)continue;
            if(!s.startsWith("#")) break;
            meta.add(s);
        }
        if(s!=null)code=s+code;
    }
    int i;
    private Procedurer getFunction(){//here add logic to get global variable. do not discard extra code.
        String header,body=null;
        if(code==null) return null;
        if(code.trim().equals("")) return null;
        i = code.indexOf("{");
        header=code.substring(0,i);
        code=code.substring(i);
        
        i=header.indexOf(";");
        if(i!=-1){
            String s;
            while ((s=getStatement(header))!=null) {
                header=header.substring(i+1);
                line++;
                if(s.length()==0)continue;
                globalVar.add(s);
            }
        }
        header=header.trim();
        boolean bracketFlag=true;
        i=0;
        for(int k=0,j=0;k<code.length();k++){
            i++;
            if(code.charAt(k)=='{')j++;
            if(code.charAt(k)=='}')j--;
            if(j==0){
                bracketFlag=false;
                break;
            }
            
        }
        if(bracketFlag){
            flag=true;
            error.add("please check brackets. closing bracket missing in function: "+header);
            return null;
        }
        body=code.substring(0,i);
        code=code.substring(i);
        Procedurer p=new Procedurer();
        p.setPrototype(header);
        p.setCode(body);
        return p;
    }
    private String getStatement(String code) {
        String s = null;
        i = code.indexOf(";");
        if(i==-1) return null;
        s = code.substring(0, i+1).trim();
        
        return s;
    }
    private String getLine() {
        String s = null;
        i = code.indexOf("\n");
        if(i==-1) return null;
        s = code.substring(0, i).trim();
        code = code.substring(i + 1);
        return s;
    }

}
