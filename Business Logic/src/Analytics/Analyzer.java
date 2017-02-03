import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Analyzer {

    /* Exception has to be handled by calling function. most likely cause would be
     * an inability to open the file (permission, existence, etc)
     */
    public static Map<String, Integer> import_student_prefs(File csvFile) throws IOException{
        Map<String, Integer> data = new HashMap<String, Integer>();
        String nextLine;
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));

        //begin reading
        reader.readLine(); //consume first line since it's useless (just a header, no data)
        while ((nextLine = reader.readLine()) != null) {
            // We want index 6 [class name] and index 10 [seat demand]
            String fields[] = nextLine.split(",");
            try {
                data.put(fields[6], Integer.parseInt(fields[10]));
            }
            catch (Exception e) { //ignore malformed input
                continue;
            }
        }
        return data;
    }
}