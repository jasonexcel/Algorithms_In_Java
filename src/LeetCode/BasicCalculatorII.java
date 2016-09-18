package LeetCode;

import java.util.Stack;

/**
 * Created by Shaun on 9/10/2016.
 */
public class BasicCalculatorII {

    public static void main(String[] args) {
        BasicCalculatorII ins = new BasicCalculatorII();
        String s = "3* 3";
        System.out.println(s + "=" + ins.calculate(s));
    }
    public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char preSign = '+';
        for(int i=0;i<len;i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                num = num*10+cur-'0';
            }
            if((!Character.isDigit(cur) &&' '!=cur) || i==len-1){
                switch (preSign) {
                    case '-' : stack.push(-num);
                        break;
                    case '+' : stack.push(num);
                        break;
                    case '*' : stack.push(stack.pop()*num);
                        break;
                    case '/' : stack.push(stack.pop()/num);
                        break;
                    default  : stack.push(num);
                        break;
                }
                //record current sign
                preSign = cur;
                //reset num
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }
}
