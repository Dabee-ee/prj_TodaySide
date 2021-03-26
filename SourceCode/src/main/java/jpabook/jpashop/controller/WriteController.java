package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.write.Write;
import jpabook.jpashop.service.WriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WriteController {

    private final WriteService writeService;

    @GetMapping("/write/new")
    public String createForm(Model model) {
        model.addAttribute("form", new WriteForm());
        return "/write/createWriteForm";
    }

    @PostMapping("/write/new")
    public String create(WriteForm form) {

        Write write = new Write();
        write.setTitle(form.getTitle());
        write.setContent(form.getContent());
        write.setRegDate(form.getRegDate());
        write.setAttach(form.getAttach());

        writeService.saveWrite(write);
        return "redirect:/";
    }

    // 게시글 목록

    @GetMapping("write")
    public String list(Model model){
        List<Write> writes = writeService.findWrites();
        model.addAttribute("writes", writes);
        return "write/writeList";
    }

    // 상세 내용

    @GetMapping("write/{writeId}")
    public String readWrite(@PathVariable("writeId") Long writeId, Model model) {
        Write write = writeService.findOne(writeId);
        model.addAttribute("write", write);

        return "write/read";
    }

}
