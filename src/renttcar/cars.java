/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renttcar;

/**
 *
 * @author akram
 */

 import java.net.MalformedURLException;
import java.rmi.Naming;
 import java.rmi.NotBoundException;
 import java.rmi.RemoteException;
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
 public class cars extends javax.swing.JFrame {
 
     
     
     public cars() {
         initComponents();
         
         table_update();
         autoID();
     }
 
     
     Connection con;
 PreparedStatement pst;
     ResultSet Rs=null;
 
 
 
    // A method that sets the registration number of a new car to the next available number.
     public void autoID() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/losrent", "laaraf","06102004");
            String sql = "SELECT MAX(Registrationnum) FROM carregistation";
            pst = con.prepareStatement(sql);
            Rs=pst.executeQuery();
            Rs.next();
            if(Rs.wasNull()) {
                RegnumTb.setText("C0001");
            } else {
                long id=Long.parseLong(Rs.getString("Max(Registrationnum)").substring(2,Rs.getString("Max(Registrationnum)").length()));
                id++;
                RegnumTb.setText("C0" + String.format("%03d",id));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
  
      public CarManager getCarManager() {
    CarManager manager = null;
    try {
        
        manager = (CarManager) Naming.lookup("//localhost/CarManager");
    } catch (NotBoundException | RemoteException | MalformedURLException e) {
        e.printStackTrace();
    }
    return manager;
}
//A method that updates the CarsTable component with the latest car information from the database.
    @SuppressWarnings("unchecked")
    public void table_update()
      {
          int c;
          try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://localhost/losrent","laaraf","06102004");
              pst=con.prepareStatement("select * from carregistation");
              ResultSet Rs=pst.executeQuery();
              
              ResultSetMetaData rd=Rs.getMetaData();
              c=rd.getColumnCount();
              DefaultTableModel df=(DefaultTableModel)CarsTable.getModel();
              df.setRowCount(0);
              
              
              while(Rs.next())
              {
                  @SuppressWarnings("rawtypes")
                Vector v2=new Vector();
                  for(int i=1;i<=c;i++)
                  {
                      v2.add(Rs.getString("Registrationnum"));
                      v2.add(Rs.getString("Brand"));
                      v2.add(Rs.getString("Model"));
                      v2.add(Rs.getString("Statut"));  
                      v2.add(Rs.getString("Price"));
  
                  }  
                  df.addRow(v2);
              }
              
              } catch (ClassNotFoundException ex) {
              Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(cars.class.getName()).log(Level.SEVERE, null, ex);
          }
              
      }
     // A method that resets all the text fields and combo box to their default values.
      private void ResetForm(){
         
         BrandTb.setText("");
         ModelTb.setText("");
         StatutCb.setSelectedIndex(0);
         PriceTb.setText("");
     }
     // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
     private void initComponents() {
 
         jPanel1 = new javax.swing.JPanel();
         jLabel8 = new javax.swing.JLabel();
         jLabel16 = new javax.swing.JLabel();
         jLabel17 = new javax.swing.JLabel();
         jLabel18 = new javax.swing.JLabel();
         jPanel3 = new javax.swing.JPanel();
         jLabel4 = new javax.swing.JLabel();
         jLabel10 = new javax.swing.JLabel();
         EditBtn = new javax.swing.JButton();
         RegnumTb = new javax.swing.JTextField();
         ResetBtn = new javax.swing.JButton();
         jLabel11 = new javax.swing.JLabel();
         SaveBtn = new javax.swing.JButton();
         BrandTb = new javax.swing.JTextField();
         jLabel15 = new javax.swing.JLabel();
         jLabel12 = new javax.swing.JLabel();
         jScrollPane2 = new javax.swing.JScrollPane();
         CarsTable = new javax.swing.JTable();
         ModelTb = new javax.swing.JTextField();
         jLabel13 = new javax.swing.JLabel();
         PriceTb = new javax.swing.JTextField();
         jLabel14 = new javax.swing.JLabel();
         StatutCb = new javax.swing.JComboBox<>();
         jLabel9 = new javax.swing.JLabel();
         DeletBtn = new javax.swing.JButton();
 
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
         jLabel18.setText("Customer");
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
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
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
                 .addContainerGap(983, Short.MAX_VALUE)
                 .addComponent(jLabel4)
                 .addContainerGap())
         );
         jPanel3Layout.setVerticalGroup(
             jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
         );
 
         jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel10.setForeground(new java.awt.Color(153, 0, 153));
         jLabel10.setText("Cars List ");
         jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         EditBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         EditBtn.setForeground(new java.awt.Color(204, 0, 204));
         EditBtn.setText("Edit");
         EditBtn.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 EditBtnActionPerformed(evt);
             }
         });
 
         RegnumTb.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
         RegnumTb.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 RegnumTbActionPerformed(evt);
             }
         });
 
         ResetBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         ResetBtn.setForeground(new java.awt.Color(204, 0, 204));
         ResetBtn.setText("Reset");
         ResetBtn.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 ResetBtnActionPerformed(evt);
             }
         });
 
         jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         jLabel11.setForeground(new java.awt.Color(153, 0, 153));
         jLabel11.setText("Brand");
         jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         SaveBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         SaveBtn.setForeground(new java.awt.Color(204, 0, 204));
         SaveBtn.setText("Save");
         SaveBtn.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 SaveBtnActionPerformed(evt);
             }
         });
 
         BrandTb.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
 
         jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel15.setForeground(new java.awt.Color(153, 0, 153));
         jLabel15.setText("Manage cars ");
         jLabel15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         jLabel12.setForeground(new java.awt.Color(153, 0, 153));
         jLabel12.setText("Model");
         jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         CarsTable.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         CarsTable.setModel(new javax.swing.table.DefaultTableModel(
             new Object [][] {
                 {null, null, "", "", null},
                 {null, null, null, null, null},
                 {null, null, null, null, null}
             },
             new String [] {
                 "Registration", "Brand", "Model", "Statut", "Prise"
             }
         ));
         CarsTable.setRowHeight(25);
         CarsTable.setRowSelectionAllowed(false);
         CarsTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
         CarsTable.setShowGrid(true);
         CarsTable.setSurrendersFocusOnKeystroke(true);
         CarsTable.addAncestorListener(new javax.swing.event.AncestorListener() {
             public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                 CarsTableAncestorAdded(evt);
             }
             public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
             }
             public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
             }
         });
         CarsTable.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 CarsTableMouseClicked(evt);
             }
         });
         jScrollPane2.setViewportView(CarsTable);
 
         ModelTb.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
         ModelTb.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 ModelTbActionPerformed(evt);
             }
         });
 
         jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         jLabel13.setForeground(new java.awt.Color(153, 0, 153));
         jLabel13.setText("Price");
         jLabel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         PriceTb.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
         PriceTb.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 PriceTbActionPerformed(evt);
             }
         });
 
         jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         jLabel14.setForeground(new java.awt.Color(153, 0, 153));
         jLabel14.setText("Statut");
         jLabel14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         StatutCb.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         StatutCb.setForeground(new java.awt.Color(153, 0, 153));
         StatutCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Booked", "Available" }));
 
         jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
         jLabel9.setForeground(new java.awt.Color(153, 0, 153));
         jLabel9.setText("Registration num");
         jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         DeletBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         DeletBtn.setForeground(new java.awt.Color(204, 0, 204));
         DeletBtn.setText("Delete");
         DeletBtn.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 DeletBtnActionPerformed(evt);
             }
         });
 
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jScrollPane2)
                     .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                         .addGap(28, 28, 28)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(layout.createSequentialGroup()
                                 .addComponent(RegnumTb, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addComponent(BrandTb, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(57, 57, 57)
                                 .addComponent(ModelTb, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(55, 55, 55))
                             .addGroup(layout.createSequentialGroup()
                                 .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(53, 53, 53)
                                 .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(57, 57, 57)
                                 .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(layout.createSequentialGroup()
                                 .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(166, 166, 166)
                                 .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                             .addGroup(layout.createSequentialGroup()
                                 .addComponent(StatutCb, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(54, 54, 54)
                                 .addComponent(PriceTb, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                         .addContainerGap())
                     .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                             .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                 .addGap(54, 54, 54)
                                 .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                             .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                 .addGap(205, 205, 205)
                                 .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(18, 18, 18)
                                 .addComponent(DeletBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(18, 18, 18)
                                 .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(18, 18, 18)
                                 .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                         .addGap(0, 0, Short.MAX_VALUE))
                     .addGroup(layout.createSequentialGroup()
                         .addGap(0, 0, Short.MAX_VALUE)
                         .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(413, 413, 413))))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addGroup(layout.createSequentialGroup()
                 .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                         .addComponent(jLabel9)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(BrandTb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(RegnumTb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addGroup(layout.createSequentialGroup()
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                 .addComponent(jLabel12)
                                 .addComponent(jLabel11)
                                 .addComponent(jLabel13)))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(StatutCb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(PriceTb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(ModelTb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                 .addGap(37, 37, 37)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(SaveBtn)
                     .addComponent(DeletBtn)
                     .addComponent(EditBtn)
                     .addComponent(ResetBtn))
                 .addGap(24, 24, 24)
                 .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(67, 67, 67)
                 .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
         );
 
         pack();
         setLocationRelativeTo(null);
     }// </editor-fold>                        
    /* A method that is called when the EditBtn button is clicked. 
    It updates the car information in the database with the new information from the text fields and combo box.*/ 
     private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
         DefaultTableModel d1 = (DefaultTableModel) CarsTable.getModel();
         int selectIndex = CarsTable.getSelectedRow();
     
         try {
             if (selectIndex >= 0) {
                 String id = d1.getValueAt(selectIndex, 0).toString();
                 @SuppressWarnings("unused")
                String make = RegnumTb.getText();
                 String Bra = BrandTb.getText();
                 String mod = ModelTb.getText();
                 String status = StatutCb.getSelectedItem().toString();
                 String pri = PriceTb.getText();
     
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 con = DriverManager.getConnection("jdbc:mysql://localhost/losrent", "laaraf", "06102004");
     
                 pst = con.prepareStatement("update carregistation set Brand=?, Model=?, Statut=?, Price=? where Registrationnum=?");
 
                 
                 pst.setString(1, Bra);
                 pst.setString(2, mod);
                 pst.setString(3, status);
                 pst.setString(4, pri);
                 pst.setString(5, id); // Update the 'Price' column
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
         
         
     
     private void RegnumTbActionPerformed(java.awt.event.ActionEvent evt) {                                         
         // TODO add your handling code here:
     }                                        
 /*A method that is called when the SaveBtn button is clicked.
  It inserts a new car record into the database with the information from the text fields and combo box. */
     private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
         String rgno=RegnumTb.getText();
          String make=BrandTb.getText();
          String mod =ModelTb.getText();
          String avl=StatutCb.getSelectedItem().toString();
          String pri=PriceTb.getText();
          
             try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 con=DriverManager.getConnection("jdbc:mysql://localhost/losrent","laaraf","06102004");
                 pst=con.prepareStatement("insert into carregistation(Registrationnum,Brand,Model,Statut,Price)values(?,?,?,?,?)");
                 pst.setString(1,rgno);
                 pst.setString(2,make);
                 pst.setString(3,mod);
                 pst.setString(4,avl); 
                 pst.setString(5,pri);
  
                 pst.executeUpdate();  
                 JOptionPane.showMessageDialog(this,"Car Added Successfully..........");
                 
                   autoID();
                   BrandTb.setText("");
                   StatutCb.setSelectedIndex(-1);
                   ModelTb.setText("");
                   PriceTb.setText("");
                   RegnumTb.requestFocus();
                   
                   table_update();
                  } catch (ClassNotFoundException ex) {
                      JOptionPane.showMessageDialog(this,"problem");
                  } catch (SQLException ex) {
                      JOptionPane.showMessageDialog(this,"problem2");
                  }
                  
                  
     }                                       
 
     private void CarsTableAncestorAdded(javax.swing.event.AncestorEvent evt) {                                        
         // TODO add your handling code here:
     }                                       
 
     private void ModelTbActionPerformed(java.awt.event.ActionEvent evt) {                                        
         // TODO add your handling code here:
     }                                       
 
     private void PriceTbActionPerformed(java.awt.event.ActionEvent evt) {                                        
         // TODO add your handling code here:
     }                                       
 /*A method that is called when the DeletBtn button is clicked.
  It deletes the selected car record from the database. */

     private void DeletBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
         
         DefaultTableModel d1 = (DefaultTableModel) CarsTable.getModel();
         int selectIndex = CarsTable.getSelectedRow();
     
         // Check if any row is selected
         if (selectIndex >= 0) {
             String id = d1.getValueAt(selectIndex, 0).toString();
             int dialogResult = JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer l'enregistrement", "Waring", JOptionPane.YES_NO_OPTION);
     
             if (dialogResult == JOptionPane.YES_OPTION) {
                 try {
                     Class.forName("com.mysql.cj.jdbc.Driver");
                     con = DriverManager.getConnection("jdbc:mysql://localhost/losrent","laaraf","06102004");
                     pst=con.prepareStatement("delete from carregistation where Registrationnum=?");
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
 /*A method that is called when a row in the CarsTable component is clicked.
  It sets the text fields and combo box with the information of the selected car. */
     private void CarsTableMouseClicked(java.awt.event.MouseEvent evt) {                                       
         DefaultTableModel d1=(DefaultTableModel)CarsTable.getModel();
         int selectIndex=CarsTable.getSelectedRow();
         
         RegnumTb.setText(d1.getValueAt(selectIndex,0).toString());
         BrandTb.setText(d1.getValueAt(selectIndex,1).toString());
         ModelTb.setText(d1.getValueAt(selectIndex,2).toString());
         StatutCb.setSelectedItem(d1.getValueAt(selectIndex,3).toString());
         PriceTb.setText(d1.getValueAt(selectIndex,4).toString());
     }                                      
 
     private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
         ResetForm();
     }                                        
 
     private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {                                     
         dispose();
     }                                    
 
     @SuppressWarnings("deprecation")
    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {                                      
         Customers customers=new Customers();
         this.hide();
         customers.setVisible(true);
     }                                     
     @SuppressWarnings("deprecation")
     private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {                                     
         rentcarsss tt=new rentcarsss();
         this.hide();
         tt.setVisible(true);
     }                                    
     @SuppressWarnings("deprecation")
     private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {                                      
         ReturnCars returnCars=new ReturnCars();
         this.hide();
         returnCars.setVisible(true);
     }                                     
     @SuppressWarnings("deprecation")
     private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {                                      
         login bb =new login();
         this.hide();
         bb.setVisible(true);
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
             java.util.logging.Logger.getLogger(cars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(cars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(cars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(cars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //</editor-fold>
 
         /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 new cars().setVisible(true);
             }
         });
     }
 
     // Variables declaration - do not modify                     
     private javax.swing.JTextField BrandTb;
     private javax.swing.JTable CarsTable;
     private javax.swing.JButton DeletBtn;
     private javax.swing.JButton EditBtn;
     private javax.swing.JTextField ModelTb;
     private javax.swing.JTextField PriceTb;
     private javax.swing.JTextField RegnumTb;
     private javax.swing.JButton ResetBtn;
     private javax.swing.JButton SaveBtn;
     private javax.swing.JComboBox<String> StatutCb;
     private javax.swing.JLabel jLabel10;
     private javax.swing.JLabel jLabel11;
     private javax.swing.JLabel jLabel12;
     private javax.swing.JLabel jLabel13;
     private javax.swing.JLabel jLabel14;
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
     // End of variables declaration                   

     
 }
 

