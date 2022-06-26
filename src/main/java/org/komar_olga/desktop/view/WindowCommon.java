package org.komar_olga.desktop.view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class WindowCommon extends JFrame{

    private JDialog jDialog;
    private JTabbedPane jTabbedPane;


    public WindowCommon() {
        jDialog =new JDialog();
        jDialog.setSize(800,600);
        jDialog.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - jDialog.getWidth()/2,
                (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - jDialog.getHeight()/2);
        jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jTabbedPane= new JTabbedPane();

        ProfileViewImpl panel=new ProfileViewImpl();
        panel.setPreferredSize(new Dimension(200,200));
        panel.setBorder(new EtchedBorder());
        jTabbedPane.addTab("View", panel);

        jTabbedPane.addTab("Edit", new JPanel());
        jDialog.add(jTabbedPane);

        jDialog.setVisible(true);
    }
}
