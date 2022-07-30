package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
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

                    System.out.println("1번 명언이 등록되었습니다.");
                    break;
                case "종료":
                    break outer;
            }
        }
    }
}
