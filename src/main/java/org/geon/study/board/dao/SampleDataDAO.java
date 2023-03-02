package org.geon.study.board.dao;

import lombok.extern.log4j.Log4j2;
import org.geon.study.board.model.Board;
import org.geon.study.common.exception.runtime.RuntimeExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Log4j2
public class SampleDataDAO {

    private final String path = "src/main/resources/org/geon/study/board/dao";

    public Optional<List<String>> getSampleList() {
        List<String> sampleList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path + "/SampleData.txt"));

            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                sampleList.add(str);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Optional<List<String>> optionalList = Optional.ofNullable(sampleList);
        return optionalList;
    }

    public int insertData(Board board) {
        String insertData = board.boardToString(board);
        try {
            FileWriter writer = new FileWriter(path + "/SampleData.txt", true);
            writer.write(insertData);
            writer.close();
            return 1;
        } catch (FileNotFoundException fnfe) {
            throw new RuntimeExceptionHandler("File Not Found", HttpStatus.NOT_FOUND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new RuntimeExceptionHandler("Fail Registration", HttpStatus.BAD_REQUEST);
        }
    }

    public Long getLastBno(Optional<List<String>> optionalList) {
        List<Long> bnoList = optionalList.orElse(Collections.emptyList())
                .stream()
                .flatMap(str -> Arrays.stream(str.split("\n")))
                .map(str -> Long.parseLong(str.split(",")[0]))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        if (bnoList.isEmpty()) {
            throw new IllegalStateException("The list is empty");
        }

        return bnoList.get(0);
    }
}
