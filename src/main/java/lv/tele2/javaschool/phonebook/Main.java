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

    private static PhoneBook readPhoneBook(File file) throws Exception{
        FileInputStream fis =new FileInputStream(file);
        ObjectInputStream ois =new ObjectInputStream(fis);

        PhoneBook result=(PhoneBook) ois.readObject();

        ois.close();
        fis.close();

        return result;
    }

    private static void savePhoneBook(File file, PhoneBook phoneBook) throws Exception{
        FileOutputStream fos = new FileOutputStream(file);

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(phoneBook);

        oos.close();
        fos.close();
    }
}
