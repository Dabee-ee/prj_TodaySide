package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.write.Write;
import jpabook.jpashop.repository.WriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WriteService {

    private final WriteRepository writeRepository;


    @Transactional
    public void saveWrite(Write write) {
        writeRepository.save(write);
    }

    public List<Write> findWrites() {
        return writeRepository.findAll();
    }

    public Write findOne(Long WriteId) {
        return writeRepository.findOne(WriteId);
    }

}
