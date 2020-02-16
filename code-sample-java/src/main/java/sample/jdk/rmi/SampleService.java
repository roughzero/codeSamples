/*
 * Created on 2015年8月22日
 */
package sample.jdk.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SampleService extends Remote {
    public SampleModel getList(String condition) throws RemoteException;
}
