package org.komar_olga.desktop.view;

import java.awt.Toolkit;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.JXTitledSeparator;
import org.painlessgridbag.PainlessGridBag;

public class ProfileEditImpl extends JPanel {
    String[][] dataName = {{"1", "2"}, {"3", "4"}, {"5", "6"}};
    String[] dataTitle = {"id", "Name"};
    private final DefaultTableModel profileProfileModel = new DefaultTableModel(dataName, dataTitle);

    private JXTable profileProfileJXTable = new JXTable(profileProfileModel);
    private JXTable profileTaskJXTable = new JXTable(profileProfileModel);
    private JXTable profileConnectionJXTable = new JXTable(profileProfileModel);
    private JXTable profileQueryJXTable = new JXTable(profileProfileModel);
    private JScrollPane profileProfileJScrollPane = new JScrollPane(profileProfileJXTable);
    private JScrollPane profileTaskJScrollPane = new JScrollPane(profileTaskJXTable);
    private JScrollPane profileConnectionJScrollPane = new JScrollPane(profileConnectionJXTable);
    private JScrollPane profileQueryJScrollPane = new JScrollPane(profileQueryJXTable);
    private JTabbedPane jTabbedPaneEdit = new JTabbedPane();
    private JTextField jTextFieldNam = new JTextField();
    private DemoCheckComboBox jCheckBoxMenuItem;
    private JComboBox jComboBox=new JComboBox<>();
    private JCheckBox jCheckBox=new JCheckBox("Demo1");

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
        this.jCheckBoxMenuItem=new DemoCheckComboBox(makeModel());
        gbl.row().cell(profileSettings()).fillX();
        gbl.row().separator();
        gbl.row().cell(jComboBox).fillX();
        gbl.row().cell(jCheckBoxMenuItem).fillX();
        gbl.row().cell(jCheckBox).fillX();
        gbl.doneAndPushEverythingToTop();
    }
    private static ComboBoxModel<CheckableItem> makeModel() {
        CheckableItem[] m = {
            new CheckableItem("aaa", false),
            new CheckableItem("bb", true),
            new CheckableItem("111", false),
            new CheckableItem("33333", true),
            new CheckableItem("2222", true),
            new CheckableItem("c", false)
        };
        return new DefaultComboBoxModel<>(m);
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

        this.profileProfileModel.setRowCount(10);
        setProfileProfileModel(profileProfileJXTable);
        setProfileProfileModel(profileTaskJXTable);
        setProfileProfileModel(profileConnectionJXTable);
        setProfileProfileModel(profileQueryJXTable);

        ListSelectionModel cellSElectionModel0 = profileProfileJXTable.getSelectionModel();
        cellSElectionModel0.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSElectionModel0.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedData = (String) profileProfileModel.getValueAt(profileProfileJXTable.getSelectedRow(), 1);
                jTabbedPaneEdit.setSelectedIndex(0);
                jTextFieldNam.setText(selectedData);
            }
        });
        ListSelectionModel cellSElectionModel1 = profileTaskJXTable.getSelectionModel();
        cellSElectionModel1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSElectionModel1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedData = (String) profileProfileModel.getValueAt(profileTaskJXTable.getSelectedRow(), 1);
                jTabbedPaneEdit.setSelectedIndex(1);
                jTextFieldNam.setText(selectedData);
            }
        });
        ListSelectionModel cellSElectionModel2 = profileConnectionJXTable.getSelectionModel();
        cellSElectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSElectionModel2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedData = (String) profileProfileModel.getValueAt(profileConnectionJXTable.getSelectedRow(), 1);
                jTabbedPaneEdit.setSelectedIndex(2);
                jTextFieldNam.setText(selectedData);
            }
        });
        ListSelectionModel cellSElectionModel3 = profileQueryJXTable.getSelectionModel();
        cellSElectionModel3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSElectionModel3.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedData = (String) profileProfileModel.getValueAt(profileQueryJXTable.getSelectedRow(), 1);
                jTabbedPaneEdit.setSelectedIndex(3);
                jTextFieldNam.setText(selectedData);
            }
        });

        gbl.row()
                .cell(profileProfileJScrollPane).fillXY()
                .cell(profileTaskJScrollPane).fillXY()
                .cellX(profileConnectionJScrollPane, 1).fillXY()
                .cellX(profileQueryJScrollPane, 1).fillXY();
        jTabbedPaneEdit = new JTabbedPane();


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
                .cell(new JLabel())
                .fillX();
        gblBtn.done();
        JLabel labelName = new JLabel("Name");
        jTextFieldNam = new JTextField();
        JLabel labelDescription = new JLabel("Description");
        JTextField jTextFieldDescription = new JTextField();

        gblField.row()
                .cell(labelName).cell(jTextFieldNam).fillX();
        gblField.row()
                .cell(labelDescription).cell(jTextFieldDescription).fillX();
        gblField.done();


        return jPanelTabbedPane;
    }

    private void setProfileProfileModel(JXTable jxTable) {

        jxTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jxTable.setColumnControlVisible(true);
        jxTable.setHorizontalScrollEnabled(true);
        jxTable.setEditable(false);
        jxTable.setVisibleRowCount(8);
        jxTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}
