/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.tuandhpc05076.Form;

import com.tuandhpc05076.Object.O_DiemChuyenDe;
import com.tuandhpc05076.Object.O_NguoiHocTungNam;
import com.tuandhpc05076.swing0.Form;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class ThongKeChuyenDe extends Form {

    ArrayList<O_DiemChuyenDe> listDiemCD = new ArrayList<>();
    DefaultTableModel tblModel;
    String userName = "sa";
    String password = "123";
    String url = "jdbc:sqlserver://localhost:1433; databaseName= EduSys;encrypt=false";

    /**
     * Creates new form ChuyenDe
     */
    public ThongKeChuyenDe() {
        initComponents();
        TieuDe();
        loadDataToArray();
        Duyet();
        tblUser.fixTable(jScrollPane2);
        tblUser.setColumnAlignment(0, JLabel.CENTER);
        tblUser.setCellAlignment(0, JLabel.CENTER);
        tblUser.setColumnAlignment(2, JLabel.CENTER);
        tblUser.setCellAlignment(2, JLabel.CENTER);
        tblUser.setColumnAlignment(4, JLabel.RIGHT);
        tblUser.setCellAlignment(4, JLabel.RIGHT);
        tblUser.setColumnWidth(0, 50);
        tblUser.setColumnWidth(2, 100);
    }

    public void TieuDe() {
        tblModel = new DefaultTableModel();
        String[] tbl = new String[]{"Chuyên đề", "Số lượng HV", "Điểm thấp nhất", "Điểm cao nhất", "Điểm TB"};
        tblModel.setColumnIdentifiers(tbl);
        tblUser.setModel(tblModel);
    }

    public void loadDataToArray() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection con = DriverManager.getConnection(url, userName, password);

            String sql = "{CALL sp_ThongKeDiem}";

            CallableStatement stmt = con.prepareCall(sql);
            listDiemCD.clear();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String Nam = rs.getString(1);
                int SoLuong = rs.getInt(2);
                float DiemNN = rs.getFloat(3);
                float DiemLN = rs.getFloat(4);
                float DiemTB = rs.getFloat(5);

                listDiemCD.add(new O_DiemChuyenDe(Nam, SoLuong, DiemNN, DiemLN, DiemTB));

            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Duyet() {
        tblModel.setRowCount(0);
        for (O_DiemChuyenDe nh : listDiemCD) {
            Object[] tbl = new Object[]{nh.getChuyenDe(), nh.getSLHV(), nh.getDiemThapNhat(), nh.getDiemCaoNhat(), nh.getDiemTB()};

            tblModel.addRow(tbl);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblUser = new tabledark.TableDark();

        setBackground(new java.awt.Color(255, 255, 255));

        tblUser.setBackground(new java.awt.Color(0, 0, 0));
        tblUser.setForeground(new java.awt.Color(255, 255, 255));
        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUser.setGridColor(new java.awt.Color(0, 0, 0));
        tblUser.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tblUser.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tblUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private tabledark.TableDark tblUser;
    // End of variables declaration//GEN-END:variables
}