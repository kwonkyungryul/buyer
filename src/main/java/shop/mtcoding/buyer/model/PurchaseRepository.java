package shop.mtcoding.buyer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PurchaseRepository {
    public int insert(@Param("userId") Integer userId, @Param("productId") Integer productId);
    public List<Purchase> findAll();
    public Purchase findByID(int id);
    public int updateById(int id, @Param("userId") Integer userId, @Param("productId") Integer productId);
    public int deleteById(int id);
}
