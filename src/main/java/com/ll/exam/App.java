package com.ll.exam;

import java.util.*;

public class App {
    private WiseSayingController wsController;
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
        wsController = new WiseSayingController(sc);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("명령) ");

            String cmd = sc.nextLine();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    wsController.create(rq);
                    break;
                case "목록":
                    wsController.readList(rq);
                    break;
                case "삭제":
                    wsController.delete(rq);
                    break;
                case "종료":
                    break outer;
            }
        }
    }
}
