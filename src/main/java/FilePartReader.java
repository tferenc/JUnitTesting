import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by tamasferenc on 2017.04.19..
 */
public class FilePartReader
{

    String filepath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader(String filepath, Integer fromLine, Integer toLine)
    {
        if (toLine < fromLine || fromLine < 1)
        {
            throw new IllegalArgumentException("Hiba");
        }
        this.filepath = filepath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws IOException{
           FileReader file = new FileReader(filepath);
           BufferedReader bfreader = new BufferedReader(file);

           String filecontent = "";
           String currentline;

           while ((currentline = bfreader.readLine()) != null) {
               filecontent += currentline + "\n";
           }
           return filecontent;

    }

    public String readlines()throws IOException {
        String result = "";

        String content = this.read();
        StringBuilder sBulder = new StringBuilder();
        String[] lines = content.split("\n");

        for (int i = 0; i < content.length(); i++) {
            if (i >= (fromLine - 1) && i < toLine) {
                sBulder.append(lines[i] + "\n");
            }
        }
        result = sBulder.toString();

        return result;
    }
}
