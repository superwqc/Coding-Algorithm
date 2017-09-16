package chubao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> strLib = new ArrayList<String>();
        ArrayList<String> subString = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            strLib.clear();
            subString.clear();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                strLib.add(sc.next());
            }
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                subString.add(sc.next());
            }
            function(strLib, subString);
        }
    }

    private static void function(ArrayList<String> strLib, ArrayList<String> subString) {

        for (int i = 0; i < subString.size(); i++) {
            int result = 0;
            for (int j = 0; j < strLib.size(); j++) {
                if(strLib.get(j).contains(subString.get(i)))
                    result++;
            }
            System.out.println(result);
        }
    }
}