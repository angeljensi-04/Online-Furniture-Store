package com.onlinefurniturestore.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class FurnitureOrder {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String orderId;
	private Date orderDate;
	@ManyToOne
	@JoinColumn(name = "furniture")
	private Furniture furniture;
	@ManyToOne
	@JoinColumn(name = "customer")
	private Customer customer;
	@NotBlank(message = "Quantity should not be blank")
	private int quanity;
	@NotBlank(message = "Price should not be blank")
	@DecimalMin(value = "100.0", message = "Amount must be a number at least 100")
	private double price;
	@NotBlank(message = "Amount should not be blank")
	@DecimalMin(value = "100.0", message = "Amount must be a number at least 100")
	private double amount;
	@Pattern(regexp = "^[A-Za-z ]{1,20}$", message = "Status must only be alphabets and whitespaces from 1 to 20 characters")
	private String status;

	public FurnitureOrder() {
	}

	public FurnitureOrder(String orderId, Date orderDate, Furniture furniture, Customer customer, int quanity,
			double price, double amount, String status) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.furniture = furniture;
		this.customer = customer;
		this.quanity = quanity;
		this.price = price;
		this.amount = amount;
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Furniture getFurniture() {
		return furniture;
	}

	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FurnitureOrder other = (FurnitureOrder) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

}
