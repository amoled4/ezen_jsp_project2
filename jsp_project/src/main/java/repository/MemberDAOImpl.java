package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;
import service.MemberServiceImpl;

public class MemberDAOImpl implements MemberDAO {

	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	// NameSpace = SQL이 mapper를 구분하기 위한 이름
	// NameSpace.SQL 구문이름
	private String NS = "MemberMapper.";
	
	// 생성자
	// DB 연결
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	
	@Override
	public int insert(MemberVO mvo) {
		// sql.insert(NS+이름, 객체);
		// transaction 처리가 자동 이루어짐
		int isOk = sql.insert(NS+"reg", mvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}
	@Override
	public List<MemberVO> selectList() {
		List<MemberVO> list = sql.selectList(NS+"list");
		return list;
	}


	@Override
	public MemberVO selectOne(MemberVO mvo2) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"login", mvo2);
	}


	@Override
	public int lastLogin(String id) {
		int isOk = sql.update(NS+"logout", id);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public MemberVO selOnemod(MemberVO mvo2) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"modify", mvo2);
	}


	@Override
	public int update(MemberVO mvoEdit) {
		int isOk = sql.update(NS+"edit",mvoEdit);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}


	@Override
	public int delete(MemberVO mvo3) {
		int isOk = sql.delete(NS+"delete",mvo3);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}


}
