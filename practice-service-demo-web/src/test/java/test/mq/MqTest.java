package test.mq;

import com.jd.ecc.commons.web.model.MessageInfo;
import com.swk.common.constants.MessageTopicConstants;
import com.swk.web.PracticeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;

/**
 * @author songwanke
 * @date 2017/11/28
 */

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = PracticeApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class MqTest {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Test
    public void kafkapush() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setPlatformId(2L);
        messageInfo.setTopic(MessageTopicConstants.SHOP_SETTLED_SUCCESS_TOPIC);
        HashMap<Object, Object> map = new HashMap();
        map.put("sellerId",1128L);
        map.put("shopId",11281L);
        messageInfo.setMessageObj(map);
//        System.out.println("++++++++++++++"+new Gson().toJson(map));
        kafkaTemplate.send(messageInfo.getTopic(),messageInfo);

    }
}
