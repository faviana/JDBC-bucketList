package com.ironyard.data;

/**
 * Created by favianalopez on 9/22/16.
 */
public class Bucket {

    private String where;
    private String when;
    private String howMuch;
    private long id;

    public Bucket(String where, String when, String howMuch, long id) {
        this.where = where;
        this.when = when;
        this.howMuch = howMuch;
        this.id = id;

    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getHowMuch() {
        return howMuch;
    }

    public void setHowMuch(String howMuch) {
        this.howMuch = howMuch;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
