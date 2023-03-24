package org.geon.study.board.dao;

import lombok.extern.log4j.Log4j2;
import org.geon.study.board.dto.Board;
import org.geon.study.board.dto.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.LongStream;

@Log4j2
@SpringBootTest
public class DAOTests {

    @Autowired
    SampleDataDAO sampleDataDAO;

    @Test
    public void filePathTest() {
        log.info(new File("src/main/resources/org/geon/study/board/dao/DAOTests.java"));
        log.info(sampleDataDAO.getSampleList().get());
    }

    @Test
    public void readFileTest() {
        String path = "D:\\study\\src\\main\\java\\org\\geon\\study\\board\\dao";
        List<String> sampleList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path + "\\SampleData.txt"));

            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                sampleList.add(str);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        log.info(sampleList.toString());
    }

    @Test
    public void dataReadTest() {
//        sampleData.sampleBoard();

    }

//    @Test
//    public void getFinalBnoTest() {
//        Long lastBno = sampleDataDAO.getLastBno(sampleDataDAO.getSampleList());
//        log.info(lastBno);
//    }

//    @Test
//    public void insertTest() {
//        Long lastBno = 1 + sampleDataDAO.getLastBno(sampleDataDAO.getSampleList());
//        Board board = Board.builder()
//                .bno(lastBno)
//                .title("제목" + lastBno)
//                .content("등록테스트" + lastBno)
//                .username("tester1")
//                .nickname("테스터12")
//                .regDate(new Date().toString())
//                .modDate(new Date().toString())
//                .role(UserRole.findByUserRole(String.valueOf(new Random().nextInt(4) + 1)))
//                .build();
//        sampleDataDAO.insertData(board);
//    }

    @Test
    public void insertLoopTest() {
        LongStream.rangeClosed(35,200).forEach(res -> {
            Board board = Board.builder()
                    .bno(res)
                    .title("제목" + res)
                    .content("등록테스트" + res)
                    .username("tester"+res)
                    .nickname("테스터12"+res)
                    .regDate(new Date().toString())
                    .modDate(new Date().toString())
                    // 1~4의 랜덤한 숫자
                    .role(UserRole.findByUserRole(String.valueOf(new Random().nextInt(4) + 1)))
                    .build();
            sampleDataDAO.insertData(board);
        });
    }

    @Test
    public void pagingTest() {

    }
}
