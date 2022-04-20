package mirea.Sportsinventory.controller;

import mirea.Sportsinventory.entity.Credential;
import mirea.Sportsinventory.service.CredentialService;
import mirea.Sportsinventory.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class QueriesController {
    @Autowired
    private QueryService queryService;

    @PostMapping("/insertProductMonkeyBars")
    public String insertProductMonkeyBars(Model model, double height, double width) {
        queryService.insertProductMonkeyBars(height, width);
        return "/index";
    }

    @PostMapping("/insertProductBall")
    public String insertProductBall(Model model, String type, double volume) {
        queryService.insertProductBall(type, volume);
        return "/index";
    }

    @PostMapping("/insertProductDumbell")
    public String insertProductDumbell(Model model, double weight) {
        queryService.insertProductDumbell(weight);
        return "/index";
    }

    @PostMapping("/insertProductHorizontalBar")
    public String insertProductHorizontalBar(Model model, String type, double diameter, double width) {
        queryService.insertProductHorizontalBar(type, diameter, width);
        return "/index";
    }

    @PostMapping("/insertProductMat")
    public String insertProductMat(Model model, double square) {
        queryService.insertProductMat(square);
        return "/index";
    }

    @PostMapping("/insertProductRope")
    public String insertProductRope(Model model, double length) {
        queryService.insertProductRope(length);
        return "/index";
    }

    @GetMapping("/getAllUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("listOfAllUsers", queryService.getAllUsers());
        return "/index";
    }

    @GetMapping("/getCatalogue")
    public String getCatalogue(Model model) {
        model.addAttribute("listOfCatalogue", queryService.getCatalogue());
        return "/index";
    }

    @PostMapping("/getAmountFromWarehouseByCatalogueName")
    public String getAmountFromWarehouseByCatalogueName(Model model, String name) {
        Map.Entry<String, Double> entry = queryService.getAmountFromWarehouseByCatalogueName(name);
        model.addAttribute("catalogueName", entry.getKey());
        model.addAttribute("warehouseAmount", entry.getValue());
        return "/index";
    }

    @PostMapping("/getVendorNameByShipmentName")
    public String getVendorNameByShipmentName(Model model, String name) {
        Map.Entry<String, String> entry = queryService.getVendorNameByShipmentName(name);
        model.addAttribute("shipmentName", entry.getKey());
        model.addAttribute("vendorName", entry.getValue());
        return "/index";
    }

    @PostMapping("/getMaterialByProductName")
    public String getMaterialByProductName(Model model, String name) {
        Map.Entry<String, String> entry = queryService.getMaterialByProductName(name);
        model.addAttribute("productName", entry.getKey());
        model.addAttribute("materialName", entry.getValue());
        return "/index";
    }

    @PostMapping("/deleteProductMat")
    public String deleteProductMat(Model model, String matIdForDelete) {
        queryService.deleteProductMat(matIdForDelete);
        return "/index";
    }

}
