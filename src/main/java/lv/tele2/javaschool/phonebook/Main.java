package lv.tele2.javaschool.phonebook;

import asg.cliche.ShellFactory;
import asg.cliche.example.HelloWorld;

import java.io.*;
import java.nio.file.NoSuchFileException;

/**
 * Created by ivanssud on 07.03.2017.
 */
public class Main {
    public static void main (String[] args){
        try {
            File file = new File("myFile.ser");
            PhoneBook phoneBook;

            if (file.exists()){
                phoneBook=readPhoneBook(file);
            }else{
                phoneBook = new PhoneBook();
            }
            ShellFactory.createConsoleShell("hello", null, phoneBook)
                    .commandLoop();

            savePhoneBook(file,phoneBook);

            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PhoneBook readPhoneBook(File file){

        try(FileInputStream fis =new FileInputStream(file);
            ObjectInputStream ois =new ObjectInputStream(fis);){

            PhoneBook result=(PhoneBook) ois.readObject();
            return result;
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error reading. Creating new phone book");
            return new PhoneBook();
        }
    }

    private static void savePhoneBook(File file, PhoneBook phoneBook){

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(phoneBook);
        }catch (IOException e){
            System.out.println("Error aving File");
        }

    }
}
