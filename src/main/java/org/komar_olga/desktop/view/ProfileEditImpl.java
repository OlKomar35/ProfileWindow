package org.komar_olga.desktop.view;

import org.jdesktop.swingx.JXTitledSeparator;
import org.painlessgridbag.PainlessGridBag;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ProfileEditImpl extends JPanel {
    private JScrollPane profileProfileJScrollPane = new JScrollPane();
    private JScrollPane profileTaskJScrollPane = new JScrollPane();
    private JScrollPane profileConnectionJScrollPane = new JScrollPane();
    private JScrollPane profileQueryJScrollPane = new JScrollPane();

    public ProfileEditImpl() {
        this.fillContentPane();

        this.setVisible(true);

        //this.pack();
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - getWidth() / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - getHeight() / 2);
    }

    private void fillContentPane() {

        this.setBorder(new EtchedBorder());

        PainlessGridBag gbl = new PainlessGridBag(this, false);

        gbl.row().cell(profileSettings()).fillX();
        gbl.row().separator();

        gbl.doneAndPushEverythingToTop();
    }

    private JPanel profileSettings() {
        JPanel panelSettings = new JPanel();
        panelSettings.setBorder(new EtchedBorder());

        PainlessGridBag gbl = new PainlessGridBag(panelSettings, false);

        gbl.row()
                .cell(new JXTitledSeparator("Profile")).fillX()
                .cell(new JXTitledSeparator("Task")).fillX()
                .cell(new JXTitledSeparator("Connection")).fillX()
                .cell(new JXTitledSeparator("Query")).fillX();


        gbl.row()
                .cellX(profileProfileJScrollPane, 1).fillX()
                .cellX(profileTaskJScrollPane, 1).fillX()
                .cellX(profileConnectionJScrollPane, 1).fillX()
                .cellX(profileQueryJScrollPane, 1).fillX();
        JTabbedPane jTabbedPaneEdit = new JTabbedPane();


        jTabbedPaneEdit.addTab("Profile", getJTabbedPane());
        jTabbedPaneEdit.addTab("Task", getJTabbedPane());
        jTabbedPaneEdit.addTab("Connection", getJTabbedPane());
        jTabbedPaneEdit.addTab("Query", getJTabbedPane());

        gbl.row()
                .cellXRemainder(jTabbedPaneEdit).fillXY();

        gbl.done();

        return panelSettings;
    }

    private JPanel getJTabbedPane() {
        JPanel jPanelTabbedPane = new JPanel();
        JPanel jPanelBtn = new JPanel();
        JPanel jPanelTextField = new JPanel();
        PainlessGridBag gbl = new PainlessGridBag(jPanelTabbedPane, false);
        PainlessGridBag gblBtn = new PainlessGridBag(jPanelBtn, false);
        PainlessGridBag gblField = new PainlessGridBag(jPanelTextField, false);

        gbl.row()
                .cellXRemainder(jPanelBtn).fillXY();
        gbl.row()
                .cellXRemainder(jPanelTextField).fillXY();
        gbl.done();
        JButton btnNew = new JButton("New");
        JButton btnCopy = new JButton("Copy");
        JButton btnDel = new JButton("Delete");
        JButton btnEdit = new JButton("Edit");
        JButton btnSave = new JButton("Save");
        btnSave.setEnabled(false);
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setEnabled(false);

        gblBtn.row()
                .cell(btnNew)
                .cell(btnCopy)
                .cell(btnDel)
                .cell(btnEdit)
                .cell(btnSave)
                .cell(btnCancel)
                .separator();
        gblBtn.done();
        JLabel labelName = new JLabel("Name");
        JTextField jTextFieldNam = new JTextField();
        JLabel labelDescription = new JLabel("Description");
        JTextField jTextFieldDescription = new JTextField();
//        JLabel jLabel = new JLabel();
//
//        gblField.row().cell(jLabel).fillX();
//        gbl.row().cell(jLabel).fillX();
//        gbl.row().cell(jLabel).fillX();

        gblField.row()
                .cell(labelName).cell(jTextFieldNam).fillX();
        gblField.row()
                .cell(labelDescription).cell(jTextFieldDescription).fillX();
        gblField.done();


        return jPanelTabbedPane;
    }

}
