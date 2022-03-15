package com.ripper.budding.exception;

import com.ripper.budding.constant.IStatus;

import java.io.IOException;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2022-01-13
 * @Description:com.ripper.budding.exception
 * @Version:1.0
 **/


public class MessageException extends IOException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int status;

    public MessageException(IStatus status) {
        super(status.getDescription());
        this.status = status.getValue();

    }

    public MessageException(IStatus status, String message) {
        super(message);
        this.status = status.getValue();

    }

    public MessageException(String message) {
        super(message);
    }

    public int getStatus() {
        return status;
    }
}
