package net.controller;

import net.model.Lists;
import net.model.User;
import net.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ListsController {
    @Autowired
    private ListService listService;

    @RequestMapping(value = "/lists", method = RequestMethod.GET)
    public String start(@ModelAttribute(name = "verifiedUser") User user, Model model) {
        List<Lists> listOfLists = listService.findListsByUserId(user.getId());
        model.addAttribute("listOfLists", listOfLists);
        return "lists";
    }
}
