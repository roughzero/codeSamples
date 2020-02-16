/*
 * Created on 2015年8月22日
 */
package sample.jdk.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SampleSeriveImpl extends UnicastRemoteObject implements SampleService {

    protected SampleSeriveImpl() throws RemoteException {
        super();
    }

    @Override
    public SampleModel getList(String condition) throws RemoteException {
        SampleModel result = new SampleModel();
        result.setId(0l);
        result.setName(condition);
        return result;
    }

}
