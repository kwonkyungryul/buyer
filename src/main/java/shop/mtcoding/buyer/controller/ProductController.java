package shop.mtcoding.buyer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import shop.mtcoding.buyer.model.Product;
import shop.mtcoding.buyer.model.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Autowired랑 같다.
    // 아래 매개변수가 있는 생성자를 구현시 디폴트 생성자가 사라지기 때문에 Spring은 아래 매개변수가 있는 생성자를 호출한다
    // 호출시 매개변수에 ProductRepository 타입이 필요하기 때문에 IOC에서 new가 돼있는지 확인 후 맞는 타입을 넣어준다. DI
    // public ProductController(ProductRepository productRepository) {
    //     this.productRepository = productRepository;
    // }

    @GetMapping({ "/", "/product" })
    public String home(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    // select * from product where price = 1000
    // pk가 아니면 queryString으로 전송
    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, Model model) {
        Product product = productRepository.findById(id);
        // 에러페이지
        if (product == null) {
            return "redirect:/notfound";
        } else {
            model.addAttribute("product", product);
            return "product/detail";
        }
    }

    
}
