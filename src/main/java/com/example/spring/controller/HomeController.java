package com.example.spring.controller;

import com.example.spring.entity.Account;
import com.example.spring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping()
    public String getIndex() {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
