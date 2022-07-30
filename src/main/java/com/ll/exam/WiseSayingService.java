package com.ll.exam;

import java.util.LinkedList;
import java.util.List;

public class WiseSayingService {
    private List<WiseSaying> wsList;

    public WiseSayingService() {
        wsList = new LinkedList<>();
    }
    public void create(WiseSaying wiseSaying) {
        wsList.add(wiseSaying);
    }

    public List<WiseSaying> getList() {
        return wsList;
    }
    public WiseSaying findById(int id) {
        for(int i = 0; i < wsList.size(); i++) {
            WiseSaying ws = wsList.get(i);
            if(id == ws.getId()) return ws;
        }
        return null;
    }

    public void remove(WiseSaying wiseSaying) {
        wsList.remove(wiseSaying);
    }
}
