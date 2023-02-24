package service;

import dao.SampleData;
import model.Board;
import model.UserRole;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamService {
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

    private final SampleData sampleData = new SampleData();

    public List<Board> getList() {
        List<Board> boardList = resultData(sampleData.sampleBoard());
        // ASC
        List<Board> sortedList = boardList.stream().sorted(Comparator.comparing(Board::getBno)).collect(Collectors.toList());
        // DESC
        // List<Board> sortedList = returnList.stream().sorted(Comparator.comparing(Board::getBno).reversed()).collect(Collectors.toList());
        return sortedList;
    }

    public List<Board> searchList(int menu, String userInput) {
        List<Board> boardList = resultData(sampleData.sampleBoard());

        Map<Integer, Predicate<Board>> filterMap = new HashMap<>();
        filterMap.put(1, board -> board.getBno().equals(Long.parseLong(userInput)));
        filterMap.put(2, board -> board.getTitle().contains(userInput));
        filterMap.put(3, board -> board.getContent().contains(userInput));
        filterMap.put(4, board -> board.getNickname().contains(userInput));
        filterMap.put(5, board -> board.getRole().toString().contains(userInput.toUpperCase()));

        Predicate<Board> filter = filterMap.getOrDefault(menu, board -> false);

        return boardList.stream().filter(filter).collect(Collectors.toList());
    }

    private List<Board> resultData(List<String> originList) {
        return originList.stream().map(this::parseBoard).collect(Collectors.toList());
    }

    private Board parseBoard(String data) {
        String[] dataList = data.split(",");
        if (dataList.length < 8) {
            throw new IllegalArgumentException("Invalid board data: " + data);
        }
        return Board.builder()
                .bno(Long.parseLong(dataList[0]))
                .title(dataList[1])
                .content(dataList[2])
                .username(dataList[3])
                .nickname(dataList[4])
                .regDate(dataList[5])
                .modDate(dataList[6])
                .role(UserRole.findByUserRole(dataList[7]))
                .build();
    }
}
