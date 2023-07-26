package com.project.fp01.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.project.fp01.dto.MemberDTO;
import com.project.fp01.mappers.MemberMapper;

import lombok.extern.log4j.Log4j2;

/*
 * Made By : Kwon Seong Joon
 * When 2023-07-26 
 * Time AM 10:32
 */

 @Log4j2
 @SpringBootTest
public class MemberMapperTests {
    
    @Autowired(required = false)
    private MemberMapper memberMapper;

    private static final String TEST_EMAIL = "thistrik@naver.com";
    private static final String TEST_MEMBER_PASSWORD = "wefjoewfjiwef";
    private static final String TEST_MEMBER_NAME = "권성준";
    private static final String TEST_MEMBER_PHONE="010-3099-0648";


    private MemberDTO memberDTO;
    private MemberDTO updateMemberDTO;

    @BeforeEach
    public void setUp() {

        memberDTO = MemberDTO.builder()
        .email(TEST_EMAIL)
        .memberPw(TEST_MEMBER_NAME)
        .memberName(TEST_MEMBER_NAME)
        .memberPhone(TEST_EMAIL)
        .build();

        updateMemberDTO = MemberDTO.builder()
        .email(TEST_EMAIL)
        .memberPw(TEST_MEMBER_NAME)
        .memberName(TEST_MEMBER_NAME)
        .memberPhone(TEST_EMAIL)
        .build();

    }

    @Test
    @Transactional
    @DisplayName("멤버 회원가입 테스트 매퍼")
    public void joinMemberTestMapper() {
        log.info("=== Start Member Join Test ===");
        int joinedMember = memberMapper.joinMember(memberDTO);
        MemberDTO readMember = memberMapper.readMember(TEST_EMAIL);
        Assertions.assertNotNull(readMember);
        Assertions.assertEquals(memberDTO.getEmail(), "thistrik@naver.com");
        log.info("=== End Member Join Test ===");
    }

    @Test
    @Transactional
    @DisplayName("멤버 회원탈퇴 테스트 매퍼")
    public void deleteMemeberTestMapper() {
        log.info("=== Start Member Delete Test ===");
        memberMapper.deleteMember(TEST_EMAIL);
        MemberDTO deleteMember = memberMapper.readMember(TEST_EMAIL);
        Assertions.assertNull(deleteMember, "deleteMember Should Be Null");
        log.info("=== End Member Delete Test ===");
    }


}
