package _16_io_text_file.bai_tap.copy_file;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        InputStream inStream = null;
        OutputStream outStream = null;

        try {
            inStream = new FileInputStream(new File("D:\\C0920G1-TranMinhChien\\C0920G1-TranMinhChien\\Module_2\\src\\_16_io_text_file\\bai_tap\\copy_file\\file_name1.txt"));
            outStream = new FileOutputStream(new File("D:\\C0920G1-TranMinhChien\\C0920G1-TranMinhChien\\Module_2\\src\\_16_io_text_file\\bai_tap\\copy_file\\copy_file2.txt"));
            int length;
            byte[] buffer = new byte[1024];
            // copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            System.out.println("File is copied successful!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inStream.close();
            outStream.close();
        }
    }
}
