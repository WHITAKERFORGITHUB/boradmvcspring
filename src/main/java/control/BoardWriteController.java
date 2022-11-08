package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.exception.AddException;
import com.my.service.RepBoardService;
import com.my.vo.RepBoard;

@Controller
public class BoardWriteController {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RepBoardService service;	
	
	// 글쓰기 화면을 보여줌
	@GetMapping("/write")
	public void showWrite() {
		
	}
	
	// 이렇게해도 글쓰기 화면을 보여 줄 수 있다.
//	public String showWrite() {
//		return "write"; // viewName
//	}
	
	@PostMapping("/write")
	public ModelAndView write(RepBoard board, RedirectAttributes rttr) {
		
		ModelAndView mnv = new ModelAndView();
		
		try {
			service.writeBoard(board);
			// mnv.setViewName("redirect:/list");
			// mnv.setViewName("redirect:/list?currentPage=1");
			rttr.addFlashAttribute("currentPage", 1);
			rttr.addFlashAttribute("word", "test");
			// rttr.addAttribute("currentPage", 1);
			mnv.setViewName("redirect:/list");
		} catch (AddException e) {
			mnv.addObject("exception", e);
			e.printStackTrace();
		}
		return mnv;
		
	}

}
