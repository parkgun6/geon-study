package dao;

import org.junit.jupiter.api.Test;

public class DAOTests {

    private SampleData sampleData = new SampleData();

    @Test
    public void dataReadTest() {
        sampleData.sampleBoard();

    }
}
