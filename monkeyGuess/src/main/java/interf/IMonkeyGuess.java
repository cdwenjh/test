package interf;

import java.util.List;

/**
 * @ClassName : IMonkeyGuess
 * @Description: 猜数游戏接口
 * @Company: com.yinhai
 * @Author: Mr.Wen
 * @Create: 2019/3/11
 * @Version 1.0
 **/
public interface IMonkeyGuess {
    //生成随机数
    List getRandomNum(int m, int n);//m生成个数，n随机范围
}
