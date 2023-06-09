package Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Fisiere {
    void saveToTxt(String numeFisier) throws IOException;
    void saveToDat(String numeFisier) throws IOException;
    void restoreFromTxt(String numeFisier) throws IOException;
    void restoreFromDat(String numeFisier) throws IOException, ClassNotFoundException;

    void restoreFromTxtStreams(String numeFisier) throws IOException;
    void restoreFromDatStream(String numeFisie) throws IOException;

    void saveToCSV(String numeFisier) throws IOException;


}