package utils;

import java.io.File;
import java.io.FileWriter;

public class FileUtil {
    public static void stringToFile (String in){
//        System.out.println("Inside the outToFile method.");

        File f = new File("./docs/user.txt");
        FileWriter fr = null;
//        System.out.println(f.getAbsolutePath());
//        System.out.println(f.getParentFile());
        f.getParentFile().mkdirs();
        try{
            fr = new FileWriter(f);
            char[] cs = in.toCharArray();
            fr.write(cs);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (fr != null){
                try{
                    fr.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }


//        System.out.println("End of the outToFile method.");
    }

}
