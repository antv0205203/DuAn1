/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tuandhpc05076.Main;

import com.tuandhpc05076.BieuDo.FormHome;
import com.tuandhpc05076.ChuongTrinh.ChaoJDialog;
import com.tuandhpc05076.ChuongTrinh.GioiThieuJDialog;
import com.tuandhpc05076.DangNhap.quenMatKhau;
import com.tuandhpc05076.Demo.demo01;
import com.tuandhpc05076.Form.ChuyenDe;

import com.tuandhpc05076.Form.HocVien;
import com.tuandhpc05076.Form.Home_Form;
import com.tuandhpc05076.Form.KhoaHoc;
import com.tuandhpc05076.Form.NguoiHoc;
import com.tuandhpc05076.Form.NhanVien;
import com.tuandhpc05076.Form.Setting_Form;
import com.tuandhpc05076.Form.ThongKeChuyenDe;
import com.tuandhpc05076.Form.ThongKeDiemTungKhoaHoc;
import com.tuandhpc05076.Form.ThongKeDoanhThu;
import com.tuandhpc05076.Form.ThongKeKhoaHoc;
import com.tuandhpc05076.Form.ThongKeNguoiHocTungNam;
import com.tuandhpc05076.Object.O_DangNhap;
import com.tuandhpc05076.swing0.EventColorChange;
import com.tuandhpc05076.swing0.EventMenu;
import com.tuandhpc05076.swing0.SystemProperties;
import com.tuandhpc05076.swing0.SystemTheme;
import com.tuandhpc05076.swing0.ThemeColor;
import com.tuandhpc05076.swing0.ThemeColorChange;
import com.tuandhpc05076.ThoiGian.Time;
import com.tuandhpc05076.helper.ShareHelper;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.time.Clock;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL E5470
 */
public class Main extends javax.swing.JFrame {

    private Setting_Form settingForm;
    //dùng để set tiêu đề
    FormHome banDo = new FormHome();
    boolean kiem = false;

    public Main() {
//        setUndecorated(true);
        initComponents();
//        setBackground(new Color(0, 0, 0));
//        Time tg = new Time(txtThoiGian);
//        tg.start();
//        for (O_DangNhap dn : listDangNhap) {
//            if (dn.isVaiTro() == false) {
//                kiem = true;
//            }
//        }
        init();
    }
    
    int i = 0;

    private void init() {
        header.initMoving(this);
        header.initEvent(this, panelBackground1);

        menu.addEventMenu(new EventMenu() {
            @Override
            public void selectedMenu(int index) {
                if (index == 0) {
                    mainBody.displayForm(new demo01());
                }
                if (index == 1) {
                    mainBody.displayForm(new demo01(), "Chuyên đề");
                }
                if (index == 2) {
                    mainBody.displayForm(new demo01(), "Khóa học");
                }
                if (index == 3) {
                    mainBody.displayForm(new demo01(), "Người học");
                }
                if (index == 4) {
                    mainBody.displayForm(new demo01(), "Học viên");
                }
                if (index == 5) {
                    mainBody.displayForm(new demo01(), "Nhân viên");
                }
                if (index == 6) {
                    if (kiem == false) {
                        mainBody.displayForm(new demo01(), "Thống kê doang thu");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Bạn không có quyền xem doanh thu");
                    }
                }
                if (index == 7) {

                    if (kiem == false) {
                        mainBody.displayForm(new demo01(), "Biểu đồ");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Bạn không có quyền xem biểu đồ doanh thu");
                    }
                }
                if (index == 8) {
                    mainBody.displayForm(new demo01(), "Thống kê từng khóa học");
                    
                }
                if (index == 9) {
                    mainBody.displayForm(new demo01(), "Thống kế người học từng năm");
                }
                if (index == 10) {
                    mainBody.displayForm(new demo01(), "Thống kê chuyên đề");
                } else if (index == 11) {
                    mainBody.displayForm(settingForm, "Cài đặt");
                }
            }
        });
        ThemeColorChange.getInstance().addThemes(new ThemeColor(new Color(34, 34, 34), Color.WHITE) {
            @Override
            public void onColorChange(Color color) {
                panelBackground1.setBackground(color);

            }
        });
        ThemeColorChange.getInstance().addThemes(new ThemeColor(Color.WHITE, new Color(80, 80, 80)) {
            @Override
            public void onColorChange(Color color) {
                mainBody.changeColor(color);

            }
        });

        ThemeColorChange.getInstance().initBackground(panelBackground1);
//        SystemProperties pro = new SystemProperties();
//        pro.loadFromFile();
//       
//        if (!pro.isDarkMode()) {
        ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.LIGHT);
        panelBackground1.setBackground(Color.WHITE);
        mainBody.changeColor(new Color(80, 80, 80));
//        }
//        if (pro.getBackgroundImage() != null) {
//            ThemeColorChange.getInstance().changeBackgroundImage(pro.getBackgroundImage());
//        }

//        SystemTheme.mainColor = pro.getColor();
        settingForm = new Setting_Form();
        settingForm.setEventColorChange(new EventColorChange() {
            @Override
            public void colorChange(Color color) {
                SystemTheme.mainColor = color;
                ThemeColorChange.getInstance().ruenEventColorChange(color);

                repaint();
//                pro.save("theme_color", color.getRGB() + "");
            }
        });
//        settingForm.setSelectedThemeColor(pro.getColor());
//        settingForm.setDarkMode(pro.isDarkMode());
//        settingForm.initBackgroundImage(pro.getBackgroundImage());
        settingForm.setDarkMode(false);
        mainBody.changeColor(new Color(80, 80, 80));

        mainBody.displayForm(new demo01());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        panelBackground1 = new com.tuandhpc05076.swing0.PanelBackground();
        header = new com.tuandhpc05076.swing0.Header();
        mainBody = new com.tuandhpc05076.ChuongTrinh.MainBody();
        menu = new com.tuandhpc05076.ChuongTrinh.Menu();
        txtThoiGian = new javax.swing.JLabel();
        textImage1 = new com.tuandhpc05076.Swing.TextImage();
        txtAP = new javax.swing.JLabel();
        txtTuyenSinh = new javax.swing.JLabel();
        txtCaoDang = new javax.swing.JLabel();

        jMenuItem2.setText("jMenuItem2");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        setForeground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(1200, 700));

        panelBackground1.setBackground(new java.awt.Color(34, 34, 34));
        panelBackground1.setPreferredSize(new java.awt.Dimension(1200, 700));

        header.setPreferredSize(new java.awt.Dimension(100, 22));

        mainBody.setPreferredSize(new java.awt.Dimension(873, 479));

        menu.setBackground(new java.awt.Color(34, 34, 34));

        txtThoiGian.setForeground(new java.awt.Color(255, 153, 255));
        txtThoiGian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tuandhpc05076/icon1/alarm-clock.png"))); // NOI18N

        textImage1.setText("TTA MOBILE");
        textImage1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        textImage1.setTextImage(new javax.swing.ImageIcon(getClass().getResource("/com/tuandhpc05076/Image/bg_5_small.jpg"))); // NOI18N

        txtAP.setForeground(new java.awt.Color(255, 153, 255));
        txtAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tuandhpc05076/icon1/10.png"))); // NOI18N
        txtAP.setText("ap.poly.edu.vn");
        txtAP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtAPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtAPMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtAPMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtAPMouseReleased(evt);
            }
        });

        txtTuyenSinh.setForeground(new java.awt.Color(255, 153, 255));
        txtTuyenSinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tuandhpc05076/Image/teamwork.png"))); // NOI18N
        txtTuyenSinh.setText("Tuyển sinh");
        txtTuyenSinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTuyenSinhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTuyenSinhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTuyenSinhMouseExited(evt);
            }
        });

        txtCaoDang.setForeground(new java.awt.Color(255, 153, 255));
        txtCaoDang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tuandhpc05076/Image/book-stack.png"))); // NOI18N
        txtCaoDang.setText("caodang@fpt.edu.vn");
        txtCaoDang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCaoDangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCaoDangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtCaoDangMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBackground1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTuyenSinh)
                                    .addGroup(panelBackground1Layout.createSequentialGroup()
                                        .addComponent(txtCaoDang)
                                        .addGap(18, 18, 18)
                                        .addComponent(textImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAP)
                                    .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 65, Short.MAX_VALUE))
                            .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, 0))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBackground1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelBackground1Layout.createSequentialGroup()
                                        .addComponent(txtAP)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtThoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCaoDang))))
                            .addGroup(panelBackground1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtTuyenSinh)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        panelBackground1.getAccessibleContext().setAccessibleParent(panelBackground1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAPMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPMouseReleased

    private void txtAPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAPMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPMousePressed

    private void txtAPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAPMouseExited
        txtAP.setForeground(new Color(255, 153, 255));        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPMouseExited

    private void txtAPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAPMouseEntered
        txtAP.setForeground(Color.yellow);        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPMouseEntered

    private void txtAPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAPMouseClicked
        // TODO add your handling code here:
        Desktop d = Desktop.getDesktop();
        try {
            d.browse(new URI("https://ap.poly.edu.vn"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }//GEN-LAST:event_txtAPMouseClicked

    private void txtTuyenSinhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuyenSinhMouseExited
        // TODO add your handling code here:
        txtTuyenSinh.setForeground(new Color(255, 153, 255));
    }//GEN-LAST:event_txtTuyenSinhMouseExited

    private void txtTuyenSinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuyenSinhMouseEntered
        txtTuyenSinh.setForeground(Color.yellow);         // TODO add your handling code here:
    }//GEN-LAST:event_txtTuyenSinhMouseEntered

    private void txtTuyenSinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuyenSinhMouseClicked
        // TODO add your handling code here:
        Desktop d = Desktop.getDesktop();
        try {
            d.browse(new URI("https://caodang.fpt.edu.vn/tuyen-sinh-cao-dang-xet-tuyen?utm_source=Google&utm_medium=CPC&utm_campaign=CD_FPT&gad=1&gclid=CjwKCAjw04yjBhApEiw"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }//GEN-LAST:event_txtTuyenSinhMouseClicked

    private void txtCaoDangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCaoDangMouseExited
        // TODO add your handling code here:
        txtCaoDang.setForeground(new Color(255, 153, 255));
    }//GEN-LAST:event_txtCaoDangMouseExited

    private void txtCaoDangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCaoDangMouseEntered
        txtCaoDang.setForeground(Color.yellow);        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaoDangMouseEntered

    private void txtCaoDangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCaoDangMouseClicked
        // TODO add your handling code here:
        Desktop d = Desktop.getDesktop();
        try {
            d.browse(new URI("https://mail.google.com/mail/u/0/#drafts?compose=DmwnWrRvwMBZsWmBwWVzXSfVGwLPhgtBgSWhTKgPDdJbKJhgScKBXQJRCHcMCBnhxpSBqNhXkvwG"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }//GEN-LAST:event_txtCaoDangMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.tuandhpc05076.swing0.Header header;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private com.tuandhpc05076.ChuongTrinh.MainBody mainBody;
    private com.tuandhpc05076.ChuongTrinh.Menu menu;
    private com.tuandhpc05076.swing0.PanelBackground panelBackground1;
    private com.tuandhpc05076.Swing.TextImage textImage1;
    private javax.swing.JLabel txtAP;
    private javax.swing.JLabel txtCaoDang;
    private javax.swing.JLabel txtThoiGian;
    private javax.swing.JLabel txtTuyenSinh;
    // End of variables declaration//GEN-END:variables
}
