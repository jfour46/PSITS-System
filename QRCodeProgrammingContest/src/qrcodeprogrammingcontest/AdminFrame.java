
package qrcodeprogrammingcontest;
import utility.BDUtility;
import com.google.gson.Gson;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

public class AdminFrame extends javax.swing.JFrame {

    
    public AdminFrame() {
        initComponents();
        showData();
        listQrCodes();
    }
    public static String path;
    public static File fil;
    Connection conn = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void listQrCodes(){
        DefaultTableModel dtm = (DefaultTableModel) listTable.getModel();
        File fileDirectory =   new File(BDUtility.getPath("/qrCodes"));
        File[] files = fileDirectory.listFiles();
        
        if(files != null){
            for(File file: files){
                dtm.addRow(new Object[]{
                    file.getName(),file.length()
                });
            }
        }
    }
    
    public void showData(){
        DefaultTableModel model = (DefaultTableModel) generateTbl.getModel();
        model.setRowCount(0);
        
        try
        {
            conn = DataConnection.getConnection();
            Statement s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM balancetbl");
            
            while(rs.next()){
                Vector vec = new Vector();
                
                vec.add(rs.getString(1));
                vec.add(rs.getString(2));
                vec.add(rs.getString(3));
                vec.add(rs.getString(4));
                vec.add(rs.getString(5));
                
                model.addRow(vec);
                
                
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        addStudentPnl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addFirstnameFld = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addLastnameFld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addBalanceFld = new javax.swing.JTextField();
        addYearSectionFld = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addPhotoLbl = new javax.swing.JLabel();
        addUploadBtn = new javax.swing.JButton();
        addAddBtn = new javax.swing.JButton();
        viewStudent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        generateTbl = new javax.swing.JTable();
        addFirstnameFld1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addLastnameFld1 = new javax.swing.JTextField();
        addYearSectionFld1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        addBalanceFld1 = new javax.swing.JTextField();
        idfld = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        qrLbl = new javax.swing.JLabel();
        saveQRAtBtn = new javax.swing.JButton();
        generateBtn = new javax.swing.JButton();
        saveQrBtn = new javax.swing.JButton();
        viewQrList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Add Student ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Firstname :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Lastname :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Year & Section :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Balance :");

        addPhotoLbl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        addUploadBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addUploadBtn.setText("Upload Photo");
        addUploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUploadBtnActionPerformed(evt);
            }
        });

        addAddBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addAddBtn.setText("Add");
        addAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAddBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addStudentPnlLayout = new javax.swing.GroupLayout(addStudentPnl);
        addStudentPnl.setLayout(addStudentPnlLayout);
        addStudentPnlLayout.setHorizontalGroup(
            addStudentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentPnlLayout.createSequentialGroup()
                .addGroup(addStudentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addStudentPnlLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(addStudentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(addStudentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addStudentPnlLayout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(addFirstnameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(addStudentPnlLayout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(addLastnameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(addStudentPnlLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addBalanceFld, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addStudentPnlLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addYearSectionFld, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                .addComponent(addPhotoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addStudentPnlLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addUploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(addStudentPnlLayout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(addAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addStudentPnlLayout.setVerticalGroup(
            addStudentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentPnlLayout.createSequentialGroup()
                .addGroup(addStudentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addStudentPnlLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(addPhotoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addStudentPnlLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(addStudentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addFirstnameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addStudentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addLastnameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addStudentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addYearSectionFld, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(addStudentPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBalanceFld, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addUploadBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(addAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        jPanel1.add(addStudentPnl, "card2");

        generateTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Firstname", "Lastname", "Year And Section", "Balance"
            }
        ));
        generateTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generateTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(generateTbl);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Firstname :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Lastname :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Year & Section :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Balance :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Id :");

        qrLbl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        saveQRAtBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveQRAtBtn.setText("Save Qr To");
        saveQRAtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveQRAtBtnActionPerformed(evt);
            }
        });

        generateBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        generateBtn.setText("Generate");
        generateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed(evt);
            }
        });

        saveQrBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saveQrBtn.setText("Save QR");
        saveQrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveQrBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewStudentLayout = new javax.swing.GroupLayout(viewStudent);
        viewStudent.setLayout(viewStudentLayout);
        viewStudentLayout.setHorizontalGroup(
            viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewStudentLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewStudentLayout.createSequentialGroup()
                        .addGroup(viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(viewStudentLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idfld, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(viewStudentLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addFirstnameFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addGroup(viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewStudentLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addYearSectionFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(viewStudentLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addBalanceFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewStudentLayout.createSequentialGroup()
                        .addGroup(viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewStudentLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addLastnameFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewStudentLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(generateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGroup(viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveQrBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qrLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(97, 97, 97))
            .addGroup(viewStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveQRAtBtn)
                .addGap(114, 114, 114))
        );
        viewStudentLayout.setVerticalGroup(
            viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewStudentLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idfld, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBalanceFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(addYearSectionFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addFirstnameFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewStudentLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addLastnameFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(generateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewStudentLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(qrLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(viewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveQRAtBtn)
                            .addComponent(saveQrBtn)))))
        );

        jPanel1.add(viewStudent, "card3");

        listTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name Of QR Codes"
            }
        ));
        listTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listTable);

        javax.swing.GroupLayout viewQrListLayout = new javax.swing.GroupLayout(viewQrList);
        viewQrList.setLayout(viewQrListLayout);
        viewQrListLayout.setHorizontalGroup(
            viewQrListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewQrListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        viewQrListLayout.setVerticalGroup(
            viewQrListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewQrListLayout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(viewQrListLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(viewQrList, "card4");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Generate Qr");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("List Of Qr Codes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         jPanel1.removeAll();
         jPanel1.add(addStudentPnl);
         jPanel1.repaint();
         jPanel1.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAddBtnActionPerformed
         String firstname = addFirstnameFld.getText();
         String lastname = addLastnameFld.getText();
         String yearSection = addYearSectionFld.getText();
         int balance = Integer.parseInt(addBalanceFld.getText());
         
         try
         {
             conn = DataConnection.getConnection();
             ps = conn.prepareStatement("INSERT INTO balancetbl (firstname, lastname, yearandsection, balance, image) VALUES(?,?,?,?,?)");
             ps.setString(1, firstname);
             ps.setString(2, lastname);
             ps.setString(3, yearSection);
             ps.setInt(4, balance);
             InputStream inputSt = new FileInputStream(new File(path));
             ps.setBlob(5, inputSt);
             
             int check = ps.executeUpdate();
             
             if(check == 1)
            {
              JOptionPane.showMessageDialog(null,"Successfully add!", "Message", JOptionPane.PLAIN_MESSAGE);  
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Not add!", "Message", JOptionPane.ERROR_MESSAGE);
            }
             
         }
         catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
         }
    }//GEN-LAST:event_addAddBtnActionPerformed

    private void addUploadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUploadBtnActionPerformed
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            fil = fileChooser.getSelectedFile();
            path = fil.getAbsolutePath();
            try 
            {
                BufferedImage bufferedImg = ImageIO.read(new File(path));
                Image img = bufferedImg.getScaledInstance(216, 175, Image.SCALE_SMOOTH);
                ImageIcon imgIcon = new ImageIcon(img);
                addPhotoLbl.setIcon(imgIcon);
            } 
            catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }//GEN-LAST:event_addUploadBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         jPanel1.removeAll();
         jPanel1.add(viewStudent);
         jPanel1.repaint();
         jPanel1.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void generateTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateTblMouseClicked
        DefaultTableModel model = (DefaultTableModel) generateTbl.getModel();
        
        String id = model.getValueAt(generateTbl.getSelectedRow(), 0).toString();
        String firstname = model.getValueAt(generateTbl.getSelectedRow(), 1).toString();
        String lastname = model.getValueAt(generateTbl.getSelectedRow(), 2).toString();
        String yearAndSection = model.getValueAt(generateTbl.getSelectedRow(), 3).toString();
        String balance = model.getValueAt(generateTbl.getSelectedRow(), 4).toString();
        
        idfld.setText(id);
        addFirstnameFld1.setText(firstname);
        addLastnameFld1.setText(lastname);
        addYearSectionFld1.setText(yearAndSection);
        addBalanceFld1.setText(balance);
    }//GEN-LAST:event_generateTblMouseClicked
    ByteArrayOutputStream out = null;
    String firstname;
    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed
         int id = Integer.parseInt(idfld.getText());
           firstname = addFirstnameFld1.getText();
         String lastname = addLastnameFld1.getText();
         String yearSection = addYearSectionFld1.getText();
         int balance = Integer.parseInt(addBalanceFld1.getText());
        
        Map<String, String> data = new HashMap<>();
         data.put("id",Integer.toString(id));
         data.put("firstname", firstname);
         data.put("lastname", lastname);
         data.put("yearandsection", yearSection);
         data.put("balance", Integer.toString(balance));
         
         
//         for(String datas : data.keySet()){
//             System.out.print(datas);
//             Gson gson = new Gson();
//            String jsonData = gson.toJson(data.get(datas));
//            out = QRCode.from(jsonData).withSize(293,210).to(ImageType.PNG).stream();
//            continue;
//         }
            Gson gson = new Gson();
            String jsonData = gson.toJson(data);
            out = QRCode.from(jsonData).withSize(293,210).to(ImageType.PNG).stream();
         
         
         try{
             byte[] imageData = out.toByteArray();
             ImageIcon icon = new ImageIcon(imageData);
             qrLbl.setIcon(icon);
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null, ex.getMessage());
         }
    }//GEN-LAST:event_generateBtnActionPerformed

    private void saveQrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveQrBtnActionPerformed
       try
       {
           if(out == null)
           {
               JOptionPane.showMessageDialog(null, "No Qr Codes!!");
               return;
           }
           
           String defualtDirec = BDUtility.getPath("qrCodes");
           File directory = new File(defualtDirec);
           if(!directory.exists()){
               directory.mkdirs();
           }
           
           File defaultFile = new File(directory, firstname + ".jpg");
           try{
               java.nio.file.Files.write(defaultFile.toPath(), out.toByteArray());
               JOptionPane.showMessageDialog(null,"Successfully save Qr Codes");
           }
           catch(Exception ex)
           {
               JOptionPane.showMessageDialog(null, ex.getMessage());
           }
       }
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, ex.getMessage());
       }
    }//GEN-LAST:event_saveQrBtnActionPerformed

    private void saveQRAtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveQRAtBtnActionPerformed
        try
        {
            if(out == null){
                JOptionPane.showMessageDialog(this, "No Qr Codes!!");
                return;
            }
            
            JFileChooser jfc = new JFileChooser();
            jfc.setDialogTitle("Save QR Code at");
            jfc.setSelectedFile(new File(firstname + ".png"));
            int userSelection = jfc.showSaveDialog(this);
            if(userSelection == JFileChooser.APPROVE_OPTION){
                File filetoSave = jfc.getSelectedFile();
                try
                {
                    java.nio.file.Files.write(filetoSave.toPath(), out.toByteArray() );
                    JOptionPane.showMessageDialog(this, "Qr Codes Saved Successfully!!");
                }
                catch(Exception Ex){
                    JOptionPane.showMessageDialog(this, Ex.getMessage());
                }
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }//GEN-LAST:event_saveQRAtBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanel1.removeAll();
         jPanel1.add(viewQrList);
         jPanel1.repaint();
         jPanel1.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTableMouseClicked
        int index = listTable.getSelectedRow();
        TableModel model = listTable.getModel();
        String name = model.getValueAt(index,0).toString();
        ImageIcon icon = new ImageIcon(BDUtility.getPath("qrCodes" + File.separator + name));
        Image image = icon.getImage().getScaledInstance(300, 280, Image.SCALE_SMOOTH);
        
        ImageIcon resizedIcon = new ImageIcon(image);
        
        jLabel10.setIcon(resizedIcon);
        
    }//GEN-LAST:event_listTableMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAddBtn;
    private javax.swing.JTextField addBalanceFld;
    private javax.swing.JTextField addBalanceFld1;
    private javax.swing.JTextField addFirstnameFld;
    private javax.swing.JTextField addFirstnameFld1;
    private javax.swing.JTextField addLastnameFld;
    private javax.swing.JTextField addLastnameFld1;
    private javax.swing.JLabel addPhotoLbl;
    private javax.swing.JPanel addStudentPnl;
    private javax.swing.JButton addUploadBtn;
    private javax.swing.JTextField addYearSectionFld;
    private javax.swing.JTextField addYearSectionFld1;
    private javax.swing.JButton generateBtn;
    private javax.swing.JTable generateTbl;
    private javax.swing.JTextField idfld;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTable listTable;
    private javax.swing.JLabel qrLbl;
    private javax.swing.JButton saveQRAtBtn;
    private javax.swing.JButton saveQrBtn;
    private javax.swing.JPanel viewQrList;
    private javax.swing.JPanel viewStudent;
    // End of variables declaration//GEN-END:variables
}
