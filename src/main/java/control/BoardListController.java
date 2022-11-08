package control;

import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.my.exception.FindException;
import com.my.service.RepBoardService;
import com.my.vo.RepBoard;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class BoardListController {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RepBoardService service;
	
	@RequestMapping("/list")
	public ModelAndView list(String word, @RequestParam(required=false, defaultValue="0") int currentPage) {
		// String path ="/WEB-INF/views/error.jsp";
		// request.setCharacterEncoding("utf-8");
		log.info("검색어: " + word);
		List<RepBoard> list;
		ModelAndView mnv = new ModelAndView();
		try {
			//2. 비지니스로직 호출
			if(word == null) { //전체검색
				list = service.findAll();
			}else { //검색어에 만족하는 검색
				list = service.findByBoard_titleORBoard_writer(word);
			}
			// list객체를 list.jsp 페이지로 전달해준다
			mnv.addObject("list", list);
			mnv.setViewName("list");
		} catch (FindException e) {
			mnv.addObject("exception", e);
			mnv.setViewName("error");
			e.printStackTrace();
		}
		return mnv;
		
	}

}
