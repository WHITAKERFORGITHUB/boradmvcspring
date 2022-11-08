package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.exception.FindException;
import com.my.service.RepBoardService;
import com.my.vo.RepBoard;

import lombok.extern.log4j.Log4j;


@Controller
@Log4j
public class BoardDetailController {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RepBoardService service;
	
	@RequestMapping("/detail")
	public ModelAndView detail(int board_no) {
		
		ModelAndView mnv = new ModelAndView();
		try {
			//2. 비지니스로직 호출
			RepBoard board = service.findByBoard_no(board_no);
			mnv.addObject("board", board);
			mnv.setViewName("detail");
		} catch (FindException e) {
			mnv.addObject("exception", e);
			mnv.setViewName("error");
			e.printStackTrace();
		}
		return mnv;
		
	}

}
