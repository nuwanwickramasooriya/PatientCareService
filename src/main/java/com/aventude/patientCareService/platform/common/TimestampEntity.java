/**
 * 
 */
package com.aventude.patientCareService.platform.common;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
@Getter
@Setter
public class TimestampEntity extends BaseEntity {
	
	@Column(name = "created_date", nullable = false, insertable = false, updatable = false)
	private DateTime createdDate;

	@Column(name = "last_updated_date")
	private DateTime lastUpdatedDate;

	@PrePersist
	protected void onTimeStampEntityCreate() {
		lastUpdatedDate = createdDate = new DateTime();
	}

	@PreUpdate
	protected void onTimeStampEntityUpdate() {
		lastUpdatedDate = new DateTime();
	}

}
