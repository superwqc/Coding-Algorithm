package program.linear;

/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext())
        {
            int n=scanner.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=scanner.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(arr[i]>arr[j])
                    {
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
            int cnt=1;
            int tempArr[]=new int[n];
            tempArr[0]=arr[0];
            for(int i=1;i<n;i++)
            {
                if(arr[i]!=arr[i-1])
                {
                    tempArr[cnt++]=arr[i];
                }
            }
            System.out.println(cnt);
            for(int i=0;i<cnt;i++)
            {
                System.out.print(tempArr[i]+" ");
            }
            System.out.println();
        }
    }

}*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();
        int arr[]=new int[n];
        int i;
        for(i=0;i<n;i++)
        {
            arr[i]=scanner.nextInt();
        }
        for(i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[i]>arr[j])
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        int count=1;
        int temp[]=new int[n];
        temp[0]=arr[0];
        for(i=1;i<n;i++)
        {
            if(arr[i]!=arr[i-1])
            {
                temp[count++]=arr[i];
            }
        }
        System.out.println(count);
        for(i=0;i<count - 1;i++)
        {
            System.out.print(temp[i]+" ");
        }
        System.out.print(temp[i]);
    }

}
