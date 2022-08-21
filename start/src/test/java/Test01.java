import com.zb.Application;
import com.zb.pojo.Warehouse;
import com.zb.service.WarehouseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = {Application.class})
public class Test01 {

    @Autowired
    private WarehouseService warehouseService;

    @Test
    void test(){
        List<Warehouse> all = warehouseService.findAll();
        System.out.println(all);
    }

}
