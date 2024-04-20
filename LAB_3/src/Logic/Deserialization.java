package Logic;

import Logic.Opinions.Opinion;
import java.io.*;
import java.util.ArrayList;

public class Deserialization {

    public static ArrayList<Opinion> readOpinionsFromFile(String filename) throws IOException, ClassNotFoundException {

        ArrayList<Opinion> opinionList =null;

        FileInputStream fileIn= new FileInputStream(filename);
        ObjectInputStream in= new ObjectInputStream(fileIn);

        opinionList= (ArrayList<Opinion>) in.readObject();

        in.close();
        fileIn.close();
        return opinionList;
    }
}
