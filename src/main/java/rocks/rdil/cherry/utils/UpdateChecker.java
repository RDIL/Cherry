package rocks.rdil.cherry.utils;

import lombok.NoArgsConstructor;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import rocks.rdil.cherry.Startup;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
public class UpdateChecker {
    public static HttpClient httpclient = HttpClients.createDefault();

    public boolean isUpToDate() {
        try {
            HttpPost tmp = new HttpPost("https://backend.rdil.rocks/cherryCheckUpdate");
            List<NameValuePair> params = new ArrayList<>(0);
            try {
                tmp.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return Objects.equals(
                    EntityUtils.toString(
                            httpclient.execute(tmp).getEntity(), "UTF-8"
                    ), Startup.VERSION);
        } catch (Exception e) {
            return false;
        }
    }
}
