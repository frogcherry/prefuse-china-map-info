package com.ooobgy.comm.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ooobgy.comm.util.testutil.UtilException;

import junit.framework.TestCase;

/**
 * 
 * @author frogcherry 周晓龙 frogcherry@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public class ValidationUtilityTest extends TestCase {

    public void testcheckNotNull() throws Exception {
        String name = "case";
        try {
            Class<UtilException> exceptionClass = UtilException.class;
            ValidationUtility.checkNotNull("note", name + "note",
                    exceptionClass);
            ValidationUtility.checkNotNull(null, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
            assertEquals(e.getMessage(), name + " should not be null");
        }
    }

    public void testcheckNotEmpty() throws Exception {
        String name = "case";
        String v = null;
        try {
            Class<UtilException> exceptionClass = UtilException.class;
            ValidationUtility.checkNotEmpty(v, name + "note",
                    exceptionClass);
            ValidationUtility.checkNotEmpty("note", name + "note",
                    exceptionClass);
            ValidationUtility.checkNotEmpty("", name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
            assertEquals(e.getMessage(), name + " should not be empty");
        }
    }

    public void testcheckNotEmptyAfterTrimming() throws Exception {
        String name = "case";
        String v = null;
        try {
            Class<UtilException> exceptionClass = UtilException.class;
            ValidationUtility.checkNotEmptyAfterTrimming(v, name + "note",
                    exceptionClass);
            ValidationUtility.checkNotEmptyAfterTrimming("note", name + "note",
                    exceptionClass);
            ValidationUtility.checkNotEmptyAfterTrimming("  ", name,
                    exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
            assertEquals(e.getMessage(), name
                    + " should not be empty (trimmed)");
        }
    }

    public void testcheckNotNullNorEmpty() throws Exception {
        String name = "case";
        try {
            Class<UtilException> exceptionClass = UtilException.class;
            ValidationUtility.checkNotNullNorEmpty("note", name + "note",
                    exceptionClass);
            ValidationUtility.checkNotNullNorEmpty("", name,
                    exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }

    public void testcheckNotNullNorEmptyAfterTrimming() throws Exception {
        String name = "case";
        try {
            Class<UtilException> exceptionClass = UtilException.class;
            ValidationUtility.checkNotNullNorEmptyAfterTrimming("note", name
                    + "note", exceptionClass);
            ValidationUtility.checkNotNullNorEmptyAfterTrimming("  ", name,
                    exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }

    public void testcheckInstance() throws Exception {
        String name = "case";
        Class<?> expectedType = String.class;
        try {
            expectedType = String.class;
            Class<UtilException> exceptionClass = UtilException.class;
            ValidationUtility.checkInstance("note", expectedType,
                    name + "note", exceptionClass);
            expectedType = Integer.class;
            ValidationUtility.checkInstance("  ", expectedType, name,
                    exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
            assertEquals(e.getMessage(), name + " should be an instance of "
                    + expectedType.getName());
        }
    }
    
    public void testcheckNullOrInstance() throws Exception {
        String name = "case";
        Class<?> expectedType = String.class;
        String v = null;
        try {
            Class<UtilException> exceptionClass = UtilException.class;
            ValidationUtility.checkNullOrInstance(v, expectedType,
                    name + "note", exceptionClass);
            expectedType = String.class;
            ValidationUtility.checkNullOrInstance("note", expectedType,
                    name + "note", exceptionClass);
            expectedType = Integer.class;
            ValidationUtility.checkNullOrInstance("  ", expectedType, name,
                    exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
            assertEquals(e.getMessage(), name + " should be null or an instance of "
                    + expectedType.getName());
        }
    }
    
    public void testcheckExists() throws Exception {
        String name = "case";
        File file = null;
        
        try {
            file = null;
            Class<UtilException> exceptionClass = UtilException.class;
            ValidationUtility.checkExists(file, name, exceptionClass);
            file = new File("./test_files/empty");
            ValidationUtility.checkExists(file, name, exceptionClass);
            file = new File("null");
            ValidationUtility.checkExists(file, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckIsFile() throws Exception {
        String name = "case";
        File file = null;
        
        try {
            file = null;
            Class<UtilException> exceptionClass = UtilException.class;
            ValidationUtility.checkIsFile(file, name, exceptionClass);
            file = new File("./test_files/empty");
            ValidationUtility.checkIsFile(file, name, exceptionClass);
            file = new File("./test_files");
            ValidationUtility.checkIsFile(file, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckIsDirectory() throws Exception {
        String name = "case";
        File file = null;
        
        try {
            file = null;
            Class<UtilException> exceptionClass = UtilException.class;
            ValidationUtility.checkIsDirectory(file, name, exceptionClass);
            file = new File("./test_files");
            ValidationUtility.checkIsDirectory(file, name, exceptionClass);
            file = new File("./test_files/empty");
            ValidationUtility.checkIsDirectory(file, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotEmptyCol() throws Exception {
        String name = "case";
        Collection<String> col = null;
        
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            col = null;
            ValidationUtility.checkNotEmpty(col, name, exceptionClass);
            col = new ArrayList<String>();
            col.add(name);
            ValidationUtility.checkNotEmpty(col, name, exceptionClass);
            col.clear();
            ValidationUtility.checkNotEmpty(col, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotNullNorEmptyCol() throws Exception {
        String name = "case";
        Collection<String> col = null;
        
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            col = new ArrayList<String>();
            col.add(name);
            ValidationUtility.checkNotNullNorEmpty(col, name, exceptionClass);
            col.clear();
            ValidationUtility.checkNotNullNorEmpty(col, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotEmptyMap() throws Exception {
        String name = "case";
        Map<String,String> map = null;
        
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            map = null;
            ValidationUtility.checkNotEmpty(map, name, exceptionClass);
            map = new HashMap<String,String>();
            map.put("k1","v1");
            ValidationUtility.checkNotEmpty(map, name, exceptionClass);
            map.clear();
            ValidationUtility.checkNotEmpty(map, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotNullNorEmptyMap() throws Exception {
        String name = "case";
        Map<String,String> map = null;
        
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            map = new HashMap<String,String>();
            map.put("k1","v1");
            ValidationUtility.checkNotNullNorEmpty(map, name, exceptionClass);
            map.clear();
            ValidationUtility.checkNotNullNorEmpty(map, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotNullElements() throws Exception {
        String name = "case";
        Collection<String> col = null;
        
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            col = null;
            ValidationUtility.checkNotNullElements(col, name, exceptionClass);
            col = new ArrayList<String>();
            col.add(name);
            ValidationUtility.checkNotNullElements(col, name, exceptionClass);
            col.add(null);
            ValidationUtility.checkNotNullElements(col, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotEmptyElements() throws Exception {
        String name = "case";
        Collection<Object> col = null;
        boolean trimStrings = false;
        Class<UtilException> exceptionClass = UtilException.class;
        
        try {
            col = null;
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);
            col = new ArrayList<Object>();
            col.add(name);
            trimStrings = false;
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);            
            trimStrings = true;
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);
            col.add(null);
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            col.clear();
            col = new ArrayList<Object>();
            col.add(name);
            trimStrings = true;
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);
            col.add("  ");
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            col.clear();
            ArrayList<Object> col1 = new ArrayList<Object>();
            col.add(name);
            trimStrings = true;
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);
            col1.add(name);
            col.add(col1);
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);
            col1.clear();
            col.clear();
            col.add(col1);
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            col.clear();
            Map<Object, Object> map = new HashMap<Object, Object>();
            col.add(name);
            col.add(new Integer(0));
            trimStrings = true;
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);
            map.put("k1", "v1");
            col.add(map);
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);
            map.clear();
            col.clear();
            col.add(map);
            ValidationUtility.checkNotEmptyElements(col, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotNullKeys() throws Exception {
        String name = "case";
        Map<Object, Object> map = null;
        Class<UtilException> exceptionClass = UtilException.class;
        
        try {
            ValidationUtility.checkNotNullKeys(map, name, exceptionClass);
            map = new HashMap<Object, Object>();
            map.put("k1", "v1");
            ValidationUtility.checkNotNullKeys(map, name, exceptionClass);
            map.put(null, "v2");
            ValidationUtility.checkNotNullKeys(map, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotNullValues() throws Exception {
        String name = "case";
        Map<Object, Object> map = null;
        Class<UtilException> exceptionClass = UtilException.class;
        
        try {
            ValidationUtility.checkNotNullValues(map, name, exceptionClass);
            map = new HashMap<Object, Object>();
            map.put("k1", "v1");
            ValidationUtility.checkNotNullValues(map, name, exceptionClass);
            map.put("v2", null);
            ValidationUtility.checkNotNullValues(map, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotEmptyKeys() throws Exception {
        String name = "case";
        Map<Object, Object> map = null;
        boolean trimStrings = false;
        Class<UtilException> exceptionClass = UtilException.class;
        
        try {
            map = null;
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);
            map = new HashMap<Object, Object>();
            map.put(name, "v1");
            trimStrings = false;
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);            
            trimStrings = true;
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);
            map.put(null, "v1");
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            map.clear();
            map = new HashMap<Object, Object>();
            map.put(name, "v1");
            trimStrings = true;
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);
            map.put("  ", "v1");
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            map.clear();
            ArrayList<Object> col1 = new ArrayList<Object>();
            map.put(name, "v1");
            trimStrings = true;
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);
            col1.add(name);
            map.put(col1, "v1");
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);
            col1.clear();
            map.clear();
            map.put(col1, "v1");
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            map.clear();
            Map<Object, Object> map1 = new HashMap<Object, Object>();
            map.put(name, "v1");
            map.put(new Integer(0), "v1");
            trimStrings = true;
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);
            map1.put("k1", "v1");
            map.put(map1, "v1");
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);
            map1.clear();
            map.clear();
            map.put(map1, "v1");
            ValidationUtility.checkNotEmptyKeys(map, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotEmptyValues() throws Exception {
        String name = "case";
        Map<Object, Object> map = null;
        boolean trimStrings = false;
        Class<UtilException> exceptionClass = UtilException.class;
        
        try {
            map = null;
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);
            map = new HashMap<Object, Object>();
            map.put("v1", name);
            trimStrings = false;
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);            
            trimStrings = true;
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);
            map.put("v1", null);
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            map.clear();
            map = new HashMap<Object, Object>();
            map.put("k1", name);
            trimStrings = true;
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);
            map.put("k1", "  ");
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            map.clear();
            ArrayList<Object> col1 = new ArrayList<Object>();
            map.put("k1", name);
            trimStrings = true;
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);
            col1.add(name);
            map.put("k1", col1);
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);
            col1.clear();
            map.clear();
            map.put("k1", col1);
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            map.clear();
            Map<Object, Object> map1 = new HashMap<Object, Object>();
            map.put("k1", name);
            map.put("k1", new Integer(0));
            trimStrings = true;
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);
            map1.put("k1", "v1");
            map.put("k1", map1);
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);
            map1.clear();
            map.clear();
            map.put("k1", map1);
            ValidationUtility.checkNotEmptyValues(map, trimStrings, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNegativeDouble() throws Exception {
        double value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            value = -10.0D;
            ValidationUtility.checkNegative(value, name, exceptionClass);
            value = 0.0D;
            ValidationUtility.checkNegative(value, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckPositiveDouble() throws Exception {
        double value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            value = 10.0D;
            ValidationUtility.checkPositive(value, name, exceptionClass);
            value = 0.0D;
            ValidationUtility.checkPositive(value, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotNegativeDouble() throws Exception {
        double value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            value = 10.0D;
            ValidationUtility.checkNotNegative(value, name, exceptionClass);
            value = -10.0D;
            ValidationUtility.checkNotNegative(value, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotPositiveDouble() throws Exception {
        double value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            value = -10.0D;
            ValidationUtility.checkNotPositive(value, name, exceptionClass);
            value = 10.0D;
            ValidationUtility.checkNotPositive(value, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotZeroDouble() throws Exception {
        double value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            value = -10.0D;
            ValidationUtility.checkNotZero(value, name, exceptionClass);
            value = 0.0D;
            ValidationUtility.checkNotZero(value, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckGreaterThanDouble() throws Exception {
        double value;
        String name = "case";
        double number = 0.0D;
        boolean inclusive = false;
        Class<UtilException> exceptionClass = UtilException.class;
        
        try {
            value = 10.0D;
            ValidationUtility.checkGreaterThan(value, number, inclusive, name, exceptionClass);
            value = 0.0D;
            ValidationUtility.checkGreaterThan(value, number, inclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            inclusive = true;
            value = 10.0D;
            ValidationUtility.checkGreaterThan(value, number, inclusive, name, exceptionClass);
            value = 0.0D;
            ValidationUtility.checkGreaterThan(value, number, inclusive, name, exceptionClass);
            value = -10.0D;
            ValidationUtility.checkGreaterThan(value, number, inclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckLessThanDouble() throws Exception {
        double value;
        String name = "case";
        double number = 0.0D;
        boolean inclusive = false;
        Class<UtilException> exceptionClass = UtilException.class;
        
        try {
            value = -10.0D;
            ValidationUtility.checkLessThan(value, number, inclusive, name, exceptionClass);
            value = 0.0D;
            ValidationUtility.checkLessThan(value, number, inclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            inclusive = true;
            value = -10.0D;
            ValidationUtility.checkLessThan(value, number, inclusive, name, exceptionClass);
            value = 0.0D;
            ValidationUtility.checkLessThan(value, number, inclusive, name, exceptionClass);
            value = 10.0D;
            ValidationUtility.checkLessThan(value, number, inclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckInRangeDouble() throws Exception {
        double value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        double from = 0.0D;
        double to = 100.0D;
        boolean fromInclusive;
        boolean toInclusive;
        
        //以下测试向上越界
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 1000.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 0.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 1000.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 100.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 10.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 1000.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 0.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 100.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 1000.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        //以下测试向下越界
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = -1000.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 0.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = -1000.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = -100.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 10.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = -1000.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 0.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 100.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = -1000.0D;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNegativeLong() throws Exception {
        long value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            value = -10L;
            ValidationUtility.checkNegative(value, name, exceptionClass);
            value = 0L;
            ValidationUtility.checkNegative(value, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckPositiveLong() throws Exception {
        long value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            value = 10L;
            ValidationUtility.checkPositive(value, name, exceptionClass);
            value = 0L;
            ValidationUtility.checkPositive(value, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotNegativeLong() throws Exception {
        long value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            value = 10L;
            ValidationUtility.checkNotNegative(value, name, exceptionClass);
            value = -10L;
            ValidationUtility.checkNotNegative(value, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotPositiveLong() throws Exception {
        long value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            value = -10L;
            ValidationUtility.checkNotPositive(value, name, exceptionClass);
            value = 10L;
            ValidationUtility.checkNotPositive(value, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckNotZeroLong() throws Exception {
        long value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        try {
            value = -10L;
            ValidationUtility.checkNotZero(value, name, exceptionClass);
            value = 0L;
            ValidationUtility.checkNotZero(value, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckGreaterThanLong() throws Exception {
        long value;
        String name = "case";
        long number = 0L;
        boolean inclusive = false;
        Class<UtilException> exceptionClass = UtilException.class;
        
        try {
            value = 10L;
            ValidationUtility.checkGreaterThan(value, number, inclusive, name, exceptionClass);
            value = 0L;
            ValidationUtility.checkGreaterThan(value, number, inclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            inclusive = true;
            value = 10L;
            ValidationUtility.checkGreaterThan(value, number, inclusive, name, exceptionClass);
            value = 0L;
            ValidationUtility.checkGreaterThan(value, number, inclusive, name, exceptionClass);
            value = -10L;
            ValidationUtility.checkGreaterThan(value, number, inclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckLessThanLong() throws Exception {
        long value;
        String name = "case";
        long number = 0L;
        boolean inclusive = false;
        Class<UtilException> exceptionClass = UtilException.class;
        
        try {
            value = -10L;
            ValidationUtility.checkLessThan(value, number, inclusive, name, exceptionClass);
            value = 0L;
            ValidationUtility.checkLessThan(value, number, inclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            inclusive = true;
            value = -10L;
            ValidationUtility.checkLessThan(value, number, inclusive, name, exceptionClass);
            value = 0L;
            ValidationUtility.checkLessThan(value, number, inclusive, name, exceptionClass);
            value = 10L;
            ValidationUtility.checkLessThan(value, number, inclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
    
    public void testcheckInRangeLong() throws Exception {
        long value;
        String name = "case";
        Class<UtilException> exceptionClass = UtilException.class;
        long from = 0L;
        long to = 100L;
        boolean fromInclusive;
        boolean toInclusive;
        
        //以下测试向上越界
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 1000L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 0L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 1000L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 100L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 10L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 1000L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 0L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 100L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = 1000L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        //以下测试向下越界
        try {
            fromInclusive = false;
            toInclusive = false;
            value = -1000L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 0L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = -1000L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = -100L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 10L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            value = -1000L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = -1000L;
            ValidationUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name, exceptionClass);
            fail();
        } catch (UtilException e) {
            assertTrue(e instanceof UtilException);
        }
    }
}
