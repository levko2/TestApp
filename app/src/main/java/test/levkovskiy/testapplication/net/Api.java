package test.levkovskiy.testapplication.net;

import retrofit2.Call;
import retrofit2.http.GET;
import test.levkovskiy.testapplication.net.response.CustomerProfileModel2;

/**
 * Created by Admin on 27.10.2016.
 */

public interface Api {

    @GET("customers/91c3924f-50aa-4acf-9fc1-28148e883c4e/userProfile")
    Call<CustomerProfileModel2> getInfo();
}

