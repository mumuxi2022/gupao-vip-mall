package com.jt.mallcommon.exception;

import com.jt.mallcommon.api.IErrorCode;

/**
 * @author 帅气的景天老师
 * @create 2022/9/9 11:34
 * 断言处理类，用于抛出各种API异常
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}

