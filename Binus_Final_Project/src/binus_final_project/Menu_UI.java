/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binus_final_project;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Menu_UI extends javax.swing.JFrame {

    /**
     * Creates new form Menu_UI
     */
    
    private void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("binus.png")));
    }
    
    public Menu_UI() {
        initComponents();
        setIcon();
        showTable();
        //getConnection();
    }
    
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_students","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Menu_UI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }    
    String imagePath = null;
    // resizing images
    public ImageIcon resizeImage(String imagePath,byte[] pict){
        ImageIcon myImg = null;
        if (imagePath != null)
        {
            myImg = new ImageIcon(imagePath);
        }
        else
        {
            myImg = new ImageIcon(pict);
        }
        Image img = myImg.getImage();
        Image img2 = img.getScaledInstance(img_frame.getWidth(), img_frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon Image =  new ImageIcon(img2);
        return Image;
    }
    public boolean checkInputs()
    {
        if (id_text.getText()== null 
                || name_text.getText() == null
                || age_text.getText() == null
                || city_text.getText()== null 
                || school_text.getText()== null 
                || gender_text.getText()== null)
        {
            return false;
        }
        else
        {
            try{
                Float.parseFloat(id_text.getText());
                return true;
            }catch(Exception ex){
                return false;
            }
        }
    }
    // to fill the student data inside an Array
    public ArrayList<Student> getStudentList()
    {
        ArrayList<Student> sl = new ArrayList<Student>();
        Connection con = getConnection();
        String query_db = "SELECT * FROM student_list";
        Statement st;
        ResultSet rs; 
        
        try
        {
            st = con.createStatement();
            rs = st.executeQuery(query_db);
            Student stud;
            while (rs.next())
            {
                stud = new Student(rs.getString("ID"),rs.getString("name"),rs.getString("gender"),
                        Integer.parseInt(rs.getString("age")),rs.getString("city"),rs.getString("school"));
                sl.add(stud);
                
            }
           
        } catch (SQLException ex)
        {
            Logger.getLogger(Menu_UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sl; // sl = student list
    }
    // To show the Student inside the Table 
    public void showTable() // show any contents from the sql inside the table
    {
        // arraylist for student
        ArrayList<Student> studentlist = getStudentList();
        // for table model
        DefaultTableModel tablemodel = (DefaultTableModel)student_table.getModel();
        tablemodel.setRowCount(0); // set the row count into 0 so it will not loop again 
        Object[] row = new Object[6];
        for (int i = 0;i<studentlist.size();i++)
        {
            row[0] = studentlist.get(i).getID();
            row[1] = studentlist.get(i).getName();
            row[2] = studentlist.get(i).getGender();
            row[3] = studentlist.get(i).getAge();
            row[4] = studentlist.get(i).getCity();
            row[5] = studentlist.get(i).getSchool();
            tablemodel.addRow(row); // too add rows inside the java table
        }
    }
     public void showOneRowItemInTable(int index) // show(highlight) item based on one row from the table
    {
       id_text.setText(getStudentList().get(index).getID());
       gender_text.setText(getStudentList().get(index).getGender());
       age_text.setText(Integer.toString(getStudentList().get(index).getAge()));
       city_text.setText(getStudentList().get(index).getCity());
       school_text.setText(getStudentList().get(index).getSchool());
       name_text.setText(getStudentList().get(index).getName());
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
        Binus_title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        id_text = new javax.swing.JTextField();
        name_text = new javax.swing.JTextField();
        city_text = new javax.swing.JTextField();
        school_text = new javax.swing.JTextField();
        gender_text = new javax.swing.JTextField();
        img_frame = new javax.swing.JLabel();
        butt_img = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        student_table = new javax.swing.JTable();
        update_data = new javax.swing.JButton();
        delete_data = new javax.swing.JButton();
        insert_data = new javax.swing.JButton();
        age_text = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        laptop_icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        Binus_title.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        Binus_title.setText("Binus International Regiteration Form");

        jLabel2.setFont(new java.awt.Font("Adobe Myungjo Std M", 1, 12)); // NOI18N
        jLabel2.setText("Your Image:");

        jLabel3.setFont(new java.awt.Font("Adobe Myungjo Std M", 1, 12)); // NOI18N
        jLabel3.setText("Enter City :");

        jLabel4.setFont(new java.awt.Font("Adobe Myungjo Std M", 1, 12)); // NOI18N
        jLabel4.setText("Enter Age :");

        jLabel5.setFont(new java.awt.Font("Adobe Myungjo Std M", 1, 12)); // NOI18N
        jLabel5.setText("Enter ID :");

        jLabel6.setFont(new java.awt.Font("Adobe Myungjo Std M", 1, 12)); // NOI18N
        jLabel6.setText("Enter name :");

        jLabel7.setFont(new java.awt.Font("Adobe Myungjo Std M", 1, 12)); // NOI18N
        jLabel7.setText("Enter Gender:");

        id_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_textActionPerformed(evt);
            }
        });

        name_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_textActionPerformed(evt);
            }
        });

        school_text.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        gender_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender_textActionPerformed(evt);
            }
        });

        img_frame.setBackground(new java.awt.Color(153, 153, 153));
        img_frame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img_frame.setOpaque(true);

        butt_img.setText("Choose Image");
        butt_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butt_imgActionPerformed(evt);
            }
        });

        student_table.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        student_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Gender", "Age", "City", "School"
            }
        ));
        student_table.setGridColor(new java.awt.Color(0, 0, 0));
        student_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                student_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(student_table);

        update_data.setText("Update Data");
        update_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_dataActionPerformed(evt);
            }
        });

        delete_data.setText("Delete");
        delete_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_dataActionPerformed(evt);
            }
        });

        insert_data.setText("Confirm");
        insert_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_dataActionPerformed(evt);
            }
        });

        age_text.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        age_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                age_textActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Adobe Myungjo Std M", 1, 12)); // NOI18N
        jLabel8.setText("Enter School :");

        laptop_icon.setBackground(new java.awt.Color(51, 255, 204));
        laptop_icon.setIcon(new javax.swing.ImageIcon("D:\\laptop.png")); // NOI18N
        laptop_icon.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(laptop_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Binus_title, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(insert_data, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(delete_data, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update_data, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gender_text, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(id_text, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(school_text, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(img_frame, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(butt_img, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(age_text, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(city_text, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(58, 58, 58)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Binus_title, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laptop_icon))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gender_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(city_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(school_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(age_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(219, 219, 219))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(img_frame, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butt_img, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delete_data, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(update_data, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(insert_data, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void name_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_textActionPerformed

    private void id_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_textActionPerformed

    private void butt_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butt_imgActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","png");
        
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            img_frame.setIcon(resizeImage(path,null));
            imagePath = path;
            
        }
        else
        {
            System.out.println("No Image File Selected");
        }
    }//GEN-LAST:event_butt_imgActionPerformed

    private void insert_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_dataActionPerformed

        if (checkInputs()&& imagePath != null)
        {
            Connection con = getConnection();
            try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO student_list(ID,Name,Gender,Age,City,School)"
                        + "values(?,?,?,?,?,?);");
                ps.setString(1, id_text.getText());
                ps.setString(2, name_text.getText());
                ps.setString(3, gender_text.getText());
                ps.setString(4, age_text.getText());
                ps.setString(5, city_text.getText());
                ps.setString(6, school_text.getText());
                ps.executeUpdate();
                showTable();
                JOptionPane.showMessageDialog(null, "Student Data has been inserted");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Check your fields please, Thank you");
        }
    }//GEN-LAST:event_insert_dataActionPerformed

    private void delete_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_dataActionPerformed
      
        if (!id_text.getText().equals("")){
            
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE from student_list WHERE ID = ?");
                int id = Integer.parseInt(id_text.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                showTable();
                JOptionPane.showMessageDialog(null, "Student Deleted");
                
            } catch (SQLException ex) {
                Logger.getLogger(Menu_UI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Delete Fail");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Delete Fail , No Primary Key selected");
        }
            
    }//GEN-LAST:event_delete_dataActionPerformed

    private void update_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_dataActionPerformed
        if(checkInputs() && id_text.getText()!= null)
        {
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
            // update without the images
            if (imagePath == null)
            {
                try {
                    UpdateQuery = "UPDATE student_list SET Name = ?,Gender = ?"
                        + ",Age = ?,City = ?,School = ? WHERE ID = ?";
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, name_text.getText());
                    ps.setString(2, gender_text.getText());
                    ps.setString(3, age_text.getText());
                    ps.setString(4, city_text.getText());
                    ps.setString(5, school_text.getText());
                    ps.setString(6, id_text.getText());
                    
                    ps.executeUpdate();
                    showTable();
                    JOptionPane.showMessageDialog(null, "Data successfuly Updated");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Menu_UI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            // this is the update with the images
            else
            {
                try {
                    InputStream img = new FileInputStream(new File(imagePath));
                    UpdateQuery = "UPDATE student_list SET Name = ?,Gender = ?"
                        + ",Age = ?,City = ?,School = ? WHERE ID = ?";
                    ps = con.prepareStatement(UpdateQuery);
                    ps.setString(1, name_text.getText());
                    ps.setString(2, gender_text.getText());
                    ps.setString(3, age_text.getText());
                    ps.setString(4, city_text.getText());
                    ps.setString(5, school_text.getText());
                    ps.setString(6, id_text.getText());
                    
                    ps.executeUpdate();
                    showTable();
                    JOptionPane.showMessageDialog(null, "Successfully Updated");
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }    
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please check your data input");
        }
    }//GEN-LAST:event_update_dataActionPerformed

    private void student_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_tableMouseClicked
       int rowOnClick = student_table.getSelectedRow();
       showOneRowItemInTable(rowOnClick);
    }//GEN-LAST:event_student_tableMouseClicked

    private void age_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_age_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_age_textActionPerformed

    private void gender_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gender_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gender_textActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Binus_title;
    private javax.swing.JTextField age_text;
    private javax.swing.JButton butt_img;
    private javax.swing.JTextField city_text;
    private javax.swing.JButton delete_data;
    private javax.swing.JTextField gender_text;
    private javax.swing.JTextField id_text;
    private javax.swing.JLabel img_frame;
    private javax.swing.JButton insert_data;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel laptop_icon;
    private javax.swing.JTextField name_text;
    private javax.swing.JTextField school_text;
    private javax.swing.JTable student_table;
    private javax.swing.JButton update_data;
    // End of variables declaration//GEN-END:variables

