package com.example.counter.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CountController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			int count = (int) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String count(HttpSession session, Model model) {
		int count = 0;
		if(session.getAttribute("count") != null) {
			count = (int) session.getAttribute("count");
		}
		model.addAttribute("count", count);
		return "count.jsp";
	}
	
	@RequestMapping("/counter/reset")
	public String reset(HttpSession session) {
		if(session.getAttribute("count") != null) {
			session.setAttribute("count", 0);
		}
		return "redirect:/";
	}
}
