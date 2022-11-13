package exams.mvc_sql_practice.gym_mem.dao;


import exams.mvc_sql_practice.gym_mem.model.Member;

import java.util.Map;

public interface MemberDao {

    Map<Integer, Member> getMembers();

    void saveMember(Member member);
}
