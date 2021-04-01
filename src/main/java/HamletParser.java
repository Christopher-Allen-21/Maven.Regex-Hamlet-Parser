import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public Boolean findHamlet(String string){
        Pattern pattern = Pattern.compile("\\b[hH][aA][mM][lL][eE][tT]");
        // could also do: Pattern pattern = Pattern.compile("Hamlet",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        boolean matchFound = matcher.find();
        return matchFound;
    }

    public Boolean findHoratio(String string){
        Pattern pattern = Pattern.compile("\\b[hH][oO][rR][aA][Tt][iI][oO]");
        // could also do: Pattern pattern = Pattern.compile("Horatio",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        boolean matchFound = matcher.find();
        return matchFound;
    }

    public String replaceHamletWithLeon(){
        Pattern pattern = Pattern.compile("\\b[hH][aA][mM][lL][eE][tT]");
        Matcher matcher = pattern.matcher(hamletData);
        String newPoem = hamletData;

        if(findHamlet(newPoem)){
            newPoem = matcher.replaceAll("Leon");
        }
        return newPoem;
    }

    public String replaceHoratioWithTariq(){
        Pattern pattern = Pattern.compile("\\b[hH][oO][rR][aA][Tt][iI][oO]");
        Matcher matcher = pattern.matcher(hamletData);
        String newPoem = hamletData;

        if(findHamlet(newPoem)){
            newPoem = matcher.replaceAll("Tariq");
        }
        return newPoem;
    }

}
