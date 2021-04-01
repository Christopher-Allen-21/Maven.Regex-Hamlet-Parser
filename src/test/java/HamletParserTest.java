import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String actual = hamletParser.replaceHamletWithLeon();
        System.out.println(actual);

        Assert.assertFalse(actual.contains("HAMLET"));
        Assert.assertFalse(actual.contains("hamlet"));
        Assert.assertFalse(actual.contains("Hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String actual = hamletParser.replaceHoratioWithTariq();
        System.out.println(actual);

        Assert.assertFalse(actual.contains("HORATIO"));
        Assert.assertFalse(actual.contains("horatio"));
        Assert.assertFalse(actual.contains("Horatio"));
    }

    @Test
    public void testFindHoratio1() {
        String string = "His name was Horatio";

        boolean expected = true;
        boolean actual = hamletParser.findHoratio(string);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHoratio2() {
        String string = "HOraTio was his name";

        boolean expected = true;
        boolean actual = hamletParser.findHoratio(string);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHoratio3() {
        String string = "His name was Horat io or something.";

        boolean expected = false;
        boolean actual = hamletParser.findHoratio(string);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHoratio4() {
        String string = "asdfHoratiof";

        boolean expected = false;
        boolean actual = hamletParser.findHoratio(string);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHamlet1() {
        String string = "his name was hamlet asdf";

        boolean expected = true;
        boolean actual = hamletParser.findHamlet(string);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHamlet2() {
        String string = "asdf HAmleT was his name";

        boolean expected = true;
        boolean actual = hamletParser.findHamlet(string);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHamlet3() {
        String string = "His name was Hamle t or something.";

        boolean expected = false;
        boolean actual = hamletParser.findHamlet(string);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHamlet4() {
        String string = "asdfHAMLETasdf";

        boolean expected = false;
        boolean actual = hamletParser.findHamlet(string);

        Assert.assertEquals(expected,actual);
    }
}