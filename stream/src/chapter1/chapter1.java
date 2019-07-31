package chapter1;

import java.io.File;
import java.io.FileFilter;

public class chapter1 {
    public static void main(String[] args) {
//        File[] hiddenFiles = new File("/").listFiles(new FileFilter() {
//            public boolean accept(File file) {
//                return file.isHidden();
//            }
//        });

        File[] hiddenFiles = new File("/").listFiles(File::isHidden);
        for (File f: hiddenFiles
             ) {
            System.out.println(f);
        }
    }
}
