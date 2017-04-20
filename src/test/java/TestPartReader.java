import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by tamasferenc on 2017.04.19..
 */
public class TestPartReader
{
    String filepath = "/home/tamasferenc/Documents/HTML/JUnitTest/src/test/resources/testfile.txt";

    //The read method private, I can't test it here. But the readlines method uses the read method, so it should work!

   @Test
    public void readLinesTest()throws IOException
    {
        String lines = "barack,\nalma,\nkörte,\n";
        FilePartReader fp = new FilePartReader(filepath, 1, 3);
        assertEquals(lines, fp.readlines());
    }
    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest()
    {
        FilePartReader fpr = new FilePartReader(filepath, 3, 1);

    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotFoundExceptionTest() throws IOException
    {
        String fpath = "/home/tamasferenc/Documents/HTML/JUnitTest/src/test/resources/tessztfile.txt";
        FilePartReader fpr = new FilePartReader(fpath, 1, 3);
        fpr.readlines();

    }


}

