package com.instinctools.reducerlink.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = LinkHistory.COLLECTION_NAME)
public class LinkHistory extends BaseEntity<Long> {
	public static final String COLLECTION_NAME = "link_history";

	@Id
    private Long id;

	private Long createdAtTimestamp;

	private Long sumClick;

	@DBRef
	private Link link;
	
	@Override
    public Long getId() {
        return id;
    }

    public LinkHistory setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getCreatedAtTimestamp() {
        return createdAtTimestamp;
    }

    public LinkHistory setCreatedAtTimestamp(Long createdAtTimestamp) {
        this.createdAtTimestamp = createdAtTimestamp;
        return this;
    }

    public Long getSumClick() {
        return sumClick;
    }

    public LinkHistory setSumClick(Long sumClick) {
        this.sumClick = sumClick;
        return this;
    }

    public Link getLink() {
        return link;
    }

    public LinkHistory setLink(Link link) {
        this.link = link;
        return this;
    }    
}
