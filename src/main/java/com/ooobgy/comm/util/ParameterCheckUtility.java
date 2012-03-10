package com.ooobgy.comm.util;

import java.io.File;
import java.util.Collection;
import java.util.Map;

/**
 * This is a utility class that provides static methods for checking whether
 * some parameter value meets specific criteria (not null, not empty, positive,
 * negative, etc). If criteria is not met, this utility throws
 * IllegalArgumentException.
 * 
 * Thread Safety: This class is immutable and thread safe when collection
 * parameters passed to it are used by the caller in thread safe manner.
 * 
 * @author frogcherry 周晓龙 frogcherry@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public class ParameterCheckUtility {
    /**
     * Empty private constructor.
     * 
     * Implementation Notes: Do nothing.
     */
    private ParameterCheckUtility() {
    }

    /**
     * Checks whether the given value is not null. And if this condition is not
     * met, the specified exception is thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is null
     * 
     * Implementation Notes: Similar to ValidationUtility.checkNotNull(value,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is null
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNotNull(Object value, String name) throws IllegalArgumentException{
        if (value == null) {
            throw new IllegalArgumentException(getParamValueName(name) + " should not be null");
        }
    }

    /**
     * Checks whether the given string value is not empty (without trimming).
     * And if this condition is not met, the specified exception is thrown. Note
     * that if value is null, exception is not thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is empty
     * 
     * Implementation Notes: Similar to ValidationUtility.checkNotEmpty(value,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is empty
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNotEmpty(String value, String name) {
        if (value != null && value.isEmpty()) {
            throw new IllegalArgumentException(getParamValueName(name) + " should not be empty");
        }
    }

    /**
     * Checks whether the given string value is not empty (after trimming). And
     * if this condition is not met, the specified exception is thrown. Note
     * that if value is null, exception is not thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is empty
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkNotEmptyAfterTrimming(value,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is empty
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNotEmptyAfterTrimming(String value, String name) {
        if (value != null && value.trim().isEmpty()) {
            throw new IllegalArgumentException(getParamValueName(name) + " should not be empty (trimmed)");
        }
    }

    /**
     * Checks whether the given string value is not null, nor empty (without
     * trimming). And if this condition is not met, the specified exception is
     * thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is null or empty
     * 
     * Implementation Notes: 1. checkNotNull(value, name); 2.
     * checkNotEmpty(value, name);
     * 
     * @throws IllegalArgumentException
     *             if the given value is null or empty
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNotNullNorEmpty(String value, String name) {
        checkNotNull(value, name);
        checkNotEmpty(value, name);
    }

    /**
     * Checks whether the given string value is not null, nor empty (after
     * trimming). And if this condition is not met, the specified exception is
     * thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is null or empty
     * 
     * Implementation Notes: 1. checkNotNull(value, name); 2.
     * checkNotEmptyAfterTrimming(value, name);
     * 
     * @throws IllegalArgumentException
     *             if the given value is null or empty
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNotNullNorEmptyAfterTrimming(String value,
            String name) {
        checkNotNull(value, name);
        checkNotEmptyAfterTrimming(value, name);
    }

    /**
     * Checks whether the given value is an instance of the specified type. And
     * if this condition is not met, the specified exception is thrown. Note
     * that if value is null, exception is thrown.
     * 
     * Parameters: value - the value of parameter to be checked expectedType -
     * the expected type of the value name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given value is not an instance of
     * the expected type
     * 
     * Implementation Notes: Similar to ValidationUtility.checkInstance(value,
     * expectedType, getParamValueName(name), IllegalArgumentException.class)
     * call. Note: it's required to duplicate source code here to increase the
     * performance. Calling the specified namesake method of ValidationUtility
     * will decrease the performance a lot since getParamValueName() will need
     * to concatenate strings on each call. In this method there is no need to
     * use ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is not an instance of the expected type
     * @param name
     *            the parameter name
     * @param expectedType
     *            the expected type of the value
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkInstance(Object value, Class<?> expectedType,
            String name) {
        if (expectedType.isInstance(value)) {
            throw new IllegalArgumentException(getParamValueName(name) + " should be an instance of " + expectedType.getName());
        }
    }

    /**
     * Checks whether the given value is null or an instance of the specified
     * type. And if this condition is not met, the specified exception is
     * thrown.
     * 
     * Parameters: value - the value of parameter to be checked expectedType -
     * the expected type of the value name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given value is not null and not
     * an instance of the expected type
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkNullOrInstance(value, expectedType,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is not null and not an instance of the
     *             expected type
     * @param name
     *            the parameter name
     * @param expectedType
     *            the expected type of the value
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNullOrInstance(Object value, Class<?> expectedType,
            String name) {
        if (value != null && expectedType.isInstance(value)) {
            throw new IllegalArgumentException(getParamValueName(name) + " should be null or an instance of " + expectedType.getName());
        }
    }

    /**
     * Checks whether the given File instance points to an existing file or
     * directory. And if this condition is not met, the specified exception is
     * thrown. Note that if file is null, exception is not thrown.
     * 
     * Parameters: file - the value of File parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given file value represents a not
     * existing file or directory
     * 
     * Implementation Notes: Similar to ValidationUtility.checkExists(file,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given file value represents a not existing file or
     *             directory
     * @param file
     *            the value of File parameter to be checked
     * @param name
     *            the parameter name
     */
    public static void checkExists(File file, String name) {
        if (file != null && !file.exists()) {
            throw new IllegalArgumentException(getParamValueName(name) + " should point to an existing file or directory");
        }
    }

    /**
     * Checks whether the given File instance points to an existing file. And if
     * this condition is not met, the specified exception is thrown. Note that
     * if file is null, exception is not thrown.
     * 
     * Parameters: file - the value of File parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given file value represents a not
     * existing file
     * 
     * Implementation Notes: Similar to ValidationUtility.checkIsFile(file,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given file value represents a not existing file
     * @param file
     *            the value of File parameter to be checked
     * @param name
     *            the parameter name
     */
    public static void checkIsFile(File file, String name) {
        if (file != null && !file.isFile()) {
            throw new IllegalArgumentException(getParamValueName(name) + " should point to an existing file");
        }
    }

    /**
     * Checks whether the given File instance points to an existing directory.
     * And if this condition is not met, the specified exception is thrown. Note
     * that if file is null, exception is not thrown.
     * 
     * Parameters: file - the value of File parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given file value represents a not
     * existing directory
     * 
     * Implementation Notes: Similar to ValidationUtility.checkIsDirectory(file,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given file value represents a not existing directory
     * @param file
     *            the value of File parameter to be checked
     * @param name
     *            the parameter name
     */
    public static void checkIsDirectory(File file, String name) {
        if (file != null && !file.isDirectory()) {
            throw new IllegalArgumentException(getParamValueName(name) + " should point to an existing directory");
        }
    }

    /**
     * Checks whether the given collection is not empty. And if this condition
     * is not met, the specified exception is thrown. Note that if collection is
     * null, exception is not thrown.
     * 
     * Parameters: collection - the value of collection parameter to be checked
     * name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given collection is empty
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkNotEmpty(collection, getParamValueName(name),
     * IllegalArgumentException.class) call. Note: it's required to duplicate
     * source code here to increase the performance. Calling the specified
     * namesake method of ValidationUtility will decrease the performance a lot
     * since getParamValueName() will need to concatenate strings on each call.
     * In this method there is no need to use ExceptionHelper, create
     * IllegalArgumentException instance explicitly instead.
     * 
     * @throws IllegalArgumentException
     *             if the given collection is empty
     * @param name
     *            the parameter name
     * @param collection
     *            the value of collection parameter to be checked
     */
    public static void checkNotEmpty(Collection<?> collection, String name) {
        if (collection != null && collection.isEmpty()) {
            throw new IllegalArgumentException(getParamValueName(name) + " should not be empty");
        }
    }

    /**
     * Checks whether the given collection is not null, nor empty. And if this
     * condition is not met, the specified exception is thrown.
     * 
     * Parameters: collection - the value of collection parameter to be checked
     * name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given collection is null or empty
     * 
     * Implementation Notes: 1. checkNotNull(collection, name); 2.
     * checkNotEmpty(collection, name);
     * 
     * @throws IllegalArgumentException
     *             if the given collection is null or empty
     * @param name
     *            the parameter name
     * @param collection
     *            the value of collection parameter to be checked
     */
    public static void checkNotNullNorEmpty(Collection<?> collection,
            String name) {
        checkNotNull(collection, name);
        checkNotEmpty(collection, name);
    }

    /**
     * Checks whether the given map value is not empty. And if this condition is
     * not met, the specified exception is thrown. Note that if map is null,
     * exception is not thrown.
     * 
     * Parameters: map - the value of map parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given map is empty
     * 
     * Implementation Notes: Similar to ValidationUtility.checkNotEmpty(map,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given map is empty
     * @param name
     *            the parameter name
     * @param map
     *            the value of map parameter to be checked
     */
    public static void checkNotEmpty(Map<?, ?> map, String name) {
        if (map != null && map.isEmpty()) {
            throw new IllegalArgumentException(getParamValueName(name) + " should not be empty");
        }
    }

    /**
     * Checks whether the given map is not null, nor empty. And if this
     * condition is not met, the specified exception is thrown.
     * 
     * Parameters: map - the value of map parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given map is null or empty
     * 
     * Implementation Notes: 1. checkNotNull(map, name); 2. checkNotEmpty(map,
     * name);
     * 
     * @throws IllegalArgumentException
     *             if the given map is null or empty
     * @param name
     *            the parameter name
     * @param map
     *            the value of map parameter to be checked
     */
    public static void checkNotNullNorEmpty(Map<?, ?> map, String name) {
        checkNotNull(map, name);
        checkNotEmpty(map, name);
    }

    /**
     * Checks whether the given collection doesn't contain null elements. And if
     * this condition is not met, the specified exception is thrown. Note that
     * if collection is null, exception is not thrown.
     * 
     * Parameters: collection - the value of collection parameter to be checked
     * name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given collection contains null
     * element
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkNotNullElements(collection,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given collection contains null element
     * @param name
     *            the parameter name
     * @param collection
     *            the value of collection parameter to be checked
     */
    public static void checkNotNullElements(Collection<?> collection,
            String name) {
        if (collection != null) {
            for (Object element : collection) {
                if (element == null) {
                    throw new IllegalArgumentException(getParamValueName(name) + " should not contain null");
                }
            }
        }
    }

    /**
     * Checks whether the given collection doesn't contain empty elements
     * (strings, collections, maps). And if this condition is not met, the
     * specified exception is thrown. Note that if collection is null, exception
     * is not thrown.
     * 
     * Parameters: collection - the value of collection parameter to be checked
     * trimStrings - true if strings should be trimmed before emptiness check,
     * false otherwise name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given collection contains an
     * empty element (string, collection or map)
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkNotEmptyElements(collection, trimStrings,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given collection contains an empty element (string,
     *             collection or map)
     * @param name
     *            the parameter name
     * @param trimStrings
     *            true if strings should be trimmed before emptiness check,
     *            false otherwise
     * @param collection
     *            the value of collection parameter to be checked
     */
    public static void checkNotEmptyElements(Collection<?> collection,
            boolean trimStrings, String name) {
        if (collection != null) {
            for (Object element : collection) {
                if (element == null) {
                    throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty elements: an element is null");
                }
                if (element instanceof String) {
                    String str = (String) element;
                    if (trimStrings) {
                        str = str.trim();
                    }
                    if (str.isEmpty()) {
                        throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty elements: a String element is empty");
                    }
                } else if (element instanceof Collection<?>) {
                    if (((Collection<?>)element).isEmpty()) {
                        throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty elements: a Collection element is empty");
                    }
                } else if (element instanceof Map<?,?>){
                    if (((Map<?,?>)element).isEmpty()) {
                        throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty elements: a Map element is empty");
                    }
                }
            }
        }
    }

    /**
     * Checks whether the given map doesn't contain a null key. And if this
     * condition is not met, the specified exception is thrown. Note that if map
     * is null, exception is not thrown.
     * 
     * Parameters: map - the value to be checked name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given map contains null key
     * 
     * Implementation Notes: Similar to ValidationUtility.checkNotNullKeys(map,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given map contains null key
     * @param name
     *            the parameter name
     * @param map
     *            the value to be checked
     */
    public static void checkNotNullKeys(Map<?, ?> map, String name) {
        if (map != null && map.containsKey(null)) {
            throw new IllegalArgumentException(getParamValueName(name) + " should not contain null key");
        }
    }

    /**
     * Checks whether the given map doesn't contain a null value. And if this
     * condition is not met, the specified exception is thrown. Note that if map
     * is null, exception is not thrown.
     * 
     * Parameters: map - the value of map parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given map contains null value
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkNotNullValues(map, getParamValueName(name),
     * IllegalArgumentException.class) call. Note: it's required to duplicate
     * source code here to increase the performance. Calling the specified
     * namesake method of ValidationUtility will decrease the performance a lot
     * since getParamValueName() will need to concatenate strings on each call.
     * In this method there is no need to use ExceptionHelper, create
     * IllegalArgumentException instance explicitly instead.
     * 
     * @throws IllegalArgumentException
     *             if the given map contains null value
     * @param name
     *            the parameter name
     * @param map
     *            the value of map parameter to be checked
     */
    public static void checkNotNullValues(Map<?, ?> map, String name) {
        if (map != null && map.containsValue(null)) {
            throw new IllegalArgumentException(getParamValueName(name) + " should not contain null value");
        }
    }

    /**
     * Checks whether the given map doesn't contain empty keys (strings,
     * collection, maps). And if this condition is not met, the specified
     * exception is thrown. Note that if map is null, exception is not thrown.
     * 
     * Parameters: map - the value of map parameter to be checked trimStrings -
     * true if strings should be trimmed before emptiness check, false otherwise
     * name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given map contains an empty key
     * (string, collection or map)
     * 
     * Implementation Notes: Similar to ValidationUtility.checkNotEmptyKeys(map,
     * trimStrings, getParamValueName(name), IllegalArgumentException.class)
     * call. Note: it's required to duplicate source code here to increase the
     * performance. Calling the specified namesake method of ValidationUtility
     * will decrease the performance a lot since getParamValueName() will need
     * to concatenate strings on each call. In this method there is no need to
     * use ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given map contains an empty key (string, collection or
     *             map)
     * @param name
     *            the parameter name
     * @param map
     *            the value of map parameter to be checked
     * @param trimStrings
     *            true if strings should be trimmed before emptiness check,
     *            false otherwise
     */
    public static void checkNotEmptyKeys(Map<?, ?> map, boolean trimStrings,
            String name) {
        if (map != null) {
            for (Object key : map.keySet()) {
                if (key == null) {
                    throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty keys: a key is null");
                }
                if (key instanceof String) {
                    String str = (String) key;
                    if (trimStrings) {
                        str = str.trim();
                    }
                    if (str.isEmpty()) {
                        throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty keys: a String key is empty");
                    }
                } else if (key instanceof Collection<?>) {
                    if (((Collection<?>)key).isEmpty()) {
                        throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty keys: a Collection key is empty");
                    }
                } else if (key instanceof Map<?,?>){
                    if (((Map<?,?>)key).isEmpty()) {
                        throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty keys: a Map key is empty");
                    }
                }
            }
        }
    }

    /**
     * Checks whether the given map doesn't contain empty values (strings,
     * collection, maps). And if this condition is not met, the specified
     * exception is thrown. Note that if map is null, exception is not thrown.
     * 
     * Parameters: map - the value of map parameter to be checked trimStrings -
     * true if strings should be trimmed before emptiness check, false otherwise
     * name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given map contains an empty value
     * (string, collection or map)
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkNotEmptyValues(map, trimStrings,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given map contains an empty value (string, collection
     *             or map)
     * @param name
     *            the parameter name
     * @param map
     *            the value of map parameter to be checked
     * @param trimStrings
     *            true if strings should be trimmed before emptiness check,
     *            false otherwise
     */
    public static void checkNotEmptyValues(Map<?, ?> map, boolean trimStrings,
            String name) {
        if (map != null) {
            for (Object value : map.values()) {
                if (value == null) {
                    throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty values: a value is null");
                }
                if (value instanceof String) {
                    String str = (String) value;
                    if (trimStrings) {
                        str = str.trim();
                    }
                    if (str.isEmpty()) {
                        throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty values: a String value is empty");
                    }
                } else if (value instanceof Collection<?>) {
                    if (((Collection<?>)value).isEmpty()) {
                        throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty values: a Collection value is empty");
                    }
                } else if (value instanceof Map<?,?>){
                    if (((Map<?,?>)value).isEmpty()) {
                        throw new IllegalArgumentException(getParamValueName(name) + " should not contain empty values: a Map value is empty");
                    }
                }
            }
        }
    }

    /**
     * Checks whether the given value is negative. And if this condition is not
     * met, the specified exception is thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is not negative
     * 
     * Implementation Notes: Similar to ValidationUtility.checkNegative(value,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is not negative
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNegative(double value, String name) {
        if (value >= 0) {
            throw new IllegalArgumentException(getParamValueName(name) + " should be negative");
        }
    }

    /**
     * Checks whether the given value is positive. And if this condition is not
     * met, the specified exception is thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is not positive
     * 
     * Implementation Notes: Similar to ValidationUtility.checkPositive(value,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is not positive
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkPositive(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(getParamValueName(name) + " should be positive");
        }
    }

    /**
     * Checks whether the given value is not negative. And if this condition is
     * not met, the specified exception is thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is negative
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkNotNegative(value, getParamValueName(name),
     * IllegalArgumentException.class) call. Note: it's required to duplicate
     * source code here to increase the performance. Calling the specified
     * namesake method of ValidationUtility will decrease the performance a lot
     * since getParamValueName() will need to concatenate strings on each call.
     * In this method there is no need to use ExceptionHelper, create
     * IllegalArgumentException instance explicitly instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is negative
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNotNegative(double value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(getParamValueName(name) + " should be not negative");
        }
    }

    /**
     * Checks whether the given value is not positive. And if this condition is
     * not met, the specified exception is thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is positive
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkNotPositive(value, getParamValueName(name),
     * IllegalArgumentException.class) call. Note: it's required to duplicate
     * source code here to increase the performance. Calling the specified
     * namesake method of ValidationUtility will decrease the performance a lot
     * since getParamValueName() will need to concatenate strings on each call.
     * In this method there is no need to use ExceptionHelper, create
     * IllegalArgumentException instance explicitly instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is positive
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNotPositive(double value, String name) {
        if (value > 0) {
            throw new IllegalArgumentException(getParamValueName(name) + " should be not positive");
        }
    }

    /**
     * Checks whether the given value is not equal to zero. And if this
     * condition is not met, the specified exception is thrown. Note: Don't
     * forget about "Floating-Point Accuracy/Comparison" problems when checking
     * floating point numbers.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is equal to 0
     * 
     * Implementation Notes: Similar to ValidationUtility.checkNotZero(value,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is equal to 0
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNotZero(double value, String name) {
        if (value == 0) {
            throw new IllegalArgumentException(getParamValueName(name) + " should not be equal to 0");
        }
    }

    /**
     * Checks whether the given value is greater than (greater than or equal to,
     * if inclusive is true) than the specified number. And if this condition is
     * not met, the specified exception is thrown. Note: Don't forget about
     * "Floating-Point Accuracy/Comparison" problems when checking floating
     * point numbers. Inclusive comparison is recommended to be used with
     * integral types only.
     * 
     * Parameters: value - the value of parameter to be checked number - the
     * number the value should be compared to inclusive - true if
     * "greater than or equal to" check should be performed, false if
     * "greater than" check should be performed name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given value is not greater than
     * (not greater than and not equal to, if inclusive is true) than the
     * specified number
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkGreaterThan(value, number, inclusive,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is not greater than (not greater than and
     *             not equal to, if inclusive is true) than the specified number
     * @param inclusive
     *            true if "greater than or equal to" check should be performed,
     *            false if "greater than" check should be performed
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     * @param number
     *            the number the value should be compared to
     */
    public static void checkGreaterThan(double value, double number,
            boolean inclusive, String name) {
        if (inclusive) {
            if (value < number) {
                throw new IllegalArgumentException(getParamValueName(name) + " should be greater than or equal to " + number);
            }
        } else {
            if (value <= number) {
                throw new IllegalArgumentException(getParamValueName(name) + " should be greater than " + number);
            }
        }
    }

    /**
     * Checks whether the given value is less than (less than or equal to, if
     * inclusive is true) than the specified number. And if this condition is
     * not met, the specified exception is thrown. Note: Don't forget about
     * "Floating-Point Accuracy/Comparison" problems when checking floating
     * point numbers. Inclusive comparison is recommended to be used with
     * integral types only.
     * 
     * Parameters: value - the value of parameter to be checked number - the
     * number the value should be compared to inclusive - true if
     * "less than or equal to" check should be performed, false if "less than"
     * check should be performed name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given value is not less than (not
     * less than and not equal to, if inclusive is true) than the specified
     * number
     * 
     * Implementation Notes: Similar to ValidationUtility.checkLessThan(value,
     * number, inclusive, getParamValueName(name),
     * IllegalArgumentException.class) call. Note: it's required to duplicate
     * source code here to increase the performance. Calling the specified
     * namesake method of ValidationUtility will decrease the performance a lot
     * since getParamValueName() will need to concatenate strings on each call.
     * In this method there is no need to use ExceptionHelper, create
     * IllegalArgumentException instance explicitly instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is not less than (not less than and not
     *             equal to, if inclusive is true) than the specified number
     * @param inclusive
     *            true if "less than or equal to" check should be performed,
     *            false if "less than" check should be performed
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     * @param number
     *            the number the value should be compared to
     */
    public static void checkLessThan(double value, double number,
            boolean inclusive, String name) {
        if (inclusive) {
            if (value > number) {
                throw new IllegalArgumentException(getParamValueName(name) + " should be less than or equal to " + number);
            }
        } else {
            if (value >= number) {
                throw new IllegalArgumentException(getParamValueName(name) + " should be less than " + number);
            }
        }
    }

    /**
     * Checks whether the given value is in the specified range. And if this
     * condition is not met, the specified exception is thrown. Note: Don't
     * forget about "Floating-Point Accuracy/Comparison" problems when checking
     * floating point numbers. Inclusive comparison is recommended to be used
     * with integral types only.
     * 
     * Parameters: value - the value of parameter to be checked from - the start
     * value of the range to - the end value of the range fromInclusive - true
     * if start value is included into the range, false otherwise toInclusive -
     * true if end value is included into the range, false otherwise name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is out of the
     * specified range
     * 
     * Implementation Notes: Similar to ValidationUtility.checkInRange(value,
     * from, to, fromInclusive, toInclusive, getParamValueName(name),
     * IllegalArgumentException.class) call. Note: it's required to duplicate
     * source code here to increase the performance. Calling the specified
     * namesake method of ValidationUtility will decrease the performance a lot
     * since getParamValueName() will need to concatenate strings on each call.
     * In this method there is no need to use ExceptionHelper, create
     * IllegalArgumentException instance explicitly instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is out of the specified range
     * @param to
     *            the end value of the range
     * @param fromInclusive
     *            true if start value is included into the range, false
     *            otherwise
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     * @param toInclusive
     *            true if end value is included into the range, false otherwise
     * @param from
     *            the start value of the range
     */
    public static void checkInRange(double value, double from, double to,
            boolean fromInclusive, boolean toInclusive, String name) {
        boolean valid = true;
        if (fromInclusive) {
            valid = (value >= from);
        } else {
            valid = (value > from);
        }
        if (toInclusive) {
            valid = valid && (value <= to);
        } else {
            valid = valid && (value < to);
        }
        if (!valid) {
            String message = getParamValueName(name) + " should be in the range " + (fromInclusive ? "[" : "(") + from + ", " + to + (toInclusive ? "]" : ")");
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Checks whether the given value is negative. And if this condition is not
     * met, the specified exception is thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is not negative
     * 
     * Implementation Notes: Similar to ValidationUtility.checkNegative(value,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is not negative
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNegative(long value, String name) {
        if (value >= 0) {
            throw new IllegalArgumentException(getParamValueName(name) + " should be negative");
        }
    }

    /**
     * Checks whether the given value is positive. And if this condition is not
     * met, the specified exception is thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is not positive
     * 
     * Implementation Notes: Similar to ValidationUtility.checkPositive(value,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is not positive
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkPositive(long value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(getParamValueName(name) + " should be positive");
        }
    }

    /**
     * Checks whether the given value is not negative. And if this condition is
     * not met, the specified exception is thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is negative
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkNotNegative(value, getParamValueName(name),
     * IllegalArgumentException.class) call. Note: it's required to duplicate
     * source code here to increase the performance. Calling the specified
     * namesake method of ValidationUtility will decrease the performance a lot
     * since getParamValueName() will need to concatenate strings on each call.
     * In this method there is no need to use ExceptionHelper, create
     * IllegalArgumentException instance explicitly instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is negative
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNotNegative(long value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(getParamValueName(name) + " should be not negative");
        }
    }

    /**
     * Checks whether the given value is not positive. And if this condition is
     * not met, the specified exception is thrown.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is positive
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkNotPositive(value, getParamValueName(name),
     * IllegalArgumentException.class) call. Note: it's required to duplicate
     * source code here to increase the performance. Calling the specified
     * namesake method of ValidationUtility will decrease the performance a lot
     * since getParamValueName() will need to concatenate strings on each call.
     * In this method there is no need to use ExceptionHelper, create
     * IllegalArgumentException instance explicitly instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is positive
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNotPositive(long value, String name) {
        if (value > 0) {
            throw new IllegalArgumentException(getParamValueName(name) + " should be not positive");
        }
    }

    /**
     * Checks whether the given value is not equal to zero. And if this
     * condition is not met, the specified exception is thrown. Note: Don't
     * forget about "Floating-Point Accuracy/Comparison" problems when checking
     * floating point numbers.
     * 
     * Parameters: value - the value of parameter to be checked name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is equal to 0
     * 
     * Implementation Notes: Similar to ValidationUtility.checkNotZero(value,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is equal to 0
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     */
    public static void checkNotZero(long value, String name) {
        if (value == 0) {
            throw new IllegalArgumentException(getParamValueName(name) + " should not be equal to 0");
        }
    }

    /**
     * Checks whether the given value is greater than (greater than or equal to,
     * if inclusive is true) than the specified number. And if this condition is
     * not met, the specified exception is thrown. Note: Don't forget about
     * "Floating-Point Accuracy/Comparison" problems when checking floating
     * point numbers. Inclusive comparison is recommended to be used with
     * integral types only.
     * 
     * Parameters: value - the value of parameter to be checked number - the
     * number the value should be compared to inclusive - true if
     * "greater than or equal to" check should be performed, false if
     * "greater than" check should be performed name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given value is not greater than
     * (not greater than and not equal to, if inclusive is true) than the
     * specified number
     * 
     * Implementation Notes: Similar to
     * ValidationUtility.checkGreaterThan(value, number, inclusive,
     * getParamValueName(name), IllegalArgumentException.class) call. Note: it's
     * required to duplicate source code here to increase the performance.
     * Calling the specified namesake method of ValidationUtility will decrease
     * the performance a lot since getParamValueName() will need to concatenate
     * strings on each call. In this method there is no need to use
     * ExceptionHelper, create IllegalArgumentException instance explicitly
     * instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is not greater than (not greater than and
     *             not equal to, if inclusive is true) than the specified number
     * @param inclusive
     *            true if "greater than or equal to" check should be performed,
     *            false if "greater than" check should be performed
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     * @param number
     *            the number the value should be compared to
     */
    public static void checkGreaterThan(long value, long number,
            boolean inclusive, String name) {
        if (inclusive) {
            if (value < number) {
                throw new IllegalArgumentException(getParamValueName(name) + " should be greater than or equal to " + number);
            }
        } else {
            if (value <= number) {
                throw new IllegalArgumentException(getParamValueName(name) + " should be greater than " + number);
            }
        }
    }

    /**
     * Checks whether the given value is less than (less than or equal to, if
     * inclusive is true) than the specified number. And if this condition is
     * not met, the specified exception is thrown. Note: Don't forget about
     * "Floating-Point Accuracy/Comparison" problems when checking floating
     * point numbers. Inclusive comparison is recommended to be used with
     * integral types only.
     * 
     * Parameters: value - the value of parameter to be checked number - the
     * number the value should be compared to inclusive - true if
     * "less than or equal to" check should be performed, false if "less than"
     * check should be performed name - the parameter name
     * 
     * Throws: IllegalArgumentException if the given value is not less than (not
     * less than and not equal to, if inclusive is true) than the specified
     * number
     * 
     * Implementation Notes: Similar to ValidationUtility.checkLessThan(value,
     * number, inclusive, getParamValueName(name),
     * IllegalArgumentException.class) call. Note: it's required to duplicate
     * source code here to increase the performance. Calling the specified
     * namesake method of ValidationUtility will decrease the performance a lot
     * since getParamValueName() will need to concatenate strings on each call.
     * In this method there is no need to use ExceptionHelper, create
     * IllegalArgumentException instance explicitly instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is not less than (not less than and not
     *             equal to, if inclusive is true) than the specified number
     * @param inclusive
     *            true if "less than or equal to" check should be performed,
     *            false if "less than" check should be performed
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     * @param number
     *            the number the value should be compared to
     */
    public static void checkLessThan(long value, long number,
            boolean inclusive, String name) {
        if (inclusive) {
            if (value > number) {
                throw new IllegalArgumentException(getParamValueName(name) + " should be less than or equal to " + number);
            }
        } else {
            if (value >= number) {
                throw new IllegalArgumentException(getParamValueName(name) + " should be less than " + number);
            }
        }
    }

    /**
     * Checks whether the given value is in the specified range. And if this
     * condition is not met, the specified exception is thrown. Note: Don't
     * forget about "Floating-Point Accuracy/Comparison" problems when checking
     * floating point numbers. Inclusive comparison is recommended to be used
     * with integral types only.
     * 
     * Parameters: value - the value of parameter to be checked from - the start
     * value of the range to - the end value of the range fromInclusive - true
     * if start value is included into the range, false otherwise toInclusive -
     * true if end value is included into the range, false otherwise name - the
     * parameter name
     * 
     * Throws: IllegalArgumentException if the given value is out of the
     * specified range
     * 
     * Implementation Notes: Similar to ValidationUtility.checkInRange(value,
     * from, to, fromInclusive, toInclusive, getParamValueName(name),
     * IllegalArgumentException.class) call. Note: it's required to duplicate
     * source code here to increase the performance. Calling the specified
     * namesake method of ValidationUtility will decrease the performance a lot
     * since getParamValueName() will need to concatenate strings on each call.
     * In this method there is no need to use ExceptionHelper, create
     * IllegalArgumentException instance explicitly instead.
     * 
     * @throws IllegalArgumentException
     *             if the given value is out of the specified range
     * @param to
     *            the end value of the range
     * @param fromInclusive
     *            true if start value is included into the range, false
     *            otherwise
     * @param name
     *            the parameter name
     * @param value
     *            the value of parameter to be checked
     * @param toInclusive
     *            true if end value is included into the range, false otherwise
     * @param from
     *            the start value of the range
     */
    public static void checkInRange(long value, long from, long to,
            boolean fromInclusive, boolean toInclusive, String name) {
        boolean valid = true;
        if (fromInclusive) {
            valid = (value >= from);
        } else {
            valid = (value > from);
        }
        if (toInclusive) {
            valid = valid && (value <= to);
        } else {
            valid = valid && (value < to);
        }
        if (!valid) {
            String message = getParamValueName(name) + " should be in the range " + (fromInclusive ? "[" : "(") + from + ", " + to + (toInclusive ? "]" : ")");
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Retrieves the parameter value name from the specified parameter name.
     * 
     * Parameters: paramName - the parameter name
     * 
     * Returns: the constructed parameter value name
     * 
     * Implementation Notes: 1. Return "The '" + paramName + "' parameter".
     * 
     * @param paramName
     *            the parameter name
     * @return the constructed parameter value name
     */
    private static String getParamValueName(String paramName) {
        return "The '" + paramName + "' parameter";
    }
}
