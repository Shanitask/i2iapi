package com.Beautosite.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


	@Data
	@ToString

	public class UserDto {
		
		
		private int id;
		private String organizationName;
		private String mailId;
		private String discription;
		private String buildedTeam;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getOrganizationName() {
			return organizationName;
		}
		public void setOrganizationName(String organizationName) {
			this.organizationName = organizationName;
		}
		public String getMailId() {
			return mailId;
		}
		public void setMailId(String mailId) {
			this.mailId = mailId;
		}
		public String getDiscription() {
			return discription;
		}
		public void setDiscription(String discription) {
			this.discription = discription;
		}
		public String getBuildedTeam() {
			return buildedTeam;
		}
		public void setBuildedTeam(String buildedTeam) {
			this.buildedTeam = buildedTeam;
		}
		
		
}
