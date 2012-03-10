package com.ooobgy.comm.util;

import java.lang.reflect.InvocationTargetException;

/**
 * This is a static helper class that provides methods for constructing
 * exception instances using reflection. It is used by ValidationUtility,
 * PropertiesUtility.
 * 
 * Thread Safety: This class is immutable and thread safe when array parameters
 * passed to it are used by the caller in thread safe manner.
 * 
 * @author frogcherry 周晓龙 frogcherry@gmail.com
 * @version 1.0.0
 * @since 1.0.0
 */
public class ExceptionHelper {
    /**
     * Empty private constructor.
     * 
     * Implementation Notes: Do nothing.
     */
    private ExceptionHelper() {
    }

    /**
     * Constructs an exception of the specified type with the given message.
     * 
     * Generic Parameters: T - the type of the exception to be created
     * 
     * Parameters: exceptionClass - the exception class message - the message
     * 
     * Returns: the constructed exception instance (not null)
     * 
     * 
     * Implementation Notes: 1. Constructor<T> constructor =
     * exceptionClass.getConstructor(String.class); 2. T result =
     * constructor.newInstance(message); 3. Return result.
     * 
     * 由于这是包内私有工具方法，该方法忽略一切由反射可能引起的异常，正确性由作者保证
     * 
     * @param message
     *            the message
     * @param exceptionClass
     *            the exception class
     * @return the constructed exception instance (not null)
     */
    public static <T extends Throwable> T constructException(
            Class<T> exceptionClass, String message) {
        try {
            return exceptionClass.getConstructor(String.class).newInstance(
                    message);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Constructs an exception of the specified type with the given message and
     * cause.
     * 
     * Generic Parameters: T - the type of the exception to be created
     * 
     * Parameters: exceptionClass - the exception class message - the message
     * cause - the exception cause
     * 
     * Returns: the constructed exception instance (not null)
     * 
     * 
     * Implementation Notes: 1. Constructor<T> constructor =
     * exceptionClass.getConstructor(String.class, Throwable.class); 2. T result
     * = constructor.newInstance(message, cause); 3. Return result.
     * 
     * Note: exceptions are populated without wrapping in this method.
     * 
     * 由于这是包内私有工具方法，该方法忽略一切由反射可能引起的异常，正确性由作者保证
     * @param message
     *            the message
     * @param cause
     *            the exception cause
     * @param exceptionClass
     *            the exception class
     * @return the constructed exception instance (not null)
     */
    public static <T extends Throwable> T constructException(
            Class<T> exceptionClass, String message, Throwable cause) {
        try {
            return exceptionClass.getConstructor(String.class).newInstance(message);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
