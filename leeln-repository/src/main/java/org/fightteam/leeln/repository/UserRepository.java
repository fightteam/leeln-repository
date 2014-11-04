package org.fightteam.leeln.repository;

import org.apache.ibatis.annotations.*;
import org.fightteam.leeln.core.User;

/**
 * 用户数据对外接口
 *
 * @author oyach
 * @since 0.0.1
 */
public interface UserRepository {

    @Select("select * from user where username = #{username}")
    @Options(useCache = true, flushCache = true)
    User findOne(@Param("username") String username);

    @Insert("insert into user (username) values(#{username})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(User user);

    @Update("update user set id = #{id}, username = #{username}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    void delete(int id);
}
