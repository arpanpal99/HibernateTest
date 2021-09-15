package com.convhibernate.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class ChapterPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "book_isbn")
	private String bookIsbn;
	@Column(name = "chapter_number")
	private Integer chapterNumber;

}














