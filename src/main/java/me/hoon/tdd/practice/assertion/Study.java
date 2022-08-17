package me.hoon.tdd.practice.assertion;

public class Study {

    private StudyStatus studyStatus = StudyStatus.DRAFT;

    private int limit;

    private String name;

    public Study(int limit) {
        if ( limit < 0) {
            throw new IllegalArgumentException("0보다 작을 수 없습니다.");
        }

        this.limit = limit;
    }

    public Study(int limit, String name) {
        if ( limit < 0) {
            throw new IllegalArgumentException("0보다 작을 수 없습니다.");
        }

        if ( name == null & "".equals(name)) {
            throw new IllegalArgumentException("0보다 작을 수 없습니다.");
        }

        this.limit = limit;
        this.name = name;
    }

    public StudyStatus getStatus() {
        return this.studyStatus;
    }

    public int getLimit() {
        return this.limit;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Study{" +
                "studyStatus=" + studyStatus +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }
}
