import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Mar 08 18:52:20 PST 2019
 */



/**
 * @author enbai kuang
 */
public class playerView extends JFrame {
    public playerView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - enbai kuang
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle("Adventure Database : Player View");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("Inventory");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(275, 30), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("Skills");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(155, 30), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("Account");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(30, 30), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("Quests");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(30, 90), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText("Friends");
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(155, 90), button5.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(385, 5, 560, 265);

        contentPane.setPreferredSize(new Dimension(950, 305));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - enbai kuang
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
