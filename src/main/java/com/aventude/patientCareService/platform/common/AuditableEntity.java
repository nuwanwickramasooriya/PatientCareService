/**
 * 
 */
package com.aventude.patientCareService.platform.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity extends TimestampEntity {
	@CreatedBy
	@Column(name = "created_by", updatable = false)
	private UUID createdBy;

	@Column(name = "last_updated_by")
	private UUID lastUpdatedBy;

	@PrePersist
	public void prePersist() {
		if (lastUpdatedBy == null)
			this.lastUpdatedBy = this.createdBy;
	}

}
