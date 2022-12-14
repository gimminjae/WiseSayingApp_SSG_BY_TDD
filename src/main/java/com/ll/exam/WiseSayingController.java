package com.ll.exam;

import java.util.*;

public class WiseSayingController {
    private WiseSayingService wsService;
    private Scanner sc;
    public WiseSayingController(Scanner sc) {
        wsService = new WiseSayingService();
        this.sc = sc;
    }
    public void create(Rq rq) {
        System.out.print("명언 : ");
        String wiseSaying = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying ws = wsService.create(wiseSaying, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", ws.getId());
    }
    public void readList(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> list = wsService.getList();
        for(int i = list.size() - 1; i >= 0; i--) {
            WiseSaying ws = list.get(i);
            System.out.printf("%d / %s / %s\n", ws.getId(), ws.getAuthor(), ws.getWiseSaying());
        }
    }
    public void delete(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if(id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }
        WiseSaying ws = wsService.findById(id);
        if(ws == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        wsService.remove(ws);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

        }

    public void update(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if(id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }
        WiseSaying ws = wsService.findById(id);
        if(ws == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        System.out.println("명언(기존) : " + ws.getWiseSaying());
        System.out.print("명언 : ");
        String wiseSaying = sc.nextLine();

        System.out.println("작가(기존) : " + ws.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wsService.update(ws, wiseSaying, author);
        System.out.printf("%d번 명언이 수정되었습니다.\n", id);

    }
}

