package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product_category database table.
 * 
 */
@Entity
@Table(name="product_category")
@NamedQuery(name="ProductCategory.findAll", query="SELECT p FROM ProductCategory p")
public class ProductCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="create_uid")
	private Integer createUid;

	private String name;

	@Column(name="parent_id")
	private Integer parentId;

	@Column(name="removal_strategy_id")
	private Integer removalStrategyId;

	@Column(name="write_uid")
	private Integer writeUid;

	//bi-directional many-to-one association to ProductTemplate
	@OneToMany(mappedBy="productCategory")
	private List<ProductTemplate> productTemplates;

	public ProductCategory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCreateUid() {
		return this.createUid;
	}

	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getRemovalStrategyId() {
		return this.removalStrategyId;
	}

	public void setRemovalStrategyId(Integer removalStrategyId) {
		this.removalStrategyId = removalStrategyId;
	}

	public Integer getWriteUid() {
		return this.writeUid;
	}

	public void setWriteUid(Integer writeUid) {
		this.writeUid = writeUid;
	}

	public List<ProductTemplate> getProductTemplates() {
		return this.productTemplates;
	}

	public void setProductTemplates(List<ProductTemplate> productTemplates) {
		this.productTemplates = productTemplates;
	}

	public ProductTemplate addProductTemplate(ProductTemplate productTemplate) {
		getProductTemplates().add(productTemplate);
		productTemplate.setProductCategory(this);

		return productTemplate;
	}

	public ProductTemplate removeProductTemplate(ProductTemplate productTemplate) {
		getProductTemplates().remove(productTemplate);
		productTemplate.setProductCategory(null);

		return productTemplate;
	}

}