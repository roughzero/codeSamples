/*
 * Created on 2012-7-24
 */
package sample.jdk.awt;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FrameSample extends JFrame {
    private JTextField text1;

    public FrameSample() {

        JButton testButton = new JButton();
        testButton.setActionCommand("TestCommand");
        testButton.setText("测试 Test");
        Font font = new Font("宋体", Font.PLAIN, 12);
        Map<TextAttribute, Object> fontDef = new HashMap<TextAttribute, Object>();
        fontDef.put(TextAttribute.FAMILY, "微软雅黑");
        fontDef.put(TextAttribute.SIZE, 16);
        font = new Font(fontDef);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LayoutManager manager = new GridLayout(2, 1);
        manager.addLayoutComponent("text1", text1);
        manager.addLayoutComponent("testButton", testButton);
        this.setLayout(manager);
        text1 = new JTextField(20);
        text1.setFont(font);
        text1.setVisible(true);
        this.add(text1);

        testButton.setFont(font);
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                Font font = ((Component) e.getSource()).getFont();
                System.out.println(font.getFamily());
                System.out.println(font.getFontName());

                Map<TextAttribute, ?> attributesMap = font.getAttributes();
                Set<TextAttribute> keys = attributesMap.keySet();
                for (TextAttribute textAttribute : keys) {
                    System.out.println(textAttribute + " = " + attributesMap.get(textAttribute));
                }
                System.out.println(text1.getText());
            }
        });
        this.add(testButton);
    }

    public static void main(String[] args) {
        FrameSample frame = new FrameSample();
        frame.setSize(630, 360);
        frame.setVisible(true);
    }
}
