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
public class ClubMenuFrame extends javax.swing.JFrame {

    User currentUser;
    ArrayList<Event> events;
    DefaultListModel<String> list;
    JList<String> thingsToDisplay;
    String selected;
    
    /**
     * Creates new form ClubMenu
     * @param user
     */
    public ClubMenuFrame(User user) {
        
        currentUser = user;
        EventCtrl ctrl = new EventCtrl();
        
        initComponents();
        
        try{
            
        events = ctrl.getClubEvents(user);
        list = new DefaultListModel<>();
        
        for(int i = 0; i < events.size(); i++){
            list.addElement(events.get(i).getName());
        }

        thingsToDisplay = new JList<>(list);
        scroll.setViewportView(thingsToDisplay);
        
        } catch(IOException ex) {
            System.out.println("IOException - no events");
            ex.printStackTrace();
        } catch(ClassNotFoundException ex3) {
            System.out.println("ClassNotFoundException");
        }
        
        //button to go back to login because not done
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                LoginScreenFrame login = new LoginScreenFrame();
                dispose();
            }
        });
        
        //add event
        addEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                PostEventFrame postEvent = new PostEventFrame(currentUser);
                dispose();
            }
        });
        
        viewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                try {
                    ViewEventFrame viewEvent = new ViewEventFrame(selected);
                } catch (IOException ex) {
                } catch (ClassNotFoundException ex) {
                }
            }
        });
        
        thingsToDisplay.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                viewDetails.setEnabled(true);
                deleteEvent.setEnabled(true);
                selected = thingsToDisplay.getSelectedValue();
            }
        });
        
        deleteEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                try {
                    ctrl.deleteEvent(currentUser, selected);
                    dispose();
                    ClubMenuFrame refreshFrame = new ClubMenuFrame(currentUser);
                    
                } catch (IOException ex) {
                    System.out.println("IOExcpetion when deleting file.");
                }
            }
        });
        
        setTitle(currentUser.getUsername() + "'s " + "Events");
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

        jLabel1 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        addEvent = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        viewDetails = new javax.swing.JButton();
        deleteEvent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Your Events");

        logout.setText("Logout");

        addEvent.setText("Add Event");

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        viewDetails.setText("View Details");
        viewDetails.setEnabled(false);

        deleteEvent.setText("Delete Event");
        deleteEvent.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addEvent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(viewDetails)
                .addGap(18, 18, 18)
                .addComponent(deleteEvent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEvent;
    private javax.swing.JButton deleteEvent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logout;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JButton viewDetails;
    // End of variables declaration//GEN-END:variables
}