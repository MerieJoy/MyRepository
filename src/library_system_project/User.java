/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_system_project;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author win10dell
 */
public class User extends javax.swing.JFrame {

    /**
     * Creates new form User
     */
    int id;
    String username;

    public User() {
        initComponents();
        icon();
        setResizable(false);
    }

    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconnn.jpg")));
    }

    public User(String name, int id) {
        this.id = id;
        this.username = name;
        initComponents();
        icon();
        usernameS(username);
        setLocationRelativeTo(null);
        hidePanels();
        showBooks();
        showTransactions();
    }

    private void showBooks() {
        try {
            Connection connect = DbConnection.getConnection();
            String sql = "select * from `tblbooks`";
            Statement s = connect.createStatement();
            ResultSet rs = s.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) tableBooks.getModel();
            model.setRowCount(0);
            for (int i = 0; rs.next(); i++) {
                String row[] = new String[4];
                row[0] = rs.getString("bookId");
                row[1] = rs.getString("booktitle");
                row[2] = rs.getString("bookauthor");
                row[3] = rs.getString("status");

                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showTransactions() {
        try {
            Connection connect = DbConnection.getConnection();
            String sql = "select tb.transactId, tb.dateborrowed, tb.datereturned, tb.status, tb.librarian,"
                    + " tb.bookId, tb2.booktitle from tbltransact tb INNER JOIN tblbooks tb2 ON tb.bookId = tb2.bookId WHERE tb.userid = " + id + " AND NOT tb.status = 'Removed'";
            Statement s = connect.createStatement();
            ResultSet rs = s.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) tableborrowedpending.getModel();
            DefaultTableModel model2 = (DefaultTableModel) tableborrowed.getModel();
            model.setRowCount(0);
            model2.setRowCount(0);
            String row[] = new String[5];
            for (int i = 0; rs.next(); i++) {
                if (rs.getString("status").equals("Returned") || rs.getString("status").equals("Disapproved")) {
                    row[0] = rs.getString("transactId");
                    row[1] = rs.getString("booktitle");
                    row[2] = rs.getString("datereturned");
                    row[3] = rs.getString("status");
                    row[4] = rs.getString("librarian");

                    model2.addRow(row);
                } else {
                    row[0] = rs.getString("bookId");
                    row[1] = rs.getString("booktitle");
                    row[2] = rs.getString("status");
                    row[3] = rs.getString("dateborrowed");
                    row[4] = rs.getString("librarian");

                    model.addRow(row);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void usernameS(String username) {
        lbluserS.setText(username);
    }

    private void hidePanels() {
        BorrowedHistory.setVisible(false);
        PendingBorrowed.setVisible(false);
        ListofBooks.setVisible(false);
    }

    private void showSelectedButton() {
        btnlist.setBackground(java.awt.Color.white);
        btnpending.setBackground(java.awt.Color.white);
        btnhistory.setBackground(java.awt.Color.white);

        if (BorrowedHistory.isVisible()) {
            btnhistory.setBackground(java.awt.Color.yellow);
        }
        if (PendingBorrowed.isVisible()) {
            btnpending.setBackground(java.awt.Color.yellow);
        }
        if (ListofBooks.isVisible()) {
            btnlist.setBackground(java.awt.Color.yellow);
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

        jPanel1 = new javax.swing.JPanel();
        ListofBooks = new javax.swing.JPanel();
        btnaddborrow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBooks = new javax.swing.JTable();
        btnsearch = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PendingBorrowed = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableborrowedpending = new javax.swing.JTable();
        btnsave = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BorrowedHistory = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableborrowed = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnlogout = new javax.swing.JButton();
        btnhistory = new javax.swing.JButton();
        btnpending = new javax.swing.JButton();
        btnlist = new javax.swing.JButton();
        lbluserS = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Library Management System/user_menu/");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(50, 157, 156));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListofBooks.setBackground(new java.awt.Color(141, 193, 207));
        ListofBooks.setOpaque(false);
        ListofBooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnaddborrow.setBackground(new java.awt.Color(255, 255, 255));
        btnaddborrow.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        btnaddborrow.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\addto.png")); // NOI18N
        btnaddborrow.setBorder(null);
        btnaddborrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnaddborrowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnaddborrowMouseExited(evt);
            }
        });
        btnaddborrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddborrowActionPerformed(evt);
            }
        });
        ListofBooks.add(btnaddborrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 192, 32));

        tableBooks.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "             Book ID ", "               Title ", "             Author ", "             Status "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBooks.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tableBooks.setSelectionForeground(new java.awt.Color(255, 255, 254));
        jScrollPane1.setViewportView(tableBooks);

        ListofBooks.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 540, 370));

        btnsearch.setBackground(new java.awt.Color(255, 255, 255));
        btnsearch.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        btnsearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\searchhh.png")); // NOI18N
        btnsearch.setToolTipText("Seach books");
        btnsearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsearchMouseExited(evt);
            }
        });
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        btnsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnsearchKeyReleased(evt);
            }
        });
        ListofBooks.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 20, 20));

        txtsearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtsearch.setBorder(null);
        ListofBooks.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 200, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\listof.png")); // NOI18N
        jLabel3.setText("jLabel3");
        ListofBooks.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 530));

        jPanel1.add(ListofBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 580, 530));

        PendingBorrowed.setBackground(new java.awt.Color(141, 193, 207));
        PendingBorrowed.setOpaque(false);
        PendingBorrowed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableborrowedpending.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableborrowedpending.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "      BookID", "       Title", "       Status", " Date Borrowed  ", "       Librarian "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableborrowedpending.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tableborrowedpending.setSelectionForeground(new java.awt.Color(255, 255, 254));
        jScrollPane2.setViewportView(tableborrowedpending);

        PendingBorrowed.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 540, 370));

        btnsave.setBackground(new java.awt.Color(255, 255, 255));
        btnsave.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\save.png")); // NOI18N
        btnsave.setBorder(null);
        btnsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsaveMouseExited(evt);
            }
        });
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        PendingBorrowed.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 92, 32));

        btnremove.setBackground(new java.awt.Color(255, 255, 255));
        btnremove.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnremove.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\remove.png")); // NOI18N
        btnremove.setBorder(null);
        btnremove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnremoveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnremoveMouseExited(evt);
            }
        });
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });
        PendingBorrowed.add(btnremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 92, 32));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\pendingb.png")); // NOI18N
        jLabel4.setText("jLabel4");
        PendingBorrowed.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 530));

        jPanel1.add(PendingBorrowed, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 580, 530));

        BorrowedHistory.setBackground(new java.awt.Color(141, 193, 207));
        BorrowedHistory.setOpaque(false);
        BorrowedHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableborrowed.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableborrowed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "  Transaction ID", "         Title ", " Date Returned", "   Status", "        Librarian "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableborrowed.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tableborrowed.setSelectionForeground(new java.awt.Color(255, 255, 254));
        jScrollPane3.setViewportView(tableborrowed);

        BorrowedHistory.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 540, 430));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\bhistory.png")); // NOI18N
        jLabel5.setText("jLabel5");
        BorrowedHistory.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 530));

        jPanel1.add(BorrowedHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 580, 530));

        btnlogout.setBackground(new java.awt.Color(255, 255, 255));
        btnlogout.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnlogout.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\logouts.png")); // NOI18N
        btnlogout.setBorder(null);
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlogoutMouseExited(evt);
            }
        });
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 430, 134, 144));

        btnhistory.setBackground(new java.awt.Color(255, 255, 255));
        btnhistory.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnhistory.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\historys.png")); // NOI18N
        btnhistory.setBorder(null);
        btnhistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhistoryMouseExited(evt);
            }
        });
        btnhistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhistoryActionPerformed(evt);
            }
        });
        jPanel1.add(btnhistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 134, 144));

        btnpending.setBackground(new java.awt.Color(255, 255, 255));
        btnpending.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnpending.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\pends.png")); // NOI18N
        btnpending.setBorder(null);
        btnpending.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnpendingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnpendingMouseExited(evt);
            }
        });
        btnpending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpendingActionPerformed(evt);
            }
        });
        jPanel1.add(btnpending, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, 134, 144));

        btnlist.setBackground(new java.awt.Color(255, 255, 255));
        btnlist.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnlist.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\lists.png")); // NOI18N
        btnlist.setBorder(null);
        btnlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlistMouseExited(evt);
            }
        });
        btnlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlistActionPerformed(evt);
            }
        });
        jPanel1.add(btnlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 134, 144));

        lbluserS.setBackground(new java.awt.Color(7, 115, 149));
        lbluserS.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        lbluserS.setForeground(new java.awt.Color(255, 255, 255));
        lbluserS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbluserS, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 200, 40));

        jLabel1.setBackground(new java.awt.Color(141, 193, 207));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\win10dell\\Desktop\\LMS Icon\\user.png")); // NOI18N
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(998, 667));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int logout = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.OK_CANCEL_OPTION);

        if (logout == 0) {
            new Login().setVisible(true);
            dispose();
        }


    }//GEN-LAST:event_formWindowClosing

    private void btnpendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpendingActionPerformed
        hidePanels();
        PendingBorrowed.setVisible(true);
        showSelectedButton();
    }//GEN-LAST:event_btnpendingActionPerformed

    private void btnhistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhistoryActionPerformed
        hidePanels();
        BorrowedHistory.setVisible(true);
        showSelectedButton();
    }//GEN-LAST:event_btnhistoryActionPerformed

    private void btnlistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlistMouseEntered
        btnlist.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_btnlistMouseEntered

    private void btnlistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlistMouseExited
        btnlist.setBackground(java.awt.Color.white);
        showSelectedButton();
    }//GEN-LAST:event_btnlistMouseExited

    private void btnpendingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpendingMouseEntered
        btnpending.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_btnpendingMouseEntered

    private void btnpendingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpendingMouseExited
        btnpending.setBackground(java.awt.Color.white);
        showSelectedButton();
    }//GEN-LAST:event_btnpendingMouseExited

    private void btnhistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhistoryMouseEntered
        btnhistory.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_btnhistoryMouseEntered

    private void btnhistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhistoryMouseExited
        btnhistory.setBackground(java.awt.Color.white);
        showSelectedButton();
    }//GEN-LAST:event_btnhistoryMouseExited

    private void btnlogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseEntered
        btnlogout.setBackground(java.awt.Color.red);
    }//GEN-LAST:event_btnlogoutMouseEntered

    private void btnlogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseExited
        btnlogout.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_btnlogoutMouseExited

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        int logout = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.OK_CANCEL_OPTION);

        if (logout == 0) {
            new Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btnlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistActionPerformed
        hidePanels();
        ListofBooks.setVisible(true);
        showSelectedButton();
    }//GEN-LAST:event_btnlistActionPerformed

    private void btnaddborrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddborrowActionPerformed
        int rows = tableBooks.getSelectedRowCount();
        if (rows != 1) {
            JOptionPane.showMessageDialog(null, "Please Select a single book", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int row = tableBooks.getSelectedRow();

            String bookId = tableBooks.getValueAt(row, 0).toString();
            String bookTitle = tableBooks.getValueAt(row, 1).toString();
            String status = tableBooks.getValueAt(row, 3).toString();

            if (status.equals("Borrowed")) {
                JOptionPane.showMessageDialog(null, "Book " + bookTitle + " is Borrowed.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                boolean found = false;
                for (int i = 0; i < tableborrowedpending.getRowCount(); i++) {
                    if (tableborrowedpending.getValueAt(i, 0).toString().equals(bookId)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    JOptionPane.showMessageDialog(null, bookTitle + " is already pending", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String borrow[] = new String[5];
                borrow[0] = bookId;
                borrow[1] = bookTitle;
                borrow[2] = "Pending";
                borrow[3] = "--";
                borrow[4] = "--";

                DefaultTableModel model = (DefaultTableModel) tableborrowedpending.getModel();
                model.addRow(borrow);
                JOptionPane.showMessageDialog(null, "Book " + bookTitle + " is added for request.");
            }

        }
    }//GEN-LAST:event_btnaddborrowActionPerformed

    private void btnaddborrowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddborrowMouseExited
        btnaddborrow.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_btnaddborrowMouseExited

    private void btnaddborrowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddborrowMouseEntered
        btnaddborrow.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_btnaddborrowMouseEntered

    private void btnsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnsearchKeyReleased

    }//GEN-LAST:event_btnsearchKeyReleased

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        String regex = txtsearch.getText();
        filterTable(regex);
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnsearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseExited
        btnsearch.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_btnsearchMouseExited

    private void btnsearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseEntered
        btnsearch.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_btnsearchMouseEntered

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        int rows = tableborrowedpending.getSelectedRowCount();
        if (rows != 1) {
            JOptionPane.showMessageDialog(null, "Please Select a single book", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int row = tableborrowedpending.getSelectedRow();

            String transactionId = tableborrowedpending.getValueAt(row, 0).toString();
            String bookTitle = tableborrowedpending.getValueAt(row, 1).toString();
            String status = tableborrowedpending.getValueAt(row, 2).toString();

            try {
                String sql = "Update tbltransact set status = 'Removed'"
                        + " WHERE userId = " + id + " AND status = 'Requested' AND bookId = " + transactionId;
                if (status.equals("Borrowed")) {
                    JOptionPane.showMessageDialog(null, "Book " + bookTitle + " cannot be removed.", "failed", JOptionPane.ERROR_MESSAGE);
                } else {
                    Connection connect = DbConnection.getConnection();
                    PreparedStatement pst = connect.prepareStatement(sql);
                    pst.executeUpdate();
                    DefaultTableModel model = (DefaultTableModel) tableborrowedpending.getModel();

                    model.removeRow(row);
                    JOptionPane.showMessageDialog(null, "Book " + bookTitle + " has been removed.", "Success", JOptionPane.PLAIN_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnremoveActionPerformed

    private void btnremoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnremoveMouseExited
        btnremove.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_btnremoveMouseExited

    private void btnremoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnremoveMouseEntered
        btnremove.setBackground(java.awt.Color.red);
    }//GEN-LAST:event_btnremoveMouseEntered

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        int rows = tableborrowedpending.getSelectedRowCount();
        if (rows != 1) {
            JOptionPane.showMessageDialog(null, "Please Select a single book", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int row = tableborrowedpending.getSelectedRow();

            String bookId = tableborrowedpending.getValueAt(row, 0).toString();
            String bookTitle = tableborrowedpending.getValueAt(row, 1).toString();
            String status = tableborrowedpending.getValueAt(row, 2).toString();

            try {
                Connection connect = DbConnection.getConnection();

                if (status.equals("Pending")) {

                    String sql = "INSERT INTO tbltransact (userid, bookid, dateborrowed, datereturned, status, librarian) "
                            + "VALUES(" + id + ", " + bookId + ", '--', '--', 'Requested', '--')";
                    PreparedStatement pst = connect.prepareStatement(sql);
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "Book " + bookTitle + " has been requested.", "Success", JOptionPane.PLAIN_MESSAGE);

                    String value = "Requested";
                    tableborrowedpending.setValueAt(value, row, 2);
                } else if (status.equals("Borrowed")) {
                    JOptionPane.showMessageDialog(null, "The book you selected is Borrowed already.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "The book you selected is Pending.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnsaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsaveMouseExited
        btnsave.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_btnsaveMouseExited

    private void btnsaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsaveMouseEntered
        btnsave.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_btnsaveMouseEntered

    private void filterTable(String regex) {
        String sql = "SELECT * from tblbooks WHERE"
                + " booktitle LIKE '%" + regex + "%' OR bookauthor LIKE '%" + regex + "%' OR"
                + " publisher LIKE '%" + regex + "%' OR pubdate LIKE '%" + regex + "%' OR status LIKE '%" + regex + "%'";

        DefaultTableModel model = (DefaultTableModel) tableBooks.getModel();
        model.setRowCount(0);
        try {
            Connection connect = DbConnection.getConnection();
            Statement s = connect.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("bookId");
                String title = rs.getString("booktitle");
                String author = rs.getString("bookauthor");
                String status = rs.getString("status");

                String row[] = {id, title, author, status};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BorrowedHistory;
    private javax.swing.JPanel ListofBooks;
    private javax.swing.JPanel PendingBorrowed;
    private javax.swing.JButton btnaddborrow;
    private javax.swing.JButton btnhistory;
    private javax.swing.JButton btnlist;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnpending;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbluserS;
    private javax.swing.JTable tableBooks;
    private javax.swing.JTable tableborrowed;
    private javax.swing.JTable tableborrowedpending;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
