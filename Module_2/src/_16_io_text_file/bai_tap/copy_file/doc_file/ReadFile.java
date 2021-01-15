package _16_io_text_file.bai_tap.copy_file.doc_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("src/_16_io_text_file/bai_tap/copy_file/doc_file/country.csv");
        FileReader fileReader;
        {
            try {
                fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;
                List<String> elementsLine = new ArrayList<>();
                while ((line = bufferedReader.readLine()) != null){
                    elementsLine.add(line);
                }
                for (String s : elementsLine){
                    System.out.println(s);
                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
