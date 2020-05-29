package com.board.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.board.dto.MemberVO;
import com.board.mapper.MemberMapper;

@Service
public class MemberService implements UserDetailsService{
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO memberVO = memberMapper.getMember(username);
		if(memberVO == null)
			throw new UsernameNotFoundException(username);
		return new User(memberVO.getId(),memberVO.getPassword(),authorize(memberVO.getGrade()));
	}

	private Collection<? extends GrantedAuthority> authorize(int grade) {
		if(grade == 1) {
			return Arrays.asList(new SimpleGrantedAuthority("MEMBER"));
		} else {
			return Arrays.asList(new SimpleGrantedAuthority("USER"));
		}
	}

	public void join(MemberVO memberVO) {
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		memberMapper.join(memberVO);
	}
	public MemberVO findOne(String id) {
		return memberMapper.getMember(id);
	}
	
}
