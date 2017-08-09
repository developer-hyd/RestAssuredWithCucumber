package services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.apache.http.HttpStatus;
import org.junit.Test;


public class VersionTests
{
	private static String ENDPOINT_GET_BOOK_BY_ISBN = "http://localhost:9441/supplierportal/supplierprofile";

	@Test
	public void testGetSupplierProfile(){
		String isbn = "isbn:9781451648546";

		given().
		header("access_token","fdfdsfdfsdfs").
		when().
		get(ENDPOINT_GET_BOOK_BY_ISBN)
		.then().
		statusCode(HttpStatus.SC_UNAUTHORIZED);
		/*body(	"totalItems", equalTo(2),
				"kind", equalTo("books#volumes"),
				"items.volumeInfo.title", containsInAnyOrder("Steve Jobs"),
				"items.volumeInfo.authors", containsInAnyOrder((Object)Arrays.asList("Walter Isaacson")),
				"items.volumeInfo.publisher", containsInAnyOrder("Simon and Schuster"),
				"items.volumeInfo.pageCount", containsInAnyOrder(630));*/
	}
}
