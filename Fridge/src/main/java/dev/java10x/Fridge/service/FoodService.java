package dev.java10x.Fridge.service;

import dev.java10x.Fridge.model.Food;
import dev.java10x.Fridge.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    public Food getById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
    }

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public Food update(Long id, Food food) {
        Food existing = getById(id);
        existing.setName(food.getName());
        existing.setQuantity(food.getQuantity());
        existing.setExpirationDate(food.getExpirationDate());
        return foodRepository.save(existing);
    }

    public Food partialUpdate(Long id, Food food) {
        Food existing = getById(id);
        if (food.getName() != null) existing.setName(food.getName());
        if (food.getQuantity() != null) existing.setQuantity(food.getQuantity());
        if (food.getExpirationDate() != null) existing.setExpirationDate(food.getExpirationDate());
        return foodRepository.save(existing);
    }

    public void delete(Long id) {
        foodRepository.deleteById(id);
    }
}