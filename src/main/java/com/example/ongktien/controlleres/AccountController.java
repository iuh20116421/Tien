package com.example.ongktien.controlleres;
import com.example.ongktien.models.Account;
import com.example.ongktien.services.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;
    @PostMapping("/add")
    public String addAcount(@ModelAttribute("account") Account account){
        accountService.AddAccount(account);
        return "redirect:/";
    }
    @GetMapping("/add")
    public String getAdd(Model model){
        model.addAttribute("account",new Account());
        return "Account";
    }
}
