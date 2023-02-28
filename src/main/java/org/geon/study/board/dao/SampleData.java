package org.geon.study.board.dao;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class SampleData {

    private final String path = "D:\\study\\study\\src\\main\\java\\org\\geon\\study\\board\\dao";

    public List<String> sampleBoard() {
        List<String> sampleList = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File(path+"\\SampleData.txt"));

            while (scanner.hasNext()){
                String str = scanner.nextLine();
                sampleList.add(str);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return sampleList;
    }
}
