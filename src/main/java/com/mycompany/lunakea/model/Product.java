
package com.mycompany.lunakea.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries({
  @NamedQuery(name = "model.Product.findAll", query = "SELECT p FROM Product p JOIN p.dimension d ORDER BY p.name ASC"),
  @NamedQuery(name = "model.Product.findById", query = "SELECT p FROM Product p JOIN p.dimension d WHERE p.id LIKE :paramId"),
  @NamedQuery(name = "model.Product.findByKeyword", query = "SELECT p FROM Product p JOIN p.dimension d WHERE p.name LIKE :paramKey OR p.description LIKE :paramKey"),
  @NamedQuery(name = "model.Product.findByEan", query = "SELECT p FROM Product p JOIN p.dimension d WHERE p.ean LIKE :paramEan ORDER BY p.ean ASC")        
})

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {
    
    
    @Id
    @JsonProperty("id")
    private Long id;
    
    @Column(name = "PR_EAN")
    @JsonProperty("ean")
    private String ean;
    
    @Column(name = "PR_NAME")
    @JsonProperty("name")
    private String name;
    
    @Column(name = "PR_DESCRIPTION")
    @JsonProperty("description")
    private String description;
    
    @Column(name = "PR_PRICE")
    @JsonProperty("price")
    private float price;
    
    @Column(name = "PR_ASSEMBLED")
    @JsonProperty("assembled")
    private boolean assembled;
    
    @Column(name = "PR_WEIGHT")
    @JsonProperty("weight")
    private float weight;
    
    @OneToOne
    @JsonProperty("dimension")
    private Dimension dimension;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAssembled() {
        return assembled;
    }

    public void setAssembled(boolean assembled) {
        this.assembled = assembled;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", ean=" + ean + ", name=" + name + ", description=" + description + ", price=" + price + ", assembled=" + assembled + ", weight=" + weight + ", dimension=" + dimension + '}';
    }
    


    //Méthode de comparaison par prix pour tri
    public static Comparator<Product> ComparatorPrice = new Comparator<Product>() {
     
        @Override
        public int compare(Product p1, Product p2) {
            return (int) (p2.getPrice() - p1.getPrice());
        }
    };
    
}
