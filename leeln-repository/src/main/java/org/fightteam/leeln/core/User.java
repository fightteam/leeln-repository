package org.fightteam.leeln.core;

/**
 * 用户基础类
 *
 * @author oyach
 * @since 0.0.1
 */
public class User {
    /**
     * 主键
     */
    private long id;

    private String username;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
