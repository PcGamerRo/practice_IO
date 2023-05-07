package Classes;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable {
    private int id;
    private String nume;

    public Student(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id).append(" ").append(nume).append("\n");
        return stringBuilder.toString();
    }
}
