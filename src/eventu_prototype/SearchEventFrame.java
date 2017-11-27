/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */
public class SearchEventFrame extends javax.swing.JFrame {

    /**
     * Creates new form SearchEventFrame
     */
    
    User currentUser;
    
    public SearchEventFrame(User user) {
        
        //currentUser = user;
        initComponents();
        setTitle(currentUser + "'s Individual Menu");
        
        setTitle("Search Events");
        
        buttonGroup1.add(radioName);
        buttonGroup1.add(radioCategory);
        radioName.setSelected(true);
        
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                if(radioName.isSelected()){
                    try {
                        SearchEvent search = new SearchEvent(currentUser, nameField.getText());
                        dispose();
                        
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
                else if(radioCategory.isSelected()){
                    try {
                        SearchEvent search = new SearchEvent(currentUser, category.getSelectedIndex());
                        dispose();
                        
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please select and complete a search option.");
                }
            }
        });
        
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                IndivMenuFrame indivFrame = new IndivMenuFrame(currentUser);
                dispose();
            }
        });
        
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        titleText = new javax.swing.JLabel();
        radioName = new javax.swing.JRadioButton();
        radioCategory = new javax.swing.JRadioButton();
        nameField = new javax.swing.JTextField();
        category = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titleText.setText("Search Events");

        radioName.setText("Search by Name");
        radioName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNameActionPerformed(evt);
            }
        });

        radioCategory.setText("Search by Category");

        category.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Social", "Sports", "Fundraising", "Other" }));

        searchButton.setText("Search");

        cancel.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioName)
                        .addGap(35, 35, 35)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioCategory)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(searchButton)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancel)
                            .addComponent(category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titleText)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titleText)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioName)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radioCategory)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(cancel))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JTextField nameField;
    private javax.swing.JRadioButton radioCategory;
    private javax.swing.JRadioButton radioName;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables
}
