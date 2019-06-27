import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.intellij.uiDesigner.core.*;
/*
 * Created by JFormDesigner on Fri Mar 08 17:48:05 PST 2019
 */



/**
 * @author enbai kuang
 */
public class startPage extends JPanel{
    public startPage() {
        initComponents();
        landing.setVisible(true);
        landing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void button5MouseClicked(MouseEvent e) { // goes into admin view
        adminView adWin = new adminView();
    }

    private void button2MouseClicked(MouseEvent e) { // goes into player view
        playerView plyWin = new playerView();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - enbai kuang
        landing = new JFrame();
        button2 = new JButton();
        button5 = new JButton();

        //======== landing ========
        {
            landing.setMinimumSize(new Dimension(16, 20));
            landing.setBackground(Color.white);
            landing.setTitle("Adventure Database");
            Container landingContentPane = landing.getContentPane();
            landingContentPane.setLayout(null);

            //---- button2 ----
            button2.setText("Player View");
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                }
            });
            landingContentPane.add(button2);
            button2.setBounds(new Rectangle(new Point(180, 60), button2.getPreferredSize()));

            //---- button5 ----
            button5.setText("Admin View");
            button5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button5MouseClicked(e);
                }
            });
            landingContentPane.add(button5);
            button5.setBounds(new Rectangle(new Point(20, 60), button5.getPreferredSize()));

            landingContentPane.setPreferredSize(new Dimension(540, 380));
            landing.pack();
            landing.setLocationRelativeTo(landing.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - enbai kuang
    private JFrame landing;
    private JButton button2;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

