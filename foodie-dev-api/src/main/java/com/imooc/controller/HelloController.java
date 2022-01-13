package com.imooc.controller;

import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.StringRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Date: 2021/9/22 4:04 下午
 * HelloController
 * Describe：
 */
@ApiIgnore
@RestController
public class HelloController {

    final  static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/hello")
    public IMOOCJSONResult   hello(){
        StringRandom test = new StringRandom();
        IMOOCJSONResult imoocjsonResult = new IMOOCJSONResult();
        String  trceid  = "trceid:" + imoocjsonResult.setTrceid(test.getStringRandom());

        logger.debug("debug: hello~" + trceid);
        logger.info(trceid + "\t" + "这个是日志id");
        logger.warn("warn: hello~");
        logger.error("error: hello~");

        return IMOOCJSONResult.ok();
    }

    @GetMapping("/setSession")
    public Object setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", "new user");
        session.setMaxInactiveInterval(3600);
        session.getAttribute("userInfo");
//        session.removeAttribute("userInfo");
        return "ok";
    }
}