package com.convhibernate.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "chapter")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class Chapter implements Serializable{

	private static final long serialVersionUID = -3161146984865936553L;
	@EmbeddedId
	private ChapterPK chapterPK;
	//@Column(name = "title")
	private String title;
	
	
}














