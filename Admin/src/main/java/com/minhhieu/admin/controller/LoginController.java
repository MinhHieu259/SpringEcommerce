package com.minhhieu.admin.controller;

import com.minhhieu.library.dto.AdminDto;
import com.minhhieu.library.model.Admin;
import com.minhhieu.library.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("adminDto", new AdminDto());
        return "register";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(Model model){
        return "forgot-password";
    }

    @PostMapping("/register-new")
    public String addNewAdmin(@Valid  @ModelAttribute("adminDto")AdminDto adminDto,
                              BindingResult result,
                              Model model,
                              HttpSession session){
        try {
            session.removeAttribute("message");
            if(result.hasErrors()){
                model.addAttribute("adminDto", adminDto);
                return "register";
            }
            String username = adminDto.getUsername();
            Admin admin = adminService.findByUsername(username);

            if(admin != null){
                model.addAttribute("adminDto", adminDto);
                session.setAttribute("message", "Your email has been registered!");
                return "register";
            }

            if (adminDto.getPassword().equals(adminDto.getRepeatPassword())){
                adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
                adminService.save(adminDto);
                session.setAttribute("message", "Register SuccessFully!");
                model.addAttribute("adminDto", adminDto);
            }else{
                model.addAttribute("adminDto", adminDto);
                session.setAttribute("message", "Password is not Same");
                System.out.println("password not same");
                return "register";
            }
        } catch (Exception e){
            e.printStackTrace();
            session.setAttribute("message", "Server is error, please try again!");
        }

        return "register";
    }
}
