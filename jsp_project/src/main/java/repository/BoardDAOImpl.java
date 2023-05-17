package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	// NameSpace = SQL이 mapper를 구분하기 위한 이름
	// NameSpace.SQL 구문이름
	private String NS = "BoardMapper.";
	
	// 생성자
	// DB 연결
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public List<BoardVO> selectList() {
		List<BoardVO> list = sql.selectList(NS+"list");
		return list;
	}

	@Override
	public int insert(BoardVO bvo) {
		int isOk = sql.insert(NS+"reg", bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int update(BoardVO bvo) {
		int isOk = sql.update(NS+"edit", bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public BoardVO selectOne(int bno) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"detail", bno);
	}

	@Override
	public int delete(int bno) {
		int isOk = sql.delete(NS+"delete", bno);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int countUp(int bno) {
		
		return sql.update(NS+"count", bno);
	}
}
