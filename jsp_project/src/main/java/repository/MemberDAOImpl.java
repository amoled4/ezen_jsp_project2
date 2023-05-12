package repository;

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

}