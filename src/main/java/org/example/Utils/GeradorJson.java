package org.example.Utils;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorJson {

    public void geradorTxt(String body, String cep) throws IOException {
        FileWriter writer = new FileWriter(cep + ".Json");
        writer.write(body);
        writer.close();
    }
}
