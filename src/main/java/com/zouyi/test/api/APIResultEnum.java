package com.zouyi.test.api;

public enum APIResultEnum {
    /**
     * 枚举类型
     */

    SUCCESS(1, "成功"),
    UNKOWM_ERROR(-1, "未知错误"),
    FWK_DUPLICATEKEY(-2, "该记录已经存在"),
    VALID_FAIL(-3, "参数验证失败[{0}]"),
    POINT_FNULL(-4, "空指针异常"),
    NOT_FOUND(-5,"NOT FOUND");



    private Integer code;
    private String msg;

    APIResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
