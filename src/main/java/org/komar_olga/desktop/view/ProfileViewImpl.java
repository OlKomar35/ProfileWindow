package org.komar_olga.desktop.view;


import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.JXTitledSeparator;
import org.painlessgridbag.PainlessGridBag;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProfileViewImpl extends JPanel {

    private JPanel jPanel = new JPanel();
    String[][] dataName={{"1","2"},{"3","4"},{"5","6"}};
    String[] dataTitle={"Number","Content"};
    private final DefaultTableModel profileProfileModel = new DefaultTableModel(dataName,dataTitle);

    private JXTable profileProfileJXTable = new JXTable(profileProfileModel);
    private final JXTable profileTaskJXTable = new JXTable(profileProfileModel);
    private final JXTable profileSqlJXTable = new JXTable();
    private final JXTable profileMetadataJXTable = new JXTable();
    private final JScrollPane profileProfileJScrollPane = new JScrollPane(profileProfileJXTable);
    private final JScrollPane profileTaskJScrollPane = new JScrollPane(profileTaskJXTable);
    private final JScrollPane profileSqlJScrollPane = new JScrollPane();
    private final JScrollPane profileMetadataJScrollPane = new JScrollPane();
    private final DetailedComboBox profileConnectionDetailedComboBox = new DetailedComboBox(new String[]{"name"}, new int[]{1}, 2);
    private final JTextField profileUrlJTextField = new JTextField();
    private final JScrollPane profileSqlTextJScrollPane = new JScrollPane();
    private final JScrollPane profileSqlDescJScrollPane = new JScrollPane();
    private final JTextArea profileSqlTextJTextArea = new JTextArea();
    private final JTextArea profileSqlDescJTextArea = new JTextArea();




    public ProfileViewImpl() {
//        this.jFrame = new JFrame();
//        this.profileProfileJXTable = new JTable();
//        this.profileTaskJXTable = new JTable();
//        this.profileSqlJXTable = new JTable();
//        this.profileMetadataJXTable = new JTable();
//        this.profileProfileJScrollPane = new JScrollPane();
//        this.profileTaskJScrollPane = new JScrollPane();
//        this.profileSqlJScrollPane = new JScrollPane();
//        this.profileMetadataJScrollPane = new JScrollPane();
//        this.profileUrlJTextField = new JTextField();
//        this.profileSqlTextJScrollPane = new JScrollPane();
//        this.profileSqlDescJScrollPane = new JScrollPane();
//        this.profileSqlTextJTextArea = new JTextArea();
//        this.profileSqlDescJTextArea = new JTextArea();





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

//        gbl.row()
//                .cellX(getButtonPanel(), 4).fillX();

        gbl.row()
                .cell(new JXTitledSeparator("Profile")).fillX()
                .cell(new JXTitledSeparator("Task")).fillX()
                .cell(new JXTitledSeparator("Connection")).fillX()
                .cell(new JXTitledSeparator("")).fillX();


        gbl.row()
                .cellX(profileProfileJScrollPane,1).fillXY()
                .cellX(profileTaskJScrollPane, 1).fillXY()
                .cellX(getConnectionAndSql(), 2).fillXY();

        gbl.row()
                .cellXRemainder(profileSqlTextJScrollPane).fillX();


        JTextArea jTextArea = new JTextArea(15, 50);

        gbl.row().cellXYRemainder(jTextArea).fillXY();
        gbl.done();

        return panelSettings;
    }

//    private JPanel getButtonPanel() {
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setBorder(new EtchedBorder());
//        PainlessGridBag gblButton = new PainlessGridBag(buttonPanel, GUIHelper.getPainlessGridbagConfiguration(), false);
//
//        gblButton.row()
//                .cell(GUIHelper.getJButton("Profile"))
//                .cell(GUIHelper.getJButton("Task"))
//                .cell(GUIHelper.getJButton("Connection"))
//                .cell(GUIHelper.getJButton("SQL"))
//                .separator();
//
//        gblButton.done();
//
//        return buttonPanel;
//    }

    private JPanel getConnectionAndSql() {
        JPanel jPanel = new JPanel();

        PainlessGridBag gbl = new PainlessGridBag(jPanel, false);

        JLabel lblName = new JLabel("Name");
        JLabel lblUrl = new JLabel("Url");

        gbl.row().cell(lblName).cell(profileConnectionDetailedComboBox).fillX();
        gbl.row().cell(lblUrl).cell(profileUrlJTextField).fillX();

        gbl.row()
                .cellXRemainder(getSql()).fillX();

        gbl.done();

        return jPanel;
    }

    private JPanel getSql() {
        JPanel jPanel = new JPanel();

        PainlessGridBag gbl = new PainlessGridBag(jPanel, false);

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.add("SQL", profileSqlJScrollPane);
        jTabbedPane.add("Description", profileSqlDescJScrollPane);
        jTabbedPane.add("Metadata", profileMetadataJScrollPane);

        gbl.row()
                .cell(jTabbedPane).fillX();

        gbl.done();

        return jPanel;
    }

    public void showProfile(int id) {
        try {

            //int rowIndex = getRowIndexForIdColumnFromModel("ProfileColumnNames.ID.getColName()", id);
            profileProfileJXTable.setRowSelectionInterval(0, 0);
            profileTaskJXTable.setRowSelectionInterval(0, 0);
            profileSqlJXTable.setRowSelectionInterval(0, 0);

            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setVisible(true);
        this.setSize(800, 600);
    }

    private int getRowIndexForIdColumnFromModel(String columnName, int columnValue) {
        int index = 0;
        for (int i = 0; i < profileProfileModel.getRowCount(); i++) {
            int rowValue = (int) profileProfileModel.getValueAt(i, profileProfileModel.findColumn(columnName));
            if (columnValue == rowValue) {
                index = i;
            }
        }

        return index;
    }
//
//    public void hideProfile() {
//        this.setVisible(false);
//    }

//    //@Override
//    public void bindPresenter() {
//        //profilePresenter.get().fillProfileModel(profileProfileModel);
//
//        profileProfileJXTable.getColumnExt(0).setVisible(false);
//        //profileProfileJXTable.getColumnModel().getColumn(0).setCellRenderer(new ActiveColumnCellRenderer());
//
//        profileTaskJXTable.getColumnExt(0).setVisible(false);
//        //profileTaskJXTable.getColumnModel().getColumn(0).setCellRenderer(new ActiveColumnCellRenderer());
//
//        profileSqlJXTable.getColumnExt(0).setVisible(false);
//        //profileSqlJXTable.getColumnModel().getColumn(0).setCellRenderer(new ActiveColumnCellRenderer());
//
//        profileMetadataJXTable.getColumnExt(0).setVisible(false);
//        //profileMetadataJXTable.getColumnModel().getColumn(0).setCellRenderer(new ActiveColumnCellRenderer());
//
//        //addWindowListener(profilePresenter.get());
//    }
}
