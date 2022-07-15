package com.example.gestionStock.Entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="mvtStock")

public class MvtStock extends AbstractEntity {

	
	
	
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;
}
