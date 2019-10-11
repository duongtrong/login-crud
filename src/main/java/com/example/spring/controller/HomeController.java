package com.example.spring.controller;

import com.example.spring.entity.Account;
import com.example.spring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex() {
        Account account = new Account();
        account.setEmail("user@gmail.com");
        account.setPassword(passwordEncoder.encode("password"));
        accountRepository.save(account);
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "login";
    }
}
