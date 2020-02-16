/*
 * Created on 2015年8月22日
 */
package sample.jdk.rmi;

import java.rmi.Naming;

public class SampleClient {
    public static void main(String[] args) {
        try {
            //调用远程对象，注意RMI路径与接口必须与服务器配置一致
            SampleService sampleService = (SampleService) Naming.lookup("rmi://localhost:8080/sampleService");
            SampleModel sampleModel = sampleService.getList("test");
            System.out.println(sampleModel.getId() + ": " + sampleModel.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
