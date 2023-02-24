package dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SampleData {

    public List<String> sampleBoard() {
        List<String> sampleList = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File("D:\\study\\stream\\src\\main\\java\\dao\\SampleData.txt"));

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
