package ui;
import db.DatabaseConnection;
import javax.swing.JOptionPane;
import models.Product;
import patterns.factory.ProductFactory;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import models.Order;
import models.ProductComponent;
import patterns.builder.OrderBuilder;
import patterns.decorator.WarrantyDecorator;
import patterns.factory.OrderFactory;
import patterns.singleton.*;


public class MainUI extends javax.swing.JFrame {
    
        public MainUI() {
        initComponents();
        loadProducts();
        updateOrderTable();
      // <editor-fold desc="Valuse of ComboBox"> 
    categoryComboBox.addItem("Electronics");
    categoryComboBox.addItem("Clothing");
    categoryComboBox.addItem("HomeAppliances");
    payCompoBox.addItem("Credit Card");
    payCompoBox.addItem("PayPal");
    typeBox.addItem("Standard");
     typeBox.addItem("Express");

    // </editor-fold>
    }
      
    //to get values from database to table in jtabel
    private void loadProducts() { 
    DefaultTableModel model = (DefaultTableModel) tableModel.getModel(); // Assuming tableModel is your JTable

    String sql = "SELECT * FROM products"; // SQL query

    try (Connection conn = DatabaseConnection.getInstance().getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            // Add a row for each product
            model.addRow(new Object[]{
                rs.getInt(1),          // ID
                rs.getString(2),     // Name
                rs.getString(3),  // Category
                rs.getDouble(4)      // Price
            });
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Print any SQL exceptions
    }
}
    private void updateCartTable() {
    
    
  DefaultTableModel model = (DefaultTableModel) CardTable.getModel(); 
   // Clear existing rows
   model.setRowCount(0);
     
    // Fetch products from the cart
    List <ProductComponent> cartProducts = CartManager.getInstance().getCartItems();
    double totalPrice = 0;

 for (ProductComponent product : CartManager.getInstance().getCartItems()) {
        model.addRow(new Object[]{
            product.getId(),
            product.getName(),
            product.getCategory(),
            product.getPrice()
        });
        totalPrice += product.getPrice();
    }

}
        private void updateOrderTable() {
            
 DefaultTableModel model = (DefaultTableModel) OrderTable.getModel(); 

    String sql = "SELECT * FROM Orderss"; // SQL query

    try (Connection conn = DatabaseConnection.getInstance().getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            // Add a row for each product
            model.addRow(new Object[]{
                rs.getInt(1),          // ID
                rs.getString(2),     // Location
                rs.getDouble(3),  // TotalPrice
                rs.getString(4),      // Type
                rs.getString(5)  //name 
            });
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Print any SQL exceptions
    }

}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        categoryComboBox = new javax.swing.JComboBox<>();
        CloneProductButton = new javax.swing.JButton();
        AddProductButton = new javax.swing.JButton();
        ToCardButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableModel = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ConfirmButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        WarrantyButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        locationtxt = new javax.swing.JTextField();
        payCompoBox = new javax.swing.JComboBox<>();
        typeBox = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CardTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        Orderpanel = new javax.swing.JPanel();
        panelorder = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane6.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane6.setForeground(new java.awt.Color(57, 0, 109));
        jTabbedPane6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(204, 51, 255,80));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1100, 760));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/Home.jpg"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1100, 760));

        jTabbedPane6.addTab("Home               ", jPanel3);

        jPanel4.setForeground(new java.awt.Color(214, 107, 221));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harrington", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 18))); // NOI18N
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        jPanel5.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 136, 410, 60));

        priceField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 18))); // NOI18N
        jPanel5.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 410, 60));

        categoryComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 18))); // NOI18N
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });
        jPanel5.add(categoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 360, 420, 69));

        CloneProductButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        CloneProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/clone.jpg"))); // NOI18N
        CloneProductButton.setText("Clone");
        CloneProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloneProductButtonActionPerformed(evt);
            }
        });
        jPanel5.add(CloneProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 140, 60));

        AddProductButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        AddProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/add.jpg"))); // NOI18N
        AddProductButton.setText("Add");
        AddProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductButtonActionPerformed(evt);
            }
        });
        jPanel5.add(AddProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 125, 60));

        ToCardButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        ToCardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/add.jpg"))); // NOI18N
        ToCardButton.setText(" Cart");
        ToCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToCardButtonActionPerformed(evt);
            }
        });
        jPanel5.add(ToCardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 120, 60));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 500, 660));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Products Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harrington", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tableModel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Category", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableModel);
        if (tableModel.getColumnModel().getColumnCount() > 0) {
            tableModel.getColumnModel().getColumn(0).setMinWidth(1);
            tableModel.getColumnModel().getColumn(0).setPreferredWidth(1);
            tableModel.getColumnModel().getColumn(0).setMaxWidth(1);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 520, 660));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/order.jpg"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 780));

        jTabbedPane6.addTab("Products               ", jPanel4);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirm Your Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harrington", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        ConfirmButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        ConfirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/cofirm.jpg"))); // NOI18N
        ConfirmButton.setText("Confirm ");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        ClearButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        ClearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/clear.jpg"))); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        WarrantyButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        WarrantyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/warrnty.jpg"))); // NOI18N
        WarrantyButton.setText("Add Warranty ");
        WarrantyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WarrantyButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Select the item to get Warranty cost 20$");

        nametxt.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        nametxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 18), new java.awt.Color(102, 0, 102))); // NOI18N
        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });

        locationtxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 18))); // NOI18N

        payCompoBox.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        payCompoBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 18), new java.awt.Color(102, 0, 102))); // NOI18N
        payCompoBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        typeBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 18))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(WarrantyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(locationtxt)
                            .addComponent(nametxt)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(payCompoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ConfirmButton)))))
                .addGap(754, 754, 754))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(payCompoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(locationtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WarrantyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 440, 680));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Card Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harrington", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        CardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Category", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CardTable.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(CardTable);
        CardTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (CardTable.getColumnModel().getColumnCount() > 0) {
            CardTable.getColumnModel().getColumn(0).setMinWidth(1);
            CardTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            CardTable.getColumnModel().getColumn(0).setMaxWidth(1);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 620, 680));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/order.jpg"))); // NOI18N
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 770));

        jTabbedPane6.addTab("Cart                     ", jPanel6);

        panelorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Complete Order", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harrington", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrderTable.setFont(new java.awt.Font("Times New Roman", 0, 14));
        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Location", "TotalPrice", "Type", "customers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrderTable.setRowHeight(20);
        OrderTable.setRowMargin(5);
        jScrollPane3.setViewportView(OrderTable);
        if (OrderTable.getColumnModel().getColumnCount() > 0) {
            OrderTable.getColumnModel().getColumn(0).setResizable(false);
            OrderTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            OrderTable.getColumnModel().getColumn(1).setResizable(false);
            OrderTable.getColumnModel().getColumn(2).setResizable(false);
            OrderTable.getColumnModel().getColumn(3).setResizable(false);
            OrderTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel10.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 1010, 350));

        panelorder.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1070, 480));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/order.jpg"))); // NOI18N
        panelorder.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 770));

        javax.swing.GroupLayout OrderpanelLayout = new javax.swing.GroupLayout(Orderpanel);
        Orderpanel.setLayout(OrderpanelLayout);
        OrderpanelLayout.setHorizontalGroup(
            OrderpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        OrderpanelLayout.setVerticalGroup(
            OrderpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelorder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        jTabbedPane6.addTab("Orders                   ", Orderpanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1113, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 13, 1120, 827));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        // TODO add your handling code here:
          DefaultTableModel model = (DefaultTableModel) CardTable.getModel();
           model.setRowCount(0);
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        // TODO add your handling code here:
       String location;
       String type;
       String CstmrName;
       
        try {
        
        // Prompt the user for payment type
        CstmrName=nametxt.getText();
        String paymentType = (String)payCompoBox.getSelectedItem();
        location=locationtxt.getText();
        type=(String)typeBox.getSelectedItem();
    
        if (paymentType == null || paymentType.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Payment type is required!");
            return;
        }
        else if (type.isEmpty()||CstmrName.isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Order type is required!");  
        return;        
        }
        
        OrderBuilder builder =new OrderBuilder();  

        Order order;
      

// Simulate total amount calculation (you should calculate this from the cart data)
        double totalAmount = CartManager.getInstance().calculateCartTotal();
        
        
        
         System.out.println("total amount "+totalAmount);
        if (totalAmount <= 0) {
            JOptionPane.showMessageDialog(null, "Cart is empty!");
            return;
        } 
     
        if (type.isEmpty())
        {
                order= builder.setCstmrName(CstmrName)              
                .setTotalPrice(totalAmount)          
                .setType(type)
                .build();
        }
        else {order= OrderFactory.createOrderProcessor(location, totalAmount, type, CstmrName);}
        
        DatabaseConnection.getInstance().insertOrder(order);           
        // Use the Singleton PaymentGateway to process payment      
        PaymentGateway paymentGateway = PaymentGateway.getInstance();

        boolean paymentSuccess = paymentGateway.processPayment(paymentType, totalAmount);

        
         
        if (paymentSuccess) {
            JOptionPane.showMessageDialog(null, "Payment successful! Total: $" + totalAmount);
            DefaultTableModel model = (DefaultTableModel) CardTable.getModel();
            model.setRowCount(0);
            updateOrderTable();
          
         nametxt.setText("");
        locationtxt.setText("");
            // Clear the cart after successful payment
            CartManager.getInstance().clearCart();
            updateCartTable(); // Refresh the cart table in the GUI
        } else {
            JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred during payment.");
    }
        
    }//GEN-LAST:event_ConfirmButtonActionPerformed

    private void WarrantyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WarrantyButtonActionPerformed
        // TODO add your handling code here:

 int selectedRow = CardTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a product to add extended warranty.");
        return;
    }

    // Get the selected product from CartManager
    ProductComponent selectedProduct = CartManager.getInstance().getCartItems().get(selectedRow);

    // Wrap the product with the WarrantyDecorator
    ProductComponent warrantyProduct = new WarrantyDecorator(selectedProduct);

    // Update the product in CartManager
    CartManager.getInstance().updateProduct(selectedRow, warrantyProduct);

    // Update the cart table to reflect the changes
    updateCartTable();

    JOptionPane.showMessageDialog(null, "Extended Warranty added to " + selectedProduct.getName());
          
    }//GEN-LAST:event_WarrantyButtonActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private void ToCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToCardButtonActionPerformed
        // TODO add your handling code here:
        try {
            // الحصول على الصف المحدد من الجدول
            int selectedRow = tableModel.getSelectedRow(); // Replace with your actual table name

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a product to clone.");
                return;
            }

            int productId = (int) tableModel.getValueAt(selectedRow, 0);
            String name = (String) tableModel.getValueAt(selectedRow, 1);
            String category = (String) tableModel.getValueAt(selectedRow, 2);
            double price = (double) tableModel.getValueAt(selectedRow, 3);

            Product product = ProductFactory.createProductToCard(productId,name,category,price);

            CartManager.getInstance().addProduct(product);

            JOptionPane.showMessageDialog(null, name + " added to the cart.");
            DefaultTableModel model = (DefaultTableModel) CardTable.getModel();
            model.setRowCount(0);
            updateCartTable();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding product to the cart.");
        }
    }//GEN-LAST:event_ToCardButtonActionPerformed

    private void CloneProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloneProductButtonActionPerformed
        // TODO add your handling code here:
        try {
            // الحصول على الصف المحدد من الجدول
            int selectedRow = tableModel.getSelectedRow(); // Replace with your actual table name

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a product to clone.");
                return;
            }

            // قراءة بيانات المنتج المحدد من الجدول
            String name = (String) tableModel.getValueAt(selectedRow, 1); // Replace with your table name
            String category = (String) tableModel.getValueAt(selectedRow, 2);
            double price = (double) tableModel.getValueAt(selectedRow, 3);

            // إنشاء المنتج الأصلي
            Product originalProduct = ProductFactory.createProduct(name, category, price);

            // استنساخ المنتج باستخدام نمط Prototype
            Product clonedProduct = originalProduct.clone();

            // إضافة المنتج المستنسخ إلى قاعدة البيانات
            DatabaseConnection.getInstance().insertProduct(clonedProduct);
            DatabaseConnection.closeConnection();

            JOptionPane.showMessageDialog(null, "Product cloned successfully!");
            DefaultTableModel model = (DefaultTableModel) tableModel.getModel();
            model.setRowCount(0);
            loadProducts();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error cloning product: " + ex.getMessage());
            ex.printStackTrace();
        }

    }//GEN-LAST:event_CloneProductButtonActionPerformed

    private void AddProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductButtonActionPerformed
        // TODO add your handling code here:
        try {
            // Read data from the fields
            String name = nameField.getText();
            String category = (String)categoryComboBox.getSelectedItem();
            double productPrice = Double.parseDouble(priceField.getText());

            // Validate input
            if (name.isEmpty() || category.isEmpty() || priceField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                return;
            }
            // Create the new product
            Product product = ProductFactory.createProduct(name,category,productPrice);

            // Insert product into the database
            DatabaseConnection.getInstance().insertProduct(product);
            DatabaseConnection.closeConnection();
            // Clear the fields
            nameField.setText("");
            priceField.setText("");

            // Success message
            JOptionPane.showMessageDialog(null, "Product added successfully!");
            DefaultTableModel model = (DefaultTableModel) tableModel.getModel();
            model.setRowCount(0);
            loadProducts();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid price.");
        }

    }//GEN-LAST:event_AddProductButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        
    }//GEN-LAST:event_nameFieldActionPerformed

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }
   // <editor-fold desc="Variables declaration for gui by jframe">      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProductButton;
    private javax.swing.JTable CardTable;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton CloneProductButton;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JTable OrderTable;
    private javax.swing.JPanel Orderpanel;
    private javax.swing.JButton ToCardButton;
    private javax.swing.JButton WarrantyButton;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTextField locationtxt;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nametxt;
    private javax.swing.JPanel panelorder;
    private javax.swing.JComboBox<String> payCompoBox;
    private javax.swing.JTextField priceField;
    private javax.swing.JTable tableModel;
    private javax.swing.JComboBox<String> typeBox;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
 
}
