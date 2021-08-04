package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class MemberRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
		member.setDepId(rs.getInt("dep_id"));
		return member;
	};

	public List<Member> findLike(String language) {
		System.out.println(language);
		String sql = "select id,name,age,dep_id from members where name like :language;";
		language = "%" + language + "%";
		SqlParameterSource param = new MapSqlParameterSource().addValue("language", language);
		System.out.println(param);
		List<Member> memberList = template.query(sql, param, MEMBER_ROW_MAPPER);
		for (Member member : memberList) {
			System.out.println(member);
		}
		return memberList;
	}
}
