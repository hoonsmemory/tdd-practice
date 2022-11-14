package me.hoon.tdd.nextstep.before.baseball;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);


    public int[] input() {

        boolean isFail = true;
        String num = "";

        while(isFail) {
            System.out.print("숫자를 입력해 주세요 : ");
            num = scanner.nextLine();

            if(num.length() == ConstantParams.INPUT_NUMBER) {
                isFail = false;
            }
        }

        int[] inputs = new int[ConstantParams.INPUT_NUMBER];

        for (int i = 0; i < ConstantParams.INPUT_NUMBER; i++) {
            inputs[i] = Character.getNumericValue(num.charAt(i));
        }

        return inputs;
    }
}
