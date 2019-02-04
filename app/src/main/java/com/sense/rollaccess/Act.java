package com.sense.rollaccess;

/**
 * Created by m2270073 on 2019/01/31.
 */

public class Act {
    private long id = 0;
    private String actor, act, val, dice_num, dice_type, collect, success;

    public Act(long id, String actor, String act, String val, String dice_num, String dice_type, String collect, String success) {
        this.id = id;
        this.actor = actor;
        this.act = act;
        this.val = val;
        this.dice_num = dice_num;
        this.dice_type = dice_type;
        this.collect = collect;
        this.success = success;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String cal) {
        this.val = cal;
    }

    public String getDice_num() {
        return dice_num;
    }

    public void setDice_num(String dice_num) {
        this.dice_num = dice_num;
    }

    public String getDice_type() {
        return dice_type;
    }

    public void setDice_type(String dice_type) {
        this.dice_type = dice_type;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
