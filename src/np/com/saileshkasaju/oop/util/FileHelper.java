package np.com.saileshkasaju.oop.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edge on 1/19/2017.
 */
public class FileHelper {
  public static List<String> readLines(String fileName) throws IOException {
    List<String> lines = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line = "";
    while((line = reader.readLine()) != null) {
      lines.add(line);
    }
    reader.close();
    return lines;
  };
  public static void writeLines(String fileName, List<String> lines) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    for (String line: lines) {
      writer.write(line);
    }
    writer.close();
  }
}
