package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.exception.AddException;
import com.my.service.RepBoardService;
import com.my.vo.RepBoard;

@Controller
public class BoardReplyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RepBoardService service;	
	
	@RequestMapping("/reply")
	public ModelAndView reply(RepBoard board) {
		
		ModelAndView mnv = new ModelAndView();
		try {
			service.writeReply(board);
			mnv.setViewName("redirect:/list");
		} catch (AddException e) {
			mnv.addObject("exception", e);
			e.printStackTrace();
		}
		return mnv;
		
	}

}
