package com.basant.hazlecast.cache.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "USER")
@Setter
@Getter
@AllArgsConstructor
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = -1818061710613422175L;

	@Id
	private int id;
	private String name;
	private String address;

	public User() {
		super();
	}

}
