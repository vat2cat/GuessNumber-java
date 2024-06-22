package homework002;

import java.util.ArrayList;

public class test2 {
    public static void main(String[] a) {
        int n = 0;
        String s = "";
        for (int c = 1; c <= 5; c++) {
            if (c == 1) {
                s = func.Input("你想先猜還是後猜，先猜按0後猜按1");
            } else {
                s = func.Input("請選擇與先前不同的數字");
            }
            n = Integer.parseInt(s);
            if (n == 0) {
                // 人猜電腦
                String ans = func.GuessAnswer();
                String gus = "";
                AB p = new AB();
                int cnt = 1;
                do {
                    do {
                        do {
                            gus = func.Input("(" + cnt + ")輸入四個不同的數字：");
                        } while (gus.length() != 4);
                    } while (!func.CheckDifferent(gus));
                    cnt++;
                    p = func.CountAB2(ans, gus);
                    System.out.println(p.A + "A" + p.B + "B");
                } while (p.A != 4);
                System.out.println("ans：" + ans + " you guess " + (cnt - 1) + " 次");
            } else {
                // 電腦猜人
                ArrayList<String> sol1 = new ArrayList<>();
                ArrayList<String> sol2 = new ArrayList<>();
                String gus = "";
                String z = "";
                int pt = 0;
                int pt2 = 0;
                AB pp;
                int A = 0, B = 0;

                for (int i = 1023; i <= 9876; i++) {
                    z = String.valueOf(i);
                    if (func.CheckDifferent(z)) {
                        sol1.add(z);
                    }
                }
                
                pt = sol1.size();
                
                do {
                    int k = func.RandMN(0, pt - 1);
                    gus = sol1.get(k);
                    System.out.println("my guess... " + gus);
                    A = func.InputNum("？A ");
                    B = func.InputNum("？B ");
                    sol2.clear();
                    pt2 = 0;
                    for (int i = 0; i < pt; i++) {
                        pp = func.CountAB2(gus, sol1.get(i));
                        if (pp.A == A && pp.B == B) {
                            sol2.add(sol1.get(i));
                            pt2++;
                        }
                    }
                    sol1.clear();
                    sol1.addAll(sol2);
                    pt = pt2;
                } while (pt > 1);
                if (pt == 1) {
                    System.out.println("answer is ... " + sol1.get(0));
                } else {
                    System.out.println("you lose");
                }
            }
        }
    }
}
