package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// Database Access Object
@Component
public class MemberDAO {
    //field 에 수정을 막기 위해 final을 사용 => 이경우 소문자로 변수값 작성
    private final Map<Integer,MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<Integer,MemberDTO>();

        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    public MemberDTO findMemberBySeq(int seq){
        return memberMap.get(seq);
    }

    public boolean save(MemberDTO member){
        int before = memberMap.size();

        memberMap.put(member.getSequence(),member);

        int after = memberMap.size();

        return after>before;
    }
}
