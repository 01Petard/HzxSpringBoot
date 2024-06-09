package com.hzx.mianshi;

import java.util.Arrays;

public class test3 {

    public static void main(String[] args) {
        double M;
        int N;
        double[] historyPrices;
        int K;


//        Scanner scanner = new Scanner(System.in);
//
//        String input = scanner.nextLine();
        String input = "10000,7,[1.0, 2.0, 1.0,2.0, 2.0, 3.0, 2.0],2";

        String[] params = input.split(",");

        M = Double.parseDouble(params[0]);
        N = Integer.parseInt(params[1]);
        K = Integer.parseInt(params[params.length - 1]);

        String[] param2_parts = params[2].substring(1, params[2].length() - 1).split(",");
        historyPrices = new double[param2_parts.length];
        for (int i = 0; i < param2_parts.length; i++) {
            historyPrices[i] = Double.parseDouble(param2_parts[i]);
        }

        double maxProfit = calculateMaxProfit(M, N, historyPrices, K);
        System.out.println(maxProfit);
    }

    public static double calculateMaxProfit(double M, int N, double[] prices, int K) {

        System.out.println(M);
        System.out.println(N);
        System.out.println(Arrays.toString(prices));
        System.out.println(K);


//        double profit = 0;
//        int shares = 0;
//
//        for (int i = 0; i < N; i++) {
//            if (i == N - 1 || prices[i] >= prices[i + 1]) {
//                // 卖出股票
//                profit += shares * prices[i];
//                shares = 0;
//            } else {
//                // 买入股票
//                int buyShares = (int) Math.min(M / prices[i], K);
//                shares += buyShares;
//                M -= buyShares * prices[i];
//            }
//        }
//
        return 1.0;
    }
}
