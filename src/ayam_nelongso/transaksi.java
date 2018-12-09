/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam_nelongso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import login.login;

/**
 *
 * @author ASUS
 */
public class transaksi extends javax.swing.JFrame {

    ArrayList daftar = new ArrayList();
    ArrayList<nota_helper> nota_sementara = new ArrayList<nota_helper>();
    Connection konek = koneksi.getConnection();
    int ambil_total = 0;
    Statement stment;

    /**
     * Creates new form transaksi
     */
    public transaksi() {
        initComponents();
        daftar_makanan();
        daftar_minuman();
    }

    public void daftar_makanan() {
        try {
            String sql = "SELECT * From makanan"; //milih table
            stment = konek.createStatement(); // menghubungkan dengan database 
            ResultSet res = stment.executeQuery(sql); // menghubungkan dengan pilihan yg dipilih
            nama_makanan.addItem("Pilih makanan ");
            while (res.next()) {
                nama_makanan.addItem(res.getString("Nama_Makanan")); // Nama_Makanan dari db nya, buat nampilin yg dipilih
            }

        } catch (SQLException pes) {
            JOptionPane.showMessageDialog(null, pes.getMessage());

        }
        jumlah_makan.setText("0");
    }

    public void daftar_minuman() {
        try {
            String sql = "SELECT * From minuman"; //milih table
            stment = konek.createStatement(); // menghubungkan dengan database 
            ResultSet res = stment.executeQuery(sql); // menghubungkan dengan pilihan yg dipilih
            nama_minuman.addItem("Pilih minuman ");
            while (res.next()) {
                nama_minuman.addItem(res.getString("Nama_Minuman")); // Nama_Makanan dari db nya, buat nampilin yg dipilih
            }

        } catch (SQLException pes) {
            JOptionPane.showMessageDialog(null, pes.getMessage());

        }
        jumlah_minum.setText("0");
    }

    public void table() {
        String sim_harga1 = "0";
        String sim_harga2 = "0";
        String daftar_makanan = (String) nama_makanan.getSelectedItem();
        String daftar_minuman = (String) nama_minuman.getSelectedItem();
        try {
            String sql = "Select * from makanan where Nama_Makanan='" + daftar_makanan + "'";
            stment = konek.createStatement();
            ResultSet res = stment.executeQuery(sql);
            while (res.next()) {
                sim_harga1 = res.getString("Harga");
            }
            String sql2 = "Select * from minuman where Nama_Minuman='" + daftar_minuman + "'";
            stment = konek.createStatement();
            ResultSet res2 = stment.executeQuery(sql2);
            while (res2.next()) {
                sim_harga2 = res2.getString("Harga");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        int harga1 = Integer.parseInt(sim_harga1);
        int jum_harga1 = Integer.parseInt(jumlah_makan.getText());
        int harga2 = Integer.parseInt(sim_harga2);
        int jum_harga2 = Integer.parseInt(jumlah_minum.getText());
        int tot1 = harga1 * jum_harga1;
        int tot2 = harga2 * jum_harga2;
        //int total_3 = tot1 + tot2;
        daftar.add(daftar_makanan);
        daftar.add(daftar_minuman);
        daftar.add(sim_harga1);
        daftar.add(sim_harga2);
        daftar.add(jumlah_makan.getText());
        daftar.add(jumlah_minum.getText());
        if (jumlah_makan.getText().equalsIgnoreCase("0")) {
            daftar.add(Integer.toString(tot2));
            ambil_total = tot2;
        } else if (jumlah_minum.getText().equalsIgnoreCase("0")) {
            daftar.add(Integer.toString(tot1));
            ambil_total = tot1;
        }
        jumlah_makan.setText("0");
        jumlah_minum.setText("0");
        tot1 = 0;
        tot2 = 0;
    }
    
    public void simpan_trans(){
        try{
            String sql = "insert into transaksi (kode_karyawan,nama_pelanggan,total) values ('"+nama_kasir.getText()+"','"+nama_pembeli.getText()+"','"+total_bayar.getText()+"')";
            stment = konek.createStatement();
            stment.execute(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage()+"Gagal Disimpan");
        }
    }

    public void total_bayar() {
        int total = 0;
        int tot = 0;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            tot = Integer.parseInt((String) jTable1.getValueAt(i, 6));
            total += tot;
        }
        total_bayar.setText(Integer.toString(total));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nama_minuman = new javax.swing.JComboBox<>();
        tot = new javax.swing.JLabel();
        kem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        kembali = new javax.swing.JButton();
        nama_makanan = new javax.swing.JComboBox<>();
        proses_transaksi = new javax.swing.JButton();
        ulang = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        antrian = new javax.swing.JLabel();
        nama_kasir = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jumlah_makan = new javax.swing.JTextField();
        jumlah_minum = new javax.swing.JTextField();
        bayar = new javax.swing.JTextField();
        kembalian = new javax.swing.JTextField();
        total_bayar = new javax.swing.JTextField();
        nama_pembeli = new javax.swing.JTextField();
        antrian1 = new javax.swing.JLabel();
        antrian2 = new javax.swing.JLabel();
        antrian3 = new javax.swing.JLabel();
        antrian4 = new javax.swing.JLabel();
        antrian5 = new javax.swing.JLabel();
        antrian6 = new javax.swing.JLabel();
        antrian7 = new javax.swing.JLabel();
        kem1 = new javax.swing.JLabel();
        kem2 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(129, 207, 224));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Makanan");

        jLabel2.setText("Minuman");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton2.setText("Ulang");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Total");

        jLabel6.setText("Bayar");

        jButton3.setText("Kembali");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Kembalian");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jButton1.setText("Proses");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(308, 308, 308)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(86, 86, 86))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("jLabel7");

        jLabel11.setText("jLabel11");

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel16.setFont(new java.awt.Font("Tekton Pro", 0, 24)); // NOI18N
        jLabel16.setText("T R A N S A K S I");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(559, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(513, 513, 513))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -30, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("Bayar         : ");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("Jumlah beli  ");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setText("Nomor Antrian ");

        nama_minuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_minumanActionPerformed(evt);
            }
        });

        tot.setBackground(new java.awt.Color(255, 255, 255));
        tot.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        tot.setForeground(new java.awt.Color(204, 204, 255));
        tot.setText("Total Bayar  ");

        kem.setBackground(new java.awt.Color(255, 255, 255));
        kem.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        kem.setForeground(new java.awt.Color(204, 204, 255));
        kem.setText("Kembalian     ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Makanan", "Minuman", "Harga Makanan", "Harga Minuman", "Jumlah Makanan", "Jumlah Minuman", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        kembali.setBackground(new java.awt.Color(34, 167, 240));
        kembali.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        kembali.setForeground(new java.awt.Color(255, 255, 255));
        kembali.setText("Back");
        kembali.setBorder(null);
        kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kembaliMouseClicked(evt);
            }
        });
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        nama_makanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_makananActionPerformed(evt);
            }
        });

        proses_transaksi.setBackground(new java.awt.Color(34, 167, 240));
        proses_transaksi.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        proses_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        proses_transaksi.setText("Process");
        proses_transaksi.setBorder(null);
        proses_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proses_transaksiActionPerformed(evt);
            }
        });

        ulang.setBackground(new java.awt.Color(255, 0, 0));
        ulang.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        ulang.setForeground(new java.awt.Color(255, 255, 255));
        ulang.setText("Clear");
        ulang.setBorder(null);
        ulang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ulangMouseClicked(evt);
            }
        });
        ulang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulangActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 255));
        jLabel17.setText("Jumlah beli  ");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 255));
        jLabel18.setText("ID  Kasir   ");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 255));
        jLabel19.setText("Minuman       ");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 255));
        jLabel20.setText("Makanan    ");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 255));

        antrian.setBackground(new java.awt.Color(255, 255, 255));
        antrian.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        antrian.setForeground(new java.awt.Color(204, 204, 255));
        antrian.setText("Nomor antriannya");

        nama_kasir.setBackground(new java.awt.Color(255, 255, 255));
        nama_kasir.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        nama_kasir.setForeground(new java.awt.Color(204, 204, 255));
        nama_kasir.setText("nama kasirnya");

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 255));
        jLabel24.setText("Nama  Pembeli  ");

        jumlah_makan.setText("0");
        jumlah_makan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jumlah_makanFocusLost(evt);
            }
        });

        jumlah_minum.setText("0");
        jumlah_minum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jumlah_minumFocusLost(evt);
            }
        });

        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayarKeyReleased(evt);
            }
        });

        kembalian.setEnabled(false);

        total_bayar.setEnabled(false);

        nama_pembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_pembeliActionPerformed(evt);
            }
        });

        antrian1.setBackground(new java.awt.Color(255, 255, 255));
        antrian1.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        antrian1.setForeground(new java.awt.Color(204, 204, 255));
        antrian1.setText(":");

        antrian2.setBackground(new java.awt.Color(255, 255, 255));
        antrian2.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        antrian2.setForeground(new java.awt.Color(204, 204, 255));
        antrian2.setText(":");

        antrian3.setBackground(new java.awt.Color(255, 255, 255));
        antrian3.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        antrian3.setForeground(new java.awt.Color(204, 204, 255));
        antrian3.setText(":");

        antrian4.setBackground(new java.awt.Color(255, 255, 255));
        antrian4.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        antrian4.setForeground(new java.awt.Color(204, 204, 255));
        antrian4.setText(":");

        antrian5.setBackground(new java.awt.Color(255, 255, 255));
        antrian5.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        antrian5.setForeground(new java.awt.Color(204, 204, 255));
        antrian5.setText(":");

        antrian6.setBackground(new java.awt.Color(255, 255, 255));
        antrian6.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        antrian6.setForeground(new java.awt.Color(204, 204, 255));
        antrian6.setText(":");

        antrian7.setBackground(new java.awt.Color(255, 255, 255));
        antrian7.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        antrian7.setForeground(new java.awt.Color(204, 204, 255));
        antrian7.setText(":");

        kem1.setBackground(new java.awt.Color(255, 255, 255));
        kem1.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        kem1.setForeground(new java.awt.Color(204, 204, 255));
        kem1.setText("    : ");

        kem2.setBackground(new java.awt.Color(255, 255, 255));
        kem2.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        kem2.setForeground(new java.awt.Color(204, 204, 255));
        kem2.setText("   : ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(antrian1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(antrian3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nama_kasir)
                                            .addComponent(antrian))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel19)
                                                .addComponent(jLabel9)))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(antrian7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jumlah_minum, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(antrian5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(antrian6, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(nama_minuman, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jumlah_makan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(nama_pembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                    .addGap(33, 33, 33)
                                                    .addComponent(nama_makanan, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(antrian4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(antrian2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(701, 701, 701))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(466, 466, 466)
                                        .addComponent(kem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(kem1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(kem2)
                                        .addGap(42, 42, 42)
                                        .addComponent(total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(57, 57, 57))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(572, 572, 572))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(proses_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(ulang, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 115, 115)
                                .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel21)
                                    .addComponent(antrian)
                                    .addComponent(antrian1)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(19, 19, 19)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(nama_kasir)
                            .addComponent(antrian3))
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tot)
                            .addComponent(kem2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(kem)
                                .addComponent(kem1)))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nama_pembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(antrian2)
                            .addComponent(jLabel24))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(antrian4)
                            .addComponent(nama_makanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(antrian5)
                            .addComponent(jumlah_makan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama_minuman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(antrian6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jumlah_minum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(antrian7)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bayar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proses_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ulang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void nama_pembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_pembeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_pembeliActionPerformed

    private void bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyReleased
        // TODO add your handling code here:
        int byr = Integer.parseInt(bayar.getText());
        int tot_byr = Integer.parseInt(total_bayar.getText());
        int kemb = byr - tot_byr;
        if (byr >= tot_byr) {
            kembalian.setText(String.valueOf(kemb));
        } else {
            kembalian.setText("");
        }
    }//GEN-LAST:event_bayarKeyReleased

    private void jumlah_minumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jumlah_minumFocusLost
        // TODO add your handling code here:
        if (nama_minuman.getSelectedIndex() != 0) {
            if (Integer.parseInt(jumlah_minum.getText()) > 0) {
                int jml = Integer.parseInt(jumlah_minum.getText());
                boolean cek = false;
                daftar.clear();
                table();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(new Object[]{
                    "-", daftar.get(1), "-", daftar.get(3), "-", daftar.get(5), daftar.get(6)
                });
                total_bayar();
                if (!nota_sementara.isEmpty()) {
                    for (int i = 0; i < nota_sementara.size(); i++) {
                        if (nota_sementara.get(i).nama.equalsIgnoreCase(String.valueOf(nama_minuman.getSelectedItem()))) {
                            nota_sementara.get(i).jumlah_beli = nota_sementara.get(i).jumlah_beli + jml;
                            nota_sementara.get(i).total_harga = nota_sementara.get(i).total_harga + ambil_total;
                            cek = false;
                            break;
                        } else {
                            cek = true;
                        }
                    }
                } else {
                    nota_sementara.add(new nota_helper(String.valueOf(nama_minuman.getSelectedItem()), jml, ambil_total));
                }

                if (cek) {
                    nota_sementara.add(new nota_helper(String.valueOf(nama_minuman.getSelectedItem()), jml, ambil_total));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Jumlah minuman tidak valid!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih minuman anda!");
        }
    }//GEN-LAST:event_jumlah_minumFocusLost

    private void jumlah_makanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jumlah_makanFocusLost
        // TODO add your handling code here:
        if (nama_makanan.getSelectedIndex() != 0) {
            if (Integer.parseInt(jumlah_makan.getText()) > 0) {
                int jml = Integer.parseInt(jumlah_makan.getText());
                boolean cek = false;
                daftar.clear();
                table();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(new Object[]{
                    daftar.get(0), "-", daftar.get(2), "-", daftar.get(4), "-", daftar.get(6)
                });
                total_bayar();
                if (!nota_sementara.isEmpty()) {
                    for (int i = 0; i < nota_sementara.size(); i++) {
                        if (nota_sementara.get(i).nama.equalsIgnoreCase(String.valueOf(nama_makanan.getSelectedItem()))) {
                            nota_sementara.get(i).jumlah_beli = nota_sementara.get(i).jumlah_beli + jml;
                            nota_sementara.get(i).total_harga = nota_sementara.get(i).total_harga + ambil_total;
                            cek = false;
                            break;
                        } else {
                            cek = true;
                        }
                    }
                } else {
                    nota_sementara.add(new nota_helper(String.valueOf(nama_makanan.getSelectedItem()), jml, ambil_total));
                }
                if (cek) {
                    nota_sementara.add(new nota_helper(String.valueOf(nama_makanan.getSelectedItem()), jml, ambil_total));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Jumlah makanan tidak valid!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih makanan anda!");
        }
    }//GEN-LAST:event_jumlah_makanFocusLost

    private void ulangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ulangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ulangMouseClicked

    private void proses_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proses_transaksiActionPerformed
        tampilan_nota tn = new tampilan_nota();
        simpan_trans();
        int jum = 0;
        for(int i = 0; i < nota_sementara.size(); i++){
            jum += nota_sementara.get(i).jumlah_beli;
            tn.jTextArea2.append("\n"+nota_sementara.get(i).nama + "\t" + nota_sementara.get(i).jumlah_beli + "\t" + nota_sementara.get(i).total_harga);
        }
        tn.id_kar_set.setText(nama_kasir.getText());
        tn.nama_pel1.setText(nama_pembeli.getText());
        tn.tot_item.setText(String.valueOf(jum));
        tn.tot_bayar.setText("Rp. "+total_bayar.getText());
        tn.tunai.setText("Rp. "+bayar.getText());
        tn.kmb.setText("Rp. "+kembalian.getText());
        tn.antr = Integer.parseInt(antrian.getText());
        tn.nm = nama_kasir.getText();
        this.setVisible(false);
        tn.setVisible(true);
    }//GEN-LAST:event_proses_transaksiActionPerformed

    private void nama_makananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_makananActionPerformed

    }//GEN-LAST:event_nama_makananActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembaliActionPerformed

    private void kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseClicked
        this.setVisible(false);
        new login().setVisible(true);
    }//GEN-LAST:event_kembaliMouseClicked

    private void nama_minumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_minumanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_minumanActionPerformed

    private void ulangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulangActionPerformed
        nama_pembeli.setText("");
        jumlah_makan.setText("0");
        jumlah_minum.setText("0");
        bayar.setText("");
        total_bayar.setText("");
        kembalian.setText("");
        DefaultTableModel tb = (DefaultTableModel)jTable1.getModel();
        while(tb.getRowCount() > 0){
            for(int i=0; i<tb.getRowCount(); i++){
                tb.removeRow(i);
            }
        }
        daftar.clear();
        nota_sementara.clear();
    }//GEN-LAST:event_ulangActionPerformed

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
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel antrian;
    private javax.swing.JLabel antrian1;
    private javax.swing.JLabel antrian2;
    private javax.swing.JLabel antrian3;
    private javax.swing.JLabel antrian4;
    private javax.swing.JLabel antrian5;
    private javax.swing.JLabel antrian6;
    private javax.swing.JLabel antrian7;
    private javax.swing.JTextField bayar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jumlah_makan;
    private javax.swing.JTextField jumlah_minum;
    private javax.swing.JLabel kem;
    private javax.swing.JLabel kem1;
    private javax.swing.JLabel kem2;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField kembalian;
    public static javax.swing.JLabel nama_kasir;
    private javax.swing.JComboBox<String> nama_makanan;
    private javax.swing.JComboBox<String> nama_minuman;
    private javax.swing.JTextField nama_pembeli;
    private javax.swing.JButton proses_transaksi;
    private javax.swing.JLabel tot;
    private javax.swing.JTextField total_bayar;
    private javax.swing.JButton ulang;
    // End of variables declaration//GEN-END:variables
}
