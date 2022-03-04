package appCrud.controller;

import appCrud.model.User;
import appCrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerBase {
    final private UserService userService;

    public ControllerBase(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    String getAllUsersPage(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/{id}")
    String getPage(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @GetMapping("/new")
    String getAddPage(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @GetMapping("/{id}/edit")
    String getEditPage(@PathVariable Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        userService.deleteUser(user.getId());
        return "edit";
    }

    @PostMapping("/")
    String add(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @PatchMapping("/")
    String edit(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    String delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
