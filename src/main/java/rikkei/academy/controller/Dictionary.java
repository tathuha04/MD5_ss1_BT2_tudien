package rikkei.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {
    @RequestMapping(value = "/")
    public String home() {
        return "dictionary";
    }

    @RequestMapping(value = "/dictionary")
    public String getWithModalMap(@RequestParam("eng") String eng, ModelMap modelMap) {
        modelMap.put("hello", "xin chào");
        modelMap.put("goodbye", "tạm biệt");
        modelMap.put("apple", "táo");
        modelMap.put("cat", "mèo");
        String vietnamese = (String) modelMap.get(eng);
        if (vietnamese == null) {
            vietnamese = "not found";
        }
        modelMap.addAttribute("eng", eng);
        modelMap.addAttribute("vietnam", vietnamese);
        return "result";
    }
}
