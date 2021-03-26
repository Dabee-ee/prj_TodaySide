package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {

    public final MemberService memberService;

    //============= login ========//
    @GetMapping("/login")
    private String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "/members/loginMemberForm";
    }



//    @RequestMapping("/logout")
//    public ModelAndView logout(HttpSession session) {
//        session.invalidate();
//        ModelAndView mv = new ModelAndView("redirect:/");
//        return mv;
//




    @PostMapping("/login")
    public String login(@Valid LoginForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/loginMemberForm";

        }

        Member member = new Member();
        member.setNick(form.getNick());
        member.setPassword(form.getPassword());

        memberService.login(member);
        return "redirect:/";
    }


//        }
////        Member member = new Member();
//
//        member.setName(form.getName());
//        member.setAddress(address);
//
//        memberService.join(member);
//        return "redirect:/";
//    }

//
//    @PostMapping("/login")
//    public String login(@Valid LoginForm form, BindingResult result){
//
//        if (result.hasErrors()) {
//            return "members/loginMemberForm";
//        }
//        memberService.login();
//
//        Member member = new Member();
//        memberService.findMembers();
//        form.getMemberId();
//        form.getMemberPassword();
//
//        return "redirect:/";
//    }

//    @PostMapping("items/{itemId}/edit")
//    public String searchUser(@PathVariable Long memberId, @ModelAttribute("form") Member form) {
//
////        Book book = new Book();
////        book.setId(form.getId());
////        book.setName(form.getName());
////        book.setPrice(form.getPrice());
////        book.setStockQuantity(form.getStockQuantity());
////        book.setAuthor(form.getAuthor());
////        book.setIsbn(form.getIsbn());
////        itemService.saveItem(book);
//
//        memberService.searchUser(form.getId(), form.Password());
//
//        return "redirect:/items";
//    }
}
