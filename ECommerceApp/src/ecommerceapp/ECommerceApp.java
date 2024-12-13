
package ecommerceapp;

import javax.swing.SwingUtilities;
import ui.MainUI;

public class ECommerceApp {

    public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new MainUI().setVisible(true));
    }
    
}
