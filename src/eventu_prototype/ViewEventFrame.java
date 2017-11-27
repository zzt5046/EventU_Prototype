/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;

/**
 *
 * @author Zach
 */
public class ViewEventFrame extends javax.swing.JFrame {

    /**
     * Creates new form ViewEventFrame
     */
    
    Event eventObject;
    
    public ViewEventFrame(String selectedEvent) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        EventCtrl ctrl = new EventCtrl();
        eventObject = ctrl.getEvent(selectedEvent);

        initComponents();
        setTitle("Details for event: " + selectedEvent);
        
        setDetails(eventObject);
        
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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

        eventName = new javax.swing.JLabel();
        startTime = new javax.swing.JLabel();
        location = new javax.swing.JLabel();
        endTime = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descArea = new javax.swing.JTextArea();
        nameVal = new javax.swing.JLabel();
        startVal = new javax.swing.JLabel();
        endVal = new javax.swing.JLabel();
        locationVal = new javax.swing.JLabel();
        dateVal = new javax.swing.JLabel();
        categoryVal = new javax.swing.JLabel();
        priceVal = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        eventName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        eventName.setText("Event Name:");

        startTime.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startTime.setText("Start Time:");

        location.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        location.setText("Location:");

        endTime.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        endTime.setText("End Time:");

        date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        date.setText("Date:");

        category.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        category.setText("Category:");

        price.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        price.setText("Price:");

        description.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        description.setText("Description:");

        descArea.setColumns(20);
        descArea.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        descArea.setRows(5);
        descArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(descArea);

        nameVal.setText("jLabel1");

        startVal.setText("jLabel1");

        endVal.setText("jLabel1");

        locationVal.setText("jLabel1");

        dateVal.setText("jLabel1");

        categoryVal.setText("jLabel1");

        priceVal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        priceVal.setForeground(new java.awt.Color(80, 191, 43));
        priceVal.setText("jLabel1");

        closeButton.setText("Close");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(description)
                    .addComponent(price)
                    .addComponent(category)
                    .addComponent(date)
                    .addComponent(eventName)
                    .addComponent(startTime)
                    .addComponent(endTime)
                    .addComponent(location))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameVal)
                            .addComponent(startVal)
                            .addComponent(endVal)
                            .addComponent(locationVal)
                            .addComponent(dateVal)
                            .addComponent(categoryVal)
                            .addComponent(priceVal))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventName)
                    .addComponent(nameVal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startTime)
                    .addComponent(startVal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endTime)
                    .addComponent(endVal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(location)
                    .addComponent(locationVal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date)
                    .addComponent(dateVal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(category)
                    .addComponent(categoryVal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price)
                    .addComponent(priceVal))
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setDetails(Event event){
        
        nameVal.setText(eventObject.getName());
        startVal.setText(eventObject.getTimeStart());
        endVal.setText(eventObject.getTimeEnd());
        locationVal.setText(eventObject.getLocation());
        dateVal.setText(eventObject.getDate());
        categoryVal.setText(eventObject.getCategoryName(eventObject.getCategory()));
        descArea.setText(eventObject.getDescription());
        descArea.setEditable(false);
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        priceVal.setText(formatter.format(eventObject.getPrice()));  
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel category;
    private javax.swing.JLabel categoryVal;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel date;
    private javax.swing.JLabel dateVal;
    private javax.swing.JTextArea descArea;
    private javax.swing.JLabel description;
    private javax.swing.JLabel endTime;
    private javax.swing.JLabel endVal;
    private javax.swing.JLabel eventName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel location;
    private javax.swing.JLabel locationVal;
    private javax.swing.JLabel nameVal;
    private javax.swing.JLabel price;
    private javax.swing.JLabel priceVal;
    private javax.swing.JLabel startTime;
    private javax.swing.JLabel startVal;
    // End of variables declaration//GEN-END:variables
}
