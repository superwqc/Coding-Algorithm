package didi;


import java.util.Scanner;

public class Didi{

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Integer.parseInt(scanner.nextLine());
        String str=scanner.nextLine();
        String[] arr=str.split(" ");

        int start=0,cnt=0;
        for(int i=0; i<arr.length; i++){
                if(Integer.parseInt(arr[i]) == 0){
                    cnt++;
                    start=i + 1;
                    continue;
                }
                for(int j=start;j<i;j++){
                    int flag=0;
                    for(int k=j; k<=i; k++)
                        flag ^= Integer.parseInt(arr[k]);
                    if(flag == 0){
                        cnt ++;
                        start=i + 1;
                        continue;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

/*
* #include <iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main()
{
	int count;
	while (cin >> count)
	{
		vector<int> arr;
		for (int i = 0; i < count; i++)
		{
			int data;
			cin >> data;
			arr.push_back(data);
		}
		int start = 0;
		int sum=0;

		for (int i = 0; i < count; i++)
		{
			if (arr[i] == 0)
			{
				sum++;
				start = i + 1;
				continue;
			}
			for (int j = start; j < i; j++)
			{
				int flag = 0;
				for (int k = j; k <= i; k++)
				{
					flag ^= arr[k];
				}
				if (flag == 0)
				{
					sum++;
					start = i + 1;
					continue;
				}
			}
		}
		cout << sum << endl;

	}
	return 0;
}
    * */
