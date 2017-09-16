package tuya;

import java.util.Scanner;
/**
 * Created by Qi on 2017/9/7.
 */
public class ValidIP {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                String ipTest = sc.nextLine();
                String trimIp = ipTest.replace(" ", "");
                System.out.println(validIPAddress(trimIp));
            }
        }

        public static String validIPAddress(String IP) {
            if (IP.equals("")) return "Not An IP";//false,not validIPAddress
            if (isValidIpv4Address(IP)) return "IPv4";
            if (testIpv6(IP)) return "IPv6";
            return "Not An IP";
        }

        //IPv4检测
        public static boolean isValidIpv4Address(String trimIp) {
            if (trimIp.length() < 7 || trimIp.endsWith(".") || trimIp.startsWith("."))
                return false;
            String[] strings = trimIp.split("\\.");
            if (strings.length != 4)
                return false;
            for (String string : strings) {
                try {
                    if (string.startsWith("0") && string.length() > 1
                            || string.startsWith("-")
                            || Integer.parseInt(string) > 255)
                        return false;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return true;
        }
        //IPv6检测
        public static boolean testIpv6(String testIp) {
            if (testIp.length() < 4)
                return false;
            if (testIp.startsWith(":") && testIp.charAt(1) != ':')
                return false;
            if (testIp.endsWith(":") && testIp.charAt(testIp.length() - 2) != ':')
                return false;
            String[] strings = testIp.split(":");
            if (strings.length > 8 || strings.length < 8 && numberOfString(strings) != 1)
                return false;
            for (String string : strings) {
                if (string.length() > 4)
                    return false;
                for (int i = 0; i < string.length(); i++)
                    if (string.charAt(i) >= '0'
                            && string.charAt(i) <= '9'
                            || string.charAt(i) >= 'a'
                            && string.charAt(i) <= 'f'
                            || string.charAt(i) >= 'A'
                            && string.charAt(i) <= 'F')
                        continue;
                    else
                        return false;
            }
            return true;
        }

        private static int numberOfString(String[] strings) {
            int count = 0;
            for (String string : strings) {
                if ("".endsWith(string))
                    count++;
            }
            return count;
        }
    }

