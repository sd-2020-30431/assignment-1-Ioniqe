package net.service;

import net.model.Item;
import net.model.Lists;
import net.repository.ItemRepository;
import net.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listAll() {
        return itemRepository.findAll();
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

    public void delete(long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> findItems(Long id) {
        return itemRepository.findAllByListId(id);
    }

}
