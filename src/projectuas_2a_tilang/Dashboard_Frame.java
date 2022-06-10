/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectuas_2a_tilang;


import java.sql.Statement;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Dashboard_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard_Frame
     */
    
    
    Border panel_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.darkGray);
    
    ArrayList<Dashboard> dashboardArray = new ArrayList<>();
    
    int position = 0;
            
    public Dashboard_Frame() 
    {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        jPanel_Container.setBorder(panel_border);
        
        showProductsInTable();
    }
  
    public ArrayList<Dashboard> getDashboardList()
    {
        ArrayList<Dashboard> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM `dashboard`";
        
        Statement st;
        ResultSet rs;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery(selectQuery);
            Dashboard dashboard;
            
            while (rs.next())
            {
                dashboard = new Dashboard(rs.getInt("id"),rs.getString("nama"),
                                            rs.getString("kategori"), rs.getInt("jumlah"),
                                            rs.getString("lokasi"), rs.getString("gambar"));
                list.add(dashboard);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dashboardArray = list;
        return list;
        
    }
    
    public void showProductsInTable()
    {
        ArrayList<Dashboard> dashboardList = getDashboardList();
        DefaultTableModel model = (DefaultTableModel) jTable_display_.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[6];
        
        for(int i = 0; i < dashboardList.size(); i++)
        {
            row[0] = dashboardList.get(i).getId();
            row[1] = dashboardList.get(i).getNama();
            row[2] = dashboardList.get(i).getKategori();
            row[3] = dashboardList.get(i).getJumlah();
            row[4] = dashboardList.get(i).getLokasi();
            row[5] = dashboardList.get(i).getGambar();
            
            model.addRow(row);
                    
        }
        
    }
    
    public void showProductData(int index)
    {
        jSpinner_id.setValue(dashboardArray.get(index).getId());
        jTextField_name.setText(dashboardArray.get(index).getNama());
        jComboBox_Category.setSelectedItem(dashboardArray.get(index).getKategori());
        jTextField_Quantity.setText(dashboardArray.get(index).getJumlah().toString());
        jTextField_Lokasi.setText(dashboardArray.get(index).getLokasi().toString());
        jTextField_imgpath_.setText(dashboardArray.get(index).getGambar());
        displayImage(dashboardArray.get(index).getGambar(),jLabel_image,'a');
        
        
    }
    
    public boolean checkEmptyFields()
    {
        String nama = jTextField_name.getText().trim();
        String jumlah = jTextField_Quantity.getText().trim();
        String lokasi = jTextField_Lokasi.getText().trim();
        String gambar = jTextField_imgpath_.getText().trim();
        
        if(nama.equals("") || jumlah.equals("") || lokasi.equals("") || gambar.equals(""))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public void displayImage(String gambar, JLabel label, char rsc)
    {
        ImageIcon imgIco;
        if (rsc == 'r')
        {
            imgIco = new ImageIcon(getClass().getResource(gambar));
        }
        else
        {
            imgIco = new ImageIcon(gambar);
        }
        Image img = imgIco.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }
    
    public void clearFields()
    {
        jSpinner_id.setValue(0);
        jTextField_name.setText("");
        jTextField_Quantity.setText("");
        jComboBox_Category.setSelectedIndex(0);
        jTextField_Lokasi.setText("");
        jTextField_imgpath_.setText("");
        jLabel_image.setIcon(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Container = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_close = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_display_ = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSpinner_id = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jTextField_Quantity = new javax.swing.JTextField();
        jTextField_Lokasi = new javax.swing.JTextField();
        jComboBox_Category = new javax.swing.JComboBox<>();
        jLabel_image = new javax.swing.JLabel();
        jButton_add_ = new javax.swing.JButton();
        jButton_edit_ = new javax.swing.JButton();
        jButton_remove_ = new javax.swing.JButton();
        jButton_search_ = new javax.swing.JButton();
        jButton_browse_ = new javax.swing.JButton();
        jTextField_imgpath_ = new javax.swing.JTextField();
        jButton_last_ = new javax.swing.JButton();
        jButton_previous_ = new javax.swing.JButton();
        jButton_next_ = new javax.swing.JButton();
        jButton_first_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_Container.setBackground(new java.awt.Color(231, 203, 245));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectuas_2a_tilang_icon/Dashboard's Header.jpg"))); // NOI18N

        jLabel_close.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_close.setText("X");
        jLabel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseClicked(evt);
            }
        });

        jTable_display_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Kategori", "Jumlah", "Lokasi", "Gambar"
            }
        ));
        jTable_display_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_display_MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_display_);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ID :");

        jSpinner_id.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nama :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Kategori :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Jumlah :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Lokasi :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Gambar :");

        jTextField_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });

        jTextField_Quantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_QuantityActionPerformed(evt);
            }
        });

        jTextField_Lokasi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jComboBox_Category.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox_Category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ukuran Kecil", "Ukuran Sedang", "Ukuran Besar" }));

        jLabel_image.setBackground(new java.awt.Color(255, 204, 153));
        jLabel_image.setOpaque(true);

        jButton_add_.setBackground(new java.awt.Color(255, 204, 153));
        jButton_add_.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_add_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_add_.setText("Tambahkan");
        jButton_add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_add_ActionPerformed(evt);
            }
        });

        jButton_edit_.setBackground(new java.awt.Color(255, 204, 153));
        jButton_edit_.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_edit_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_edit_.setText("Perbarui");
        jButton_edit_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_edit_ActionPerformed(evt);
            }
        });

        jButton_remove_.setBackground(new java.awt.Color(255, 204, 153));
        jButton_remove_.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_remove_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_remove_.setText("Hapus");
        jButton_remove_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_remove_ActionPerformed(evt);
            }
        });

        jButton_search_.setBackground(new java.awt.Color(255, 204, 153));
        jButton_search_.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton_search_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_search_.setText("Cari");
        jButton_search_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_search_ActionPerformed(evt);
            }
        });

        jButton_browse_.setBackground(new java.awt.Color(255, 204, 153));
        jButton_browse_.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton_browse_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_browse_.setText("Pilih Gambar");
        jButton_browse_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_browse_ActionPerformed(evt);
            }
        });

        jTextField_imgpath_.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jTextField_imgpath_.setMaximumSize(new java.awt.Dimension(7, 17));

        jButton_last_.setBackground(new java.awt.Color(255, 204, 153));
        jButton_last_.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton_last_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_last_.setText(">>");
        jButton_last_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_last_ActionPerformed(evt);
            }
        });

        jButton_previous_.setBackground(new java.awt.Color(255, 204, 153));
        jButton_previous_.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton_previous_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_previous_.setText("<");
        jButton_previous_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_previous_ActionPerformed(evt);
            }
        });

        jButton_next_.setBackground(new java.awt.Color(255, 204, 153));
        jButton_next_.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton_next_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_next_.setText(">");
        jButton_next_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_next_ActionPerformed(evt);
            }
        });

        jButton_first_.setBackground(new java.awt.Color(255, 204, 153));
        jButton_first_.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton_first_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_first_.setText("<<");
        jButton_first_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_first_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ContainerLayout = new javax.swing.GroupLayout(jPanel_Container);
        jPanel_Container.setLayout(jPanel_ContainerLayout);
        jPanel_ContainerLayout.setHorizontalGroup(
            jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ContainerLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel_ContainerLayout.createSequentialGroup()
                .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_ContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_add_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_edit_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_remove_))
                    .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel_ContainerLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel_ContainerLayout.createSequentialGroup()
                                    .addComponent(jSpinner_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton_search_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel_ContainerLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField_Quantity)
                                .addComponent(jTextField_Lokasi)
                                .addComponent(jComboBox_Category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel_ContainerLayout.createSequentialGroup()
                                    .addComponent(jButton_browse_)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField_imgpath_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ContainerLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ContainerLayout.createSequentialGroup()
                        .addComponent(jButton_first_)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_next_)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_previous_)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_last_)
                        .addGap(98, 98, 98))))
        );
        jPanel_ContainerLayout.setVerticalGroup(
            jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ContainerLayout.createSequentialGroup()
                .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_ContainerLayout.createSequentialGroup()
                        .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_search_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_ContainerLayout.createSequentialGroup()
                                .addComponent(jComboBox_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_browse_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_imgpath_, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_image, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_add_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_edit_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_remove_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_last_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_previous_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_next_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_first_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseClicked
        // Tombol Close
        System.exit(0);
    }//GEN-LAST:event_jLabel_closeMouseClicked

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nameActionPerformed

    private void jButton_add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_add_ActionPerformed
       //INSERT INTO `dashboard`(`nama`, `kategori`, `jumlah`, `lokasi`, `gambar`) VALUES (?,?,?,?,?) 
       if(checkEmptyFields())
       {
       String nama = jTextField_name.getText();
       String kategori = jComboBox_Category.getSelectedItem().toString();
       Integer jumlah = Integer.valueOf(jTextField_Quantity.getText());
       String lokasi = jTextField_Lokasi.getText();
       String gambar = jTextField_imgpath_.getText();
       
       String insertQuery = "INSERT INTO `dashboard`(`nama`, `kategori`, `jumlah`, `lokasi`, `gambar`) VALUES (?,?,?,?,?)";
       
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, nama);
            ps.setString(2, kategori);
            ps.setInt(3, jumlah);
            ps.setString(4, lokasi);
            ps.setString(5, gambar);
            
            if(ps.executeUpdate() > 0)
            {
                showProductsInTable();
                JOptionPane.showMessageDialog(null, "Data Baru Sukses Ditambahkan", "Tambah Data", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Data Baru Telah Ditambahkan");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Data Baru Gagal Ditambahkan", "Tambah Data", JOptionPane.ERROR_MESSAGE);
                System.out.println("Ada Kesalahan");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        else
       {
           JOptionPane.showMessageDialog(null, "Data Baru Gagal Ditambahkan", "Tambah Data", JOptionPane.ERROR_MESSAGE);
           System.out.println("Terdapat Satu atau Lebih Kolom yang Kosong");
       }
    }//GEN-LAST:event_jButton_add_ActionPerformed

    private void jButton_remove_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_remove_ActionPerformed
        if(Integer.valueOf(jSpinner_id.getValue().toString())>0)
        {
            Integer id = Integer.valueOf(jSpinner_id.getValue().toString());
            
            String deleteQuery = "DELETE FROM dashboard WHERE id=?";
            
            try{
                PreparedStatement ps = DB.getConnection().prepareStatement(deleteQuery);
                ps.setInt(1, id);
                
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Menghapus Data Ini?", "Hapus Data", JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION)
                {
                    if(ps.executeUpdate()>0)
                    {
                        showProductsInTable();
                        JOptionPane.showMessageDialog(null, "Data Sukses Dihapus", "Hapus Data", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Data Terhapus");
                        clearFields();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Data Tidak Terhapus, Pastikan ID Valid", "Hapus Data", JOptionPane.ERROR_MESSAGE);
                        //System.out.println("Terjadi Kesalahan");
                    }
                }
                
                } catch (SQLException ex){
                    Logger.getLogger(Dashboard_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Data Tidak Terhapus, Pastikan ID Valid", "Hapus Data", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton_remove_ActionPerformed

    private void jButton_edit_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_edit_ActionPerformed
        if(checkEmptyFields())
        {
            Integer id = Integer.valueOf(jSpinner_id.getValue().toString());
            String nama = jTextField_name.getText();
            String kategori = jComboBox_Category.getSelectedItem().toString();
            Integer jumlah = Integer.valueOf(jTextField_Quantity.getText());
            String lokasi = jTextField_Lokasi.getText();
            String gambar = jTextField_imgpath_.getText();
            
            String updateQuery = "UPDATE dashboard SET nama=?, kategori=?, jumlah=?, lokasi=?, gambar=? WHERE id=?";
            
            try{
                PreparedStatement ps = DB.getConnection().prepareStatement(updateQuery);
                ps.setString(1, nama);
                ps.setString(2, kategori);
                ps.setInt(3, jumlah);
                ps.setString(4, lokasi);
                ps.setString(5, gambar);
                ps.setInt(6, id);
                
                if(ps.executeUpdate() > 0)
                {
                    showProductsInTable();
                    JOptionPane.showMessageDialog(null, "Data Diperbarui", "Perbarui Data", JOptionPane.INFORMATION_MESSAGE);
                    //System.out.Println("Data telah Diperbarui");   
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Data tidak Diperbarui", "Perbarui Data", JOptionPane.ERROR_MESSAGE);
                    //System.out.println("Ada Kesalahan");
                }
            }catch (SQLException ex){
                Logger.getLogger(Dashboard_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Satu atau Lebih Kolom Kosong", "Perbarui Data", JOptionPane.ERROR_MESSAGE);
            System.out.println("Satu atau Lebih Kolom Kossong");
        }
    }//GEN-LAST:event_jButton_edit_ActionPerformed

    private void jButton_search_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_search_ActionPerformed
       if(checkEmptyFields())
       {
           int id = Integer.valueOf(jSpinner_id.getValue().toString());
           String selectQuery = "SELECT * FROM 'dashboard' WHERE 'id'="+id;
           
           try{
               Statement st = DB.getConnection().createStatement();
               ResultSet rs = st.executeQuery(selectQuery);
               
               if (rs.next())
               {
                   jTextField_name.setText(rs.getString("nama"));
                   jComboBox_Category.setSelectedItem(rs.getString("kategori"));
                   jTextField_Quantity.setText(rs.getString("jumlah"));
                   jTextField_Lokasi.setText(rs.getString("lokasi"));
                   jTextField_imgpath_.setText(rs.getString("gambar"));
                   displayImage(rs.getString("gambar"), jLabel_image, 'a');
               }
               else
               {
                   System.out.println("Tidak Ada Data dengan ID Ini");
               }
           }catch(SQLException ex){
               Logger.getLogger(Dashboard_Frame.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        else
       {
           System.out.println("Satu atau Lebih Kolom yang Kosong");
       }
    }//GEN-LAST:event_jButton_search_ActionPerformed

    private void jButton_browse_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_browse_ActionPerformed
        
        JFileChooser filechooser = new JFileChooser();
        filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*images", ".png", "jpg", ".jpeg");
        filechooser.addChoosableFileFilter(filter);
        
        if(filechooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            File selectedImage = filechooser.getSelectedFile();
            String gambar = selectedImage.getAbsolutePath();
            displayImage(gambar, jLabel_image,'a');
            jTextField_imgpath_.setText(gambar);
                System.out.println(gambar);
        }
        else
        {
            System.out.println("Tidak ada file yang dipilih");
        }
    }//GEN-LAST:event_jButton_browse_ActionPerformed

    private void jTable_display_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_display_MouseClicked
        int index = jTable_display_.getSelectedRow();
        showProductData(index);
        position = index;
    }//GEN-LAST:event_jTable_display_MouseClicked

    private void jButton_last_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_last_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_last_ActionPerformed

    private void jButton_previous_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_previous_ActionPerformed
        position--;
        if(position < 0)
        {
            position = 0;
        }
        showProductData(position);
        jTable_display_.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_jButton_previous_ActionPerformed

    private void jButton_next_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_next_ActionPerformed
        position++;
        if (position > dashboardArray.size()-1)
        {
            position = dashboardArray.size()-1;
        }
        showProductData(position);
        jTable_display_.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_jButton_next_ActionPerformed

    private void jButton_first_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_first_ActionPerformed
        position = 0;
        showProductData(position);
        jTable_display_.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_jButton_first_ActionPerformed

    private void jTextField_QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_QuantityActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_add_;
    private javax.swing.JButton jButton_browse_;
    private javax.swing.JButton jButton_edit_;
    private javax.swing.JButton jButton_first_;
    private javax.swing.JButton jButton_last_;
    private javax.swing.JButton jButton_next_;
    private javax.swing.JButton jButton_previous_;
    private javax.swing.JButton jButton_remove_;
    private javax.swing.JButton jButton_search_;
    private javax.swing.JComboBox<String> jComboBox_Category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_image;
    private javax.swing.JPanel jPanel_Container;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_id;
    private javax.swing.JTable jTable_display_;
    private javax.swing.JTextField jTextField_Lokasi;
    private javax.swing.JTextField jTextField_Quantity;
    private javax.swing.JTextField jTextField_imgpath_;
    private javax.swing.JTextField jTextField_name;
    // End of variables declaration//GEN-END:variables
}
