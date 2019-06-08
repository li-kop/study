package com.ljq.mvc.async;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author : LJQ
 * @date : 2019/6/7 15:31
 */
@RestController
public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private OrderEntity orderEntity;
    @Autowired
    private DeferredResultHandler handler;

    @GetMapping("/order")
    public DeferredResult<String> order() {
        logger.info("主线程开始");

/*    Callable<String> result= () -> {
      logger.info("副线程开始");
      try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
      logger.info("副线程结束");
      return "success";

  };*/

        String orderNo = RandomStringUtils.randomNumeric(8);
        orderEntity.setStartOrder(orderNo);

        DeferredResult<String> result = new DeferredResult<>();

        handler.getMap().put(orderNo, result);

        logger.info("主线程结束");

        return result;

    }
}
