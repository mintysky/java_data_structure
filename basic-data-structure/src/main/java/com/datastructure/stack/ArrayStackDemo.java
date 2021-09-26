package com.datastructure.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show: show stack");
            System.out.println("exit: exit stack");
            System.out.println("push: add node to stack");
            System.out.println("pop: get node from stack");
            System.out.println("pls input your choice");
            key = scanner.next();
            switch (key){
                case "show":
                   stack.list();
                   break;
                case "push":
                    System.out.println("please input a number");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("pop num %d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("app exit ----------------");
    }
}


class ArrayStack {
    private int maxSize; //stack size
    private int[] stack; //Array simulate stack
    private int top = -1;  // stack top , init -1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }
        top++;
        stack[top] =value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty.....");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list(){
        if(isEmpty()){
            System.out.println("stack is empty...2");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]=%d \n", i, stack[i]);
        }
    }
}