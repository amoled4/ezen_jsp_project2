package service;

import java.util.List;

import domain.MemberVO;

public interface MemverService {

	int register(MemberVO mvo);

	List<MemberVO> list();

	MemberVO login(MemberVO mvo2);

	int lastLogin(String id);

	MemberVO modify(MemberVO mvo2);

	int edit(MemberVO mvoEdit);

	int delete(MemberVO mvo3);

}
