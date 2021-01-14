/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Asus
 */
public class formtransaksi extends javax.swing.JInternalFrame {
    DefaultTableModel tabmode; 
//    HashMap param = HashMap();
//    JasperReport jasReport;
//    JasperPrint jasPrint;
//    JasperDesign jasDesign;
    
    
    
    public void combobox(){
        try {
            Connection koneksi = new koneksi().getConnection();
            Statement stat = koneksi.createStatement();
            String sql = "Select ID_Pegawai from Pegawai";
            ResultSet hasil = stat.executeQuery(sql);
            
            while(hasil.next()){
                Object[] ob = new Object[1];
                ob[0] = hasil.getString(1);
                jComboBox1.addItem((String) ob[0]);
            }
            hasil.close(); 
            stat.close();
            koneksi.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void tampilComboBox(){
        try{
            Connection koneksi = new koneksi().getConnection();
            Statement stat = koneksi.createStatement();
            String sql = "select Nama_Pegawai from Pegawai where ID_Pegawai='"+jComboBox1.getSelectedItem()+"'";
            ResultSet hasil = stat.executeQuery(sql);
            
            while(hasil.next()){
                Object[] ob = new Object[1];
                ob[0] = hasil.getString(1);
                jTextField3.setText((String) ob[0]);
            }
            hasil.close(); 
            stat.close();
            koneksi.close();
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    
    public void combobox2(){
        try {
            Connection koneksi = new koneksi().getConnection();
            Statement stat = koneksi.createStatement();
            String sql = "Select ID_Pelanggan from Pelanggan";
            ResultSet hasil = stat.executeQuery(sql);
            
            while(hasil.next()){
                Object[] ob = new Object[1];
                ob[0] = hasil.getString(1);
                jComboBox2.addItem((String) ob[0]);
            }
            hasil.close(); 
            stat.close();
            koneksi.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil_transaksi(){
        Object[]baris = {"ID Transaksi", "ID Pesanan", "ID Pegawai", "Nama Pegawai", "ID Pelanggan", "Total Bayar"};
        tabmode= new DefaultTableModel(null, baris);
        jTable1.setModel(tabmode);
        String sql = "select Transaksi.ID_Transaksi, Transaksi.ID_Pesanan, Transaksi.ID_Pegawai, Pegawai.Nama_Pegawai, "
                + "Transaksi.ID_Pelanggan, Transaksi.Total_Bayar from Pegawai, Transaksi where "
                + "Pegawai.ID_Pegawai=Transaksi.ID_Pegawai";
        try {
            Connection koneksi = new koneksi().getConnection();
            Statement stat = koneksi.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            String   nama_pegawai = namaPegawaiLabel;
            while (hasil.next()){
                String id_transaksi = hasil.getString("ID_Transaksi");
                String id_pesanan = hasil.getString("ID_Pesanan");
                String id_pegawai = hasil.getString("ID_Pegawai");
                nama_pegawai = hasil.getString("Nama_Pegawai");
                String id_pelanggan = hasil.getString("ID_Pelanggan");
                String total_bayar = hasil.getString("Total_Bayar");
                String[]data = {id_transaksi, id_pesanan, id_pegawai, nama_pegawai, id_pelanggan, total_bayar};
                tabmode.addRow(data);
            }
            koneksi.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Creates new form formtransaksi
     */
    public formtransaksi() {
        initComponents();
        combobox();
        combobox2();
        tampil_transaksi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gatau = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        namaPegawaiLabel = new javax.swing.JLabel();

        gatau.setBackground(new java.awt.Color(0, 255, 255));
        gatau.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                gatauAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Transaksi");

        jLabel2.setText("ID Transaksi");

        jLabel3.setText("ID Pesanan");

        jLabel4.setText("ID Pegawai");

        jLabel5.setText("Nama Pegawai");

        jLabel6.setText("ID Pelanggan");

        jLabel8.setText("Total Bayar");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "~" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ubah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "ID Pesanan", "ID Pegawai", "Nama Pegawai", "ID Pelanggan", "Total Bayar"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        namaPegawaiLabel.setText(" ");

        javax.swing.GroupLayout gatauLayout = new javax.swing.GroupLayout(gatau);
        gatau.setLayout(gatauLayout);
        gatauLayout.setHorizontalGroup(
            gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gatauLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(261, 261, 261))
            .addGroup(gatauLayout.createSequentialGroup()
                .addGroup(gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gatauLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(81, 81, 81)
                        .addGroup(gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gatauLayout.createSequentialGroup()
                                .addGroup(gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(namaPegawaiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(gatauLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jButton1)
                        .addGap(34, 34, 34)
                        .addComponent(jButton2)
                        .addGap(35, 35, 35)
                        .addComponent(jButton3)
                        .addGap(31, 31, 31)
                        .addComponent(btnCetak)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        gatauLayout.setVerticalGroup(
            gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gatauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(namaPegawaiLabel))
                .addGap(18, 18, 18)
                .addGroup(gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(gatauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(btnCetak))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gatau.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jComboBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jTextField5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(btnCetak, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        gatau.setLayer(namaPegawaiLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gatau)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gatau)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        tampilComboBox();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ID_Transaksi="", ID_Pesanan = "", Total_Bayar = "";
        
        ID_Transaksi = jTextField1.getText();
        String ID_Pegawai = (String) jComboBox1.getSelectedItem();
        String ID_Pelanggan = (String) jComboBox2.getSelectedItem();
        ID_Pesanan = jTextField2.getText();
        Total_Bayar = jTextField5.getText();
        try {
            Connection koneksi = new koneksi().getConnection();
            String sql = "insert into Transaksi values('"+ID_Transaksi+"', '"+ID_Pesanan+"', '"+ID_Pegawai+"', '"+ID_Pelanggan+"', '"+Total_Bayar+"')";
            PreparedStatement stat = (PreparedStatement) koneksi.prepareStatement(sql);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Menyimpan data BERHASIL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            tampil_transaksi(); //view data kedalam tabel
            reset();
            koneksi.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Menyimpan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int J_Table1 = jTable1.getSelectedRow();
        jTextField1.setText(jTable1.getValueAt(J_Table1, 0).toString());
        jTextField2.setText(jTable1.getValueAt(J_Table1, 1).toString());
        jComboBox1.setSelectedItem(jTable1.getValueAt(J_Table1, 2).toString());
        namaPegawaiLabel.setText(jTable1.getValueAt(J_Table1, 3).toString());
        jComboBox2.setSelectedItem(jTable1.getValueAt(J_Table1, 4).toString());
        jTextField5.setText(jTable1.getValueAt(J_Table1, 5).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String ID_Transaksi="", ID_Pesanan = "", Total_Bayar = "";
        
        ID_Transaksi = jTextField1.getText();
        String ID_Pegawai = (String) jComboBox1.getSelectedItem();
        String ID_Pelanggan = (String) jComboBox2.getSelectedItem();
        ID_Pesanan = jTextField2.getText();
        Total_Bayar = jTextField5.getText();
        try {
            Connection koneksi = new koneksi().getConnection();
            String sql = "update Transaksi set "
                    + "ID_Pegawai='"+ID_Pegawai+"',"
                    + "ID_Pelanggan='"+ID_Pelanggan+"',"
                    + "ID_Pesanan='"+ID_Pesanan+"',"
                    + "Total_Bayar='"+Total_Bayar+"'"
                    + "where ID_Transaksi='"+ID_Transaksi+"'";
            PreparedStatement stat = (PreparedStatement) koneksi.prepareStatement(sql);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Merubah data BERHASIL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            tampil_transaksi();
            reset();
            koneksi.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Merubah data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String ID_Transaksi = jTextField1.getText();
        try {
            Connection koneksi = new koneksi().getConnection();
            String sql = "delete from Transaksi where ID_Transaksi='"+ID_Transaksi+"'";
            PreparedStatement stat = (PreparedStatement) koneksi.prepareStatement(sql);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Menghapus data BERHASIL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            tampil_transaksi();
            reset();
            koneksi.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Menghapus data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        
        
//        try {
//            String namaFile = "src/resto/laporanResto.jasper";
//        String url = "jdbc:oracle:thin:@localhost:1521:XE";
//        String dbName = "uaspbd";
//        String driver = "oracle.jdbc.OracleDriver";
//        String usertname = "uaspbd";
//        String password = "uas";
//        Class.forName("oracle.jdbc.OracleDriver").newInstance();
//        Connection koneksi = DriverManager.getConnection(url + dbName, usertname, password);
//        HashMap param = new HashMap();
//        //mengambil parameter
//        param.put("no_transaksi", Integer.valueOf(String.getText()));
//        } catch (Exception e) {
//        }  
        try {
            Connection koneksi = new koneksi().getConnection();
            Statement stat = koneksi.createStatement();
            String sql = "Select ID_Pegawai from Pegawai";
            ResultSet hasil = stat.executeQuery(sql);
            String file = "src/resto/laporanResto.jasper";
            JasperPrint jp = JasperFillManager.fillReport(file, null, koneksi());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (Exception e) {
            System.out.print(e);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void gatauAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gatauAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_gatauAncestorAdded

    private void namaPegawai(){
        try {
            Connection koneksi = new koneksi().getConnection();
            String sql = "select max(nama_pegawai) from pegawai";
            PreparedStatement stat = koneksi.prepareCall(sql);
            ResultSet hasil = stat.executeQuery(sql);
            stat.executeQuery();
            while(hasil.next()){
                String namaPegawai = hasil.getString(1);
                namaPegawaiLabel.setText(sql);
            }
            tampil_transaksi();
            reset();
            koneksi().close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void reset(){
        jTextField1.setText("");
        jComboBox1.setSelectedItem("Pilih");
        jComboBox2.setSelectedItem("Pilih");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JDesktopPane gatau;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel namaPegawaiLabel;
    // End of variables declaration//GEN-END:variables

    private HashMap HashMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Connection koneksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
