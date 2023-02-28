package org.geon.study.common.exception.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
// @AllArgsConstructor는 모든 필드에 대해 인자를 받는 생성자를 만들어준다.
// 즉, 모든 필드에 대한 매개변수가 있는 생성자를 자동으로 만들어주는 것이다.
@AllArgsConstructor
// @NoArgsConstructor는 인자를 받지 않는 기본 생성자를 만들어준다.
// 이 생성자는 클래스를 초기화할 때 사용된다.
@NoArgsConstructor
@ToString
public class ErrorResponse {

    private int status;
    private String errorMsg;
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String errorMsg) {
        this.status = status;
        this.errorMsg = errorMsg;
        this.timestamp = LocalDateTime.now();
    }
}
