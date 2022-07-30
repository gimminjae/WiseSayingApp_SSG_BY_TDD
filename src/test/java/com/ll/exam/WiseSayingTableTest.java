package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WiseSayingTableTest {
    @Test
    public void WiseSayingSaveTest() {
        WiseSayingTable wsTable = new WiseSayingTable("test_data");
        WiseSaying ws = new WiseSaying(1, "나에게 불가능이란 없다", "나폴레옹");
        wsTable.save(ws);
        assertTrue(new File("test_data/wise_saying/1.json").exists());
        ws = new WiseSaying(2, "나의 죽음을 적들에게 알리지 마라.", "이순신");
        wsTable.save(ws);
        assertTrue(new File("test_data/wise_saying/2.json").exists());
    }

}
