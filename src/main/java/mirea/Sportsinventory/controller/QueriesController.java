package mirea.Sportsinventory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import mirea.Sportsinventory.entity.Credential;
import mirea.Sportsinventory.service.CredentialService;
import mirea.Sportsinventory.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("api/queries")
@Tag(name = "Queries Controller")
public class QueriesController {
    @Autowired
    private QueryService queryService;

    @PostMapping("/insertProductMonkeyBars")
    @Operation(summary = "Добавить шведскую стенку")
    public String insertProductMonkeyBars(Model model,
                                          @Parameter(name = "height", required = true, description = "Высота шведской стенки в метрах", example = "4.00") @RequestParam double height,
                                          @Parameter(name = "width", required = true, description = "Ширина шведской стенки в метрах", example = "2.00") @RequestParam double width) {
        queryService.insertProductMonkeyBars(height, width);
        return "/index";
    }

    @PostMapping("/insertProductBall")
    @Operation(summary = "Добавить мяч")
    public String insertProductBall(Model model,
                                    @Parameter(name = "type", required = true, description = "Тип мяча", example = "basketball") @RequestParam String type,
                                    @Parameter(name = "volume", required = true, description = "Объем мяча в м^3", example = "1.00") @RequestParam double volume) {
        queryService.insertProductBall(type, volume);
        return "/index";
    }

    @PostMapping("/insertProductDumbell")
    @Operation(summary = "Добавить гантель")
    public String insertProductDumbell(Model model,
                                       @Parameter(name = "weight", required = true, description = "Вес гантели в кг", example = "10.00") @RequestParam double weight) {
        queryService.insertProductDumbell(weight);
        return "/index";
    }

    @PostMapping("/insertProductHorizontalBar")
    @Operation(summary = "Добавить турник")
    public String insertProductHorizontalBar(Model model,
                                             @Parameter(name = "type", required = true, description = "Тип турника", example = "door") @RequestParam String type,
                                             @Parameter(name = "diameter", required = true, description = "Диаметр перекладины в см", example = "3.00") @RequestParam double diameter,
                                             @Parameter(name = "width", required = true, description = "Ширина перекладины в см", example = "80.00") @RequestParam double width) {
        queryService.insertProductHorizontalBar(type, diameter, width);
        return "/index";
    }

    @PostMapping("/insertProductMat")
    @Operation(summary = "Добавить мат")
    public String insertProductMat(Model model,
                                   @Parameter(name = "square", required = true, description = "Площадь мата в м^2", example = "5.00") @RequestParam double square) {
        queryService.insertProductMat(square);
        return "/index";
    }

    @PostMapping("/insertProductRope")
    @Operation(summary = "Добавить канат")
    public String insertProductRope(Model model,
                                    @Parameter(name = "length", required = true, description = "Длина каната в м", example = "4.00") @RequestParam double length) {
        queryService.insertProductRope(length);
        return "/index";
    }

    @GetMapping("/getAllUsers")
    @Operation(summary = "Получить всех пользователей")
    public String getAllUsers(Model model) {
        model.addAttribute("listOfAllUsers", queryService.getAllUsers());
        return "/index";
    }

    @GetMapping("/getCatalogue")
    @Operation(summary = "Получить каталог")
    public String getCatalogue(Model model) {
        model.addAttribute("listOfCatalogue", queryService.getCatalogue());
        return "/index";
    }

    @PostMapping("/getAmountFromWarehouseByCatalogueName")
    @Operation(summary = "Получить количество товара со склада по названию в каталоге")
    public String getAmountFromWarehouseByCatalogueName(Model model, String name) {
        Map.Entry<String, Double> entry = queryService.getAmountFromWarehouseByCatalogueName(name);
        model.addAttribute("catalogueName", entry.getKey());
        model.addAttribute("warehouseAmount", entry.getValue());
        return "/index";
    }

    @PostMapping("/getVendorNameByShipmentName")
    @Operation(summary = "Получить название поставщика по названю поставки")
    public String getVendorNameByShipmentName(Model model, String name) {
        Map.Entry<String, String> entry = queryService.getVendorNameByShipmentName(name);
        model.addAttribute("shipmentName", entry.getKey());
        model.addAttribute("vendorName", entry.getValue());
        return "/index";
    }

    @PostMapping("/getMaterialByProductName")
    @Operation(summary = "Получить материал по названию продукта")
    public String getMaterialByProductName(Model model, String name) {
        Map.Entry<String, String> entry = queryService.getMaterialByProductName(name);
        model.addAttribute("productName", entry.getKey());
        model.addAttribute("materialName", entry.getValue());
        return "/index";
    }

    @PostMapping("/deleteProductMat")
    @Operation(summary = "Удалить мат по его id")
    public String deleteProductMat(Model model, String matIdForDelete) {
        queryService.deleteProductMat(matIdForDelete);
        return "/index";
    }

}
