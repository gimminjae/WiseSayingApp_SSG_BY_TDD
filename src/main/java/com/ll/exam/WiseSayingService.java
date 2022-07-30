package com.ll.exam;

import java.util.LinkedList;
import java.util.List;

public class WiseSayingService {
    private WiseSayingRepository wsRepository;
    public WiseSayingService() {
        wsRepository = new WiseSayingRepository();
    }
    public WiseSaying create(String content, String author) {
        return wsRepository.create(content, author);
    }
    public List<WiseSaying> getList() {
        return wsRepository.showList();
    }
    public void remove(WiseSaying wiseSaying) {
        wsRepository.remove(wiseSaying);
    }
    public WiseSaying findById(int id) {
        return wsRepository.findById(id);

    }

    public WiseSaying update(WiseSaying ws, String content, String author) {

        return wsRepository.update(ws, content, author);
    }
}
