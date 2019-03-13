package entity;

/**
 * @ClassName : Number
 * @Description: 猜数实体列
 * @Company: com.yinhai
 * @Author: Mr.Wen
 * @Create: 2019/3/11
 * @Version 1.0
 **/
public class Number {
    private int correct = 0;//数字正确且位置正确的个数
    private int wrong = 0;//数字正确但位置不正确的个数

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    //验证输入
    public boolean checkNum(String arr[]){
        boolean flag = false;
        int length = arr.length;
        label1:for(int i = 0; i < length; i++){
            //判断输入是否为数字,且范围0~9
            if(!Character.isDigit(arr[i].charAt(0)) || (Integer.parseInt(arr[i]) < 0 || Integer.parseInt(arr[i]) > 9)){
                flag = true;
                break;
            }
            //判断输入是否有重复
            for(int j = i+1; j < length; j++){
                if(arr[i].equals(arr[j])){
                    flag = true;
                    break label1;
                }
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        return "Number{" +
                "correct=" + correct +
                ", wrong=" + wrong +
                '}';
    }
}
