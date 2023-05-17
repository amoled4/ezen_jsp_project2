package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public List<BoardVO> list() {
		log.info(">>> list service 진입");
		return bdao.selectList();
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info(">>> insert service 진입");
		return bdao.insert(bvo);
	}


	@Override
	public int edit(BoardVO bvo) {
		log.info(">>> edit service 진입");
		return bdao.update(bvo);
	}

	@Override
	public BoardVO detail(int bno) {
		log.info(">>> detail service 진입");
		return bdao.selectOne(bno);
	}

	@Override
	public int remove(int bno) {
		log.info(">>> remove service 진입");
		return bdao.delete(bno);
	}

	@Override
	public int count(int bno) {
		log.info(">>> readcount service 진입");
		return bdao.countUp(bno);
	}
}
