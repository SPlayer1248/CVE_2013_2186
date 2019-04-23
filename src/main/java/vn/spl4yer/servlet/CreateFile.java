package vn.spl4yer.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreateFile {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("spl4yer");
        user.setAge(21);
        user.setFullname("spl4yerrrrr");
        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream("employee.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.printf("Du lieu da duoc serialize duoc luu giu trong employee.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
