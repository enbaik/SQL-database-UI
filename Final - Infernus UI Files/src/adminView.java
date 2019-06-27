import java.awt.*;
import javax.swing.*;

import java.sql.*;
import net.proteanit.sql.DbUtils;
/*
 * Created by JFormDesigner on Fri Mar 08 18:46:49 PST 2019
 */



/**
 * @author enbai kuang
 */
public class adminView extends JFrame {
    ResultSet rs = null;
    Connection conn = null;
    PreparedStatement pst = null;

    public adminView() {
        initComponents();
        startConnection();
        getData();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - enbai kuang
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle("Adventure Database : Admin View");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("Inventory");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(25, 15), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText(" Skills");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(150, 15), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText(" Status");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(265, 15), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("Quests");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(25, 65), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText(" Accounts");
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(150, 65), button5.getPreferredSize()));

        //---- button6 ----
        button6.setText(" Members");
        contentPane.add(button6);
        button6.setBounds(new Rectangle(new Point(390, 15), button6.getPreferredSize()));

        //---- button7 ----
        button7.setText("Items/Gold");
        contentPane.add(button7);
        button7.setBounds(new Rectangle(new Point(270, 65), button7.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(5, 175, 495, 255);

        contentPane.setPreferredSize(new Dimension(510, 470));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // used to update table
        private void getData(){
        try{

            String select = "select * from STORED_ITEM";
            pst = conn.prepareStatement(select);
            rs = pst.executeQuery();

            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){ //changed this to SQlException??
            JOptionPane.showMessageDialog(null,e);
        }

    }
    private void startConnection() {
    	String url = "jdbc:mysql://css475-game-db.cxsyug8fydyy.us-west-1.rds.amazonaws.com:3306/";
    	String dbName = "ADVENTURE_GAME";
    	String driver = "com.mysql.cj.jdbc.Driver";
    	String userName = "grader";
    	String password = "uwbcss475pw!";
    	try {
    	  Class.forName(driver).newInstance();
    	  conn = DriverManager.getConnection(url+dbName,userName,password);
    	  System.out.println("Connected to the database");
    	  //conn.close();
    	  System.out.println("Disconnected from database");
    	} catch (Exception e) {
    	    System.out.println("NO CONNECTION =(");
    	}
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - enbai kuang
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
