package com.ll.exam;

import java.util.LinkedList;
import java.util.List;

public class WiseSayingRepository {
    private int lastId;

    private List<WiseSaying> wsList;

    public WiseSayingRepository() {
        lastId = 1;

        wsList = new LinkedList<>();
    }

    public WiseSaying create(String content, String author) {
        WiseSaying ws = new WiseSaying(lastId++, author, content);
        wsList.add(ws);
        return ws;
    }

    public List<WiseSaying> showList() {
        return wsList;
    }

    public void remove(WiseSaying wiseSaying) {
        wsList.remove(wiseSaying);
    }

    public WiseSaying findById(int id) {
        for(int i = 0; i < wsList.size(); i++) {
            WiseSaying ws = wsList.get(i);
            if(id == ws.getId()) return ws;
        }
        return null;
    }
}
