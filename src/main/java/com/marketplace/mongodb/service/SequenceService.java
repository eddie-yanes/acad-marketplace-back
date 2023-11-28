package com.marketplace.mongodb.service;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.marketplace.mongodb.model.Sequence;

@Service
public class SequenceService {
	
	@Autowired
	private MongoOperations mongo;
	
	public int getNextSequence(String seqName) {
		
		Query query = Query.query(Criteria.where("_id").is(seqName));
		
		Sequence counter = mongo.findAndModify(
				query, 
				new Update().inc("seq",1), 
				FindAndModifyOptions.options().returnNew(true).upsert(true), 
				Sequence.class
		);
		
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
	
}
