package ru.kpfu.util;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Repository
public class NamesTXTParser {
    private static final String FILE_PATH = "C:\\Users\\nanob\\Desktop\\Java Задания\\MusicAPI\\Names.txt";

    private File file = new File(FILE_PATH);

    public List<String> getAllNames() {

        BufferedReader bufferedReader;

        try {
            StringBuffer buffer = new StringBuffer();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH), Charset.forName("UTF-8")));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                buffer.append(line+"\n");
            }
            bufferedReader.close();

            return Arrays.asList(buffer.toString().split(","));
        }
        catch (Throwable t){
            t.printStackTrace();
        }
        return null;
    }
}
