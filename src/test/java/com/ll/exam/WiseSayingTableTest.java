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
    }
}
