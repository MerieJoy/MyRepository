
package library_system_project;

import java.sql.Connection;
import java.sql.DriverManager;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Login extends javax.swing.JFrame {
    Connection connect;
    ResultSet ab;
    PreparedStatement pre;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        icon();
        setResizable(false);
    }
    private void icon(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconnn.jpg")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbsignup = new javax.swing.JLabel();
        ckbshowpass = new javax.swing.JCheckBox();
        pswdlogin = new javax.swing.JPasswordField();
        txtusername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Library Management System/login");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbsignup.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lbsignup.setForeground(new java.awt.Color(0, 102, 204));
        lbsignup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbsignup.setText("Don't have an account? Sign Up");
        lbsignup.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbsignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbsignupMouseClicked(evt);
            }
        });
        jPanel1.add(lbsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 270, -1));

        ckbshowpass.setFont(new java.awt.Font("Segoe UI Black", 0, 10)); // NOI18N
        ckbshowpass.setForeground(new java.awt.Color(16, 119, 124));
        ckbshowpass.setText("Show password");
        ckbshowpass.setOpaque(false);
        ckbshowpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbshowpassActionPerformed(evt);
            }
        });
        jPanel1.add(ckbshowpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, 20));

        pswdlogin.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        pswdlogin.setToolTipText("Enter password");
        pswdlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswdloginActionPerformed(evt);
            }
        });
        jPanel1.add(pswdlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 200, 28));

        txtusername.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        txtusername.setToolTipText("Enter username");
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 200, 28));

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/login.png"))); // NOI18N
        btnLogin.setBorder(null);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 82, 32));

        btnclear.setBackground(new java.awt.Color(255, 255, 255));
        btnclear.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/clear.png"))); // NOI18N
        btnclear.setBorder(null);
        btnclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnclearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnclearMouseExited(evt);
            }
        });
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel1.add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 82, 32));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/userpass.png"))); // NOI18N
        jLabel5.setText("jLabel4");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 30, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/userlogin.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/bglogin.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ckbshowpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbshowpassActionPerformed
        if (ckbshowpass.isSelected()){
            pswdlogin.setEchoChar((char)0);
        }else{
            pswdlogin.setEchoChar(('"'));
        }
    }//GEN-LAST:event_ckbshowpassActionPerformed

    private void btnclearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclearMouseEntered
        btnclear.setBackground(java.awt.Color.red);
    }//GEN-LAST:event_btnclearMouseEntered

    private void btnclearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclearMouseExited
         btnclear.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_btnclearMouseExited

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
         txtusername.setText("");
         pswdlogin.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

    private void lbsignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbsignupMouseClicked
        Regform signup = new Regform();
        signup.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_lbsignupMouseClicked

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        // TODO add your handling code here:
         btnLogin.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        // TODO add your handling code here:
        btnLogin.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_btnLoginMouseExited

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
         try{
            Connection connect = DbConnection.getConnection();
            String sql = "select * from `tablelms` where `username`='" + txtusername.getText() + "'";
            Statement s = connect.createStatement();
            ResultSet rs = s.executeQuery(sql);
            String username = txtusername.getText();
            String password = pswdlogin.getText();
           
            
            if(rs.next()){
                
                if (username.equals(rs.getString("Username"))&& password.equals(rs.getString("Password"))){
                    if(rs.getString("Status").equals("Deactivated")){
                        JOptionPane.showMessageDialog(null, "Account currently deactivated.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (rs.getString("usertype").equals("Admin")){
                    Admin ad = new Admin();
                    ad.setVisible(true);
                    this.setVisible(true);
                    this.setVisible(false);
                    
                    ad.usernameA(username);
                    
                    
                    }else{
                     User us = new User(username, rs.getInt("UserID"));
                    us.setVisible(true);
                    this.setVisible(false);
                    }
                }else{
                JOptionPane.showMessageDialog(null, "Incorrect username or password.");
            } 
            }
            
        }catch (SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            btnLogin.doClick(); }
    }//GEN-LAST:event_btnLoginKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int close = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?","Yes",JOptionPane.OK_CANCEL_OPTION);
        
        if(close==0){
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void pswdloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswdloginActionPerformed
        btnLoginActionPerformed(evt);
    }//GEN-LAST:event_pswdloginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnclear;
    private javax.swing.JCheckBox ckbshowpass;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbsignup;
    private javax.swing.JPasswordField pswdlogin;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
