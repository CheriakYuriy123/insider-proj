package fourthTaskAPI.tests.positive;

import fourthTaskAPI.pojo.requests.PetBuilder;
import fourthTaskAPI.pojo.responses.Response;
import fourthTaskAPI.specification.Specification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static fourthTaskAPI.specification.Specification.petId;
import static io.restassured.RestAssured.given;

public class CheckSuccessfulCRUDPet {

    @Test
    public void checkPetCreation() {
        Specification
                .installSpec(Specification.request(), Specification.response(200));

        PetBuilder petBody = PetBuilder.builder().build();

        Response response = given()
                .when()
                .body(petBody)
                .post("/pet")
                .then().log().body()
                .extract().as(Response.class);

        Assert.assertEquals(response.getName(), "Buba");
    }

    @Test
    public void checkGettingPetById() {
        Specification
                .installSpec(Specification.request(), Specification.response(200));

        Response response = given()
                .when()
                .get("/pet/" + petId)
                .then().log().all()
                .extract().as(Response.class);

        Assert.assertNotNull(response.getName());
    }

    @Test
    public void checkUpdatingPet() {
        Specification
                .installSpec(Specification.request(), Specification.response(200));

        String changedName = "Mura";
        String changedStatus = "Changed";

        PetBuilder petBody = PetBuilder.builder().status(changedStatus).name(changedName).build();

        Response response = given()
                .when()
                .body(petBody)
                .put("/pet")
                .then().log().body()
                .extract().as(Response.class);

        Assert.assertEquals(response.getName(), changedName);
        Assert.assertEquals(response.getStatus(), changedStatus);
    }

    @Test
    public void checkDeletingPetById() {
        Specification
                .installSpec(Specification.request(), Specification.response(200));

        given()
                .when()
                .delete("/pet/" + petId)
                .then().log().all();
    }
}
