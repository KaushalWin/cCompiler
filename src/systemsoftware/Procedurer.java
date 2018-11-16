/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemsoftware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author peace
 */
public class Procedurer {

    //String Prototype;
    String name;
    String returnType;
    String code;
    List dataType;
    boolean flag;
    ArrayList<String> error;
    ArrayList<Parameter> parameters;

    public Procedurer() {
        flag = false;
        dataType = Arrays.asList(Keyword.DataType);
        parameters=new ArrayList<>();
        error=new ArrayList<>();
    }

    public static class Parameter {

        String name;
        String dataType;

        public Parameter(String name, String dataType) {
            this.name = name;
            this.dataType = dataType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

    }

    public String getPrototype() {
        return name;
    }

    public void setPrototype(String prototype) {
        int i = prototype.indexOf("(");
        String rn = prototype.substring(0, i).trim();
        String param = prototype.substring(i+1).trim();
        String arr[] = rn.split("\\s");
        arr=removeEmpty(arr);
        if (arr.length > 2) {
            flag = true;
            error.add("Invalid Function Name at'" + rn + "'");
            returnType = arr[0];
            name = arr[1];
        } else if (arr.length == 1) {
            flag = true;
            if (!dataType.contains(arr[0])) {
                error.add("no Function Name at'" + rn + "'");
                returnType = arr[0];
                name = "";
            } else {
                error.add("no Return type at'" + rn + "'");
                returnType = "";
                name = arr[0];
            }

        } else if (arr.length == 0) {
            flag = true;
            error.add("no Function Name or returntype");
            returnType = arr[0];
            name = "";
        } else {
            returnType = arr[0];
            name = arr[1];
        }
        arr = param.split("\\)");
               if(arr.length!=0) {arr=arr[0].split(",");arr=removeEmpty(arr);}
        String p[];
        
       
        for (String a : arr) {
            p = a.split("\\s+");
            p=removeEmpty(p);
            if (p.length > 2) {
                flag = true;
                error.add("Invalid Parameter Name at'" + a + "'");

            } else if (p.length == 1) {
                flag = true;
                if (!dataType.contains(arr[0])) {
                    error.add("no Parameter Name at'" + a + "'");
                } else {
                    error.add("no Data type at'" + a + "'");
                }

            } else if (p.length == 0) {
                flag = true;
                error.add("Empty Parameter(no name, no datatype)");

            }else{
                parameters.add(new Parameter(p[0],p[1]));
            }
        }

    }
    private String[] removeEmpty(String arr[]){
        ArrayList<String> fun = new ArrayList<String>();
        for (int k = 0; k < arr.length; k++) {
            arr[k]=arr[k].trim();
            if (!arr[k].equals("")) {
                fun.add(arr[k]);
            }
        }
        arr=new String[fun.size()];
        for(int k=0;k<fun.size();k++)arr[k]=fun.get(k);
        return arr;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

}
