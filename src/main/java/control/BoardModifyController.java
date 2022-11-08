package control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.exception.ModifyException;
import com.my.service.RepBoardService;
import com.my.vo.RepBoard;

@Controller
public class BoardModifyController {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RepBoardService service;	
	
	@RequestMapping("/modify")
	public ModelAndView modify(RepBoard board, String certify_board_pwd, HttpServletRequest request) {
		
		ModelAndView mnv = new ModelAndView();
		try {
			service.modify(board, certify_board_pwd);
			String contextPath = request.getContextPath();
			mnv.setViewName("redirect:/list");
		} catch (ModifyException e) {
			mnv.addObject("exception", e);
			e.printStackTrace();
			mnv.setViewName("error");
			
		}
		return mnv;
		
	}

}
