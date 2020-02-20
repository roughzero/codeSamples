/*
 * Created on 2015年8月22日
 */
package sample.jdk.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SampleServiceImpl extends UnicastRemoteObject implements SampleService {

    private static long nextId = 0l;

    protected SampleServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public SampleModel getList(String condition) throws RemoteException {
        SampleModel result = new SampleModel();
        result.setId(nextId++);
        result.setName(condition);
        return result;
    }

}
