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
    void  명령_등록_입력시_명언과_작가를_입력받는지_Test() {
        String rs = AppTestRunner.run("""
        등록
        과거를 사랑하라
        작자미상
        종료
        """);

        System.out.print(rs);
        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
    }
    @Test
    void 명언과_작가_입력시_등록완료_메시지가_출력되는지_Test() {
        String rs = AppTestRunner.run("""
                등록
                과거를 사랑하라
                작자미상
                종료
                """);
        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
    }

    @Test
    void 등록시_명언번호가_증가하는지_Test() {
        String rs = AppTestRunner.run("""
                등록
                과거를 사랑하라
                작자미상
                등록
                현재를 사랑하라
                작자모름
                종료
                """);
        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
        assertTrue(rs.contains("2번 명언이 등록되었습니다."));
    }
    @Test
    void 명령어_목록_입력시_등록된_명언들을_출력하는지() {
        String rs = AppTestRunner.run("""
                등록
                과거를 사랑하라
                작자미상
                등록
                현재를 사랑하라
                작자모름
                목록
                종료
                """);
        System.out.print(rs);
        assertTrue(rs.contains("번호 / 작가 / 명언"));
        assertTrue(rs.contains("2 / 작자모름 / 현재를 사랑하라"));
        assertTrue(rs.contains("1 / 작자미상 / 과거를 사랑하라"));
    }

}
