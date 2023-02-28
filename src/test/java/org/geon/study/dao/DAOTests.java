package org.geon.study.dao;

import lombok.extern.log4j.Log4j2;
import org.geon.study.board.dao.SampleData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Log4j2
public class DAOTests {

    @Autowired
    SampleData sampleData;

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
}
