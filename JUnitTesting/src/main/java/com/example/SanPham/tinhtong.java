package com.example.SanPham;

public class tinhtong {
    public int TinhTong(int n){
        int sum=0;
        for ( int i=1;i<=n;i+=2){
            sum +=i;
        }
        return sum;
    }
}
