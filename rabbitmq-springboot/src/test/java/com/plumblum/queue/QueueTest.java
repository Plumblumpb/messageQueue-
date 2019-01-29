package com.plumblum.queue;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: cpb
 * @Date: 2019/1/29 09:49
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QueueTest {
    @Autowired
    private ProduceController produceController;

    @Test
    public void sendMessage(){
        produceController.queue();
    }
}
