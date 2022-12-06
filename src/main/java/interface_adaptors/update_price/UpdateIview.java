package interface_adaptors.update_price;

public interface UpdateIview {
    // this is an interface in interface adapters layer so that the Update Price use case follows MVC model.

    String UPDATE_SCREEN_NAME_CONSTANT = "Update Price";

    void setMessage(String message);
}
