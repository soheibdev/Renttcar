/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renttcar;

/**
 *
 * @author akram
 */

import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.ResultSetMetaData;
 import java.sql.SQLException;
 import java.util.Vector;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javax.swing.JOptionPane;
 import javax.swing.table.DefaultTableModel;
 

 /**
  *
  * @author laaraf mohamed
  */
 public class Customers extends javax.swing.JFrame {
 
     
     public Customers() {
        initComponents();
        table_update();
        autoID();
       
    }

     
Connection con;
PreparedStatement pst;
ResultSet Rs=null;
     
    
        
     private void ResetForm(){
        
        namebtn.setText("");
        addressbtn.setText("");
        phonebtn.setText("");
    } 
    private void autoID() {

        try {
    
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/losrent", "laaraf", "06102004");
            String sql = "SELECT MAX(LENGTH(cust_id)) FROM customer2 WHERE cust_id REGEXP '^C[0-9]{3}$'";
            pst = con.prepareStatement(sql);
            Rs = pst.executeQuery();
            Rs.next();
            if (Rs.wasNull()) {
                idbtn.setText("C0001");
            } else {
                long id = Rs.getLong(1) + 1;
                idbtn.setText("C0" + String.format("%03d", id));
            }
    
        } catch (ClassNotFoundException ex) {
    
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
    
        } catch (SQLException ex) {
    
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
    
        }
    
    }
  
    
      @SuppressWarnings("unchecked")
    public void table_update(){
        int c;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/losrent","laaraf","06102004");
            pst=con.prepareStatement("select * from customer2");
            ResultSet Rs=pst.executeQuery();
            
            ResultSetMetaData rd=Rs.getMetaData();
            c=rd.getColumnCount();
            DefaultTableModel df=(DefaultTableModel)jTable2.getModel();
            df.setRowCount(0);
            
            
            while(Rs.next())
            {
                @SuppressWarnings("rawtypes")
                Vector v2=new Vector();
                for(int i=1;i<=c;i++)
                {
                    v2.add(Rs.getString("cust_id"));
                    v2.add(Rs.getString("name"));
                    v2.add(Rs.getString("address"));
                    v2.add(Rs.getString("mobile"));                    
                }  
                df.addRow(v2);
            }
            
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }                     
     private void initComponents() {
 
         jPanel1 = new javax.swing.JPanel();
         jLabel8 = new javax.swing.JLabel();
         jLabel16 = new javax.swing.JLabel();
         jLabel17 = new javax.swing.JLabel();
         jLabel18 = new javax.swing.JLabel();
         jPanel3 = new javax.swing.JPanel();
         jLabel4 = new javax.swing.JLabel();
         jLabel9 = new javax.swing.JLabel();
         deletbtn = new javax.swing.JButton();
         jLabel10 = new javax.swing.JLabel();
         editbtn = new javax.swing.JButton();
         idbtn = new javax.swing.JTextField();
         jLabel11 = new javax.swing.JLabel();
         savebtn = new javax.swing.JButton();
         namebtn = new javax.swing.JTextField();
         jLabel15 = new javax.swing.JLabel();
         jLabel12 = new javax.swing.JLabel();
         jScrollPane2 = new javax.swing.JScrollPane();
         jTable2 = new javax.swing.JTable();
         addressbtn = new javax.swing.JTextField();
         jLabel13 = new javax.swing.JLabel();
         phonebtn = new javax.swing.JTextField();
         resetbtn = new javax.swing.JButton();
 
         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
         setUndecorated(true);
 
         jPanel1.setBackground(new java.awt.Color(102, 0, 102));
 
         jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel8.setForeground(new java.awt.Color(255, 255, 255));
         jLabel8.setText("Rent car ");
         jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
         jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 jLabel8MouseClicked(evt);
             }
         });
 
         jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel16.setForeground(new java.awt.Color(255, 255, 255));
         jLabel16.setText("Return car");
         jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
         jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 jLabel16MouseClicked(evt);
             }
         });
 
         jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel17.setForeground(new java.awt.Color(255, 255, 255));
         jLabel17.setText("Logout");
         jLabel17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
         jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 jLabel17MouseClicked(evt);
             }
         });
 
         jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel18.setForeground(new java.awt.Color(255, 255, 255));
         jLabel18.setText("Cars");
         jLabel18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
         jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 jLabel18MouseClicked(evt);
             }
         });
 
         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                 .addContainerGap(39, Short.MAX_VALUE)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(34, 34, 34))
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(17, 17, 17)
                 .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(110, 110, 110)
                 .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(18, 18, 18)
                 .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(27, 27, 27)
                 .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
         );
 
         jPanel3.setBackground(new java.awt.Color(255, 255, 255));
 
         jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
         jLabel4.setForeground(new java.awt.Color(255, 0, 0));
         jLabel4.setText("×");
         jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 jLabel4MouseClicked(evt);
             }
         });
 
         javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
         jPanel3.setLayout(jPanel3Layout);
         jPanel3Layout.setHorizontalGroup(
             jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addComponent(jLabel4)
                 .addContainerGap())
         );
         jPanel3Layout.setVerticalGroup(
             jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
         );
 
         jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         jLabel9.setForeground(new java.awt.Color(153, 0, 153));
         jLabel9.setText("Customers Id ");
         jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         deletbtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         deletbtn.setForeground(new java.awt.Color(204, 0, 204));
         deletbtn.setText("Delete");
         deletbtn.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 deletbtnActionPerformed(evt);
             }
         });
 
         jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel10.setForeground(new java.awt.Color(153, 0, 153));
         jLabel10.setText("Customers List ");
         jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         editbtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         editbtn.setForeground(new java.awt.Color(204, 0, 204));
         editbtn.setText("Edit");
         editbtn.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 editbtnActionPerformed(evt);
             }
         });
 
         idbtn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
 
         jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         jLabel11.setForeground(new java.awt.Color(153, 0, 153));
         jLabel11.setText("Customers Name");
         jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         savebtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         savebtn.setForeground(new java.awt.Color(204, 0, 204));
         savebtn.setText("Save");
         savebtn.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 savebtnActionPerformed(evt);
             }
         });
 
         namebtn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
 
         jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel15.setForeground(new java.awt.Color(153, 0, 153));
         jLabel15.setText("Manage customers");
         jLabel15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         jLabel12.setForeground(new java.awt.Color(153, 0, 153));
         jLabel12.setText("Address");
         jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         jTable2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         jTable2.setModel(new javax.swing.table.DefaultTableModel(
             new Object [][] {
                 {null, null, "", ""}
             },
             new String [] {
                 "Customers Id", "Customers Name", "Address", "Phone"
             }
         ));
         jTable2.setRowHeight(25);
         jTable2.setRowSelectionAllowed(false);
         jTable2.setSelectionBackground(new java.awt.Color(204, 204, 204));
         jTable2.setShowGrid(true);
         jTable2.setSurrendersFocusOnKeystroke(true);
         jTable2.addAncestorListener(new javax.swing.event.AncestorListener() {
             public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                 jTable2AncestorAdded(evt);
             }
             public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
             }
             public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
             }
         });
         jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 jTable2MouseClicked(evt);
             }
         });
         jScrollPane2.setViewportView(jTable2);
 
         addressbtn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
 
         jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         jLabel13.setForeground(new java.awt.Color(153, 0, 153));
         jLabel13.setText("Phone");
         jLabel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         phonebtn.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
 
         resetbtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         resetbtn.setForeground(new java.awt.Color(204, 0, 204));
         resetbtn.setText("Reset");
         resetbtn.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 resetbtnActionPerformed(evt);
             }
         });
 
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(jScrollPane2)
                     .addGroup(layout.createSequentialGroup()
                         .addGap(211, 211, 211)
                         .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(18, 18, 18)
                         .addComponent(deletbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(18, 18, 18)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(addressbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addGroup(layout.createSequentialGroup()
                                 .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(18, 18, 18)
                                 .addComponent(resetbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                             .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(0, 0, Short.MAX_VALUE))
                     .addGroup(layout.createSequentialGroup()
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(layout.createSequentialGroup()
                                 .addGap(43, 43, 43)
                                 .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                             .addGroup(layout.createSequentialGroup()
                                 .addGap(125, 125, 125)
                                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                     .addComponent(idbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addGap(6, 6, 6)
                                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addGroup(layout.createSequentialGroup()
                                         .addGap(52, 52, 52)
                                         .addComponent(jLabel15))
                                     .addGroup(layout.createSequentialGroup()
                                         .addGap(37, 37, 37)
                                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addComponent(namebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                         .addGap(230, 230, 230)
                                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                             .addComponent(phonebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                         .addContainerGap(132, Short.MAX_VALUE))))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(18, 18, 18)
                 .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                         .addGap(37, 37, 37)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(namebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(idbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                             .addComponent(addressbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addGroup(layout.createSequentialGroup()
                         .addGap(12, 12, 12)
                         .addComponent(jLabel13)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(phonebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                         .addGap(12, 12, 12)
                         .addComponent(jLabel12))
                     .addGroup(layout.createSequentialGroup()
                         .addGap(10, 10, 10)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(jLabel9)
                             .addComponent(jLabel11))))
                 .addGap(32, 32, 32)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(savebtn)
                     .addComponent(deletbtn)
                     .addComponent(editbtn)
                     .addComponent(resetbtn))
                 .addGap(57, 57, 57)
                 .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );
 
         pack();
         setLocationRelativeTo(null);
     }// </editor-fold>                        
 
     private void jTable2AncestorAdded(javax.swing.event.AncestorEvent evt) {                                      
         // TODO add your handling code here:
     }                                     
 
     private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String custId=idbtn.getText();
        String Cust_name=namebtn.getText();
        String address =addressbtn.getText();
       String mobile =phonebtn.getText();
       
           try {
               Class.forName("com.mysql.jdbc.Driver");
               con=DriverManager.getConnection("jdbc:mysql://localhost/losrent","laaraf","06102004");
               pst=con.prepareStatement("insert into customer2(cust_id,name,address,mobile)values(?,?,?,?) ");
               pst.setString(1,custId);
               pst.setString(2,Cust_name);
               pst.setString(3,address);
               pst.setString(4,mobile); 
               pst.executeUpdate();  
               JOptionPane.showMessageDialog(this,"Customer Added Successfully ..........");
                 autoID();
                 namebtn.setText("");
                 addressbtn.setText("");
                 phonebtn.setText("");
                 idbtn.requestFocus();
                 table_update();

               
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
           }
     }                                       
 
     private void deletbtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        DefaultTableModel d1 = (DefaultTableModel) jTable2.getModel();
        int selectIndex = jTable2.getSelectedRow();
    
        // Check if any row is selected
        if (selectIndex >= 0) {
            String id = d1.getValueAt(selectIndex, 0).toString();
            int dialogResult = JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer l'enregistrement", "Waring", JOptionPane.YES_NO_OPTION);
    
            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/losrent","laaraf","06102004");
                    pst=con.prepareStatement("delete from customer2 where cust_id=?");
                    pst.setString(1, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Enregistrement supprimé");
                    table_update();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
     }                                        
 
     private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        DefaultTableModel d1 = (DefaultTableModel) jTable2.getModel();
        int selectIndex = jTable2.getSelectedRow();
    
        try {
            if (selectIndex >= 0) {
                String id = d1.getValueAt(selectIndex, 0).toString();
                @SuppressWarnings("unused")
                String make = idbtn.getText();
                String Bra = namebtn.getText();
                String mod = addressbtn.getText();
                String pri = phonebtn.getText();
    
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/losrent", "laaraf", "06102004");
    
                pst = con.prepareStatement("update customer2 set name=?, address=?, mobile =? where cust_id =?");

                
                pst.setString(1, Bra);
                pst.setString(2, mod);
                pst.setString(3, pri);
                pst.setString(4, id); // Update the 'Price' column
                 // Match the 'where' clause
    
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record Updated");
                table_update();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to edit.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
        }
     }                                       
 
     private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ResetForm();
     }                                        
 
     private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {                                     
        DefaultTableModel d1=(DefaultTableModel)jTable2.getModel();
        int selectIndex=jTable2.getSelectedRow();
        
        idbtn.setText(d1.getValueAt(selectIndex,0).toString());
        namebtn.setText(d1.getValueAt(selectIndex,1).toString());
        addressbtn.setText(d1.getValueAt(selectIndex,2).toString());
        phonebtn.setText(d1.getValueAt(selectIndex,3).toString());
     }                                    
 
     @SuppressWarnings("deprecation")
    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {                                      
         cars vv=new cars();
         this.hide();
         vv.setVisible(true);
     }                                     
     @SuppressWarnings("deprecation")
     private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {                                     
         rentcarsss hh=new rentcarsss();
         this.hide();
         hh.setVisible(true);
     }                                    
     @SuppressWarnings("deprecation")
     private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {                                      
         ReturnCars returnCars=new ReturnCars();
         this.hide();
         returnCars.setVisible(true);
     }                                     
     @SuppressWarnings("deprecation")
     private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {                                      
         login mm =new login();
         this.hide();
         mm.setVisible(true);
     }                                     
 
     private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {                                     
         dispose();
     }                                    
 
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
             java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //</editor-fold>
 
         /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 new Customers().setVisible(true);
             }
         });
     }
 
     // Variables declaration - do not modify                     
     private javax.swing.JTextField addressbtn;
     private javax.swing.JButton deletbtn;
     private javax.swing.JButton editbtn;
     private javax.swing.JTextField idbtn;
     private javax.swing.JLabel jLabel10;
     private javax.swing.JLabel jLabel11;
     private javax.swing.JLabel jLabel12;
     private javax.swing.JLabel jLabel13;
     private javax.swing.JLabel jLabel15;
     private javax.swing.JLabel jLabel16;
     private javax.swing.JLabel jLabel17;
     private javax.swing.JLabel jLabel18;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel8;
     private javax.swing.JLabel jLabel9;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel3;
     private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JTable jTable2;
     private javax.swing.JTextField namebtn;
     private javax.swing.JTextField phonebtn;
     private javax.swing.JButton resetbtn;
     private javax.swing.JButton savebtn;
     // End of variables declaration                   
 
    }
 