/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qrcodeprogrammingcontest;

import utility.BDUtility;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author KATOLIKO AKO
 */
public class StudentScanQrCodes extends javax.swing.JFrame implements Runnable,  ThreadFactory{

    private WebcamPanel panel = null;
    private Webcam webCam = null;
    private ExecutorService executor = Executors.newSingleThreadExecutor(this);
    private volatile boolean running = true;
    public StudentScanQrCodes() {
        initComponents();
        initWebcam();
    }
    Connection conn = null;
    Statement statement;
    ResultSet rs;
    PreparedStatement ps;
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scanPnl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scanLastNameLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scanPnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scanPnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Scan Your QR Code");

        scanLastNameLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        scanLastNameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(scanPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(scanLastNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scanPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scanLastNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentScanQrCodes().setVisible(true);
            }
        });
    }
    public void loadImageInPosPanel(){
        try {
            byte[] imgData = rs.getBytes("image");
            ImageIcon imgIcon1 = new ImageIcon(imgData);
            Image img = imgIcon1.getImage();
            Image img2 = img.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            ImageIcon imgIcon2 = new ImageIcon(img2);
            
            TryFrameIfWork.pictureLabel.setIcon(imgIcon2);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel scanLastNameLbl;
    private javax.swing.JPanel scanPnl;
    // End of variables declaration//GEN-END:variables

    Map<String,String> resultMap = new HashMap<String, String>();
    @Override
    public void run() {
        do{
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){
            }
            
            try{
                Result result = null;
                BufferedImage image = null;
                if(webCam.isOpen()){
                    if((image = webCam.getImage()) == null){
                        continue;
                    }
                }
                
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap  bitmap = new BinaryBitmap(new HybridBinarizer(source));
                try{
                    result = new MultiFormatReader().decode(bitmap);
                }catch(NotFoundException ex){
                    
                }
                
                if(result != null){
                    String jsonString = result.getText();
                    Gson gson = new Gson();
                    java.lang.reflect.Type type = new TypeToken<Map<String, String>>(){
                        
                    }.getType();
                    
                    resultMap = gson.fromJson(jsonString, type);
//                    String finalPath = BDUtility.getPath("images\\"+resultMap.get("firstname") + ".jpg");
                    String finalPath = BDUtility.getPath(resultMap.get("firstname") + ".jpg");
                    CircularImageFrame(finalPath);
                }
            }
            catch(Exception ex)
            {
               
               JOptionPane.showMessageDialog(null, "Null" + ex.getMessage());
            }
            
        }while(running);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    private void initWebcam() {
        webCam = Webcam.getDefault();
        if(webCam != null){
            Dimension[] resolutions = webCam.getViewSizes();
            Dimension  maxResolution = resolutions[resolutions.length-1];
            
            if(webCam.isOpen()){
                webCam.close();
            }
            webCam.setViewSize(maxResolution);
            webCam.open();
            
            panel =  new WebcamPanel(webCam);
            panel.setPreferredSize(maxResolution);
            panel.setFPSDisplayed(true);
            
            scanPnl.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,500,461));
            executor.execute(this);
            executor.shutdown();
        }
        else{
            JOptionPane.showMessageDialog(null, "Issue with Camera");
        }
    }
    private void stopWebCam(){
         if(webCam != null && webCam.isOpen()){
             webCam.close();
         }
    }
    
    BufferedImage imagee = null;
    private void CircularImageFrame(String imagePath) {
        try
        {
            conn = DataConnection.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM balancetbl WHERE firstname = '" + resultMap.get("firstname") + "';");
            if(!rs.next()){
                showPopUpForCertainDuration("User is not Registered","Invalid QR", JOptionPane.ERROR_MESSAGE);
            }
            
            imagee = null;
            
            File imageFile = new File(imagePath);
            if(imageFile.exists()){
                try{
                    imagee = ImageIO.read(new File(imagePath));
                    imagee = createCircularImage(imagee);
                    ImageIcon icon = new ImageIcon(imagee);
                    //Wala pa Label
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }else{
                BufferedImage imageeee = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = imageeee.createGraphics();
                
                g2d.setColor(Color.BLACK);
                g2d.fillOval(10, 10, 20, 20);
                
                g2d.setFont(new Font("Serif", Font.BOLD, 250));
                g2d.setColor(Color.WHITE);
                g2d.drawString(String.valueOf(resultMap.get("lastname").charAt(2)).toUpperCase(), 20,100);
                g2d.dispose();
            }
            scanLastNameLbl.setText(resultMap.get("id"));
            int yourID = Integer.parseInt(scanLastNameLbl.getText());
            
            ps = conn.prepareStatement("SELECT * FROM balancetbl WHERE id = ?");
            ps.setInt(1, yourID);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                TryFrameIfWork fr = new TryFrameIfWork();
                fr.setVisible(true);
                this.dispose();
                loadImageInPosPanel();
            }
            
            
            
//            if(resultMap.get("id") != null){
//                TryFrameIfWork fram = new TryFrameIfWork();
//                fram.setVisible(true);
//                this.dispose();
//            }
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void showPopUpForCertainDuration(String user_is_not_Registered, String invalid_QR, int ERROR_MESSAGE) {
       
    }

    private BufferedImage createCircularImage(BufferedImage imagee) {
       
        return null;
       
    }
}
