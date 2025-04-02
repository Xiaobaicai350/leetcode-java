import java.util.LinkedList;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.next();
        if(s.isEmpty()){
            System.out.println(true);
            return;
        }
        //String s="()[]{}";
        char[] chars=s.toCharArray();
        LinkedList<Character> stark=new LinkedList<Character>();
        for(int i=0;i<chars.length;i++){
            if(chars[i]==')'){
                char c= stark.pop();
                if(c!='('){
                    System.out.println(false);
                    return;
                }
            }else if(chars[i]==']'){
                char c= stark.pop();
                if(c!='['){
                    System.out.println(false);
                    return;
                }
            }else if(chars[i]=='}'){
                char c= stark.pop();
                if(c!='{'){
                    System.out.println(false);
                    return;
                }
            }else {
                stark.push(chars[i]);
            }
        }
        if(stark.isEmpty()){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}