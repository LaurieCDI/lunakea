
package com.mycompany.lunakea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Dimension implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    
    @JsonProperty("width")
    private int dimWidth;
    
    @JsonProperty("depth")
    private int dimDepth;
    
    @JsonProperty("height")
    private int dimHeight;
    
    @JsonIgnore
    @OneToOne(mappedBy = "dimension")
    private Product product;

    
    
    public Dimension() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getWidth() {
        return dimWidth;
    }

    public void setWidth(int width) {
        this.dimWidth = width;
    }

    public int getDepth() {
        return dimDepth;
    }

    public void setDepth(int depth) {
        this.dimDepth = depth;
    }

    public int getHeight() {
        return dimHeight;
    }

    public void setHeight(int height) {
        this.dimHeight = height;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    

    @Override
    public String toString() {
        return "Dimension{" + "width=" + dimWidth + ", depth=" + dimDepth + ", height=" + dimHeight + '}';
    }
    
}
