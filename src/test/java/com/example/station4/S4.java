package com.example.station4;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class S4 {

    @Test
    public void test1() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        System.setOut(out);

        Main.main(null);

        String a = baos.toString();

        assertEquals("true\nfalse\n", a);
    }
}
