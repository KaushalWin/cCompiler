/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemsoftware;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author peace 
*/
public class FileReader {
    String code;
    File f;
    FileReader(){
     f=null;
     code=null;
        
    }
    public void OpenStream(String FileName){
        f=new File(FileName);
        if(f.exists())if(f.isFile())if(f.canRead()){
            try {
                code=new String(Files.readAllBytes(f.toPath()));
            } catch (IOException ex) {
                Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Exception Caught in FileReader.OpenStream while converting file to path");
                return;
            }
            
        }
        else{
            System.out.println("Invalid File");
            return;
        }
    }
    public void OpenStream(File f){
        
        if(f.exists())if(f.isFile())if(f.canRead()){
            try {
                code=new String(Files.readAllBytes(f.toPath()));
            } catch (IOException ex) {
                Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Exception Caught in FileReader.OpenStream while converting file to path");
                return;
            }
            
        }
        else{
            System.out.println("Invalid File");
            return;
        }
    }
    public void OpenStream(){
        JFileChooser jf=new JFileChooser(".");
        int r=jf.showOpenDialog(null);
        if(r==JFileChooser.APPROVE_OPTION){
            OpenStream(jf.getSelectedFile());
        }
        else{
            System.out.println("You have selected invalid file");
        }
    }

    public String getCode() {
        return code;
    }
    
}
