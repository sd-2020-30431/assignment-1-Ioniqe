package net.service;

import net.model.Lists;
import net.model.User;
import net.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ListService {

    @Autowired
    private ListRepository listRepository;

    public List<Lists> listAll() {
        return listRepository.findAll();
    }

    public void save(Lists list) {
        listRepository.save(list);
    }

    public void delete(long id) {
        listRepository.deleteById(id);
    }

    public Lists findList(String name) {
        return listRepository.findListsByName(name);
    }

    public List<Lists> findListsByUserId(Long userId){
        return listRepository.findAllByUserId(userId);
    }
}
