package org.geon.study.model;

import org.geon.study.board.model.UserRole;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

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
}
