/*
 * Created on 2017年12月28日
 */
package sample.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SampleOfInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress实例
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("HostName: " + address.getHostName()); //获取计算机名
        System.out.println("HostAddress: " + address.getHostAddress()); //获取IP地址
        InetAddress[] inetAddresses = InetAddress.getAllByName(address.getHostName());
        for (InetAddress inetAddress : inetAddresses) {
            System.out.println("HostName: " + inetAddress.getHostName()); //获取计算机名
            System.out.println("HostAddress: " + inetAddress.getHostAddress()); //获取IP地址
        }
    }
}
