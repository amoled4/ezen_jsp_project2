package repository;

import java.util.List;

import domain.BoardVO;

public interface BoardDAO {

	List<BoardVO> selectList();

	int insert(BoardVO bvo);

	BoardVO selectOne(int bno);

	int update(BoardVO bvo);

	int delete(int bno);

}
