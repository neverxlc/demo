package com.example.demo.util;

import org.apache.commons.lang3.text.translate.AggregateTranslator;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.EntityArrays;
import org.apache.commons.lang3.text.translate.LookupTranslator;
import sun.awt.util.IdentityArrayList;

import javax.swing.*;
import java.io.IOException;
import java.io.Writer;

public final class EscapeUtils {

    private static final CharSequenceTranslator ESCAPE_SQL =
            new AggregateTranslator(new CharSequenceTranslator[] {
                    new LookupTranslator(new String[][]{{"’","\\’"}, {"\"","\\\""},
                            {"\\","\\\\"}, {"/","\\/"}, {"%","\\%"}, {"_","\\_"}}),
                    new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE())
            });

    public EscapeUtils() {
    }


    public static final String EscapeSql(String input) {
        return ESCAPE_SQL.translate(input);
    }


    public static void main(String[] args) {
        String search = "%asd%";
        System.out.println(EscapeUtils.EscapeSql(search));
    }
}
