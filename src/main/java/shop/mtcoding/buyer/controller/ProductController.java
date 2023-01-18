package shop.mtcoding.buyer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer.model.Product;
import shop.mtcoding.buyer.model.ProductRepository;
import shop.mtcoding.buyer.model.PurchaseRepository;

@Controller
public class ProductController {
    
    @Autowired
    ProductRepository productRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @GetMapping({"/", "product"})
    public String home(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, Model model) {
        Product product = productRepository.findByID(id);
        model.addAttribute("product", product);
        return "product/detail";
    }

    @GetMapping("/product/{id}/purchaseForm")
    public String purchaseForm(@PathVariable int id, Model model) {
        Product product = productRepository.findByID(id);
        model.addAttribute(product);
        return "product/purchaseForm";
    }

    @PostMapping("/product/{id}/purchase")
    public String purchase(@PathVariable int id, int userId, int productId, int qty, int count, Model model) {
        int result = purchaseRepository.insert(userId, productId);
        
        if (count > 0 && count <= qty) {
            productRepository.updateToQty(id, (qty - count));
        } else {
            model.addAttribute("msg", "올바르지 않은 값입니다.");
            return "redirect:/product/" + id + "/purchaseForm";
        }

        if (result == 1) {
            return "redirect:/product/" + id;
        } else {
            return "redirect:/product/" + id + "/purchaseForm";
        }
    }
}
