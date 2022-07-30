package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class IoTest {
    @Test
    public void 스캐너에_키보드가_아닌_문자열을_입력으로_설정() {
        Scanner sc = TestUtil.genScanner("Hello");

        String cmd = sc.nextLine().trim();
        assertThat(cmd).isEqualTo("Hello");
    }
    @Test
    public void 출력을_모니텨에_하지_않고_문자열로_얻기() {
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("Hello");
        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertThat(rs).isEqualTo("Hello");
    }
    @Test
    public void 문자열을_파일에_저장() {
        Util.file.mkdir("test_data");
        Util.file.saveToFile("test_data/1.txt", "Hello");

        String body = Util.file.readFromFile("test_data/1.txt", "");

        assertThat(body).isEqualTo("Hello");
    }
}
