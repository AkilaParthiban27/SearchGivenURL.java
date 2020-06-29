import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.net.URI;
import java.awt.Desktop;
class URLEncodingExample {

    // Method to encode a string value using `UTF-8` encoding scheme
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    public static void main(String[] args)throws URISyntaxException,IOException
    {
        String baseUrl = "https://www.google.com/search?q=";

        String query = "https://www.amazon.in/Lenovo-Ideapad-A6-9225-Windows-81N30063IN/dp/B081Z4H8BM/ref=sr_1_3?dchild=1&keywords=laptop&qid=1592895466&sr=8-3";
        String encodedQuery = encodeValue(query); // Encoding a query string

        String completeUrl = baseUrl + encodedQuery;
        Desktop desktop=java.awt.Desktop.getDesktop();
        URI URI=new URI(completeUrl);
        desktop.browse(URI);
        System.out.println("WebPage opened");
    }
}
