package org.geon.study.model;

import lombok.extern.log4j.Log4j2;
import org.geon.study.board.model.UserRole;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@Log4j2
public class UserRoleTests {

    @Test
    public void findRoleTest() {
//        System.out.println(UserRole.findByUserRole("3"));
        String[] test = new String[3];
        test[0] = "2";
        test[1] = "4";
        test[2] = "3";

        Stream.of(test).forEach(res ->
                System.out.println(UserRole.findByUserRole(res))
        );
        System.out.println(UserRole.findByUserRole(String.valueOf(new Random().nextInt(4) + 1)));
    }

    @Test
    public void roleToValueTest() {
        String[] test = new String[3];
        test[0] = "ADMIN";
        test[1] = "GUEST";
        test[2] = "MANAGER";

        Stream.of(test).forEach(res ->
                System.out.println(UserRole.parseValue(res))
        );
    }

    @Test
    public void userRoleConstTest() {
        boolean isPresent = Arrays.stream(UserRole.values()).filter(res -> res.equals("1")).findAny().isPresent();
        System.out.println(isPresent);
    }

    @Test
    public void roleEqualTest() {
//        UserRole userRole = UserRole.of("3");
//        System.out.println(userRole.getRole());
    }

    @Test
    public void timeTest() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        log.info(dateFormat.format(date));
    }
}
