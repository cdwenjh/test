package interf.impl;

import interf.IMonkeyGuess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName : MonkeyGuessImpl
 * @Description: 实现类
 * @Company: com.yinhai
 * @Author: Mr.Wen
 * @Create: 2019/3/11
 * @Version 1.0
 **/
public class MonkeyGuessImpl implements IMonkeyGuess {
    // 生成 [0-m) 个不重复的随机数
    public List getRandomNum(int m, int n) {
        // list 用来保存这些随机数
        List list = new ArrayList();
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < m; i++) {
            do {
                // 如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        return list;
    }
}
