/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemsoftware;

/**
 *
 * @author peace
 */
public class SystemSoftware {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FileReader fr=new FileReader();
        fr.OpenStream();
        SourceFile sf=new SourceFile(fr.getCode());
        sf.compile();
        System.out.println(""+sf.error);
    }
    
}
