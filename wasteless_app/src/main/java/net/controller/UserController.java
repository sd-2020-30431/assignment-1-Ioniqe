package net.controller;

import net.model.User;
import net.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    //get form page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "login";
    }

    //check for credentials
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "user") User user, Model model, RedirectAttributes redirectAttributes) {
        String username = user.getUsername();
        String password = user.getPassword();
        User verifyUser = service.findUser(username, password);

        if (verifyUser != null) {
            //this means that the user does exist
            redirectAttributes.addFlashAttribute("verifiedUser", verifyUser);
            return "redirect:/lists";
        }
        if(!username.equals("") && !password.equals(""))
            model.addAttribute("message", "Invalid User");

        //return again login page
        return "login";
    }

    @RequestMapping("/newUser")
    public String showNewProductPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST) //create a new user
    public String saveProduct(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        if(service.findUser(user.getUsername(), user.getPassword()) != null){
            redirectAttributes.addFlashAttribute("message", "User Already Exists!");
        }else{
            service.save(user);
            redirectAttributes.addFlashAttribute("message", "User Created!");
        }
        return "redirect:/login";
    }
}
