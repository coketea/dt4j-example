package com.coketea.dt.example.init;

import com.alibaba.fastjson.JSONObject;
import com.coketea.dt.client.AbstractDTClient;
import com.coketea.dt.client.DTClient;
import com.coketea.dt.io.protocol.Actions;
import com.coketea.dt.io.protocol.DTCommunicationMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApplicationInitializer implements ApplicationListener<ContextRefreshedEvent> {

    static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

    @Autowired
    private AbstractDTClient dtClient;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //当spring父容器初始化完毕时，开始应用程序自身初始化
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            logger.info("start to init application self after spring context inited");

            try {
                dtClient.connect();
            } catch (Exception e) {
                dtClient.close();
                logger.error("connect to coordinator failed, check if coordinator started", e);
                System.exit(1);
            }

            try {
                DTCommunicationMessage msgSend = new DTCommunicationMessage();
                msgSend.setAction(Actions.REGISTER);
                dtClient.sendMsg(JSONObject.toJSONString(msgSend));

                DTCommunicationMessage msgRcv = JSONObject.parseObject(dtClient.receiveMsg(), DTCommunicationMessage.class);
                if (Actions.ACK_SUCCESS.equals(msgRcv.getAction()) &&
                        msgRcv.getUuid().equals(msgSend.getUuid())) {
                    dtClient.setId(msgRcv.getAttachedData());
                }

                logger.info("register to coordinator success");
            } catch (IOException e) {
                dtClient.close();
                logger.error("register to coordinator failed, check if coordinator started", e);
                System.exit(1);
            }
        }
    }
}
