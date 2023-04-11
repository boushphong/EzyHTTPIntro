import com.tvd12.ezyhttp.client.HttpClientProxy;
import com.tvd12.ezyhttp.client.request.GetRequest;
import com.tvd12.ezyhttp.client.request.Request;
import com.tvd12.ezyhttp.client.request.RequestEntity;
import com.tvd12.ezyhttp.core.constant.StatusCodes;

public class ApiGetUserTest {
    public static void main(String[] args) throws Exception {
        HttpClientProxy httpClient = HttpClientProxy.builder()
                .build();
        httpClient.start();
        RequestEntity entity = RequestEntity.builder().build();
        Request helloRequest = new GetRequest()
                .setURL("http://localhost:8080/api/v1/users/dev")
                .setEntity(entity)
                .setResponseType(String.class)
                .setResponseType(StatusCodes.NOT_FOUND, String.class);
        String reponse = httpClient.call(helloRequest, 10000);
        System.out.println("get user reponse: " + reponse);
    }
}
