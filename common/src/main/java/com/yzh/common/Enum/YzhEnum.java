package com.yzh.common.Enum;


/**
 * @author yzh
 * @date 2019/8/8
 */
public enum YzhEnum {
    USER_EXIST(400, "用户已存在"),
    COMMON_ERROR(0, "") {
        @Override
        public YzhEnum build(int status, String msg) {
            this.status = status;
            this.msg = msg;
            return this;
        }
    },;
    protected int status;
    protected String msg;

    YzhEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getValue() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public YzhEnum build(int status, String msg) {
        return this;
    }
}
