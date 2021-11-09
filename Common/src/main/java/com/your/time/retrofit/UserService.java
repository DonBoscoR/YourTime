package com.your.time.retrofit;

import com.your.time.dto.UserDto;
import com.your.time.util.YourTimeRestURIConstants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
	
	@POST(YourTimeRestURIConstants.UsersWS.WS_USER_AUTHENDICATE)
	public Call<UserDto> authendicate(@Body UserDto userDto);
}
