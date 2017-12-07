package test.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author songwanke
 * @date 2017/12/6
 */
public class ReadAFile {
    public static void main(String[] args) {
        File myFile = new File("doc/file/test.txt");
        read(myFile);
        List<String> list = reader(myFile);
        writer(myFile, list);
    }

    public static void read(File myFile) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(myFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("&&&&" + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> reader(File myFile) {
        BufferedReader reader = null;
        StringBuffer buf = new StringBuffer();
        List<String> list = new ArrayList<String>();

        try {
            reader = new BufferedReader(new FileReader(myFile));
            String line = null;
            Integer count = 1;
            while ((line = reader.readLine()) != null) {
                buf.append(count).append(":").append(line);
                System.out.println("******" + buf.toString());
                list.add(buf.toString());
                buf.delete(0, buf.length());
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void writer(File myFile, List<String> list) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(myFile));
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i));
                System.out.println("----" + list.get(i));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
