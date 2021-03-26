package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    /**
     * 회원가입
     */
    @Transactional //변경
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers =
                memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }


    public Long login(Member member) {
        validateMember(member); // 회원 여부 확인
        return member.getId();
    }

    private void validateMember(Member member) {

        List<Member> matchAuth =
                memberRepository.findAuth(member.getNick(), member.getPassword());

        if ( matchAuth.isEmpty() ) {
            throw new IllegalStateException("아이디 또는 비밀번호를 다시 확인해주세요.");
        }

    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {

        return memberRepository.findOne(memberId);
    }
}