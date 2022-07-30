package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private int id;

    public App(Scanner sc) {
        this.sc = sc;
        id = 1;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("명령) ");

            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록":
                    System.out.print("명언 : ");
                    System.out.print("작가 : ");

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id++);
                    break;
                case "종료":
                    break outer;
            }
        }
    }
}
