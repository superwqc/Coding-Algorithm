package test;

import java.util.Scanner;
public class Jump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s;
        s = scanner.nextInt();
        int[] m = new int[s];
        int[] n = new int[s];
        for(int i=0;i<s;i++){
            m[i] = scanner.nextInt();
        }
        for(int i=0;i<s;i++){
            for(int j=0;j<i;j++){
                if(m[i]<m[j]) n[i]++;
            }
        }
        for(int i =0;i<n.length;i++){
            System.out.println(n[i]);
        }
    }
}


/*

#include<iostream>
using namespace std;

        int main(void){
        int *p;
        int *state;
        int n;

        cin>>n;
        p = new int[n];
        state = new int[n];
        for(int i = 0; i < n; i++){
        state[i] = 0;
        }

        for(int i = 0; i < n; i++){
        cin>>p[i];
        }

        for(int i = 1; i < n ; i++){
        for(int j = 0; j < i; j++){
        if(p[i] < p[j]){
        state[i]++;
        }
        }
        }

        for(int i = 0; i < n; i++){
        cout<<state[i]<<" ";
        }
        cout<<endl;

        return 0;
        }*/
