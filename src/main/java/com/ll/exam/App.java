package com.ll.exam;

import java.util.*;

public class App {
    private List<WiseSaying> wsList;
    private Scanner sc;
    private int id;

    public App(Scanner sc) {
        wsList = new LinkedList<>();
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
                    String wiseSaying = sc.nextLine();

                    System.out.print("작가 : ");
                    String author = sc.nextLine();

                    wsList.add(new WiseSaying(id, author, wiseSaying));

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id++);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");

                    for(int i = wsList.size() - 1; i >= 0; i--) {
                        WiseSaying ws = wsList.get(i);
                        System.out.printf("%d / %s / %s\n", ws.getId(), ws.getAuthor(), ws.getWiseSaying());
                    }
                    break;
                case "종료":
                    break outer;
            }
        }
    }
}
