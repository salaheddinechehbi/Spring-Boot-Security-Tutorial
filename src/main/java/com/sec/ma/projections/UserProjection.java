package com.sec.ma.projections;

import org.springframework.data.rest.core.config.Projection;

import com.sec.ma.entities.User;

@Projection(name = "infoPers", types = User.class)
public interface UserProjection {

	public String getUserName();
	public String getTele();
	public String getEmail();
	public String getPassword();
	public String getNom();
}
