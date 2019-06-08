package com.ljq.mvc.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author : LJQ
 * @date : 2019/6/7 15:57
 */
@Component
public class OrderEntity {

    Logger logger= LoggerFactory.getLogger(getClass());

    private String startOrder;

    private String finishOrder;

    public String getStartOrder() {
        return startOrder;
    }

    public void setStartOrder(String startOrder) {
                new Thread(() -> {
                    logger.info("开始下单:"+startOrder);

                    try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

                    logger.info("下单结束:"+startOrder);

                    this. finishOrder =startOrder;
                        }).start();

    }

    public String getFinishOrder() {
        return finishOrder;
    }

    public void setFinishOrder(String finishOrder) {
        this.finishOrder = finishOrder;
    }
}
