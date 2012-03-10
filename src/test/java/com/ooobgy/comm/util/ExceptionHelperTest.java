package com.ooobgy.comm.util;

import org.junit.Test;

import com.ooobgy.comm.util.ExceptionHelper;
import com.ooobgy.comm.util.testutil.UtilException;

import junit.framework.TestCase;

/**
 * 
 * @author frogcherry 周晓龙 frogcherry@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public class ExceptionHelperTest extends TestCase {

    @Test
    public void testConstructException1() throws Exception {
        String case01Msg = "case01";
        Throwable e = ExceptionHelper.constructException(UtilException.class, case01Msg);
        assertTrue(e instanceof UtilException);
        assertEquals(e.getMessage(), case01Msg);
    }
    
    @Test
    public void testConstructException2() throws Exception {
        String case01Msg = "case02";
        UtilException cause = new UtilException(new Throwable());
        Throwable e = ExceptionHelper.constructException(UtilException.class, case01Msg, cause);
        assertTrue(e instanceof UtilException);
        assertEquals(e.getMessage(), case01Msg);
    }
}
