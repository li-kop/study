package com.ljq.mvc.async;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author : LJQ
 * @date : 2019/6/7 16:18
 */
@Component
public class OrderListener  implements ApplicationListener {

    Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    OrderEntity orderEntity;
    @Autowired
    DeferredResultHandler deferredResultHandler;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
             new Thread(() -> {
                 while (true){
                     if (StringUtils.isNotBlank(orderEntity.getFinishOrder())){
                         String orderNo=orderEntity.getFinishOrder();
                         logger.info("返回 订单结果："+orderNo);
                         deferredResultHandler.getMap().get(orderNo).setResult("success");
                         orderEntity.setFinishOrder(null);

                     }else {
                         try {
                             Thread.sleep(100);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 }
                     }).start();
    }
}
