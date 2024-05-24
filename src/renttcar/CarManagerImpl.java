/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renttcar;

/**
 *
 * @author akram
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CarManagerImpl extends UnicastRemoteObject implements CarManager {
    public CarManagerImpl() throws RemoteException {
        super();
    }

    @Override
    public String autoID() throws RemoteException {
        String id = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/losrent", "laaraf", "06102004");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select Max(Registrationnum) from carregistation");
            rs.next();
            if (rs.getString("Max(Registrationnum)") == null) {
                id = "C0001";
            } else {
                long rid = Long.parseLong(rs.getString("Max(Registrationnum)").substring(2, rs.getString("Max(Registrationnum)").length()));
                rid++;
                id = "C0" + String.format("%03d", rid);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
