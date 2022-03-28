package com.kanq.deduce.web.socket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ServerEndpoint(value = "/test/oneToMany")
public class OneToManyWebSocket {
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    private static Map<String, Session> clients = new ConcurrentHashMap<>();


    @OnOpen
    public void onOpen(Session session) {
        onlineCount.incrementAndGet();
        clients.put(session.getId(), session);
        log.info("有新连接加入：{}，当前在线人数为：{}", session.getId(), onlineCount.get());
    }

    @OnClose
    public void onClose(Session session){
        onlineCount.decrementAndGet();
        clients.remove(session.getId());
        log.info("有连接断开：{}，当前在线人数为：{}", session.getId(), onlineCount.get());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("服务器收到客户端[{}]的消息：{}", session.getId(), message);
        //收到后即返回
        this.sendMessage("server info: " + message, session);
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        log.error("发生错误");
        throwable.printStackTrace();
    }

    private void sendMessage(String message, Session fromSession){
        for(Map.Entry<String,Session> sessionEntry : clients.entrySet()){
            Session toSession = sessionEntry.getValue();
            if(!fromSession.getId().equals(toSession.getId())){
                log.info("服务端给客户端[{}]发送消息：{}", toSession.getId(), message);
                toSession.getAsyncRemote().sendText(message);
            }
        }
        // try {
        //     log.info("服务端给客户端[{}]发送消息：{}", session.getId(), message);
        //     session.getBasicRemote().sendText(message);
        // } catch (Exception e) {
        //     log.error("服务端发送消息给客户端失败：{}", e);
        // }
    }

}
