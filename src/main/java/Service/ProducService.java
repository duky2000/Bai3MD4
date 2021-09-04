package Service;

import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProducService {
    public List<Product> list = new ArrayList<>();

    public ProducService() {
        list.add(new Product(1, "OPP", "30000", "https://cellphones.com.vn/sforum/wp-content/uploads/2020/04/thong-tin-OPPO-A12-1.jpg", "99%"));
        list.add(new Product(2, "Iphone", "20000", "data:image/jpeg;base64,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", "100%"));
        list.add(new Product(3, "SamSung", "70000", "data:image/jpeg;base64,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", "99%"));
    }

    public void add(Product product) {
        list.add(product);
    }

    public void edit(int id, Product product) {
        list.set(id, product);
    }

    public void remove(int id) {
        list.remove(id);
    }

    public List<Product> find(String name) {
        ArrayList<Product> list1 = new ArrayList<>();
        for (Product p : list) {
            if (p.getName().contains(name)) {
                list1.add(p);
            }
        }
        return list1;
    }
}