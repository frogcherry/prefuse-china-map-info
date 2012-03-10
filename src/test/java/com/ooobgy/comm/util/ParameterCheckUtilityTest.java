package com.ooobgy.comm.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
/**
 * 
 * @author frogcherry 周晓龙 frogcherry@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public class ParameterCheckUtilityTest extends TestCase {

    public void testcheckNotNull() throws Exception {
        String name = "case";
        try {
            ParameterCheckUtility.checkNotNull("note", name + "note");
            ParameterCheckUtility.checkNotNull(null, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    public void testcheckNotEmpty() throws Exception {
        String name = "case";
        String v = null;
        try {
            ParameterCheckUtility.checkNotEmpty(v, name + "note");
            ParameterCheckUtility.checkNotEmpty("note", name + "note");
            ParameterCheckUtility.checkNotEmpty("", name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    public void testcheckNotEmptyAfterTrimming() throws Exception {
        String name = "case";
        String v = null;
        try {
            ParameterCheckUtility.checkNotEmptyAfterTrimming(v, name + "note");
            ParameterCheckUtility.checkNotEmptyAfterTrimming("note", name + "note");
            ParameterCheckUtility.checkNotEmptyAfterTrimming("  ", name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    public void testcheckNotNullNorEmpty() throws Exception {
        String name = "case";
        try {
            ParameterCheckUtility.checkNotNullNorEmpty("note", name + "note");
            ParameterCheckUtility.checkNotNullNorEmpty("", name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    public void testcheckNotNullNorEmptyAfterTrimming() throws Exception {
        String name = "case";
        try {
            ParameterCheckUtility.checkNotNullNorEmptyAfterTrimming("note", name
                    + "note");
            ParameterCheckUtility.checkNotNullNorEmptyAfterTrimming("  ", name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    public void testcheckInstance() throws Exception {
        String name = "case";
        Class<?> expectedType = String.class;
        try {
            expectedType = String.class;
            ParameterCheckUtility.checkInstance("note", expectedType,
                    name + "note");
            expectedType = Integer.class;
            ParameterCheckUtility.checkInstance("  ", expectedType, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNullOrInstance() throws Exception {
        String name = "case";
        Class<?> expectedType = String.class;
        String v = null;
        try {
            ParameterCheckUtility.checkNullOrInstance(v, expectedType,
                    name + "note");
            expectedType = String.class;
            ParameterCheckUtility.checkNullOrInstance("note", expectedType,
                    name + "note");
            expectedType = Integer.class;
            ParameterCheckUtility.checkNullOrInstance("  ", expectedType, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckExists() throws Exception {
        String name = "case";
        File file = null;
        
        try {
            file = null;
            ParameterCheckUtility.checkExists(file, name);
            file = new File("./test_files/empty");
            ParameterCheckUtility.checkExists(file, name);
            file = new File("null");
            ParameterCheckUtility.checkExists(file, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckIsFile() throws Exception {
        String name = "case";
        File file = null;
        
        try {
            file = null;
            ParameterCheckUtility.checkIsFile(file, name);
            file = new File("./test_files/empty");
            ParameterCheckUtility.checkIsFile(file, name);
            file = new File("./test_files");
            ParameterCheckUtility.checkIsFile(file, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckIsDirectory() throws Exception {
        String name = "case";
        File file = null;
        
        try {
            file = null;
            ParameterCheckUtility.checkIsDirectory(file, name);
            file = new File("./test_files");
            ParameterCheckUtility.checkIsDirectory(file, name);
            file = new File("./test_files/empty");
            ParameterCheckUtility.checkIsDirectory(file, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotEmptyCol() throws Exception {
        String name = "case";
        Collection<String> col = null;
        try {
            col = null;
            ParameterCheckUtility.checkNotEmpty(col, name);
            col = new ArrayList<String>();
            col.add(name);
            ParameterCheckUtility.checkNotEmpty(col, name);
            col.clear();
            ParameterCheckUtility.checkNotEmpty(col, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotNullNorEmptyCol() throws Exception {
        String name = "case";
        Collection<String> col = null;
        try {
            col = new ArrayList<String>();
            col.add(name);
            ParameterCheckUtility.checkNotNullNorEmpty(col, name);
            col.clear();
            ParameterCheckUtility.checkNotNullNorEmpty(col, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotEmptyMap() throws Exception {
        String name = "case";
        Map<String,String> map = null;
        try {
            map = null;
            ParameterCheckUtility.checkNotEmpty(map, name);
            map = new HashMap<String,String>();
            map.put("k1","v1");
            ParameterCheckUtility.checkNotEmpty(map, name);
            map.clear();
            ParameterCheckUtility.checkNotEmpty(map, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotNullNorEmptyMap() throws Exception {
        String name = "case";
        Map<String,String> map = null;
        try {
            map = new HashMap<String,String>();
            map.put("k1","v1");
            ParameterCheckUtility.checkNotNullNorEmpty(map, name);
            map.clear();
            ParameterCheckUtility.checkNotNullNorEmpty(map, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotNullElements() throws Exception {
        String name = "case";
        Collection<String> col = null;
        try {
            col = null;
            ParameterCheckUtility.checkNotNullElements(col, name);
            col = new ArrayList<String>();
            col.add(name);
            ParameterCheckUtility.checkNotNullElements(col, name);
            col.add(null);
            ParameterCheckUtility.checkNotNullElements(col, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotEmptyElements() throws Exception {
        String name = "case";
        Collection<Object> col = null;
        boolean trimStrings = false;
        
        try {
            col = null;
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);
            col = new ArrayList<Object>();
            col.add(name);
            trimStrings = false;
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);            
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);
            col.add(null);
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            col.clear();
            col = new ArrayList<Object>();
            col.add(name);
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);
            col.add("  ");
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            col.clear();
            ArrayList<Object> col1 = new ArrayList<Object>();
            col.add(name);
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);
            col1.add(name);
            col.add(col1);
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);
            col1.clear();
            col.clear();
            col.add(col1);
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            col.clear();
            Map<Object, Object> map = new HashMap<Object, Object>();
            col.add(name);
            col.add(new Integer(0));
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);
            map.put("k1", "v1");
            col.add(map);
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);
            map.clear();
            col.clear();
            col.add(map);
            ParameterCheckUtility.checkNotEmptyElements(col, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotNullKeys() throws Exception {
        String name = "case";
        Map<Object, Object> map = null;
        
        try {
            ParameterCheckUtility.checkNotNullKeys(map, name);
            map = new HashMap<Object, Object>();
            map.put("k1", "v1");
            ParameterCheckUtility.checkNotNullKeys(map, name);
            map.put(null, "v2");
            ParameterCheckUtility.checkNotNullKeys(map, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotNullValues() throws Exception {
        String name = "case";
        Map<Object, Object> map = null;
        
        try {
            ParameterCheckUtility.checkNotNullValues(map, name);
            map = new HashMap<Object, Object>();
            map.put("k1", "v1");
            ParameterCheckUtility.checkNotNullValues(map, name);
            map.put("v2", null);
            ParameterCheckUtility.checkNotNullValues(map, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotEmptyKeys() throws Exception {
        String name = "case";
        Map<Object, Object> map = null;
        boolean trimStrings = false;
        
        try {
            map = null;
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);
            map = new HashMap<Object, Object>();
            map.put(name, "v1");
            trimStrings = false;
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);            
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);
            map.put(null, "v1");
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            map.clear();
            map = new HashMap<Object, Object>();
            map.put(name, "v1");
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);
            map.put("  ", "v1");
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            map.clear();
            ArrayList<Object> col1 = new ArrayList<Object>();
            map.put(name, "v1");
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);
            col1.add(name);
            map.put(col1, "v1");
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);
            col1.clear();
            map.clear();
            map.put(col1, "v1");
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            map.clear();
            Map<Object, Object> map1 = new HashMap<Object, Object>();
            map.put(name, "v1");
            map.put(new Integer(0), "v1");
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);
            map1.put("k1", "v1");
            map.put(map1, "v1");
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);
            map1.clear();
            map.clear();
            map.put(map1, "v1");
            ParameterCheckUtility.checkNotEmptyKeys(map, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotEmptyValues() throws Exception {
        String name = "case";
        Map<Object, Object> map = null;
        boolean trimStrings = false;
        
        try {
            map = null;
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);
            map = new HashMap<Object, Object>();
            map.put("v1", name);
            trimStrings = false;
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);            
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);
            map.put("v1", null);
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            map.clear();
            map = new HashMap<Object, Object>();
            map.put("k1", name);
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);
            map.put("k1", "  ");
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            map.clear();
            ArrayList<Object> col1 = new ArrayList<Object>();
            map.put("k1", name);
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);
            col1.add(name);
            map.put("k1", col1);
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);
            col1.clear();
            map.clear();
            map.put("k1", col1);
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            map.clear();
            Map<Object, Object> map1 = new HashMap<Object, Object>();
            map.put("k1", name);
            map.put("k1", new Integer(0));
            trimStrings = true;
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);
            map1.put("k1", "v1");
            map.put("k1", map1);
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);
            map1.clear();
            map.clear();
            map.put("k1", map1);
            ParameterCheckUtility.checkNotEmptyValues(map, trimStrings, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNegativeDouble() throws Exception {
        double value;
        String name = "case";
        try {
            value = -10.0D;
            ParameterCheckUtility.checkNegative(value, name);
            value = 0.0D;
            ParameterCheckUtility.checkNegative(value, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckPositiveDouble() throws Exception {
        double value;
        String name = "case";
        try {
            value = 10.0D;
            ParameterCheckUtility.checkPositive(value, name);
            value = 0.0D;
            ParameterCheckUtility.checkPositive(value, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotNegativeDouble() throws Exception {
        double value;
        String name = "case";
        try {
            value = 10.0D;
            ParameterCheckUtility.checkNotNegative(value, name);
            value = -10.0D;
            ParameterCheckUtility.checkNotNegative(value, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotPositiveDouble() throws Exception {
        double value;
        String name = "case";
        try {
            value = -10.0D;
            ParameterCheckUtility.checkNotPositive(value, name);
            value = 10.0D;
            ParameterCheckUtility.checkNotPositive(value, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotZeroDouble() throws Exception {
        double value;
        String name = "case";
        try {
            value = -10.0D;
            ParameterCheckUtility.checkNotZero(value, name);
            value = 0.0D;
            ParameterCheckUtility.checkNotZero(value, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckGreaterThanDouble() throws Exception {
        double value;
        String name = "case";
        double number = 0.0D;
        boolean inclusive = false;
        
        try {
            value = 10.0D;
            ParameterCheckUtility.checkGreaterThan(value, number, inclusive, name);
            value = 0.0D;
            ParameterCheckUtility.checkGreaterThan(value, number, inclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            inclusive = true;
            value = 10.0D;
            ParameterCheckUtility.checkGreaterThan(value, number, inclusive, name);
            value = 0.0D;
            ParameterCheckUtility.checkGreaterThan(value, number, inclusive, name);
            value = -10.0D;
            ParameterCheckUtility.checkGreaterThan(value, number, inclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckLessThanDouble() throws Exception {
        double value;
        String name = "case";
        double number = 0.0D;
        boolean inclusive = false;
        
        try {
            value = -10.0D;
            ParameterCheckUtility.checkLessThan(value, number, inclusive, name);
            value = 0.0D;
            ParameterCheckUtility.checkLessThan(value, number, inclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            inclusive = true;
            value = -10.0D;
            ParameterCheckUtility.checkLessThan(value, number, inclusive, name);
            value = 0.0D;
            ParameterCheckUtility.checkLessThan(value, number, inclusive, name);
            value = 10.0D;
            ParameterCheckUtility.checkLessThan(value, number, inclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckInRangeDouble() throws Exception {
        double value;
        String name = "case";
        double from = 0.0D;
        double to = 100.0D;
        boolean fromInclusive;
        boolean toInclusive;
        
        //以下测试向上越界
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 1000.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 0.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 1000.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 100.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 10.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 1000.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 0.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 100.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 1000.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        //以下测试向下越界
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = -1000.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 0.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = -1000.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = -100.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 10.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = -1000.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 0.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 100.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = -1000.0D;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNegativeLong() throws Exception {
        long value;
        String name = "case";
        try {
            value = -10L;
            ParameterCheckUtility.checkNegative(value, name);
            value = 0L;
            ParameterCheckUtility.checkNegative(value, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckPositiveLong() throws Exception {
        long value;
        String name = "case";
        try {
            value = 10L;
            ParameterCheckUtility.checkPositive(value, name);
            value = 0L;
            ParameterCheckUtility.checkPositive(value, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotNegativeLong() throws Exception {
        long value;
        String name = "case";
        try {
            value = 10L;
            ParameterCheckUtility.checkNotNegative(value, name);
            value = -10L;
            ParameterCheckUtility.checkNotNegative(value, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotPositiveLong() throws Exception {
        long value;
        String name = "case";
        try {
            value = -10L;
            ParameterCheckUtility.checkNotPositive(value, name);
            value = 10L;
            ParameterCheckUtility.checkNotPositive(value, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckNotZeroLong() throws Exception {
        long value;
        String name = "case";
        try {
            value = -10L;
            ParameterCheckUtility.checkNotZero(value, name);
            value = 0L;
            ParameterCheckUtility.checkNotZero(value, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckGreaterThanLong() throws Exception {
        long value;
        String name = "case";
        long number = 0L;
        boolean inclusive = false;
        
        try {
            value = 10L;
            ParameterCheckUtility.checkGreaterThan(value, number, inclusive, name);
            value = 0L;
            ParameterCheckUtility.checkGreaterThan(value, number, inclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            inclusive = true;
            value = 10L;
            ParameterCheckUtility.checkGreaterThan(value, number, inclusive, name);
            value = 0L;
            ParameterCheckUtility.checkGreaterThan(value, number, inclusive, name);
            value = -10L;
            ParameterCheckUtility.checkGreaterThan(value, number, inclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckLessThanLong() throws Exception {
        long value;
        String name = "case";
        long number = 0L;
        boolean inclusive = false;
        
        try {
            value = -10L;
            ParameterCheckUtility.checkLessThan(value, number, inclusive, name);
            value = 0L;
            ParameterCheckUtility.checkLessThan(value, number, inclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            inclusive = true;
            value = -10L;
            ParameterCheckUtility.checkLessThan(value, number, inclusive, name);
            value = 0L;
            ParameterCheckUtility.checkLessThan(value, number, inclusive, name);
            value = 10L;
            ParameterCheckUtility.checkLessThan(value, number, inclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    public void testcheckInRangeLong() throws Exception {
        long value;
        String name = "case";
        long from = 0L;
        long to = 100L;
        boolean fromInclusive;
        boolean toInclusive;
        
        //以下测试向上越界
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 1000L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 0L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 1000L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 100L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 10L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 1000L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 0L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 100L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = 1000L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        //以下测试向下越界
        try {
            fromInclusive = false;
            toInclusive = false;
            value = -1000L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 0L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = -1000L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = false;
            toInclusive = false;
            value = 10L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = -100L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = 10L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            value = -1000L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        
        try {
            fromInclusive = true;
            toInclusive = true;
            value = -1000L;
            ParameterCheckUtility.checkInRange(value, from, to, fromInclusive, toInclusive, name);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
}
