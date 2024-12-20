# E-Commerce System

This is a Java-based desktop application for managing product listings, customers, orders, and payments. The project is built using **Object-Oriented Programming** principles and implements several **Design Patterns** for maintainability and scalability.

## Features

- Add, update, and manage products.
- Manage a shopping cart using a Singleton pattern.
- Process orders using a Factory pattern.
- Clone products using a Prototype pattern.
- Enhance functionality using the Decorator pattern.

---

## Design Patterns Used

1. **Singleton Pattern**:
   - Ensures a single instance of `CartManager` for managing the shopping cart.
   - Used in the `DatabaseConnection` class to manage database connections.
   - Implemented for a `PaymentGateway` to handle consistent payment processing.

2. **Factory Pattern**:
   - Used to create products (`ProductFactory`) and order processing (`OrderFactory`) based on customer choices.

3. **Prototype Pattern**:
   - Enables cloning of products for efficient reuse.

4. **Decorator Pattern**:
   - Adds functionality, such as applying warranties to products, without altering existing classes.

5. **Builder Pattern**:
   - Constructs complex product objects step-by-step.

---

## Technologies Used

- **Java Swing** for the graphical user interface.
- **JDBC** for database connectivity.
- **SQL Server** for the database.
- **Maven** for dependency management.

---

## Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your_username/ecommerce-system.git
   ```

2. **Database Configuration:**
   - Create a database named `ECommerceDB`.
   - Run the SQL scripts in `database_setup.sql` to set up tables (`Products`, `Cart`, `Orders`).
   - Update the `DatabaseConnection` class with your SQL Server credentials.

3. **Run the Application:**
   - Open the project in **NetBeans 8.2**.
   - Build and run the application.

---

## How to Use

### **Product Management**
- Add products by filling in details (Name, Category, Price) and clicking the "Add" button.
- Clone products using the "Clone" button.

### **Cart Management**
- Add products to the cart by selecting a product and pressing "Add to Cart."
- View total price in the cart.

### **Order Processing**
- Choose order type (Standard/Express) during checkout.

---

## Project Structure

```
ECommerceSystem
├── src
│   ├── db
│   │   └── DatabaseConnection.java
│   ├── models
│   │   ├── Product.java
│   │   ├── CartManager.java
│   │   ├── PaymentGateway.java
│   │   ├── ProductFactory.java
│   │   └── OrderFactory.java
│   ├── ui
│   │   └── MainUI.java
│   └── utils
│       └── decorators
│           ├── ProductDecorator.java
│           └── WarrantyDecorator.java
├── database_setup.sql
└── README.md
```

---

## Contributors

1. **Database Manager:** [Name]
2. **Back-End Developer:** [Name]
3. **GUI Developer:** [Name]
4. **Integration Specialist:** [Name]
5. **Documentation Specialist:** [Name]

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Acknowledgments

Special thanks to our university and professors for guidance and support throughout the project.
