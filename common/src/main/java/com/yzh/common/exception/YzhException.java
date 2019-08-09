package com.yzh.common.exception;

import com.yzh.common.Enum.YzhEnum;
import lombok.Data;

/**
 * @author yzh
 * @date 2019/8/8
 */
@Data
public class YzhException extends RuntimeException {
    private int status;

    public YzhException(YzhEnum e) {
        super(e.getMsg());
        this.status = e.getValue();
    }

    public YzhException(YzhEnum e, Throwable cause) {
        super(e.getMsg(), cause);
        this.status = e.getValue();
    }


}
