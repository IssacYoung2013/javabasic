package com.interview.javabasic.throwable;

import java.io.FileNotFoundException;

/**
 *
 * author:  ywy
 * date:    2019-02-20
 * desc:
 */
public class ErrorAndException {
    private void throwError() {
        throw new StackOverflowError();
    }
    private void throwRuntimeException() {
        throw new RuntimeException();
    }
    private void throwCheckedException()throws FileNotFoundException {
        // 可检查的异常
//        try {
            throw new FileNotFoundException();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ErrorAndException eae=  new ErrorAndException();
        //eae.throwError();
        //eae.throwRuntimeException();
        eae.throwCheckedException();
    }

}
