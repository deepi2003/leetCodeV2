package org.example;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

public class StackExcercises {

    static class MinStack {

        Stack<Integer> stack;

        PriorityQueue<Integer> pqueue = new PriorityQueue<>();

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
           stack.push(val);
           pqueue.add(val);
        }
        public void pop() {
           int temp = stack.pop();
           pqueue.remove(temp);
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return pqueue.peek();
        }
    }


    class MinStackV2 {

        class Node{
            int val;
            int minVal;
            Node next;

            public Node(int val, int minVal, Node next) {

                this.val = val;
                this.minVal = minVal;
                this.next = next;
            }
        }

        Node head;
        public MinStackV2() {

        }

        public void push(int val) {
            if(head == null) {
                head = new Node(val, val, null);
            }
            head = new Node(val, Math.min(val, head.minVal), head);
        }
        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.minVal;
        }
    }


    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a = 0, b = 0;
        for(String token: tokens) {
            switch (token) {
                case "+" -> {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                }
                case "*" -> {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                }
                default -> stack.push(Integer.parseInt(token));
            }
            }
        return stack.pop();
    }

    public int evalRPNV2(String[] tokens) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        int a = 0, b = 0, c = 0;
        int j = 0;
        for(int i = 0 ; i < tokens.length; i++) {
            if (!pattern.matcher(tokens[i]).matches()) {
                a = Integer.parseInt(tokens[i - 2]);
                b = Integer.parseInt(tokens[i - 1]);

                switch (tokens[i]) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a- b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = a / b;
                        break;
                }
                tokens[i] = String.valueOf(c);
            }
        }
        return Integer.parseInt(tokens[tokens.length-1]);
    }


    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        TreeMap<Integer, Integer> t = new TreeMap<>((o1, o2) -> o1-o2);
            int result = 0;
        Queue<Integer> stk1 = new LinkedList<>(a);
        Queue<Integer> stk2 = new LinkedList<>(b);
        int target = maxSum;

        while(!stk1.isEmpty() && !stk2.isEmpty()) {
            int i = stk1.peek();
            int j = stk2.peek();
            target -= (i< j)? stk1.remove(): stk2.remove();
            if(target > 0) {
                result++;
            }else {
                break;
            }

        }
        if(stk1.isEmpty() && target > 0) {
            while( !stk2.isEmpty() ) {
                target -= stk2.remove();
                if(target > 0) {
                    result++;
                }else {
                    break;
                }
            }
        }
        if(stk2.isEmpty() && target > 0) {
            while( !stk1.isEmpty() ) {
                target -= stk1.remove();
                if(target > 0) {
                    result++;
                }else {
                    break;
                }
            }
        }
        return result;
    }

    public static int twoStacks2(int maxSum, List<Integer> a, List<Integer> b) {
        int result = 0;
        int target = maxSum;
        while(target > 0 && !a.isEmpty() && !b.isEmpty()) {
            int i = a.get(0);
            int j = b.get(0);
            target -= (i< j)? a.remove(0): b.remove(0);
            if(target > 0) {
                result++;
            }

        }
        while(target > 0) {
            if(a.isEmpty() && !b.isEmpty()) {
                target -= b.remove(0);
            }
            if(target > 0) {
                result++;
            }
        }

        while(target > 0) {
            if(b.isEmpty() && !a.isEmpty()) {
                target -= a.remove(0);
            }
            if(target > 0) {
                result++;
            }
        }
        return result;
    }

    String oktaQuestion(String s){
        StringBuilder res = new StringBuilder();
        Stack<String> input = new Stack<>();
        //cr2[m]3[op4[s]]    [opssss]
        int repeat = 0;
        for(int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i) == ']')
                continue;
            if(s.charAt(i) == '[') {
                input.push(String.valueOf(s.charAt(i))) ;
            }
            else if(Character.isLetter(s.charAt(i))){
                StringBuilder temp = new StringBuilder();
                while(i >=0 && Character.isLetter(s.charAt(i))){
                    temp.append(s.charAt(i--));
                }
                input.push(temp.toString());
            }
            else if(Character.isDigit(s.charAt(i))) {
                StringBuilder temp = new StringBuilder();
                while(i >=0 && Character.isDigit(s.charAt(i))){
                    temp.append(s.charAt(i--));
                }
                repeat = Integer.parseInt(temp.toString());
                temp = new StringBuilder();
                while(!input.isEmpty() && input.peek().equals("[")) {
                    temp.append(input.pop());
                }
               input.push(temp.toString().repeat(repeat));
            }
        }
        StringBuilder temp = new StringBuilder();
        while(!input.isEmpty()) {
            temp.append(input.pop());
        }
        return temp.toString();
    }


    public boolean isValid(String s) {
        Stack<Character> input = new Stack();
        for(int i =s.length()-1; i >=0; i--) {
            char lastCloseBracket ;
            switch(s.charAt(i)) {
                case ')':
                case ']':
                case '}':
                    input.push(s.charAt(i));
                    break;
                case '{': {
                    if(input.isEmpty())
                        return false;
                    lastCloseBracket = input.pop();
                    if(lastCloseBracket != '}')
                        return false;
                }
                break;
                case '[':
                {
                    if(input.isEmpty())
                        return false;
                    lastCloseBracket = input.pop();
                    if(lastCloseBracket != ']')
                        return false;
                }
                break;
                case '(': {
                    if(input.isEmpty())
                        return false;
                    lastCloseBracket = input.pop();
                    if(lastCloseBracket != ')')
                        return false;
                }
                break;
            }
        }
        return true;
    }
}

class MinStack {
    /*
    all integers?
getMin and pop and top will be called on non empty Stack
 app1 :
    manintain min item

app2 :
Use PriorityQueue internally

    */


    class Node{
        int min;
        int val;
        public Node(int min, int val){
            this.min = min;
            this.val = val;
        }
    }
    Stack<Node> st = new Stack();
    int min = Integer.MAX_VALUE;
    public MinStack() {
    }

    public void push(int val) {
        min = Math.min(min, val);
        st.push(new Node(min, val));
    }

    public void pop() {
        Node t = st.pop();
        if(!st.isEmpty() && min == t.min) {
            min = st.peek().min;
        }
    }

    public int top(){
        return st.peek().val;

    }

    public int getMin() {
        return st.peek().min;
    }
}