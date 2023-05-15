package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.MemberController;
import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemverService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public int register(MemberVO mvo) {
		log.info(">>> register service 진입");
		return mdao.insert(mvo);
	}

	@Override
	public List<MemberVO> list() {
		log.info(">>> list service 진입");
		return mdao.selectList();
	}

	@Override
	public MemberVO login(MemberVO mvo2) {
		log.info(">>> login service 진입");
		return mdao.selectOne(mvo2);
	}

	@Override
	public int lastLogin(String id) {
		log.info(">>> logout service 진입");
		return mdao.lastLogin(id);
	}

	@Override
	public MemberVO modify(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(">>> modify service 진입");
		return mdao.selOnemod(mvo);
	}

	@Override
	public int edit(MemberVO mvoEdit) {
		log.info(">>> edit service 진입");
		return mdao.update(mvoEdit);
	}

	@Override
	public int delete(MemberVO mvo3) {
		log.info(">>> delete service 진입");
		return mdao.delete(mvo3);
	}
}
