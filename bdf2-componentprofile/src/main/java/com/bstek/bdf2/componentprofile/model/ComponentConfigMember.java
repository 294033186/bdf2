/*
 * @author Bing
 * @since 2013-03-05
 */
package com.bstek.bdf2.componentprofile.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "BDF2_CP_COMP_MEMB")
public class ComponentConfigMember implements java.io.Serializable, Cloneable {
	private static final long serialVersionUID = -7658024545081912471L;
	public static final String CONTROL_TYPE_INDICATOR_COLUMN = "IndicatorColumn";
	public static final String CONTROL_TYPE_ROW_NUM_COLUMN = "RowNumColumn";
	public static final String CONTROL_TYPE_ROW_SELECTOR_COLUMN = "RowSelectorColumn";
	public static final String CONTROL_TYPE_DATA_COLUMN = "DataColumn";
	public static final String CONTROL_TYPE_COLUMN_GROUP = "ColumnGroup";

	@Id
	@Column(name = "ID_", length = 50)
	private String id;

	@Column(name = "CONTROL_NAME_", length = 50)
	private String controlName;

	@Column(name = "CONTROL_TYPE_", length = 20)
	private String controlType;

	@Column(name = "ORDER_")
	private Integer order;

	@Column(name = "PARENT_CONTROL_NAME_", length = 50)
	private String parentControlName;

	@Column(name = "CAPTION_", length = 50)
	private String caption;

	@Column(name = "WIDTH_", length = 50)
	private String width;

	@Column(name = "COL_SPAN_")
	private Integer colSpan;

	@Column(name = "ROW_SPAN_")
	private Integer rowSpan;

	@Column(name = "VISIBLE_")
	private Boolean visible;

	@Transient
	private List<ComponentConfigMember> children = null;

	@ManyToOne
	@JoinColumn(name = "CONFIG_ID_")
	private ComponentConfig componentConfig;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getControlName() {
		return this.controlName;
	}

	public void setControlName(String controlName) {
		this.controlName = controlName;
	}

	public String getControlType() {
		return this.controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getParentControlName() {
		return this.parentControlName;
	}

	public void setParentControlName(String parentControlName) {
		this.parentControlName = parentControlName;
	}

	public String getCaption() {
		return this.caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getWidth() {
		return this.width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public Integer getColSpan() {
		return this.colSpan;
	}

	public void setColSpan(Integer colSpan) {
		this.colSpan = colSpan;
	}

	public Integer getRowSpan() {
		return this.rowSpan;
	}

	public void setRowSpan(Integer rowSpan) {
		this.rowSpan = rowSpan;
	}

	public Boolean getVisible() {
		return this.visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public List<ComponentConfigMember> getChildren() {
		return children;
	}

	public void setChildren(List<ComponentConfigMember> children) {
		this.children = children;
	}

	public void addChildren(ComponentConfigMember member) {
		if (this.children == null) {
			this.children = new ArrayList<ComponentConfigMember>();
		}
		this.children.add(member);
	}

	public ComponentConfig getComponentConfig() {
		return componentConfig;
	}

	public void setComponentConfig(ComponentConfig componentConfig) {
		this.componentConfig = componentConfig;
	}

	public ComponentConfigMember clone() {
		ComponentConfigMember o = null;
		try {
			o = (ComponentConfigMember) super.clone();
			ArrayList<ComponentConfigMember> member = null;

			if (children != null) {
				member = new ArrayList<ComponentConfigMember>();
				for (ComponentConfigMember componentConfigMember : children) {
					member.add(componentConfigMember.clone());
				}
			}
			o.setChildren(member);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
}
