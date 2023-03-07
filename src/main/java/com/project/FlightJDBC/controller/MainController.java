package com.project.FlightJDBC.controller;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.project.FlightJDBC.entity.UserRole;
import com.project.FlightJDBC.service.UserDetailServiceImpl;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//</editor-fold>

/**
 *
 * @author Pham Minh Luan
 * @email phamminhluan@fabercompany.co.jp
 */
@Controller
public class MainController {

    @Autowired
    private UserDetailServiceImpl userDetailServ;
    
    @GetMapping("/403")
    public String accessDenied() {
        return "/403";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }
    
    @PostMapping("/checkLogin")
    public String login(@RequestParam (name="userAccount", defaultValue = "") String userAccount,
                        @RequestParam (name="userPassword", defaultValue = "") String userPassword,
                        HttpServletRequest request, RedirectAttributes redirectAttr){
        String result = userDetailServ.checkLogin(userAccount, userPassword, request);
        switch(result){
            case "success":{
                return "redirect:/listFlight";
            }
            case "failed":{
                redirectAttr.addFlashAttribute("failed", true);
                return "redirect:/login";
            }
            default:{
                redirectAttr.addFlashAttribute("error", true);
                return "redirect:/login";
            }
        }
    }
}
