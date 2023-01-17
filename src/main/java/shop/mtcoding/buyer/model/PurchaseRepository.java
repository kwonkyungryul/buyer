package shop.mtcoding.buyer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseRepository {
    public int insert(Integer userId, Integer productId);
    public List<Purchase> findAll();
    public Purchase findByID(int id);
    public int updateById(int id, Integer userId, Integer productId);
    public int deleteById(int id);
}
