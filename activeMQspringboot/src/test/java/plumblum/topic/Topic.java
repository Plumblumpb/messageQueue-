package plumblum.topic;


import com.plumblum.PlumblumApplication;
import com.plumblum.topic.Produce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: cpb
 * @Date: 2018/12/29 15:21
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlumblumApplication.class)
public class topic {
    @Autowired
    private Produce produce;

    @Test
    public void test() throws InterruptedException {

        for(int i=0; i<5; i++){
            produce.sendMessage("topic", "接收信息!!!");
        }
    }
}
