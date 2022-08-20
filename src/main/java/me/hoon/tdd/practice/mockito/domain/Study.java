package me.hoon.tdd.practice.mockito.domain;

import java.util.Optional;

public class Study {

    private Member owner;

    private int limit;
    private String name;

    public Study(int limit, String name) {
        this.limit = limit;
        this.name = name;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }

}
