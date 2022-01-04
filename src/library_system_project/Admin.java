package library_system_project;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author win10dell
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        setLocationRelativeTo(null);
        icon();
        hidePanels();
        showBooks();
        showUsers();
        showTransactions();

        setResizable(false);
    }

    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconnn.jpg")));
    }

    private void showBooks() {
        try {
            Connection connect = DbConnection.getConnection();
            String sql = "select * from `tblbooks`";
            Statement s = connect.createStatement();
            ResultSet rs = s.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) tblbooks.getModel();
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

    private void showUsers() {
        try {
            Connection connect = DbConnection.getConnection();
            String sql = "select * from `tablelms`";
            Statement s = connect.createStatement();
            ResultSet rs = s.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) tblusers.getModel();
            model.setRowCount(0);
            for (int i = 0; rs.next(); i++) {
                String row[] = new String[4];
                row[0] = rs.getString("UserId");
                row[1] = rs.getString("firstname") + " " + rs.getString("lastname");;
                row[2] = rs.getString("usertype");
                row[3] = rs.getString("status");

                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showTransactions() {
        try {
            String sql = "select t.transactId, t.bookId, b.booktitle, t.dateborrowed, t.status, u.firstname, u.lastname"
                    + " from tbltransact t INNER JOIN tblbooks b ON t.bookId = b.bookId"
                    + " INNER JOIN tablelms u ON t.userId = u.userId WHERE NOT t.status = 'Removed'";
            Connection connect = DbConnection.getConnection();
            Statement s = connect.createStatement();
            ResultSet rs = s.executeQuery(sql);
            DefaultTableModel modelBorrow = (DefaultTableModel) tblreq.getModel();
            modelBorrow.setRowCount(0);
            DefaultTableModel modelHistory = (DefaultTableModel) tbltrans.getModel();
            modelHistory.setRowCount(0);
            String row[] = new String[4];

            while (rs.next()) {
                if (rs.getString("Status").equals("Requested")) {
                    row[0] = rs.getString("transactId");
                    row[1] = rs.getString("bookId");
                    row[2] = rs.getString("bookTitle");
                    row[3] = rs.getString("firstname") + " " + rs.getString("lastname");

                    modelBorrow.addRow(row);
                } else {
                    row = new String[6];
                    row[0] = rs.getString("transactId");
                    row[1] = rs.getString("bookId");
                    row[2] = rs.getString("bookTitle");
                    row[3] = rs.getString("firstname") + " " + rs.getString("lastname");
                    row[4] = rs.getString("dateborrowed");
                    row[5] = rs.getString("status");

                    modelHistory.addRow(row);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void usernameA(String username) {
        lbladminusername.setText(username);
    }

    private void hidePanels() {
        regbooks.setVisible(false);
        listofbooks.setVisible(false);
        listofusers.setVisible(false);
        pendingreq.setVisible(false);
        trans.setVisible(false);
    }

    private void showSelectedButton() {
        btnregbook.setBackground(java.awt.Color.white);
        btnlistofbooks.setBackground(java.awt.Color.white);
        btnlist.setBackground(java.awt.Color.white);
        btnpending.setBackground(java.awt.Color.white);
        btnborrowed.setBackground(java.awt.Color.white);

        if (regbooks.isVisible()) {
            btnregbook.setBackground(java.awt.Color.yellow);
        }
        if (listofbooks.isVisible()) {
            btnlistofbooks.setBackground(java.awt.Color.yellow);
        }
        if (listofusers.isVisible()) {
            btnlist.setBackground(java.awt.Color.yellow);
        }
        if (pendingreq.isVisible()) {
            btnpending.setBackground(java.awt.Color.yellow);
        }
        if (trans.isVisible()) {
            btnborrowed.setBackground(java.awt.Color.yellow);
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
        regbooks = new javax.swing.JPanel();
        btnclear = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        txtpublisher = new javax.swing.JTextField();
        txtauthor = new javax.swing.JTextField();
        txttitle = new javax.swing.JTextField();
        txtbookid = new javax.swing.JTextField();
        jDatepublished = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        listofbooks = new javax.swing.JPanel();
        txtsearchb = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbooks = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        pendingreq = new javax.swing.JPanel();
        txtsearchp = new javax.swing.JTextField();
        btnsearchreq = new javax.swing.JButton();
        btndisapprove = new javax.swing.JButton();
        btnapprove = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblreq = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        trans = new javax.swing.JPanel();
        txtsearchtrans = new javax.swing.JTextField();
        btnsearcht = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbltrans = new javax.swing.JTable();
        btnreturn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        listofusers = new javax.swing.JPanel();
        txtsearchu = new javax.swing.JTextField();
        btnseachu = new javax.swing.JButton();
        btnupdateu = new javax.swing.JButton();
        btnreg = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblusers = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnlogout = new javax.swing.JButton();
        btnborrowed = new javax.swing.JButton();
        btnlistofbooks = new javax.swing.JButton();
        btnpending = new javax.swing.JButton();
        btnlist = new javax.swing.JButton();
        btnregbook = new javax.swing.JButton();
        lbladminusername = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Library Management System/admin_menu/");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(50, 157, 156));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 630));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regbooks.setOpaque(false);
        regbooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/clearr.png"))); // NOI18N
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        regbooks.add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 92, 32));

        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/update.png"))); // NOI18N
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        regbooks.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 92, 32));

        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/add.png"))); // NOI18N
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        regbooks.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 92, 32));

        txtpublisher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regbooks.add(txtpublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 350, 30));

        txtauthor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regbooks.add(txtauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 350, 30));

        txttitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regbooks.add(txttitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 350, 30));

        txtbookid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtbookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookidActionPerformed(evt);
            }
        });
        regbooks.add(txtbookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 350, 30));

        jDatepublished.setDateFormatString("yyyy/MM/dd");
        jDatepublished.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jDatepublished.setVerifyInputWhenFocusTarget(false);
        regbooks.add(jDatepublished, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 350, 30));

        jLabel6.setBackground(new java.awt.Color(16, 119, 124));
        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Date Published:");
        jLabel6.setOpaque(true);
        regbooks.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 120, 30));

        jLabel5.setBackground(new java.awt.Color(16, 119, 124));
        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Publisher:");
        jLabel5.setOpaque(true);
        regbooks.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 120, 30));

        jLabel4.setBackground(new java.awt.Color(16, 119, 124));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Book Author:");
        jLabel4.setOpaque(true);
        regbooks.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 120, 30));

        jLabel3.setBackground(new java.awt.Color(16, 119, 124));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Book Title:");
        jLabel3.setOpaque(true);
        regbooks.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 120, 30));

        jLabel2.setBackground(new java.awt.Color(16, 119, 124));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Book ID:");
        jLabel2.setOpaque(true);
        regbooks.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/regbooks.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        regbooks.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 530));

        jPanel1.add(regbooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 580, 530));

        listofbooks.setOpaque(false);
        listofbooks.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsearchb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        listofbooks.add(txtsearchb, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 200, 20));

        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/searchhh.png"))); // NOI18N
        btnsearch.setToolTipText("Search books");
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
        listofbooks.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 20, 20));

        tblbooks.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblbooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "     Book ID ", "     Title  ", "     Author ", "     Status "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblbooks.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tblbooks.setSelectionForeground(new java.awt.Color(255, 255, 254));
        jScrollPane1.setViewportView(tblbooks);

        listofbooks.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 540, 440));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/listofwithoutline.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        listofbooks.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 530));

        jPanel1.add(listofbooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 580, 530));

        pendingreq.setOpaque(false);
        pendingreq.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsearchp.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        pendingreq.add(txtsearchp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 200, 20));

        btnsearchreq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/searchhh.png"))); // NOI18N
        btnsearchreq.setToolTipText("Search request");
        btnsearchreq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsearchreqMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsearchreqMouseExited(evt);
            }
        });
        btnsearchreq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchreqActionPerformed(evt);
            }
        });
        pendingreq.add(btnsearchreq, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 20, 20));

        btndisapprove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/disapprove.png"))); // NOI18N
        btndisapprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndisapproveActionPerformed(evt);
            }
        });
        pendingreq.add(btndisapprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 92, 32));

        btnapprove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/appove.png"))); // NOI18N
        btnapprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapproveActionPerformed(evt);
            }
        });
        pendingreq.add(btnapprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 92, 32));

        tblreq.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblreq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction No.", "    Book ID", "   Book Title", "    Borrower"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblreq.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tblreq.setSelectionForeground(new java.awt.Color(255, 255, 254));
        jScrollPane3.setViewportView(tblreq);

        pendingreq.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 540, 370));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/request.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        pendingreq.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(pendingreq, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 580, 530));

        trans.setOpaque(false);
        trans.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsearchtrans.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        trans.add(txtsearchtrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 190, 20));

        btnsearcht.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/searchhh.png"))); // NOI18N
        btnsearcht.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsearchtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsearchtMouseExited(evt);
            }
        });
        btnsearcht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchtActionPerformed(evt);
            }
        });
        trans.add(btnsearcht, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 20, 20));

        tbltrans.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbltrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction No.", "    Book ID", "    Book Title", "   Borrower", "    Date Borrowed", "      Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbltrans.setSelectionBackground(new java.awt.Color(16, 119, 124));
        tbltrans.setSelectionForeground(new java.awt.Color(255, 255, 254));
        jScrollPane4.setViewportView(tbltrans);

        trans.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 540, 370));

        btnreturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/return.png"))); // NOI18N
        btnreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreturnActionPerformed(evt);
            }
        });
        trans.add(btnreturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 92, 32));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/tr.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        trans.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 530));

        jPanel1.add(trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 580, 530));

        listofusers.setOpaque(false);
        listofusers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsearchu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        listofusers.add(txtsearchu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 200, 20));

        btnseachu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/searchhh.png"))); // NOI18N
        btnseachu.setToolTipText("Search user");
        btnseachu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnseachuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnseachuMouseExited(evt);
            }
        });
        btnseachu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseachuActionPerformed(evt);
            }
        });
        listofusers.add(btnseachu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 20, 20));

        btnupdateu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/update.png"))); // NOI18N
        btnupdateu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateuActionPerformed(evt);
            }
        });
        listofusers.add(btnupdateu, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 92, 32));

        btnreg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/registeru.png"))); // NOI18N
        btnreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregActionPerformed(evt);
            }
        });
        listofusers.add(btnreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 92, 32));

        tblusers.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblusers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "    User ID", "    Name", "    User Type", "    Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblusers.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tblusers.setSelectionForeground(new java.awt.Color(255, 255, 254));
        jScrollPane2.setViewportView(tblusers);

        listofusers.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 540, 370));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/listuser.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        listofusers.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 530));

        jPanel1.add(listofusers, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 580, 530));

        btnlogout.setBackground(new java.awt.Color(255, 255, 255));
        btnlogout.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/logouts copy.png"))); // NOI18N
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
        jPanel1.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 480, 124, 104));

        btnborrowed.setBackground(new java.awt.Color(255, 255, 255));
        btnborrowed.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnborrowed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/transhis.png"))); // NOI18N
        btnborrowed.setBorder(null);
        btnborrowed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnborrowedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnborrowedMouseExited(evt);
            }
        });
        btnborrowed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrowedActionPerformed(evt);
            }
        });
        jPanel1.add(btnborrowed, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 124, 104));

        btnlistofbooks.setBackground(new java.awt.Color(255, 255, 255));
        btnlistofbooks.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnlistofbooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/lists copy.png"))); // NOI18N
        btnlistofbooks.setBorder(null);
        btnlistofbooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlistofbooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlistofbooksMouseExited(evt);
            }
        });
        btnlistofbooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlistofbooksActionPerformed(evt);
            }
        });
        jPanel1.add(btnlistofbooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 124, 104));

        btnpending.setBackground(new java.awt.Color(255, 255, 255));
        btnpending.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnpending.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/req.png"))); // NOI18N
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
        jPanel1.add(btnpending, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 370, 124, 104));

        btnlist.setBackground(new java.awt.Color(255, 255, 255));
        btnlist.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnlist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/listu.png"))); // NOI18N
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
        jPanel1.add(btnlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 124, 104));

        btnregbook.setBackground(new java.awt.Color(255, 255, 255));
        btnregbook.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        btnregbook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/registerb.png"))); // NOI18N
        btnregbook.setBorder(null);
        btnregbook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnregbookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnregbookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnregbookMouseExited(evt);
            }
        });
        btnregbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregbookActionPerformed(evt);
            }
        });
        jPanel1.add(btnregbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 124, 104));

        lbladminusername.setBackground(new java.awt.Color(124, 152, 133));
        lbladminusername.setFont(new java.awt.Font("Ink Free", 1, 18)); // NOI18N
        lbladminusername.setForeground(new java.awt.Color(255, 255, 255));
        lbladminusername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbladminusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 200, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LMS Icon/admin.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnregbookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregbookMouseEntered
        btnregbook.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_btnregbookMouseEntered

    private void btnlistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlistMouseEntered
        btnlist.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_btnlistMouseEntered

    private void btnpendingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpendingMouseExited
        btnpending.setBackground(java.awt.Color.white);
        showSelectedButton();
    }//GEN-LAST:event_btnpendingMouseExited

    private void btnborrowedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnborrowedMouseEntered
        btnborrowed.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_btnborrowedMouseEntered

    private void btnregbookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregbookMouseExited
        btnregbook.setBackground(java.awt.Color.white);
        showSelectedButton();
    }//GEN-LAST:event_btnregbookMouseExited

    private void btnlistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlistMouseExited
        btnlist.setBackground(java.awt.Color.white);
        showSelectedButton();
    }//GEN-LAST:event_btnlistMouseExited

    private void btnpendingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpendingMouseEntered
        btnpending.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_btnpendingMouseEntered

    private void btnborrowedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnborrowedMouseExited
        btnborrowed.setBackground(java.awt.Color.white);
        showSelectedButton();
    }//GEN-LAST:event_btnborrowedMouseExited

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int logout = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.OK_CANCEL_OPTION);

        if (logout == 0) {
            new Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

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

    private void btnlistofbooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlistofbooksMouseEntered
        btnlistofbooks.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_btnlistofbooksMouseEntered

    private void btnlistofbooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlistofbooksMouseExited
        btnlistofbooks.setBackground(java.awt.Color.white);
        showSelectedButton();
    }//GEN-LAST:event_btnlistofbooksMouseExited

    private void btnregbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregbookActionPerformed
        hidePanels();
        regbooks.setVisible(true);
        showSelectedButton();
    }//GEN-LAST:event_btnregbookActionPerformed

    private void btnlistofbooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistofbooksActionPerformed
        hidePanels();
        listofbooks.setVisible(true);
        showSelectedButton();
    }//GEN-LAST:event_btnlistofbooksActionPerformed

    private void btnlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistActionPerformed
        hidePanels();
        listofusers.setVisible(true);
        showSelectedButton();
    }//GEN-LAST:event_btnlistActionPerformed

    private void btnpendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpendingActionPerformed
        hidePanels();
        pendingreq.setVisible(true);
        showSelectedButton();
    }//GEN-LAST:event_btnpendingActionPerformed

    private void btnborrowedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrowedActionPerformed
        hidePanels();
        trans.setVisible(true);
        showSelectedButton();
    }//GEN-LAST:event_btnborrowedActionPerformed

    private void btnapproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapproveActionPerformed
        int row = tblreq.getSelectedRow();
        String date = LocalDate.now().toString();
        date = date.replaceAll("-", "/");

        String sql = "UPDATE tbltransact t INNER JOIN tblbooks b on t.bookId = b.bookId"
                + " SET t.status = 'Borrowed', t.dateborrowed = '" + date + "', b.status = 'Borrowed',"
                + " t.librarian = '" + lbladminusername.getText() + "'"
                + " WHERE transactId = " + tblreq.getValueAt(row, 0);

        try {
            Connection connect = DbConnection.getConnection();
            PreparedStatement s = connect.prepareStatement(sql);
            s.execute();

            JOptionPane.showMessageDialog(null, "Successful");
            showBooks();
            showTransactions();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnapproveActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        String id = txtbookid.getText();
        String title = txttitle.getText();
        String author = txtauthor.getText();
        String publisher = txtpublisher.getText();
        String datePublished = ((JTextField) jDatepublished.getDateEditor().getUiComponent()).getText();

        if (id.isEmpty() || title.isEmpty() || author.isEmpty() || publisher.isEmpty() || datePublished.isEmpty()) {
            JOptionPane.showMessageDialog(null, "please complete all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO tblbooks(bookId, booktitle, bookauthor, publisher, pubdate)"
                + " VALUES(?,?,?,?,?)";

        try {
            Connection connect = DbConnection.getConnection();

            Statement stm = connect.createStatement();
            ResultSet rs = stm.executeQuery("select * from tblbooks where bookid = " + id + " OR booktitle = '" + title + "'");

            if (rs.next()) {
                if (rs.getString("bookId").equals(id)) {
                    JOptionPane.showMessageDialog(null, "Invalid book id", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (rs.getString("booktitle").equals(title)) {
                    JOptionPane.showMessageDialog(null, "book already registered", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            PreparedStatement s = connect.prepareStatement(sql);
            s.setString(1, id);
            s.setString(2, title);
            s.setString(3, author);
            s.setString(4, publisher);
            s.setString(5, datePublished);
            s.executeUpdate();

            JOptionPane.showMessageDialog(null, "Book Successfuly Registered");
            showBooks();
        } catch (Exception e) {
            e.printStackTrace();
        }

        txtbookid.setText("");
        txttitle.setText("");
        txtauthor.setText("");
        txtpublisher.setText("");
        ((JTextField) jDatepublished.getDateEditor().getUiComponent()).setText("");
    }//GEN-LAST:event_btnaddActionPerformed

    private void btndisapproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndisapproveActionPerformed
        int row = tblreq.getSelectedRow();
        int id = Integer.parseInt(tblreq.getValueAt(row, 0).toString());
        String sql = "UPDATE tbltransact SET Status = 'Disapproved', librarian = '" + lbladminusername.getText()
                + "' WHERE transactId = " + id;

        try {
            Connection connect = DbConnection.getConnection();
            PreparedStatement s = connect.prepareStatement(sql);
            s.execute();

            JOptionPane.showMessageDialog(null, "Request disapproved.");

            showTransactions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btndisapproveActionPerformed

    private void btnreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreturnActionPerformed
        int row = tbltrans.getSelectedRow();
        String status = tbltrans.getValueAt(row, 5).toString();
        int id = Integer.parseInt(tbltrans.getValueAt(row, 0).toString());
        String date = LocalDate.now().toString();
        date = date.replaceAll("-", "/");

        String sql = "UPDATE tbltransact t JOIN tblbooks b on t.bookId = b.bookId"
                + " SET t.status = 'Returned', t.datereturned = '" + date + "', b.status = 'Available'"
                + " WHERE transactId = " + id;
        try {
            if (status.equals("Borrowed")) {
                Connection connect = DbConnection.getConnection();
                PreparedStatement s = connect.prepareStatement(sql);
                s.execute();

                JOptionPane.showMessageDialog(null, "Book has been returned.");
                showBooks();
                showTransactions();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnreturnActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtbookid.setText("");
        txttitle.setText("");
        txtpublisher.setText("");
        txtauthor.setText("");
        jDatepublished.setCalendar(null);
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnsearchreqMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchreqMouseEntered
        btnsearchreq.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_btnsearchreqMouseEntered

    private void btnsearchreqMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchreqMouseExited
        btnsearchreq.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_btnsearchreqMouseExited

    private void btnsearchtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchtMouseEntered
        btnsearcht.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_btnsearchtMouseEntered

    private void btnsearchtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchtMouseExited
        btnsearcht.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_btnsearchtMouseExited

    private void btnseachuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnseachuMouseEntered
        btnseachu.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_btnseachuMouseEntered

    private void btnseachuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnseachuMouseExited
        btnseachu.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_btnseachuMouseExited

    private void btnsearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseEntered
        btnsearch.setBackground(java.awt.Color.blue);
    }//GEN-LAST:event_btnsearchMouseEntered

    private void btnsearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseExited
        btnsearch.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_btnsearchMouseExited

    private void btnregbookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregbookMouseClicked

    }//GEN-LAST:event_btnregbookMouseClicked

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        String regex = txtsearchb.getText();
        filterTableList(regex);
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnsearchtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchtActionPerformed
        String regex = txtsearchtrans.getText();
        filterTableTransaction(regex);
    }//GEN-LAST:event_btnsearchtActionPerformed

    private void btnseachuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseachuActionPerformed
        String regex = txtsearchu.getText();
        filterTableUser(regex);
    }//GEN-LAST:event_btnseachuActionPerformed

    private void btnsearchreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchreqActionPerformed
        String regex = txtsearchp.getText();
        filterTableBorrow(regex);
    }//GEN-LAST:event_btnsearchreqActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        String id = txtbookid.getText();
        String title = txttitle.getText();
        String author = txtauthor.getText();
        String publisher = txtpublisher.getText();
        String datePublished = ((JTextField) jDatepublished.getDateEditor().getUiComponent()).getText();

        if (id.isEmpty() || title.isEmpty() || author.isEmpty() || publisher.isEmpty() || datePublished.isEmpty()) {
            JOptionPane.showMessageDialog(null, "please complete all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "UPDATE tblbooks SET bookTitle = ?,  bookauthor = ?, publisher = ?, pubdate = ?"
                + "WHERE bookId = ?";

        try {
            Connection connect = DbConnection.getConnection();

            Statement stm = connect.createStatement();
            ResultSet rs = stm.executeQuery("Select * from tblbooks where bookId = " + id);

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "bookid not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            PreparedStatement s = connect.prepareStatement(sql);
            s.setString(1, title);
            s.setString(2, author);
            s.setString(3, publisher);
            s.setString(4, datePublished);
            s.setString(5, id);
            s.executeUpdate();

            JOptionPane.showMessageDialog(null, "Book Successfuly Updated");
            showBooks();
        } catch (Exception e) {
            e.printStackTrace();
        }

        txtbookid.setText("");
        txttitle.setText("");
        txtauthor.setText("");
        txtpublisher.setText("");
        ((JTextField) jDatepublished.getDateEditor().getUiComponent()).setText("");
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregActionPerformed
        Regform update = new Regform(0);
        update.setVisible(true);
        update.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                showUsers();
            }
        });
    }//GEN-LAST:event_btnregActionPerformed

    private void btnupdateuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateuActionPerformed
        int rows = tblusers.getSelectedRowCount();

        if (rows != 1) {
            JOptionPane.showMessageDialog(null, "Please Select a single row", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int row = tblusers.getSelectedRow();

        int id = Integer.parseInt(tblusers.getValueAt(row, 0).toString());

        Regform update = new Regform(id);
        update.setVisible(true);
        update.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                showUsers();
            }
        });
    }//GEN-LAST:event_btnupdateuActionPerformed

    private void txtbookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookidActionPerformed
        String id = txtbookid.getText();

        try {
            Connection connect = DbConnection.getConnection();
            Statement s = connect.createStatement();
            ResultSet rs = s.executeQuery("Select * from tblbooks where bookId = " + id);

            if (rs.next()) {
                txttitle.setText(rs.getString("booktitle"));
                txtauthor.setText(rs.getString("bookauthor"));
                txtpublisher.setText(rs.getString("publisher"));
                ((JTextField) jDatepublished.getDateEditor().getUiComponent()).setText(rs.getString("pubdate"));
            } else {
                JOptionPane.showMessageDialog(null, "Bookid not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtbookidActionPerformed

    private void filterTableBorrow(String regex) {
        String sql = "select t.transactId, t.bookId, b.booktitle, u.firstname, u.lastname "
                + "from tbltransact t INNER JOIN tblbooks b ON t.bookId = b.bookId "
                + "INNER JOIN tablelms u ON t.userId = u.userId WHERE (t.status = 'Requested') AND"
                + " (t.transactId LIKE '%" + regex + "%' OR t.bookId LIKE '%" + regex + "%' OR t.booktitle LIKE '%" + regex + "%'"
                + " OR CONCAT(u.firstname, ' ', u.lastname) LIKE '%" + regex + "%')";

        DefaultTableModel model = (DefaultTableModel) tblreq.getModel();
        model.setRowCount(0);
        try {
            Connection connect = DbConnection.getConnection();
            Statement s = connect.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String transid = rs.getString("transactId");
                String bookid = rs.getString("bookId");
                String title = rs.getString("bookTitle");
                String borrower = rs.getString("firstname") + " " + rs.getString("lastname");

                String row[] = {transid, bookid, title, borrower};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void filterTableTransaction(String regex) {
        String sql = "select t.transactId, t.bookId, b.booktitle, t.dateborrowed, t.status, u.firstname, u.lastname"
                + " from tbltransact t INNER JOIN tblbooks b ON t.bookId = b.bookId"
                + " INNER JOIN tablelms u ON t.userId = u.userId WHERE (t.status NOT IN('Removed', 'Requested')) AND"
                + " (t.transactId LIKE '%" + regex + "%' OR t.bookId LIKE '%" + regex + "%' OR b.booktitle LIKE '%" + regex + "%'"
                + " OR t.Dateborrowed LIKE '%" + regex + "%' OR t.status LIKE '%" + regex + "%'"
                + " OR CONCAT(u.firstname, ' ', u.lastname) LIKE '%" + regex + "%')";

        DefaultTableModel model = (DefaultTableModel) tbltrans.getModel();
        model.setRowCount(0);
        try {
            Connection connect = DbConnection.getConnection();
            Statement s = connect.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String transid = rs.getString("transactId");
                String bookid = rs.getString("bookId");
                String title = rs.getString("bookTitle");
                String borrower = rs.getString("firstname") + " " + rs.getString("lastname");
                String dateBorrowed = rs.getString("Dateborrowed");
                String status = rs.getString("status");

                String row[] = {transid, bookid, title, borrower, dateBorrowed, status};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void filterTableList(String regex) {
        String sql = "SELECT * from tblbooks WHERE"
                + " booktitle LIKE '%" + regex + "%' OR bookauthor LIKE '%" + regex + "%' OR"
                + " publisher LIKE '%" + regex + "%' OR pubdate LIKE '%" + regex + "%' OR status LIKE '%" + regex + "%'";

        DefaultTableModel model = (DefaultTableModel) tblbooks.getModel();
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

    private void filterTableUser(String regex) {
        String sql = "SELECT * from tablelms WHERE"
                + " userID LIKE '%" + regex + "%' OR firstname LIKE '%" + regex + "%' OR"
                + " lastname LIKE '%" + regex + "%' OR usertype LIKE '%" + regex + "%' OR status LIKE '%" + regex + "%'";

        DefaultTableModel model = (DefaultTableModel) tblusers.getModel();
        model.setRowCount(0);
        try {
            Connection connect = DbConnection.getConnection();
            Statement s = connect.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("userID");
                String name = rs.getString("firstname") + " " + rs.getString("lastname");
                String usertype = rs.getString("usertype");
                String status = rs.getString("status");

                String row[] = {id, name, usertype, status};
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnapprove;
    private javax.swing.JButton btnborrowed;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndisapprove;
    private javax.swing.JButton btnlist;
    private javax.swing.JButton btnlistofbooks;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnpending;
    private javax.swing.JButton btnreg;
    private javax.swing.JButton btnregbook;
    private javax.swing.JButton btnreturn;
    private javax.swing.JButton btnseachu;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnsearchreq;
    private javax.swing.JButton btnsearcht;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnupdateu;
    private com.toedter.calendar.JDateChooser jDatepublished;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbladminusername;
    private javax.swing.JPanel listofbooks;
    private javax.swing.JPanel listofusers;
    private javax.swing.JPanel pendingreq;
    private javax.swing.JPanel regbooks;
    private javax.swing.JTable tblbooks;
    private javax.swing.JTable tblreq;
    private javax.swing.JTable tbltrans;
    private javax.swing.JTable tblusers;
    private javax.swing.JPanel trans;
    private javax.swing.JTextField txtauthor;
    private javax.swing.JTextField txtbookid;
    private javax.swing.JTextField txtpublisher;
    private javax.swing.JTextField txtsearchb;
    private javax.swing.JTextField txtsearchp;
    private javax.swing.JTextField txtsearchtrans;
    private javax.swing.JTextField txtsearchu;
    private javax.swing.JTextField txttitle;
    // End of variables declaration//GEN-END:variables
}
