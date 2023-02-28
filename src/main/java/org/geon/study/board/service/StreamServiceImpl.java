package org.geon.study.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.study.board.dao.SampleData;
import org.geon.study.board.model.Board;
import org.geon.study.common.exception.runtime.RuntimeExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class StreamServiceImpl implements StreamService {
    /*
     Stream   -> 람다식으로 요소처리 코드를 제공한다.
              -> 내부 반복자를 사용하므로 벙렬 처리가 쉽다.
              -> 스트림은 중간 처리와 최종 처리를 할 수 있다.
     */
    // filter   -> Predicate가 true를 리턴하는 요소만 filtering 한다.
    // map      -> 요소를 대체하는 요소로 구성된 새로운 Stream을 리턴한다.
    // sorted   -> 객체를 Comparable 구현 방법에 따라 정렬한다.
    // forEach  -> 요소 전체를 반복한다. ( 최종처리 메소드 )
    // collect  -> 필요한 요소만 Collection으로 담고, 요소들을 grouping 할 수 있다.

    private final SampleData sampleData;

    @Override
    public String aopTest() {
        return "aopTest.................";
    }

    @Override
    public List<Board> getList() {
        Optional<List<Board>> optBoardList = resultData(sampleData.sampleBoard());
        // ASC
        log.info(optBoardList.isPresent());
        if (optBoardList.isPresent()) {
            return optBoardList.get().stream()
                    .sorted(Comparator.comparing(Board::getBno))
                    .collect(Collectors.toList());
        } else {
            // 결과가 존재하지 않을 경우 404 NOT_FOUND 상태 코드를 반환하는 것은 RESTful API 설계의 일반적인 패턴이다.
            log.info("No Data.........");
            throw new RuntimeExceptionHandler("Result Not Found", HttpStatus.NOT_FOUND);
//            return optBoardList.orElseGet(ArrayList::new);
        }
        // DESC
        // List<Board> sortedList = returnList.stream().sorted(Comparator.comparing(Board::getBno).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<Board> searchList(int menu, String userInput) {
        Optional<List<Board>> optBoardList = resultData(sampleData.sampleBoard());
        Map<Integer, Predicate<Board>> filterMap = new HashMap<>();
        filterMap.put(1, board -> board.getBno().equals(Long.parseLong(userInput)));
        filterMap.put(2, board -> board.getTitle().contains(userInput));
        filterMap.put(3, board -> board.getContent().contains(userInput));
        filterMap.put(4, board -> board.getNickname().contains(userInput));
        filterMap.put(5, board -> board.getRole().toString().contains(userInput.toUpperCase()));

        Predicate<Board> filter = filterMap.getOrDefault(menu, board -> false);
        List<Board> searchList = optBoardList.get().stream().filter(filter).collect(Collectors.toList());
        if (!searchList.isEmpty()) {
            return searchList;
        } else {
            log.info("No Data.........");
            throw new RuntimeExceptionHandler("Result Not Found", HttpStatus.NOT_FOUND);
        }
    }


}
