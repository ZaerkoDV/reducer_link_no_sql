package com.instinctools.reducerlink.model.support;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = SequenceGenerator.COLLECTION_NAME)
public class SequenceGenerator {
    public static final String COLLECTION_NAME = "sequence_generator";

    @Id
	private String id;
	private Long sequence;

    public SequenceGenerator() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }
}
