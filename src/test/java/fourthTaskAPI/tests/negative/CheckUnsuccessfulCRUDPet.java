package fourthTaskAPI.tests.negative;

import fourthTaskAPI.pojo.requests.PetBuilder;
import fourthTaskAPI.specification.Specification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static fourthTaskAPI.specification.Specification.petId;
import static io.restassured.RestAssured.given;

public class CheckUnsuccessfulCRUDPet {

    @Test
    public void checkPetCreationWithoutBody() {
        Specification
                .installSpec(Specification.request(), Specification.response(405));

        String error = given()
                .when()
                .post("/pet")
                .then().log().body()
                .extract().asString();

        Assert.assertNotNull(error);
        Assert.assertEquals(error, "{\"code\":405,\"type\":\"unknown\",\"message\":\"no data\"}");
    }

    @Test
    public void checkPetCreationWithIncorrectEndpoints() {
        Specification
                .installSpec(Specification.request(), Specification.response(404));

        PetBuilder petBody = PetBuilder.builder().build();

        String error = given()
                .when()
                .body(petBody)
                .post("/pets")
                .then().log().body()
                .extract().asString();

        Assert.assertNotNull(error);
    }

    @Test
    public void checkGettingPetByIncorrectId() {
        Specification
                .installSpec(Specification.request(), Specification.response(404));

        String error = given()
                .when()
                .get("/pet/" + petId + "1")
                .then().log().all()
                .extract().asString();

        Assert.assertNotNull(error);
    }

    @Test
    public void checkUpdatingPetWithoutBody() {
        Specification
                .installSpec(Specification.request(), Specification.response(405));

        String error = given()
                .when()
                .put("/pet")
                .then().log().body()
                .extract().asString();

        Assert.assertNotNull(error);
        Assert.assertEquals(error, "{\"code\":405,\"type\":\"unknown\",\"message\":\"no data\"}");
    }

    @Test
    public void checkDeletingPetByNonExistentId() {
        Specification
                .installSpec(Specification.request(), Specification.response(404));

        given()
                .when()
                .delete("/pet/" + petId + "1")
                .then().log().all();
    }
}
