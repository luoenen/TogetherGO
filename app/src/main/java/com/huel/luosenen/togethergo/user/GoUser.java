package com.huel.luosenen.togethergo.user;

import cn.bmob.v3.BmobUser;

public class GoUser extends BmobUser {

    private String nick;
    private String University;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }
}
