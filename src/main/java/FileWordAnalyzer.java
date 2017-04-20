import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tamasferenc on 2017.04.19..
 */
public class FileWordAnalyzer
{
    FilePartReader fpreader;
    public FileWordAnalyzer(FilePartReader fpreader)
    {
        this.fpreader = fpreader;
    }

    public ArrayList wordsByABC() throws IOException{

            String lines = fpreader.readlines();
            lines = lines.replaceAll("[,|.]", "");
            ArrayList<String> orderedwords = new ArrayList<String>(Arrays.asList(lines.split("\\s")));
            Collections.sort(orderedwords, String.CASE_INSENSITIVE_ORDER);
            return orderedwords;


    }
     public ArrayList wordsContainingSubString(String substring) throws IOException
     {
             String linesFromFile = fpreader.readlines();
             linesFromFile = linesFromFile.replaceAll("[,|.]", "");
             String[] lines = linesFromFile.split("\\s");
             ArrayList<String> wordsContainsSubsting = new ArrayList<String>();

             for (String e : lines) {
                 if (e.toLowerCase().contains(substring.toLowerCase())) {
                     wordsContainsSubsting.add(e);
                 }

             }
             return wordsContainsSubsting;


     }
}
