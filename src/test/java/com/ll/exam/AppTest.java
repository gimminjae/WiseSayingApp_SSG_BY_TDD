package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    @Test
    public void Test() {
        assertTrue(1 == 1);
        assertEquals(1, 1);
    }
    @Test
    void 프로그램_시작_및_종료_Test() {
        Scanner sc = TestUtil.genScanner("종료");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령) "));
    }
    @Test
    void  명령_등록_입력시_명언과_작가를_묻는지_Test() {
        Scanner sc = TestUtil.genScanner("등록");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
    }

}
