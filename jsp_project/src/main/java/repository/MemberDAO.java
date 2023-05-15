package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	List<MemberVO> selectList();

	MemberVO selectOne(MemberVO mvo2);

	int lastLogin(String id);

	MemberVO selOnemod(MemberVO mvo2);

	int update(MemberVO mvoEdit);

	int delete(MemberVO mvo3);

}
