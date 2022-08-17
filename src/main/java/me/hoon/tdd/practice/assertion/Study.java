package me.hoon.tdd.practice.assertion;

public class Study {

    private StudyStatus studyStatus = StudyStatus.DRAFT;

    private int limit;

    public Study(int limit) {
        if ( limit > 0) {
            throw new IllegalArgumentException("0보다 작을 수 없습니다.");
        }

        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return this.studyStatus;
    }

    public int getLimit() {
        return 0;
    }
}
