package org.geon.study.common.util;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public class ConvertUtil {

    /*
        static 메서드는 객체가 생성되기 전에 클래스가 메모리에 로딩될 때
        메모리에 올라가기 때문에 객체 생성과는 무관하게 호출할 수 있다.
        따라서 static 메서드는 객체를 생성하지 않고도 호출할 수 있기 때문에,
        인스턴스 메서드보다는 메모리 사용량이 적다.

        그러나, @Component 어노테이션을 사용하여 클래스를 빈으로 등록하는 경우에는
        해당 클래스가 스프링 컨텍스트에 빈으로 등록된다.
        따라서 불필요한 클래스까지 빈으로 등록하는 것은 메모리 사용량을 증가시키고,
        어플리케이션의 성능에 영향을 미칠 수 있다.

        만약 Util 클래스의 메서드를 다른 클래스에서 사용하고 싶다면,
        해당 클래스에서 Util 클래스의 정적 메서드를 직접 호출하는 것이
        메모리 사용량 측면에서 더 효율적이다.
        이렇게 함으로써, 불필요한 클래스를 빈으로 등록하는 것을 방지할 수 있고,
        어플리케이션의 성능을 개선할 수 있다.
     */
    public static <T> Optional<List<T>> arrayToOptionalList(List<T> list) {
        return Optional.ofNullable(list);
    }
}
