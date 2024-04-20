package Logic;

import Logic.Opinions.Opinion;
import java.io.*;
import java.util.ArrayList;

public class Serialization {

    public static void writeOpinionsToFile(ArrayList<Opinion> opinions,String filename) {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {

                outputStream.writeObject(opinions);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

