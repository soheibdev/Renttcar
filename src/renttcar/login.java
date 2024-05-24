/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renttcar;

/**
 *
 * @author akram
 */



 import javax.swing.JOptionPane;

 /**
  *
  * @author laaraf mohamed
  */
 public class login extends javax.swing.JFrame {
 
     /**
      * Creates new form login
      */
     public login() {
         initComponents();
     }
 
     
    
                              
     private void initComponents() {
 
         jPanel1 = new javax.swing.JPanel();
         jLabel3 = new javax.swing.JLabel();
         jLabel5 = new javax.swing.JLabel();
         jLabel6 = new javax.swing.JLabel();
         jLabel15 = new javax.swing.JLabel();
         jLabel17 = new javax.swing.JLabel();
         txtusername = new javax.swing.JTextField();
         txtpassword = new javax.swing.JPasswordField();
         jPanel3 = new javax.swing.JPanel();
         jLabel4 = new javax.swing.JLabel();
         jButton1 = new javax.swing.JButton();
         jLabel1 = new javax.swing.JLabel();
 
         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
         setUndecorated(true);
 
         jPanel1.setBackground(new java.awt.Color(255, 153, 51));
         jPanel1.setForeground(new java.awt.Color(255, 153, 0));
 
         jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel3.setText("Amazing servise");
 
         jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel5.setText("Responsivness");
 
         jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel6.setText("Security");
 
         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addContainerGap(16, Short.MAX_VALUE)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                         .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(14, 14, 14))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                         .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(23, 23, 23))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                         .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addContainerGap())))
         );
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGap(68, 68, 68)
                 .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(18, 18, 18)
                 .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(18, 18, 18)
                 .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );
 
         jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel15.setText("Password");
         jLabel15.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
         jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
         jLabel17.setText("User Name");
         jLabel17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
 
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
                 .addContainerGap(447, Short.MAX_VALUE)
                 .addComponent(jLabel4)
                 .addContainerGap())
         );
         jPanel3Layout.setVerticalGroup(
             jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
         );
 
         jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
         jButton1.setText("Login");
         jButton1.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton1ActionPerformed(evt);
             }
         });
 
         jLabel1.setIcon(new javax.swing.ImageIcon("img/auto.png")); // NOI18N
         jLabel1.setText("jLabel1");
 
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                 .addGap(176, 176, 176)
                 .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(0, 0, Short.MAX_VALUE))
             .addGroup(layout.createSequentialGroup()
                 .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                         .addGap(63, 63, 63)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(18, 18, 18)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addContainerGap())
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                 .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(172, 172, 172))
                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                 .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addGap(132, 132, 132))))))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(13, 13, 13)
                 .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(18, 18, 18)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(18, 18, 18)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(94, Short.MAX_VALUE))
             .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         );
 
         pack();
         setLocationRelativeTo(null);
     }// </editor-fold>                        
     @SuppressWarnings("deprecation")
     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
          String USERNAME=txtusername.getText();
         String PASSWORD=txtpassword.getText();
         if(USERNAME.equals("Soheib")&& PASSWORD.equals("2004"))
         {
             cars m=new cars();
             this.hide();
             m.setVisible(true);
             
         }
         else
         {
             JOptionPane.showMessageDialog(this,"Username and Password not matching please "
                  + "\n Enter the correct username and password");
          
         }
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
             java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //</editor-fold>
 
         /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 new login().setVisible(true);
             }
         });
     }
 
     // Variables declaration - do not modify                     
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel15;
     private javax.swing.JLabel jLabel17;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel3;
     private javax.swing.JPasswordField txtpassword;
     private javax.swing.JTextField txtusername;
     // End of variables declaration                   
 }
 
