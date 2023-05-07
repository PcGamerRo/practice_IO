import Classes.Grupa;
import Classes.Student;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> name = Arrays.asList("Robert", "Alex", "John");

        // FILE WRITER
        FileWriter fileWriter = new FileWriter("file.txt");
        BufferedWriter bf = new BufferedWriter(fileWriter);
        for(var x: name)
            bf.write(x+"\n");
        bf.close();

        // FILE READER
        FileReader fileReader = new FileReader("file.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String line = br.readLine();
        while(line!=null){
            //System.out.println(line);
            line = br.readLine();
        }
        br.close();

        // BINARY FILE WRITER
        FileOutputStream fileOutputStream = new FileOutputStream("file.dat");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        for(var x: name)
            dataOutputStream.writeUTF(x);
        dataOutputStream.close();

        // BINARY FILE READER
        FileInputStream fileInputStream = new FileInputStream("file.dat");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        String value;
        while(dataInputStream.available() > 0){
            value = dataInputStream.readUTF();
            //System.out.println(value);
        }
        dataInputStream.close();


        List<Student> students = Arrays.asList(
                new Student(1, "Robert"),
                new Student(2, "Alex"),
                new Student(3, "Ionut")
        );

        Grupa grupa = new Grupa(1058, students);
        grupa.saveToTxt("fisierGrupa.txt");
        grupa.saveToDat("fisierGrupa.dat");

        Grupa obj = new Grupa(1059);
        obj.restoreFromTxt("fisierGrupa.txt");
        obj.restoreFromDat("fisierGrupa.dat");
        System.out.println(obj.toString());
    }
}