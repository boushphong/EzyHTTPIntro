
import com.boushphong.GitHub.entity.User;
import com.tvd12.ezyhttp.client.HttpClient;
import com.tvd12.ezyhttp.client.request.PostRequest;
import com.tvd12.ezyhttp.client.request.Request;
import com.tvd12.ezyhttp.client.request.RequestEntity;
import com.tvd12.ezyhttp.core.constant.StatusCodes;

public class ApiAddUserTest {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient.builder()
                .build();
        User body = new User();
        body.setUsername("dev");
        body.setPassword("123456");
        RequestEntity entity = RequestEntity.body(body);
        Request request = new PostRequest()
                .setURL("http://localhost:8080/api/v1/users/add")
                .setEntity(entity)
                .setResponseType(Boolean.class)
                .setResponseType(StatusCodes.CONFLICT, String.class);
        Boolean reponse = httpClient.call(request);
        System.out.println("add user reponse: " + reponse);
    }
}
