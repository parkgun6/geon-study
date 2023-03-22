package org.geon.study.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PairReturnTypeUtil<T, U> {
    private T firstReturnType;
    private U secondReturnType;
}
