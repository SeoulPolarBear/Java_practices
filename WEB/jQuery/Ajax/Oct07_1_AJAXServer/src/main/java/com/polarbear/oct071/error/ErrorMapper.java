package com.polarbear.oct071.error;

import java.util.List;

public interface ErrorMapper {
	
public abstract List<Error>	getAllError();
public abstract List<Error> getSearchError(Error e);
}
