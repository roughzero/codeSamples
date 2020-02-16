/*
 * Created on 2013-4-8
 */
package sample.jdk.lang;

import java.io.IOException;
import java.util.UUID;

public class SampleRuntime {

    public static void main(String[] args) throws IOException {
        // Runtime runtime = Runtime.getRuntime();
        // runtime.exec("c:\\python31\\pythonw.exe d:\\green\\FileEditorChooser\\chooser.pyw 1234567889.sql");
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(UUID.randomUUID().toString());
    }
}
