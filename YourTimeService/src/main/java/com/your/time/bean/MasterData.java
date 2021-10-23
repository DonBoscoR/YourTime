package com.your.time.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.your.time.util.MongodbMapperUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection=MongodbMapperUtil.Collections.MASTER_DATA)
public class MasterData  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    private String id;
	private String type;
	private String code;
	private String value;
	private int isActive;
	private int order;
}
