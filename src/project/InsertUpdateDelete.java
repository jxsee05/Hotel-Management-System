/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author edule
 */
public class InsertUpdateDelete {
    
    public static void setData(String query, String msg) {
        Connection con = null;
        Statement st = null;
        
        try {
            // Establecer la conexión
            con = ConnectionProvider.getCon();
            
            if (con != null) {
                // Crear el statement
                st = con.createStatement();
                
                // Ejecutar la consulta
                st.executeUpdate(query);
                
                // Mostrar el mensaje si no es vacío
                if (!msg.equals("")) {
                    JOptionPane.showMessageDialog(null, msg);
                }
            } else {
                JOptionPane.showMessageDialog(null, "La conexión a la base de datos no fue establecida.");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Cerrar el statement y la conexión en el bloque finally
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
