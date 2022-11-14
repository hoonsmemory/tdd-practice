package me.hoon.tdd.nextstep.before.baseball;

public class ResultView {

    protected void getResult(int strike, int ball) {

        StringBuilder sb = new StringBuilder();

        if(strike == 0 && ball == 0) {
            sb.append("낫싱");
            System.out.println(sb.toString());
            return;
        }

        if(ball > 0) {
            sb.append(ball);
            sb.append("볼 ");
        }

        if(strike > 0) {
            sb.append(strike);
            sb.append("스트라이크");
        }
        System.out.println(sb.toString());
    }

}
