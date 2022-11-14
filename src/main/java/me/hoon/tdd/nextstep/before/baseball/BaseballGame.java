package me.hoon.tdd.nextstep.before.baseball;

public class BaseballGame {

    public int[] draw3Numbers() {
        int[] numbers = {1, 1, 1};

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 9) + 1;

            for(int j = 0; j < i; j++) {
                if(numbers[i] == numbers[j] && (i != j)) {
                    i--;
                }
            }
        }
        return numbers;
    }

    public void play(int[] randomNum) {
        boolean isFail = true;
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        while(isFail) {
            int[] inputNum = inputView.input();
            int strike = 0;
            int ball = 0;

            for(int i = 0; i < inputNum.length; i++) {
                strike += getStrikeOrBall(randomNum[i], inputNum[i]);

                for(int j = 0; j < inputNum.length; j++) {
                    if(i != j) {
                        ball += getStrikeOrBall(randomNum[i], inputNum[j]);
                    }
                }
            }

            resultView.getResult(strike, ball);

            if(strike == ConstantParams.INPUT_NUMBER) {
                isFail = false;
            }
        }
    }

    private int getStrikeOrBall(int randomNum, int inputNum) {
        int strikeOrBall = 1;
        int nothing = 0;

        if(randomNum == inputNum) {
            return strikeOrBall;
        }

        return nothing;
    }

}
