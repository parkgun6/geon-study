package org.geon.study.board.ui;

import lombok.RequiredArgsConstructor;
import org.geon.study.board.model.Board;
import org.geon.study.board.service.StreamServiceImpl;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class MainUI {

    private static final Scanner scanner = new Scanner(System.in);

    private final StreamServiceImpl service;

    public void main() {
        // 재귀호출은 지양한다.
        selectMenu();
    }

    private void selectMenu() {
        while (true) {
            System.out.println("1. 목록조회\n2. 검색");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    showList();
                    return;
                case 2:
                    selectSearchOption();
                    return;
                default:
                    System.out.println("정확한 번호를 입력해주세요.");
                    break;
            }
        }
    }

    private void selectSearchOption() {
        while (true) {
            System.out.println("1. 게시글번호\n2. 제목\n3. 내용\n4. 글쓴이\n5. 권한\n6. 이전");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    search(option);
                    return;
                case 6:
                    selectMenu();
                    return;
                default:
                    System.out.println("다시 입력해주세요.");
                    break;
            }
        }
    }

    private void search(int option) {
        System.out.println("검색할 내용을 입력해주세요.");
        String userInput = scanner.next();

        try {
            List<Board> resultList = service.searchList(option, userInput);
            if (resultList.isEmpty()) {
                System.out.println("검색된 내용이 없습니다.");
            } else {
                resultList.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showList() {
        List<Board> boardList = service.getList();
        boardList.forEach(System.out::println);
    }
}
