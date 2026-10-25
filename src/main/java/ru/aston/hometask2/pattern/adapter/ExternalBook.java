package ru.aston.hometask2.pattern.adapter;

public class ExternalBook {
    public String name;
    public String writer;
    public int pageCount;
    public int publishYear;

    public ExternalBook(String name, String writer, int pageCount, int publishYear) {
        this.name = name;
        this.writer = writer;
        this.pageCount = pageCount;
        this.publishYear = publishYear;
    }
}