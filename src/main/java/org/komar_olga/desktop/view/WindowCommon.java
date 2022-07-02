package org.komar_olga.desktop.view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class WindowCommon extends JDialog {

    private JDialog jDialog;
    private JTabbedPane jTabbedPane;


    public WindowCommon() {
        jDialog = new JDialog();
        jDialog.setSize(800, 600);
        jDialog.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - jDialog.getWidth() / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - jDialog.getHeight() / 2);
        jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jTabbedPane = new JTabbedPane();


        ProfileViewImpl panelView = new ProfileViewImpl();
        ProfileEditImpl panelEdit = new ProfileEditImpl();
        panelView.setPreferredSize(new Dimension(200, 200));
        panelView.setBorder(new EtchedBorder());
        jTabbedPane.addTab("View", panelView);
        panelEdit.setPreferredSize(new Dimension(200, 200));
        panelEdit.setBorder(new EtchedBorder());
        jTabbedPane.addTab("Edit", panelEdit);
        jDialog.add(jTabbedPane);

        jDialog.setVisible(true);
    }
}
