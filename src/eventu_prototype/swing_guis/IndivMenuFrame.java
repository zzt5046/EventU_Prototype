/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Zach
 */
public class IndivMenuFrame extends javax.swing.JFrame {

    /**
     * Creates new form IndivMenuFrame
     */
    
    User currentUser;
    DefaultListModel<String> list;
    JList<String> thingsToDisplay;
    String selected;
    
    public IndivMenuFrame(User user) {
        
        currentUser = user;
        
        initComponents();
        
        
        //button to go back to login because not done
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                LoginScreenFrame login = new LoginScreenFrame();
                dispose();
            }
        });
        
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                SearchEventFrame searchFrame = new SearchEventFrame(currentUser);
                dispose();
            }
        });
        
        setVisible(true);
    }
    
    //same as basic constructor but builds and display list of received events---------------------------------------------------------------------------------
    public IndivMenuFrame(User user, ArrayList<Event> searchResults){
        
        currentUser = user;
        
        initComponents();
        
        try{
        list = new DefaultListModel<>();
        
        for(int i = 0; i < searchResults.size(); i++){
            list.addElement(searchResults.get(i).getName());
        }
        
        thingsToDisplay = new JList<>(list);
        scroll.setViewportView(thingsToDisplay);
        
        //add listener for event selection
        thingsToDisplay.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                viewDetails.setEnabled(true);
                selected = thingsToDisplay.getSelectedValue();
            }
        });
        
        } catch(NullPointerException ex){
            System.out.println("No events.");
        }
        
        //button to go back to login because not done
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                LoginScreenFrame login = new LoginScreenFrame();
                dispose();
            }
        });
        
        //search listener
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                SearchEventFrame searchFrame = new SearchEventFrame(currentUser);
            }
        });
        
        //view details listener
        viewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                try {
                    ViewEventFrame viewEvent = new ViewEventFrame(selected);
                } catch (IOException ex) {
                } catch (ClassNotFoundException ex) {
                }
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

        titleText = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        searchButton = new javax.swing.JButton();
        viewDetails = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleText.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        titleText.setText("Find Events");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        searchButton.setText("New Search");

        viewDetails.setText("View Details");
        viewDetails.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchButton)
                        .addGap(18, 18, 18)
                        .addComponent(viewDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleText)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton logoutButton;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel titleText;
    private javax.swing.JButton viewDetails;
    // End of variables declaration//GEN-END:variables
}