/**
 * Created by tamasferenc on 2017.04.20..
 */
import junit.framework.AssertionFailedError;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;

public class TestWordAnalyzer
{
    String filepath = "/home/tamasferenc/Documents/HTML/JUnitTest/src/test/resources/testfile.txt";
    FilePartReader fpMock = new FilePartReader(filepath, 1, 3);

    @Test
    public void sortFileWordsByAbcOrder() throws IOException
    {
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpMock);
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("alma");
        lines.add("barack");
        lines.add("körte");
        assertEquals(lines, fwa.wordsByABC());
    }

    @Test
    public void substringInWords() throws IOException
    {
        FileWordAnalyzer fwa = new FileWordAnalyzer(fpMock);
        ArrayList<String> words = new ArrayList<String>();
        words.add("barack");
        words.add("alma");
        assertEquals(words, fwa.wordsContainingSubString("a"));
    }




}