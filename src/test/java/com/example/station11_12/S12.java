package com.example.station11_12;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class S12 {

    @Test
    public void test() throws Exception {
        Class<?> itemClass = Main.class.getDeclaredClasses()[0];
        Constructor<?> constructor = itemClass.getDeclaredConstructor(Main.class, String.class, int.class, String.class, String[].class);
        Object item = constructor.newInstance(new Main(), "名前", 100000, "カテゴリ", new String[]{"タグ1", "タグ2"});
        assertEquals("名前", item.getClass().getDeclaredField("name").get(item));
        assertEquals(100000, item.getClass().getDeclaredField("price").get(item));
        assertEquals("カテゴリ", item.getClass().getDeclaredField("category").get(item));
        assertEquals("タグ1", ((String[]) (item.getClass().getDeclaredField("tags").get(item)))[0]);
        assertEquals("タグ2", ((String[]) (item.getClass().getDeclaredField("tags").get(item)))[1]);

        Method method = itemClass.getDeclaredMethod("getPriceWithTax", boolean.class);
        assertEquals(108000, (float) method.invoke(item, true), 0.1);
        assertEquals(110000, (float) method.invoke(item, false), 0.1);
    }
}
