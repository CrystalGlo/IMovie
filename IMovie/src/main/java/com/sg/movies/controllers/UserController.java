package com.sg.movies.controllers;

import com.sg.movies.dao.UserDao;
import com.sg.movies.models.User;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;

@Controller
public class UserController {

    public static boolean isConnexionOn = false;

    @Autowired
    UserDao userDao;

    @GetMapping("login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @PostMapping("login")
    public String login(HttpServletRequest request, Model model) {
        String email = request.getParameter("loginEmail");
        String userPassword = request.getParameter("loginPassword");
        User loginUser = userDao.getUser(email, userPassword);
        if(loginUser != null) {
            isConnexionOn = true;
            return "redirect:/";
        } else {
            isConnexionOn = false;
            return "redirect:/login";
        }
    }

    @PostMapping("addUser")
    public String addUser(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("signupEmail");
        String userPassword = request.getParameter("signupPassword");

        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setUserPassword(userPassword);
        newUser.setIsAdmin(0);

        userDao.addUserAccount(newUser);

        return "redirect:/login";
    }
}
