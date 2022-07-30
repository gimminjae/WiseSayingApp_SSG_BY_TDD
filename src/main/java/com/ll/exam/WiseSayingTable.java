package com.ll.exam;

public class WiseSayingTable {
    private String baseDir;
    public WiseSayingTable(String baseDir) {
        this.baseDir = baseDir;
    }
    public void save(WiseSaying wiseSaying) {
        int id = getLastId() + 1;

        Util.file.mkdir("%s/wise_saying".formatted(baseDir));
        String body = "내용";

        Util.file.saveToFile("%s/wise_saying/%d.json".formatted(baseDir, wiseSaying.getId()), body);

    }
    public void saveLastId(int id) {
        Util.file.saveToFile("%s/wise_saying/last_id.txt".formatted(baseDir), id + "");
    }
    public int getLastId() {
        String lastId = Util.file.readFromFile("%s/wise_saying/last_id.txt".formatted(baseDir), "");

        if(lastId.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(lastId);
    }
}
