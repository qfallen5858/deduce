package com.kanq.deduce.web.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import static com.kanq.deduce.common.enums.CodeEnum.FAILED;

import com.kanq.deduce.common.enums.CodeEnum;
@Data
@EqualsAndHashCode(callSuper = true)
public class KanqException extends RuntimeException {
    private Integer code;

    public KanqException(){
        super();
    }

    public KanqException(String message){
        super(message);
        this.setCode(FAILED.getCode());
    }

    public KanqException(CodeEnum codeEnum){
        super(codeEnum.getMessage());
        this.setCode(codeEnum.getCode());
    }

    public KanqException(String message, Throwable cause){
        super(message, cause);
        this.setCode(FAILED.getCode());
    }

    public KanqException(String message, Integer code){
        super(message);
        this.setCode(code);
    }
}
