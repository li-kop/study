package com.ljq;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : LJQ
 * @date : 2019/5/20 20:42
 */
@RestController
public class TestController {
@RequestMapping("/dor/login")
    public String test(){

    return "xxx";
}

}
