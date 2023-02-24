package service;

import org.junit.jupiter.api.Test;

public class ServiceTests {

    private StreamService service = new StreamService();

    @Test
    public void getList() {
        service.getList();
    }

    @Test
    public void searchTest() {
        String containValue = "abcdefg hijk";

        System.out.println(containValue.contains("a"));
    }

    @Test
    public void searchTest2() {
//        service.searchList(1, "박건");
    }

    @Test
    public void searchTest3() {
//        Object test = service.searchList2("model.Board", 2, "제목");
//        System.out.println(test);
    }
}
