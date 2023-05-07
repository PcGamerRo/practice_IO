package Classes;

import Interfaces.Fisiere;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Grupa implements Fisiere {
    int numar;
    List<Student> studenti;

    public Grupa(int numar, List<Student> studenti) {
        this.numar = numar;
        this.studenti = studenti;
    }

    public Grupa(int numar) {
        this.numar = numar;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numar).append("\n");
        for(var x: studenti)
            stringBuilder.append(x);
        return stringBuilder.toString();
    }

    @Override
    public void saveToTxt(String numeFisier) throws IOException {
        FileWriter fileWriter = new FileWriter(numeFisier);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (var x: studenti)
            bufferedWriter.write(x.toString());
        bufferedWriter.close();
    }

    @Override
    public void saveToDat(String numeFisier) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(numeFisier);
//        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
//        for (var x: studenti)
//            dataOutputStream.writeUTF(x.toString());
//        dataOutputStream.close();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (var x: studenti)
            objectOutputStream.writeObject(x);
        objectOutputStream.close();
    }

    @Override
    public void restoreFromTxt(String numeFisier) throws IOException {
        FileReader fileReader = new FileReader(numeFisier);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        studenti = new ArrayList<>();
        String linie = bufferedReader.readLine();
        while (linie!=null){
            studenti.add( new Student(
               Integer.parseInt(linie.split(" ")[0]),
               linie.split(" ")[1]
            ));
            linie = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    @Override
    public void restoreFromDat(String numeFisier) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(numeFisier);
//        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
//        studenti = new ArrayList<>();
//        String linie;
//        while (dataInputStream.available() > 0 ){
//            linie = dataInputStream.readUTF();
//            studenti.add( new Student(
//                    Integer.parseInt( linie.split(" ")[0]),
//                    linie.split(" ")[1]
//            ));
//        }
//        dataInputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        while (objectInputStream.available() > 0 ){
            studenti.add((Student) objectInputStream.readObject());
        }
        objectInputStream.close();
    }

    @Override
    public void restoreFromTxtStreams(String numeFisier) throws IOException {
        FileReader fileReader = new FileReader(numeFisier);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        studenti =  bufferedReader.lines()
                .map(linie -> new Student(
                        Integer.parseInt(linie.split(" ")[0]),
                        linie.split(" ")[1]
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void restoreFromDatStream(String numeFisie) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(numeFisie);
        //ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
    }
}