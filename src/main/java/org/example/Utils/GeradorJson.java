package org.example.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorJson {

    public void geradorTxt(String body, String cep) throws IOException {
        FileWriter writer = new FileWriter(cep + ".Json");
        writer.write(body);
        writer.close();
    }
}
