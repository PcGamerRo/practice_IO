import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
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
            System.out.println(line);
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
            System.out.println(value);
        }
        dataInputStream.close();
    }
}