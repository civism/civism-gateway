package com.civism.gateway.core.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/26 11:04
 */
public class IpUtil {

    public static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetworkInterfaces =
                    NetworkInterface.getNetworkInterfaces();

            while (allNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = allNetworkInterfaces.nextElement();
                Enumeration<InetAddress> allInetAddress = networkInterface.getInetAddresses();
                while (allInetAddress.hasMoreElements()) {
                    InetAddress ipAddress = allInetAddress.nextElement();
                    if (ipAddress instanceof Inet4Address) {
                        if (!"127.0.0.1".equals(ipAddress.getHostAddress())) {
                            return ipAddress.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }
}
