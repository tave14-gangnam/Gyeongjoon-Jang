package com.tave.gangnam.week3.assigment.exception;

public class BankAlreadyExistsException extends RuntimeException {
    public BankAlreadyExistsException(String message) {
        super(message); // 상위 클래스인 RuntimeException의 생성자를 호출
    }
    /**
     * 예외 처리
     * 1. Checked Exception: 반드시 처리해야 하는 예외. (컴파일 타임에 강제됨) - Exception 상속
     * 2. Unchecked Exception (RuntimeException): 개발자가 직접 처리하지 않아도 되며, 런타임 시에 발생. - RuntimeException 상속
     */
}

