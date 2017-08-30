package test;


    import java.util.Scanner;

    public class Swim {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int m, n, a, b, c, d, x, y, z;
            int k = 0;
            int max = 0;
            int i=0,j=0;
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            d = scanner.nextInt();
            x = scanner.nextInt();
            y = scanner.nextInt();
            z = scanner.nextInt();

            for ( i = 0; i * a <= n && i * b <= m; i++) {
                for ( j = 0; j * c <= m; j++) {
                    k = (n - i * a) / d;
                    if (a * i + d * k <= n && b * i + c * j <= m) {
                        max = Math.max(max, i * x + j * y + k * z);
                    }
                }
            }
            System.out.println(max);
        }
    }

