package org.geon.study.board.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.study.board.model.Board;
import org.geon.study.board.service.StreamService;
import org.geon.study.common.exception.runtime.RuntimeExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@Api(tags = {"게시판"})
@RequiredArgsConstructor
@Log4j2
/*
    Controller는 View를 렌더링 하는 용도로 사용되고,
    RestController는 데이터를 반환하는 API 역할을 하는 용도로 사용된다.
    RestController는 @Controller와 @ResponseBody를 합친것과 같다.
    또한 모든 메소드에 @ResponseBody가 적용된다.
 */
public class BoardRestController {
    /*
        new 키워드를 사용하여 객체를 생성하고 인스턴스 메서드를 호출하는 경우와
        @Autowired 어노테이션을 사용하여 컴포넌트를 주입받고
        인스턴스 메서드를 호출하는 경우 모두 객체가 메모리에 할당되고 메서드가 호출된다.

        하지만 new 키워드를 사용하여 객체를 생성하는 경우,
        해당 객체의 생명 주기와 관련하여 명시적인 관리가 필요하다.
        객체를 생성한 코드 블록이 끝나면 해당 객체는 더 이상 참조되지 않고 메모리에서 해제되어야 한다.

        이와 달리 Spring에서 @Autowired 어노테이션을 사용하여 컴포넌트를 주입받는 경우,
        Spring 컨테이너가 객체의 생명 주기를 관리하므로 명시적인 관리가 필요하지 않다.

        따라서, new 키워드를 사용하여 객체를 생성하고 인스턴스 메서드를 호출하는 경우와
        @Autowired 어노테이션을 사용하여 컴포넌트를 주입받고 인스턴스 메서드를 호출하는 경우
        모두 메모리 사용량 측면에서 큰 차이가 없다.

        다만, Spring의 DI 기능을 사용하여 컴포넌트를 주입받는 경우,
        객체의 생명 주기를 명시적으로 관리하지 않아도 되므로,
        코드의 간결성과 유지보수성이 향상될 수 있다.
     */
    private final StreamService service;

    @GetMapping("")
    @ApiOperation(value = "Hello World", response = Board.class)
    public ResponseEntity<String> getHelloWorld() {
        return new ResponseEntity<>("HELLO WORLD", HttpStatus.OK);
    }

    @GetMapping("aop-test")
    @ApiOperation(value = "AOP TEST")
    public ResponseEntity<String> aopTest() {
        log.info("aopTest.........");
        service.aopTest();
        return new ResponseEntity<>("TEST...", HttpStatus.OK);
    }

    @GetMapping(value = {"board", "board/{menu}/{userinput}"})
    @ApiOperation(value = "GET BOARD", response = Board.class)
    public ResponseEntity<?> getBoardList(@PathVariable(required = false, value = "menu")
                                                            Integer menu,
                                                    @PathVariable(required = false, value = "userinput")
                                                            String userInput) {
        // 이곳에 try catch를 하지 않아도 @RestControllerAdvice(RestControllerErrorResponse.class)가
        // 에러를 직접 Intercept해서 에러를 return한다.
        try {
            log.info(userInput);
            log.info(menu);
            if (userInput != null && !userInput.isEmpty()) {
                List<Board> searchList = service.searchList(menu, userInput);
                log.info("search.........");
                return ResponseEntity.ok(searchList);
            } else {
                List<Board> boardList = service.getList();
                log.info("getList.........");
                return ResponseEntity.ok(boardList);
            }
        } catch (RuntimeExceptionHandler ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("요청한 자료를 찾을 수 없습니다.");
        }
    }
}
