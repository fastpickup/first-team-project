package com.project.fp01.mapper;

import java.util.List;

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

    private static final String TEST_EMAIL_VERSION2 = "tttt@naver.com";

    private static final String TEST_MEMBER_PASSWORD = "wefjoewfjiwef";
    private static final String TEST_MEMBER_NAME = "권성준";
    private static final String TEST_MEMBER_PHONE="010-3099-0648";


    private MemberDTO memberDTO;
    private MemberDTO updateMemberDTO;

    @BeforeEach
    public void setUp() {

        memberDTO = MemberDTO.builder()
        .email(TEST_EMAIL_VERSION2)
        .memberPw(TEST_MEMBER_PASSWORD)
        .memberName(TEST_MEMBER_NAME)
        .memberPhone(TEST_MEMBER_PHONE)
        .build();

        updateMemberDTO = MemberDTO.builder()
        .email(TEST_EMAIL)
        .memberPw(TEST_MEMBER_NAME)
        .memberName(TEST_MEMBER_NAME)
        .memberPhone(TEST_MEMBER_PHONE)
        .build();

    }

    @Test
    @Transactional
    @DisplayName("멤버 회원가입 테스트 매퍼")
    public void joinMemberTestMapper() {
        // GIVEN 
        log.info("=== Start Member Join Test ===");
        // WHEN 
        int joinedMember = memberMapper.joinMember(memberDTO);
        // THEN 
        MemberDTO readMember = memberMapper.readMember(TEST_EMAIL);
        Assertions.assertNotNull(readMember);
        Assertions.assertEquals(memberDTO.getEmail(), "tttt@naver.com");
        log.info("=== End Member Join Test ===");
    }

    @Test
    @Transactional
    @DisplayName("멤버 회원탈퇴 테스트 매퍼")
    public void deleteMemeberTestMapper() {
        // GIVEN 
        log.info("=== Start Member Delete Test ===");
        // WHEN 
        memberMapper.deleteMember(TEST_EMAIL);
        // THEN 
        MemberDTO deleteMember = memberMapper.readMember(TEST_EMAIL);
        Assertions.assertNull(deleteMember, "deleteMember Should Be Null");
        log.info("=== End Member Delete Test ===");
    }

    @Test
    @Transactional
    @DisplayName("멤버 회원 업데이트 테스트 매퍼")
    public void updateMembertestMapper() {
        // GIVEN 
        log.info("=== Start Member Update Test ===");
        // WHEN 
        memberMapper.updateMember(updateMemberDTO);
        // THEN 
        MemberDTO updatedMember = memberMapper.readMember(TEST_EMAIL);
        Assertions.assertNotNull(updatedMember, "updatedMember Should Be Not Null");
        Assertions.assertEquals(updateMemberDTO.getEmail(), TEST_EMAIL);
        Assertions.assertEquals(updateMemberDTO.getMemberName(), TEST_MEMBER_NAME);
        Assertions.assertEquals(updateMemberDTO.getMemberPhone(), TEST_MEMBER_PHONE);
        log.info("=== End Member Update Test ===");
    }

    @Test
    @Transactional
    @DisplayName("멤버 리스트 테스트 매퍼")
    public void listMemberTestMapper() {
        // GIVEN 
        log.info("=== Start Member List Test ==="); 
        // WHEN 
        List<MemberDTO> listMember = memberMapper.listMember();
        // THEN 
        Assertions.assertNotNull(listMember, "listMember Should Be Not Null");
        log.info("=== End Member List Test ===");
    }

    @Test
    @Transactional
    @DisplayName("멤버 조회 테스트 매퍼")
    public void readMemberTestMapper() {
        // GIVEN 
        log.info("=== Start Member Read Test ===");
        // WHEN 
        MemberDTO readMember = memberMapper.readMember(TEST_EMAIL);
        // THEN 
        Assertions.assertNotNull(readMember, "readMember Should Be Not null");
        Assertions.assertEquals(readMember.getEmail(), "thistrik@naver.com");
    }

}
