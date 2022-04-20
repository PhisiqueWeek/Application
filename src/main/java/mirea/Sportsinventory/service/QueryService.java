package mirea.Sportsinventory.service;

import mirea.Sportsinventory.entity.*;
import mirea.Sportsinventory.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QueryService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    CatalogueRepository catalogueRepository;
    @Autowired
    ProductMonkeyBarRepository productMonkeyBarRepository;
    @Autowired
    ProductBallRepository productBallRepository;
    @Autowired
    ProductDumbellRepository productDumbellRepository;
    @Autowired
    ProductHorizontalBarRepository productHorizontalBarRepository;
    @Autowired
    ProductMatRepository productMatRepository;
    @Autowired
    ProductRopeRepository productRopeRepository;

    private Connection conn = null;

    {
        String url = "jdbc:postgresql://localhost/sport_inventory";
        try {
            conn = DriverManager.getConnection(url,"postgres","postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProductMonkeyBars(double height, double width) {
        ProductMonkeyBar productMonkeyBar = new ProductMonkeyBar();
        productMonkeyBar.setProduct(catalogueRepository.findById("69bf767a-ad82-49cf-8442-304f7bdce750").get());
        productMonkeyBar.setHeightCm(height);
        productMonkeyBar.setWidthCm(width);
        productMonkeyBarRepository.save(productMonkeyBar);
    }

    public void insertProductBall(String type, double volume) {
        ProductBall productBall = new ProductBall();
        productBall.setProduct(catalogueRepository.findById("039d683b-fe44-46e3-91e8-8240c7e65489").get());
        productBall.setType(type);
        productBall.setVolumeCm3(volume);
        productBallRepository.save(productBall);
    }

    public void insertProductDumbell(double weight) {
        ProductDumbell productDumbell = new ProductDumbell();
        productDumbell.setProduct(catalogueRepository.findById("344036e8-9c07-48d2-84c8-7aa251f55f52").get());
        productDumbell.setWeightKg(weight);
        productDumbellRepository.save(productDumbell);
    }

    public void insertProductHorizontalBar(String type, double diameter, double width) {
        ProductHorizontalBar productHorizontalBar = new ProductHorizontalBar();
        productHorizontalBar.setProduct(catalogueRepository.findById("69bf767a-ad82-49cf-8442-304f7bdce750").get());
        productHorizontalBar.setType(type);
        productHorizontalBar.setDiameterMm(diameter);
        productHorizontalBar.setWidthCm(width);
        productHorizontalBarRepository.save(productHorizontalBar);
    }

    public void insertProductMat(double square) {
        ProductMat productMat = new ProductMat();
        productMat.setProduct(catalogueRepository.findById("8e1546f9-92c7-4084-99bc-a091af6ec0c7").get());
        productMat.setSquareCm2(square);
        productMatRepository.save(productMat);
    }

    public void insertProductRope(double length) {
        ProductRope productRope = new ProductRope();
        productRope.setProduct(catalogueRepository.findById("e74c3d7a-5e2d-4053-a1d8-7c3db5203389").get());
        productRope.setLengthCm(length);
        productRopeRepository.save(productRope);
    }

    public List<User> getAllUsers() {
        Query query = this.em.createNativeQuery(
                "SELECT * FROM public.user", User.class);
        return new ArrayList<User>(query.getResultList());
    }

    public List<Catalogue> getCatalogue() {
        Query query = this.em.createNativeQuery(
                "SELECT * FROM public.catalogue", Catalogue.class);
        return new ArrayList<Catalogue>(query.getResultList());
    }

    public Map.Entry<String, Double> getAmountFromWarehouseByCatalogueName(String name) {
        Map.Entry<String, Double> entry = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT t1.name, t2.amount FROM public.catalogue AS t1 LEFT JOIN public.warehouse as t2 ON t1.product_id = t2.product_id WHERE t1.name = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            entry = new AbstractMap.SimpleEntry<String, Double>(resultSet.getString("name"), resultSet.getDouble("amount"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entry;
    }

    public Map.Entry<String, String> getVendorNameByShipmentName(String name) {
        Map.Entry<String, String> entry = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT t1.shipment_name, t2.vendor_name FROM public.shipment AS t1 LEFT JOIN public.vendor as t2 ON t1.vendor_id = t2.vendor_id WHERE t1.shipment_name = ?;");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            entry = new AbstractMap.SimpleEntry<String, String>(resultSet.getString("shipment_name"), resultSet.getString("vendor_name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entry;
    }

    public Map.Entry<String, String> getMaterialByProductName(String name) {
            Map.Entry<String, String> entry = null;
            try {
                PreparedStatement preparedStatement = conn.prepareStatement("SELECT t1.name as product_name, t2.name as material_name FROM public.catalogue AS t1 LEFT JOIN public.material as t2 ON t1.material_id = t2.material_id WHERE t1.name = ?;");
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();

                entry = new AbstractMap.SimpleEntry<String, String>(resultSet.getString("product_name"), resultSet.getString("material_name"));

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return entry;
        }

    public void deleteProductMat(String id) {
        productMatRepository.deleteById(id);
    }

}
