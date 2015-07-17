package com.mum.edu.happycart.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "total_amount", nullable=false)
	private double totalAmount;

	@Column(name = "ordered_date", nullable=false)
	private Date orderedDate;

	@OneToMany(mappedBy = "order", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<OrderDetail> orderDetail;
	
	  @OneToOne (cascade=CascadeType.ALL)
	  @JoinColumn(name="user_id", unique= false, nullable=true, insertable=true, updatable=true)
	  private User user;
	
	public void add(OrderDetail orderDetail){
		this.orderDetail.add(orderDetail);
	}

	
	public double getTotalAmount() {
		return totalAmount;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}
