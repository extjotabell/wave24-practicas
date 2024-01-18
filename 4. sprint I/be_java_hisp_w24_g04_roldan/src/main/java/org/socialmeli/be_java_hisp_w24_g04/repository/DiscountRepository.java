package org.socialmeli.be_java_hisp_w24_g04.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.socialmeli.be_java_hisp_w24_g04.exception.DataExtractionException;
import org.socialmeli.be_java_hisp_w24_g04.model.Discount;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DiscountRepository implements IDiscountRepository{
    List<Discount> discounts;

    public DiscountRepository () {
        discounts = loadDiscounts();
    }

    private ArrayList<Discount> loadDiscounts() {
        ArrayList<Discount> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<ArrayList<Discount>> typeRef = new TypeReference<>() {};
        try {
            String jsonFile = "classpath:data/discounts.json";
            file = ResourceUtils.getFile(jsonFile);
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            throw new DataExtractionException("Error reading JSON file: discount.json");
        }
        return data;
    }

    @Override
    public Discount save(Discount entity) {
        if (entity == null)
            return null;

        if (discounts == null)
            discounts = new ArrayList<>();

        discounts.add(entity);

        return entity;
    }

    @Override
    public Discount remove(Integer id) {
        var productToDelete = discounts
                .stream()
                .filter(post -> post.getDiscountId().equals(id))
                .findFirst()
                .orElse(null);

        if (productToDelete == null)
            return null;

        discounts.remove(productToDelete);

        return productToDelete;
    }

    @Override
    public Optional<Discount> get(Integer id) {
        return discounts
                .stream()
                .filter(post -> post.getDiscountId().equals(id))
                .findFirst();
    }

    @Override
    public List<Discount> findAll() {
        return discounts;
    }

    @Override
    public Discount update(Discount entity) {
        discounts = discounts
                .stream()
                .map(discount -> discount.getDiscountId().equals(entity.getDiscountId()) ? entity : discount)
                .toList();

        return entity;
    }

    @Override
    public Optional<Discount> getDiscountByProductId(Integer productId) {
        return discounts
              .stream()
              .filter(post -> post.getProductId().equals(productId))
              .findFirst();
    }
}
