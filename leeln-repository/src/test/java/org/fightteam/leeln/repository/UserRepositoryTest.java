package org.fightteam.leeln.repository;

import org.fightteam.leeln.core.User;
import org.fightteam.leeln.test.RepositoryConfigTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * description
 *
 * @author oych
 * @since 0.0.1
 */
public class UserRepositoryTest extends RepositoryConfigTest {


    @Autowired
    private UserRepository userRepository;


    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setUsername("faith");
        user.setNickname("欧阳澄泓");
        userRepository.save(user);
        Assert.assertEquals(2L, user.getId());

    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("oyach2");
        userRepository.update(user);

        User result = userRepository.findByUsername("oyach2");
        Assert.assertEquals(1L, result.getId());
    }

    @Test
    public void testFindOne() throws Exception {
        User user = userRepository.findByUsername("oyach");
        Assert.assertEquals(1L, user.getId());
    }

    @Test
    public void testDelete() throws Exception {
        userRepository.delete(1L);
        User user = userRepository.findByUsername("oyach");
        Assert.assertNull(user);
    }


    @Test
    public void testFindByNickname() throws Exception {
        User user = new User();
        user.setUsername("oyach2");
        user.setNickname("欧阳澄泓");
        userRepository.save(user);

        List<User> results = userRepository.findByNickname("欧阳澄泓");

        Assert.assertEquals(2, results.size());

    }

    @Test
    public void testFindAll() throws Exception {

        User user = new User();
        user.setUsername("oyach2");
        user.setNickname("欧阳澄泓");
        userRepository.save(user);
        List<User> users = userRepository.findAll();
        Assert.assertEquals(2, users.size());

    }
}
