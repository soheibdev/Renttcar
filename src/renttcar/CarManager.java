/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renttcar;

/**
 *
 * @author akram
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarManager extends Remote {
    String autoID() throws RemoteException;
}
