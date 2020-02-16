/*
 * Created on 2015年8月22日
 */
package sample.jdk.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SampleServerMain {
    public static void main(String[] args) {
        try {
            SampleService sampleService = new SampleSeriveImpl();
            //注册通讯端口
            LocateRegistry.createRegistry(8080);
            //注册通讯路径
            Naming.rebind("rmi://localhost:8080/sampleService", sampleService);
            System.out.println("Service Start!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
