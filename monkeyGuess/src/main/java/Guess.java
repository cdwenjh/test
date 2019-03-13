import entity.Number;
import interf.impl.MonkeyGuessImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @ClassName : Guess
 * @Description: 猜数
 * @Company: com.yinhai
 * @Author: Mr.Wen
 * @Create: 2019/3/11
 * @Version 1.0
 **/
public class Guess {
    public static void main(String[] args){
        new Guess().test();
    }
	
    public void test() {
        MonkeyGuessImpl monkeyGuess = new MonkeyGuessImpl();
        Number num = new Number();
        Scanner sc = new Scanner(System.in);
        //生成4个随机数
        List list = monkeyGuess.getRandomNum(4, 10);
        //System.out.println(list); 输出4个随机数
        int time;//输入次数
        for (time = 6; time > 0; time--) {
            System.out.println("请输入4个数字(0-9,以空格隔开！)(还有" + time + "次机会)：");
            String str = sc.nextLine();
            int b[] = new int[4];
            String arr[] = str.split(" ");
            if (arr.length != 4 || num.checkNum(arr)) {
                if(time == 1){
                    System.out.println("游戏结束！！！");
                    break;
                }
                System.out.println("输⼊不正确，重新输⼊");
                continue;
            }
			
            for (int i = 0; i < arr.length; i++) {
                b[i] = Integer.parseInt(arr[i]);
            }

            int correct = 0;//位置正确个数
            int wrong = 0;//位置错误个数
            for (int z = 0; z < list.size(); z++) {
                if ((list.get(z).equals(arr[z]))) {
                    correct++;
                    num.setCorrect(correct);
                    continue;
                }
                if (list.indexOf(b[z]) != -1) {
                    wrong++;
                    num.setWrong(wrong);
                }
            }
            if (num.getCorrect() == 4) {
                System.out.println("恭喜，你赢了！");
                break;
            } else {
                //A前⾯的数字代表位置和数字都对的个数，B前⾯的数字代表数字对但是位置不对的个数。
                System.out.println(num.getCorrect() + "A" + num.getWrong() + "B");
                System.out.println("你猜错了");
                if(time == 1){
                    System.out.println("游戏结束！");
                }
            }
        }
    }

}
