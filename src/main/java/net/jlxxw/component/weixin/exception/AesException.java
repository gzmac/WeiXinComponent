package net.jlxxw.component.weixin.exception;

import net.jlxxw.component.weixin.enums.AesExceptionEnum;

import java.util.Objects;

/**
 * 微信加解密异常
 *
 * @author lcy
 */
@SuppressWarnings("serial")
public class AesException extends Exception {


    private int code;

    public int getCode() {
        return code;
    }



    public AesException(AesExceptionEnum exceptionEnum,Exception e) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
        if(Objects.nonNull(e)){
            e.printStackTrace();
        }
    }


    public AesException(AesExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }
}
