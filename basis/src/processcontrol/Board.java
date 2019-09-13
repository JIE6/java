package processcontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 练习
 * 通过数组画一个简单的棋盘并能实现下棋
 * @author JIE
 */
public class Board {

    public static void main(String[] args) throws IOException {
        // 定义棋盘的大小
        int boardSize = 15;
        // 定义一个二维数组来充当棋盘, 初始化棋盘数组
        String[][] board = new String[boardSize][boardSize];
        // 把每个元素赋为"+" ，用于在控制台画出棋盘
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], "+");
        }

        // 在控制台输出棋盘的方法
        for (int i = 0; i < boardSize; i++) {
            for (int i1 = 0; i1 < boardSize; i1++) {
                // 打印数组元素后不换行
                System.out.print(board[i][i1]);
            }
            // 每打印完一行数组元素后换行
            System.out.println();
        }
        System.out.println("棋盘初始化完毕， 接下来开始下棋");
        System.out.println("请输入您下棋的坐标，应以x,y 的格式: ") ;
        // 现在一个15 * 15的棋盘就打印好了 接下来用于获取键盘输入的方法
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        String inputStr = null;
        // br.readLine() : 每当在键盘上输入一行内容后按回车键，刚输入的内容将被br 读取到
        while ((inputStr = br.readLine()) != null) {
            // 将用户输入的字符串以逗号(，)作为价隔符.分隔成2 个字符串
            String[] posStrArr = inputStr.split(",");
            // 将2 个字符串转换成用户下棋的坐标
            int xPos = Integer.parseInt(posStrArr[0]);
            int yPos = Integer.parseInt(posStrArr[1]);
            // 把对应的数组元素赋为"O"
            board[yPos - 1] [xPos - 1] = "O";
            /*
             * 电脑随机生成2 个整数，作为电脑下棋的坐标， 赋给board 数组
             * 还涉及
             * 1.坐标的有效性，只能是数字，不能超出棋盘范围
             * 2.下的棋的点，不能重复下棋
             * 3.每次下棋后，需要扫描谁赢了
             */

            for (int i = 0; i < boardSize; i++) {
                for (int i1 = 0; i1 < boardSize; i1++) {
                    // 打印数组元素后不换行
                    System.out.print(board[i][i1]);
                }
                // 每打印完一行数组元素后换行
                System.out.println();
            }
            System.out.println("请输入您下棋的坐标，应以x,y 的格式: ") ;

        }
    }
}
