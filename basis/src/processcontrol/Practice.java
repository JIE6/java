package processcontrol;

import java.util.Arrays;

/**
 * 练习
 * @author JIE
 */
public class Practice {
    public static void main(String[] args) {
        // 使用循环输出九九乘法表。:
        System.out.println("使用循环输出九九乘法表");
        for (int i = 1; i <= 9; i++) {
            for (int i1 = 1; i1 < (i+1); i1++) {
                System.out.print(i + "*" + i1 + "=" + i*i1 + " ");
            }
            System.out.println();
        }

        // 使用循环输出等腰图形， 当时自己想的写法。后发现太low
        System.out.println("使用循环输出等腰图形,第一种写法：");
        // 行
        int row = 15;
        // 数量
        int num = 1;
        // 星星
        String fill = "*";
        // 左边的填充符
        String leftXx = " ";
        // 右边的填充符
        String rightXx = "";
        String[] starArray = new String[row];
        for (int i = 0; i < row; i++) {
            if (i != 0) {
                num+=2;
            }
            for (int i1 = 0; i1 < num; i1++) {
                if (i1 == 0) {
                    starArray[i]=fill;
                }else {
                    starArray[i]+=fill;
                }
            }
        }
        for (int i = 0; i < starArray.length; i++) {
            if (i == 0) {
                num =(num-1)/2;
            }else {
                num =num-1;
            }
            String[] leftFiller = new String[num];
            Arrays.fill(leftFiller, leftXx);
            String leftStr = "";
            for (String leftXxs : leftFiller) {
                leftStr += leftXxs;
            }

            String[] rightFiller = new String[num];
            Arrays.fill(rightFiller, rightXx);
            String rightStr = "";
            for (String rightXxs : rightFiller) {
                rightStr += rightXxs;
            }
            System.out.println(leftStr + starArray[i] + rightStr);
        }
        // 后参考网上
        System.out.println("使用循环输出等腰图形,第二种写法：");
        for (int i = 0; i < row; i++) {
            for (int i1 = 0; i1 < (row - i - 1); i1++) {
                System.out.print(leftXx);
            }
            for (int i1 = 0; i1 < i * 2 + 1; i1++) {
                System.out.print(fill);
            }
            System.out.println();
        }
    }
}
