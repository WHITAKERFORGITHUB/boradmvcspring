package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.exception.RemoveException;
import com.my.service.RepBoardService;


@Controller
public class BoardRemoveController {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RepBoardService service;
	
	@RequestMapping("/remove")
	public ModelAndView remove(int board_no, String certify_board_pwd) {
		ModelAndView mnv = new ModelAndView();
		try {
			service.remove(board_no, certify_board_pwd);
			mnv.setViewName("redirect:/list");
		} catch (RemoveException e) {
			mnv.addObject("exception", e);
			e.printStackTrace();
			mnv.setViewName("error");
			
		}
		return mnv;
	}
}