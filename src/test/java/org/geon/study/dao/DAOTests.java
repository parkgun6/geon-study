package org.geon.study.dao;

import org.geon.study.board.dao.SampleData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DAOTests {

    @Autowired
    private SampleData sampleData;

    @Test
    public void dataReadTest() {
        sampleData.sampleBoard();

    }
}
