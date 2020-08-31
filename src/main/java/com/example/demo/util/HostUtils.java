package com.example.demo.util;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostUtils {

    public static final String IP;
    public static final String HOSTNAME;
    private static final Logger logger = LoggerFactory.getLogger(HostUtils.class);


    static {

        String ip;
        String hostname;

        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
            hostname = addr.getHostName();
        } catch (UnknownHostException e) {
            logger.error("Can not find out address :" + e.getMessage());
            ip = "UNKNOWN";
            hostname = "UNKNOWN";
        }

        if (ip.equals("127.0.0.0") || ip.equals("::1") || ip.equals("UNKNOWN")) {

            try {
                Process process = Runtime.getRuntime().exec("hostname -i");
                if (process.waitFor() == 0) {

                    ip = new String(IOUtils.toByteArray(process.getInputStream()),"utf-8");
                }
                process = Runtime.getRuntime().exec("hostname");
                if (process.waitFor() == 0) {
                    hostname = new String(IOUtils.toByteArray(process.getInputStream()),"utf-8").trim();
                }
            } catch (Exception e) {

                logger.warn("get hostname failed {}", e.getMessage(), e);
            }
        }
        IP = ip;
        HOSTNAME = hostname;
        logger.info("IP = {}, HOSTNAME = {}", IP, HOSTNAME);
    }

    public static void main(String[] args) {
        System.out.println(HostUtils.IP);
        System.out.println(HostUtils.HOSTNAME);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
