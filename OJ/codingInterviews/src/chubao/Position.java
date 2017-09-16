package chubao;

import java.util.ArrayList;
import java.util.Scanner;

public class Position {
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

        }
    }
    public  static  double distance(){




        return 0.0;
    }
}
