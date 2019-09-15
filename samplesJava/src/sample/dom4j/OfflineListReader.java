/*
 * Created on 2019年4月19日
 */
package sample.dom4j;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class OfflineListReader {
    public void read(String fileName) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(fileName));

        Element root = document.getRootElement();
        List<Element> games = root.element("games").elements();

        NumberFormat format = new DecimalFormat("0000");
        for (Element game : games) {
            String number = game.elementText("imageNumber");
            number = format.format(Integer.parseInt(number));
            String name = game.elementText("title");

            System.out.println(number + " " + name);
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = "d:\\data\\rough\\notes\\game\\Roms\\nes_OL.xml";
        OfflineListReader reader = new OfflineListReader();
        reader.read(fileName);
    }
}
