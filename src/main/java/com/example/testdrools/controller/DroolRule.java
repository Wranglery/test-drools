package com.example.testdrools.controller;

import com.example.testdrools.entity.UserInfo;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DroolRule {

    @Autowired
    KieSession kieSession;

    @RequestMapping("/rule1")
    @ResponseBody
    public String rule1() {

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("liu");
        userInfo.setTelephone("123456");

        kieSession.insert(userInfo);

        int firedCount = kieSession.fireAllRules();
        System.out.println("触发了" + firedCount + "条规则");

        return "触发了" + firedCount + "条规则";
    }
}



