/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renttcar;

/**
 *
 * @author akram
 */
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HelloServer {
    public HelloServer() {}

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            CarManager manager = new CarManagerImpl();
            Naming.rebind("//localhost:1099/CarManager", manager);
            System.out.println("CarManager bound in registry");
        } catch (Exception e) {
            System.out.println("Error in HelloServer: " + e.getMessage());
            e.printStackTrace();
        }
    }}
