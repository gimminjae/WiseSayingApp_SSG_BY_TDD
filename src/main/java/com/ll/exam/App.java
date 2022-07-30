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

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
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
                case "삭제":
                    int id = rq.getIntParam("id", 0);

                    if(id == 0) {
                        System.out.println("번호를 입력해주세요.");
                    } else {
                        if(findById(id) == null) {
                            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
                        } else {
                            wsList.remove(findById(id));
                            System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                        }
                    }

                    break;
                case "종료":
                    break outer;
            }
        }
    }

    private WiseSaying findById(int id) {
        for(int i = 0; i < wsList.size(); i++) {
            WiseSaying ws = wsList.get(i);
            if(id == ws.getId()) return ws;
        }
        return null;
    }
}
