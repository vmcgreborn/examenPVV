/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pvv.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



/**
 *
 * @author vcamacho
 */
@Entity
@Table(name = "RESULTS", catalog = "")

public class ResultsDO   implements Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7300073856534897609L;
	/*
	@SequenceGenerator(
			name = "RESULT_GEN",
			sequenceName = "SQ_RESULT",
			allocationSize = 1,
			initialValue = 10
			)*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Id()
    @Column(name = "id")
    private Long id;


    @Column
    private String operation;
    @Column
    private Double val1;
    @Column
    private Double val2;
    
    @Column
    private Double result;
    
    
    


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}


	public Double getVal1() {
		return val1;
	}


	public void setVal1(Double val1) {
		this.val1 = val1;
	}


	public Double getVal2() {
		return val2;
	}


	public void setVal2(Double val2) {
		this.val2 = val2;
	}


	public Double getResult() {
		return result;
	}


	public void setResult(Double result) {
		this.result = result;
	}


	public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    
    public boolean equals(Object object) {
        // Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultsDO)) {
            return false;
        }
        ResultsDO other = (ResultsDO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}