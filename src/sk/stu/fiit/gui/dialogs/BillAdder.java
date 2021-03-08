/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.gui.dialogs;

import java.awt.Frame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.math.NumberUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import sk.stu.fiit.entity.Bill;
import sk.stu.fiit.entity.Customer;
import sk.stu.fiit.entity.Item;
import sk.stu.fiit.entity.Product;
import sk.stu.fiit.gui.utils.TableUtil;
import static sk.stu.fiit.gui.utils.TableUtil.assertSingleRowSelected;
import static sk.stu.fiit.gui.utils.TableUtil.deleteRows;

/**
 *
 * @author ixenr
 */
public class BillAdder extends javax.swing.JDialog {

    public BillAdder(Frame parentframe, Bill tempBill, List<Customer> customers, List<Product> products) {
        super(parentframe, "SuperFaktura V2 - Creating Invoice", true);
        this.customers = customers;
        this.bill = tempBill;
        initComponents();
        
        this.customers.stream().map(c -> c.getName() + ", " + c.getAddress() + ", " + c.getZipcode()).forEachOrdered(displayString -> {
            customerCombobox.addItem(displayString);
        });
        
        AutoCompleteDecorator.decorate(customerCombobox);
        
        DefaultTableModel model = (DefaultTableModel) productTableView.getModel();
        
        products.forEach(p -> {
            model.addRow(new Object[]{p, p.getName(), p.getDesc(), p.getPrice()});
        });
    }
    
    private final List<Customer> customers;
    private final Bill bill;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        customerCombobox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        allowNegativeCheckbox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        productTableView = new javax.swing.JTable();
        countField = new javax.swing.JTextField();
        billSubmit = new javax.swing.JButton();
        billCancel = new javax.swing.JButton();
        addItemsButton = new javax.swing.JButton();
        removeItemsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Customer:");

        customerCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerComboboxActionPerformed(evt);
            }
        });

        jLabel2.setText("Date:");

        allowNegativeCheckbox.setText("Allow Negative");
        allowNegativeCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allowNegativeCheckboxActionPerformed(evt);
            }
        });

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "itemObject", "Product Name", "Quantity", "Sum"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(itemTable);
        if (itemTable.getColumnModel().getColumnCount() > 0) {
            itemTable.getColumnModel().getColumn(0).setResizable(false);
        }
        itemTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                removeItemsButton.setEnabled(true);
            }
        });

        itemTable.removeColumn(itemTable.getColumnModel().getColumn(0));

        productTableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "productObject", "Product Name", "Description", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTableView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productTableView.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(productTableView);
        if (productTableView.getColumnModel().getColumnCount() > 0) {
            productTableView.getColumnModel().getColumn(0).setResizable(false);
        }
        productTableView.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                addItemsButton.setEnabled(true);
            }
        });

        productTableView.removeColumn(productTableView.getColumnModel().getColumn(0));

        billSubmit.setText("Submit");
        billSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billSubmitActionPerformed(evt);
            }
        });

        billCancel.setText("Cancel");
        billCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billCancelActionPerformed(evt);
            }
        });

        addItemsButton.setText("Add Items");
        addItemsButton.setEnabled(false);
        addItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemsButtonActionPerformed(evt);
            }
        });

        removeItemsButton.setText("Remove Items");
        removeItemsButton.setEnabled(false);
        removeItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(countField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addItemsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeItemsButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customerCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(allowNegativeCheckbox))
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(billSubmit)
                        .addGap(18, 18, 18)
                        .addComponent(billCancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(allowNegativeCheckbox))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(addItemsButton)
                    .addComponent(removeItemsButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(billSubmit)
                    .addComponent(billCancel))
                .addContainerGap())
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void customerComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerComboboxActionPerformed

    private void allowNegativeCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allowNegativeCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allowNegativeCheckboxActionPerformed

    private void removeItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemsButtonActionPerformed
        deleteRows(itemTable);
        removeItemsButton.setEnabled(false);
    }//GEN-LAST:event_removeItemsButtonActionPerformed

    private void addItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemsButtonActionPerformed
        if(!assertSingleRowSelected(productTableView)){
            JOptionPane.showMessageDialog(this, "This application version only"
                    + " supports adding one product type at a time, please"
                    + " select only one row", "Invalid selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int count = NumberUtils.toInt(countField.getText(), -1);
        
        if(count <= 0){
            JOptionPane.showMessageDialog(this, "Must enter positive non-zero integer",
                    "Invalid Value",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel modelItems = (DefaultTableModel) itemTable.getModel();
        Product tempProduct = (Product) TableUtil.getObjectFromTableSelection(productTableView, 0);
        
        for(int i = 0; i < itemTable.getRowCount(); i++){
            Item tempItem = (Item) TableUtil.getObjectFromTableIndex(itemTable, i, 0);
            
            if(tempProduct == tempItem.getProduct()){
                int currentcount = (Integer) TableUtil.getObjectFromTableIndex(itemTable, i, 2);
                currentcount += count;
                tempItem.setAmount(currentcount);
                modelItems.setValueAt(currentcount, i, 2);
                modelItems.setValueAt(tempItem.getAmount() * tempItem.getProduct().getPrice(), i, 3);
                return;
            }
        }
        
        Item tempItem = new Item();
        tempItem.setAmount(count);
        tempItem.setProduct(tempProduct);
        modelItems.addRow(new Object[]{tempItem, tempProduct.getName(), count, tempProduct.getPrice() * count});
        
    }//GEN-LAST:event_addItemsButtonActionPerformed

    private void billSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billSubmitActionPerformed
        if(datePicker1.getDateStringOrEmptyString().length() <= 0){
            JOptionPane.showMessageDialog(this, "Date must be picked", "Missing Value", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel modelItems = (DefaultTableModel) itemTable.getModel();
        
        if(modelItems.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "Must add at least one product", "Missing Value", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        for(int i = 0; i < modelItems.getRowCount(); i++){
            bill.addItem(new Item((Item) TableUtil.getObjectFromTableIndex(itemTable, i, 0)));
        }
        
        bill.setAllowNegative(allowNegativeCheckbox.isSelected());
        bill.setCustomer(new Customer(customers.get(customerCombobox.getSelectedIndex())));
        bill.setDate(datePicker1.getDate());
        bill.setInitialized(true);
        
        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_billSubmitActionPerformed

    private void billCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billCancelActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_billCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemsButton;
    private javax.swing.JCheckBox allowNegativeCheckbox;
    private javax.swing.JButton billCancel;
    private javax.swing.JButton billSubmit;
    private javax.swing.JTextField countField;
    private javax.swing.JComboBox<String> customerCombobox;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable productTableView;
    private javax.swing.JButton removeItemsButton;
    // End of variables declaration//GEN-END:variables
}