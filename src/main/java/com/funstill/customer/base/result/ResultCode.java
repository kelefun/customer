package com.funstill.customer.base.result;

import java.io.Serializable;

public interface ResultCode extends Serializable {

    public int getCode();

    public String getMsg();
}
