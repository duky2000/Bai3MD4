package Controllers;

import Model.Product;
import Service.ProducService;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {
    ProducService producService = new ProducService();

    @RequestMapping("/homeProduct")
    public String home(HttpServletRequest request) {
        request.setAttribute("listProduct", producService.list);
        return "home";
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam("index") int index) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product",producService.list.get(index));
        modelAndView.addObject("index",index);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int index) {
        producService.remove(index);
        return "redirect:/homeProduct";
    }

    @GetMapping("/find")
    public ModelAndView find(@RequestParam("find") String name) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("listProduct", producService.find(name));
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product) {
        producService.add(product);
        return "redirect:/homeProduct";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam MultipartFile uppImg,@ModelAttribute Product product, @RequestParam int index) {
        String nameImg = uppImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("C:\\Users\\DELL\\IdeaProjects\\untitledv\\src\\main\\webapp\\file\\" + nameImg));
            String urlImg = "/upload/file/" + nameImg;
            product.setImg(urlImg);
        } catch (IOException e) {
            System.err.println("error upload file");
            e.printStackTrace();
        }
        producService.edit( index,product);
        return "redirect:/homeProduct";
    }


}
