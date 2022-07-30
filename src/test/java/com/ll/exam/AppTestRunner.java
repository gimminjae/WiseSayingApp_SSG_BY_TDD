package com.ll.exam;

import java.util.*;
import java.io.*;
import java.io.ByteArrayOutputStream;

//Test코드에서의 중복을 줄이기위해 도입
public class AppTestRunner {
    public static String run(String input) {
        Scanner sc = TestUtil.genScanner(input);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        return rs;
    }
}
