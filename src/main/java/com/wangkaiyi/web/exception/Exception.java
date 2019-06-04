package com.wangkaiyi.web.exception;

import com.wangkaiyi.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Exception extends RuntimeException {
    private ExceptionEnum exceptionEnum;

}
