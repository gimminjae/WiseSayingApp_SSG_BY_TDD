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
        String rs = AppTestRunner.run("종료");

        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령) "));
    }
    @Test
    void  명령_등록_입력시_명언과_작가를_묻는지_Test() {
        String rs = AppTestRunner.run("등록");

        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
    }
    @Test
    void 명언과_작가_입력시_등록완료_메시지가_출력되는지_Test() {
        String rs = AppTestRunner.run("""
                등록
                과거를 사랑하라
                작자미상
                """);
        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
    }

}
