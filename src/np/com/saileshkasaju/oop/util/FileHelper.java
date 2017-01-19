package np.com.saileshkasaju.oop.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edge on 1/19/2017.
 */
public class FileHelper {
  public static List<String> readLines(String fileName) throws IOException, FileNotFoundException {
    List<String> lines = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line = "";
    while((line = reader.readLine()) != null) {
      lines.add(line);
    }
    reader.close();
    return lines;
  };
}
