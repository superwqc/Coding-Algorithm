package program.linear;



    import java.util.*;


    public class Div
    {
        public static void main(String[] args) {
            Scanner can = new Scanner(System.in);

            try{
                String line = can.nextLine();
                int ln = Integer.parseInt(line.trim());

                String ars = can.nextLine();
                int[] arrs = new int[ln];
                parsetoIntArray(ars,arrs);

                String l1 = can.nextLine();
                int ln1 = Integer.parseInt(l1.trim());

                String ars1 = can.nextLine();
                int[] arrs1 = new int[ln1];
                parsetoIntArray(ars1,arrs1);

                String res = getResult(arrs,arrs1);
                System.out.println(res);
            }finally{
                can.close();
            }
        }


        private static void parsetoIntArray(String ars, int[] arrs) {
            String[] ss = ars.split(" ");

            for (int i = 0; i < ss.length; i++) {
                arrs[i] = Integer.valueOf(ss[i]);
            }
        }


        private static String getResult(int[] arrs, int[] arrs1) {
            int ars[] = getResultArrs(arrs);
            StringBuffer sb = new StringBuffer();
            int j = 0;

            for (int i = 0; i < ars.length; i++) {
                while (arrs1[i] < ars[j]) {
                    j++;
                }
                sb.append(j + " ");

                j = 0;
            }

            return sb.toString();
        }


        private static int[] getResultArrs(int[] arrs) {
            int ars[] = new int[arrs.length];
            ars[0] = arrs[0];
            for (int i = 1; i < ars.length; i++) {
                ars[i] = arrs[i-1] + arrs[i];
            }
            return ars;
        }
    }

