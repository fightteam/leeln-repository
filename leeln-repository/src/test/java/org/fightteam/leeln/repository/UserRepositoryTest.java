package org.fightteam.leeln.repository;

import org.fightteam.leeln.core.User;
import org.fightteam.leeln.test.RepositoryConfigTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description
 *
 * @author oych
 * @since 0.0.1
 */
public class UserRepositoryTest extends RepositoryConfigTest {


    @Autowired
    private UserRepository userRepository;


    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setUsername("oyach");
        userRepository.save(user);

    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setUsername("faith");
        userRepository.save(user);
        Assert.assertEquals(2L, user.getId());

    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("oyach2");
        userRepository.update(user);

        User result = userRepository.findOne("oyach2");
        Assert.assertEquals(1L, result.getId());
    }

    @Test
    public void testFindOne() throws Exception {
        User user = userRepository.findOne("oyach");
        Assert.assertEquals(1L, user.getId());
    }

    @Test
    public void testDelete() throws Exception {
        userRepository.delete(1);
        User user = userRepository.findOne("oyach");
        Assert.assertNull(user);
    }
}
