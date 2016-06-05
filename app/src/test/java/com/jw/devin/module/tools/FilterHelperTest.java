package com.jw.devin.module.tools;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by devin on 16/6/5.
 */
public class FilterHelperTest {

    @Test
    public void testIsNum() throws Exception {
        assertTrue(FilterHelper.isNum("45"));
        assertFalse(FilterHelper.isNum(null));
    }
}