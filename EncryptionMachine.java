/**
 * Program Name: EncryptionMachine.java
 * Class: CSCI 716 Software Construction Assignment 01
 * Author: Terry Traylor
 * Date: 4 October 2024
 * Description: This program implements an Encryption and Decryption scheme called
                Caesar cipher - A type of substitution cipher.  The program
                accepts a number of words to be encrypted and passes a scanner to 
                an encryption algorithm that encrypts each character in the string
                using the mod operator, indexOf(), and hcarAt().
 */
import java.io.*;
import java.util.*;

public class Main
{
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz"; //The alphabet
    public static int SHIFT = 3;
    
    /**
    * This method encrypts each letter by calling the mod function.
    *c(p) -(p + key) % length(staefrof)
    * 
    * @param ch The character being encrypted.
    * @return shifted: The encrypter letter.
    */    
    public static char singleLetter(char ch) {
    char shifted = ALPHABET.charAt((ALPHABET.indexOf(ch)+SHIFT)%26);    
    return shifted;
    }
    
    /**
    * This method encrypts each word by calling the singleletter encryption method.
    *
    * @param str The word being encrypted.
    * @return cipherWord: The encrypted word.
    */
    public static String encryptWord(String str)
    {
        String cipherWord="";
        // Traverse the string
        for (int i = 0; i < str.length(); i++) {          //loop that encrypts each character
           char encryptCh = singleLetter(str.charAt(i));
           cipherWord += encryptCh;
        }
    return cipherWord;    
    }
    
    /**
    * This method runs the loops that pass the Scanner as a parameter to encrypt
    * the plantext.
    * Note:  All Scanner passing and output is produced in this loop, not in main.
    *
    * @param inputLoop The number of words that will be encrypted.
    */    
    public static void numLoops(Scanner inputLoop) 
    {
        //int nu = numL.nextInt();
        int numLoops = inputLoop.nextInt();
        
        for (int k = 0; k < numLoops; k++) {          //Loop that handles encryption
            System.out.println("Enter your word to be encrypted:");
            Scanner cipherScanner = new Scanner(System.in);
            inputWord(cipherScanner); 
        }
        System.out.println("Message fully encrypted. Happy secret messaging!");
    }
    
    /**
    * This method handles the Scanner pass to the encryption routine.
    *
    * @param Scanner The Scanner parameter being passed to the ecnryption routine.
    */    
    public static void inputWord(Scanner input) 
    { 
        String pText = input.nextLine(); 
        String cText = encryptWord(pText);
        System.out.println("Your word: " + pText + " has been encrypted to: " + cText + "!"); 
        System.out.println(" "); 
    } 

    // The main program with no output produced inside
    public static void main(String[] args) {
        System.out.println("Welcome to the CSCI717 Encryption Machine Construction"); 
        System.out.println("The program lets you encrypt a message"); 
        System.out.println("with a key for your recipient to decrypt!"); 
        System.out.println("Enter the number of words you want to encrypt."); 
        
        Scanner loops = new Scanner(System.in);  
        numLoops(loops);   //This passes the scanner to the methods
    }
}
