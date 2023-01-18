package shop.mtcoding.buyer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductRepository {
    public int insert(@Param("name") String name, @Param("price") Integer price, @Param("qty") Integer qty);
    public List<Product> findAll();
    public Product findByID(int id);
    public int updateById(@Param("id") int id, @Param("name") String name, @Param("price") Integer price, @Param("qty") Integer qty);
    public int deleteById(int id);
}
