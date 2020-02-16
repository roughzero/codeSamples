/*
 * Created on 2019年11月18日
 */
package sample.jdk.io;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.io.filefilter.NameFileFilter;

public class SampleOfFile {
    public static void main(String[] args) {
        File file = new File("Z:\\");
        FilenameFilter filenameFilter = new NameFileFilter("LS0000000000000064");
        System.out.println(System.currentTimeMillis());
        String[] files = file.list(filenameFilter);
        System.out.println(System.currentTimeMillis());
        for (String string : files) {
            System.out.println(string);
        }
    }
}
